package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Opens the GUI and starts the program
 * @author Jarrett Allen Homan
 *
 */

public class Main extends Application {
	/**
	 * Calls the GUI and starts the program
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Blackjack");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launches the GUI
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
