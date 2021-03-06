package edu.uca.csci4490.chessgame.server.communication;

import java.io.IOException;

import edu.uca.csci4490.chessgame.model.data.*;
import edu.uca.csci4490.chessgame.server.ChessServer;
import edu.uca.csci4490.chessgame.server.playermanager.PlayerManager;
import ocsf.server.ConnectionToClient;

public class PlayerLoginCommunication {
	private ChessServer server;
	private PlayerManager pmanager;
	private ChessServerCommunication chessservercom;
	
	public PlayerLoginCommunication(ChessServer server, PlayerManager pmanager, ChessServerCommunication chessservercom) { 
		this.server = server;
		this.pmanager = pmanager;
		this.chessservercom = chessservercom; 
	}
	
	public void receiveCreateAccount(CreateAccountData data, ConnectionToClient client) {
		if(pmanager.accountCreated(data)) {
			sendCreateAccountSuccessful(client);
		}
		else {
			sendCreateAccountUnsuccessful(client);
		}
		
	}
	
	public void receivePlayerLogin(PlayerLoginData data, ConnectionToClient client) {
		if(pmanager.clientLoggedIn(data, client)) {
			chessservercom.getWaitingRoomCommunication().sendWaitingRoomToAll();
		}
		else {
			sendLoginUnsuccessful(client);
		}
	}

	public void receivePlayerLogout(PlayerLogoutData data) {
		pmanager.playerDisconnected(data.getPlayer());
		chessservercom.getWaitingRoomCommunication().sendWaitingRoomToAll();
	}
	
	public void sendLoginUnsuccessful(ConnectionToClient client) {
		ErrorData data = new ErrorData("Invalid username or password");
		try {
			client.sendToClient(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendCreateAccountSuccessful(ConnectionToClient client) {
		try {
			client.sendToClient(new CreateAccountSuccessfulData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void sendCreateAccountUnsuccessful (ConnectionToClient client) {
		ErrorData data = new ErrorData("Username already in use");
		try {
			client.sendToClient(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
