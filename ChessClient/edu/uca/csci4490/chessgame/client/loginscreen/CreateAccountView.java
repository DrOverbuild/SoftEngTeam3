package edu.uca.csci4490.chessgame.client.loginscreen;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountView extends JPanel{
	// Private data fields for the important GUI components.
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField verifyPasswordField;
	private JLabel errorText;

	private JButton createAccountBtn;
	private JButton backBtn;

	// Getter for the text in the username field.
	public String getUsername()
	{
		return usernameField.getText();
	}

	// Getter for the text in the password field.
	public String getPassword()
	{
		return new String(passwordField.getPassword());
	}

	// Getter for the text in the second password field.
	public String getPasswordVerify()
	{
		return new String(verifyPasswordField.getPassword());
	}

	// Setter for the error text.
	public void setError(String error)
	{
		errorText.setText(error);
	}

	// Constructor for the create account panel.
	public CreateAccountView(CreateAccountController cc)
	{
		// Create the controller and set it in the chat client.
		//CreateAccountControl controller = new CreateAccountControl(container, client);
		//client.setCreateAccountControl(controller);

		// Create a panel for the labels at the top of the GUI.
		JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		errorText = new JLabel("", JLabel.CENTER);
		errorText.setForeground(Color.RED);
		// instructions not included in original design - but can be added 
//		JLabel instructionLabel = new JLabel("Enter a username and password to create an account.", JLabel.CENTER);
//		JLabel instructionLabel2 = new JLabel("Your password must be at least 6 characters.", JLabel.CENTER);    
		labelPanel.add(errorText);
//		labelPanel.add(instructionLabel);
//		labelPanel.add(instructionLabel2);

		// Create a panel for the account information form.
		JPanel accountPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
		usernameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
		passwordField = new JPasswordField(10);
		JLabel passwordVerifyLabel = new JLabel("Verify Password:", JLabel.RIGHT);
		verifyPasswordField = new JPasswordField(10);
		accountPanel.add(usernameLabel);
		accountPanel.add(usernameField);
		accountPanel.add(passwordLabel);
		accountPanel.add(passwordField);
		accountPanel.add(passwordVerifyLabel);
		accountPanel.add(verifyPasswordField);

		// Create a panel for the buttons.
		JPanel buttonPanel = new JPanel();
		backBtn = new JButton("Back");
		backBtn.addActionListener(cc);
		createAccountBtn = new JButton("Create Account");
		createAccountBtn.addActionListener(cc);    
		buttonPanel.add(backBtn);
		buttonPanel.add(createAccountBtn);

		// Arrange the three panels in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
		grid.add(labelPanel);
		grid.add(accountPanel);
		grid.add(buttonPanel);
		this.add(grid);
	}

	public void displayError(String msg) {
		errorText.setForeground(Color.RED);
		errorText.setText(msg);
	}

	public void displaySuccess(String msg) {
		errorText.setForeground(Color.GREEN);
		errorText.setText(msg);
	}

	public void enableButtons() {
		backBtn.setEnabled(true);
		createAccountBtn.setEnabled(true);
	}

	public void disableButtons() {
		backBtn.setEnabled(false);
		createAccountBtn.setEnabled(false);
	}
}
