package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML
    private Rectangle D1;
    @FXML
    private Rectangle D2;
    @FXML
    private Rectangle D3;
    @FXML
    private Rectangle D4;
    @FXML
    private Rectangle D5;
    @FXML
    private Rectangle D6;
    @FXML
    private Rectangle D7;
    @FXML
    private Rectangle D8;
    @FXML
    private Rectangle D9;
    @FXML
    private Rectangle P1;
    @FXML
    private Rectangle P2;
    @FXML
    private Rectangle P3;
    @FXML
    private Rectangle P4;
    @FXML
    private Rectangle P5;
    @FXML
    private Rectangle P6;
    @FXML
    private Rectangle P7;
    @FXML
    private Rectangle P8;
    @FXML
    private Rectangle P9;
    
    @FXML
    private TextField Textfield;
    @FXML
    private TextField Textfield1;

    @FXML
    private Button hitButton;
    @FXML
    private Button stayButton;
    @FXML
    private Button playButton;
    @FXML
    private Button quitButton;
  	
	Deck myDeck = new Deck();
	Blackjack mygame = new Blackjack();
	boolean hit=false;
	boolean stay=false;
	boolean playagain=true;
	int hitcount=0;
	int dealercount=0;
	Statistics stats = new Statistics();
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	
		myDeck.DeckMaker();
		myDeck.Shuffle();
		mygame.Deal(myDeck);
		stats.setNumberOfGames(stats.getNumberOfGames() + 1);
		
		String[] DealerHand = mygame.showD().split(",");
		String[] PlayerHand = mygame.showP().split(",");
		
		
		
		String C1=DealerHand[1];
		String C2=DealerHand[0];
		String C3=PlayerHand[0];
		String C4=PlayerHand[1];
		
		
		
		Image fxImage2=new Image("/images/"+C1+".png",false);
		Image fxImage = new Image("/images/"+C2+".png",false);
		Image fxImage3 = new Image("/images/"+C3+".png",false);
		Image fxImage4 = new Image("/images/"+C4+".png",false);
		
		mygame.tally();
		
		System.out.println(mygame.getDvalue());
		System.out.println(mygame.getPvalue());
		
		D1.setFill(new ImagePattern(fxImage));
		D1.setVisible(true);
		D2.setFill(new ImagePattern(fxImage2));
		D2.setVisible(true);
		
		P1.setFill(new ImagePattern(fxImage3));
		P1.setVisible(true);
		P2.setFill(new ImagePattern(fxImage4));
		P2.setVisible(true);
		
		Textfield1.setText(Integer.toString(mygame.getDvalue()));
		Textfield.setText(Integer.toString(mygame.getPvalue()));
		
		}
	
		public void start() {
			do {
				
				if(hit==true) {
				mygame.PlayerHit(myDeck);
				mygame.tally();
				showcards();
				hit=false;
				}
				
			}
			while(playagain=true);
		}
		
		/**
		 * Things to do to GUI when game is over
		 */
		public void gameOver() {
			hitButton.setDisable(true);
			stayButton.setDisable(true);
			playButton.setDefaultButton(true); //Press enter to restart game
			quitButton.setCancelButton(true); //Press [ESC] to close game window
		}
	
	
		@FXML
	    void Hit(ActionEvent event) {
			hitcount++;
			stats.setNumberOfHits(stats.getNumberOfHits() + 1);
			mygame.PlayerHit(myDeck);
			mygame.tally();
			int total=mygame.getPvalue();
			String Stotal=Integer.toString(total);
			Textfield.setText(Stotal);
			showcards();
			
			if(total>21) {
				Textfield.setText("Bust->"+Stotal);	
				stats.setNumberOfBusts(stats.getNumberOfBusts() + 1);
				gameOver();
			}
			
	    }

	    @FXML
	    void Play(ActionEvent event) {
	    	stats.setNumberOfGames(stats.getNumberOfGames() + 1);
	    	stats.saveStats();
	    	Main app=new Main();
	    	app.start(new Stage());
	    	Stage stage = (Stage) Textfield1.getScene().getWindow();
	        stage.close();
	    	}
	 

	    @FXML
	    void Quit(ActionEvent event) {
	    	stats.saveStats();
	    	Platform.exit();
	    }

	    @FXML
	    void Stay(ActionEvent event) {
	    	stats.setNumberOfStays(stats.getNumberOfStays() + 1);
	    	for (int i=0;i<6;i++){
	    	mygame.DealerTurn(myDeck);
	    	mygame.tally();
	    	showdealer();}
	    	int total=mygame.getDvalue();
			String Stotal=Integer.toString(total);
			Textfield1.setText(Stotal);
			if(total>21) {
				Textfield1.setText("Bust->"+Stotal);
				gameOver();
			}
			showcards();
	    }
	
	    public void showdealer() {
	    	
	    	String[] DealerHand = mygame.showD().split(",");
	    	int iterations=DealerHand.length-1;
	    	for (int i=1;i<iterations;i++) {
	    		switch(i) {
	    		case 1:
	    			String C12=DealerHand[2];
		    		Image fxImage11 = new Image("/images/"+C12+".png",false);
		    		D3.setFill(new ImagePattern(fxImage11));
		    		D3.setVisible(true);
		    		break;
	    		case 2:
	    			String C13=DealerHand[3];
		    		Image fxImage12 = new Image("/images/"+C13+".png",false);
		    		D4.setFill(new ImagePattern(fxImage12));
		    		D4.setVisible(true);
		    		break;
	    		case 3:
	    			String C14=DealerHand[4];
		    		Image fxImage13 = new Image("/images/"+C14+".png",false);
		    		D5.setFill(new ImagePattern(fxImage13));
		    		D5.setVisible(true);
		    		break;
	    		case 4:
	    			String C15=DealerHand[5];
		    		Image fxImage14 = new Image("/images/"+C15+".png",false);
		    		D6.setFill(new ImagePattern(fxImage14));
		    		D6.setVisible(true);
		    		break;
	    		case 5:
	    			String C16=DealerHand[6];
		    		Image fxImage15 = new Image("/images/"+C16+".png",false);
		    		D7.setFill(new ImagePattern(fxImage15));
		    		D7.setVisible(true);
		    		break;
	    		case 6:
	    			String C17=DealerHand[7];
		    		Image fxImage16 = new Image("/images/"+C17+".png",false);
		    		D8.setFill(new ImagePattern(fxImage16));
		    		D8.setVisible(true);
		    		break;
	    		case 7:
	    			String C18=DealerHand[8];
		    		Image fxImage17 = new Image("/images/"+C18+".png",false);
		    		D9.setFill(new ImagePattern(fxImage17));
		    		D9.setVisible(true);
		    		break;
		    	default:
		    		break;
		    	
		    		
	    		}
	    	}
	    }
	    	    
	    public void showcards() {
	    	String[] PlayerHand = mygame.showP().split(",");
	    	switch (hitcount) {
	    	case 1:
	    		
	    		String C5=PlayerHand[2];
	    		Image fxImage4 = new Image("/images/"+C5+".png",false);
	    		P3.setFill(new ImagePattern(fxImage4));
	    		P3.setVisible(true);
	    		break;
	    	case 2:
	    		
	    		String C6=PlayerHand[3];
	    		Image fxImage5 = new Image("/images/"+C6+".png",false);
	    		P4.setFill(new ImagePattern(fxImage5));
	    		P4.setVisible(true);
	    		break;
	    	case 3:
	    		
	    		String C7=PlayerHand[4];
	    		Image fxImage6 = new Image("/images/"+C7+".png",false);
	    		P5.setFill(new ImagePattern(fxImage6));
	    		P5.setVisible(true);
	    		break;
	    	case 4:
	    		String C8=PlayerHand[5];
	    		Image fxImage7 = new Image("/images/"+C8+".png",false);
	    		P6.setFill(new ImagePattern(fxImage7));
	    		P6.setVisible(true);
	    		break;
	    	case 5:
	    		String C9=PlayerHand[6];
	    		Image fxImage8 = new Image("/images/"+C9+".png",false);
	    		P7.setFill(new ImagePattern(fxImage8));
	    		P7.setVisible(true);
	    		break;
	    	case 6:
	    		String C10=PlayerHand[7];
	    		Image fxImage9 = new Image("/images/"+C10+".png",false);
	    		P8.setFill(new ImagePattern(fxImage9));
	    		P8.setVisible(true);
	    		break;
	    	case 7:
	    		String C11=PlayerHand[8];
	    		Image fxImage10 = new Image("/images/"+C11+".png",false);
	    		P9.setFill(new ImagePattern(fxImage10));
	    		P9.setVisible(true);
	    		break;
	    	default:
	    		break;
	    	
	    	
	    	
	    	}
	    	
	    }
	    
	    
}
