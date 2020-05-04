package application.controller;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import mytest.Blackjack;
import mytest.Deck;

/**
 * Handles the interaction between GUI and program
 * @author Jarrett Allen Homan
 *
 */

public class MainController {
	@FXML
    private Text textBox;
    @FXML
    private Button hitButton;
    @FXML
    private Button standButton;
    @FXML
    private Button playButton;
    @FXML
    private Button betButton;
	
	public void playGame(ActionEvent event) {
		//System.out.print("play button pressed\n");
	}
	
}
