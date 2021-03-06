package edu.uca.csci4490.chessgame.server.gamelogic;

import edu.uca.csci4490.chessgame.model.gamelogic.MoveData;
import edu.uca.csci4490.chessgame.server.gamelogic.piece.Piece;

import java.io.Serializable;

public class Move implements Serializable {
	private Piece piece;
	private Location from;
	private Location to;

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Location getFrom() {
		return from;
	}

	public void setFrom(Location from) {
		this.from = from;
	}

	public Location getTo() {
		return to;
	}

	public void setTo(Location to) {
		this.to = to;
	}

	public Move(Piece piece, Location from, Location to) {
		this.piece = piece;
		this.from = from;
		this.to = to;
	}

	public MoveData data() {
		return new MoveData(piece.data(), from.data(), to.data());
	}
}
