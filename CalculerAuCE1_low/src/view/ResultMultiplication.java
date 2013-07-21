package view;


import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;

import model.Business;
import CalculerAuCE1;

class ResultMultiplication extends Form implements CommandListener {
	
	

	private Command cmdRejouer;
	private Command cmdMenu;
	private Command cmdExit;
	private StringItem monScore;
	private Image imgBalloons;

	public ResultMultiplication() {
		super("Résultats");
		
		cmdRejouer = new Command("Rejouer", Command.SCREEN, 0);
		this.addCommand(cmdRejouer);

		cmdMenu = new Command("Menu", Command.SCREEN, 1);
		this.addCommand(cmdMenu);

		cmdExit = new Command("Sortir", Command.SCREEN, 2);
		this.addCommand(cmdExit);
		
		this.setCommandListener(this);
		
		//recupère le score à la fin des exercices
		int score = Business.getInstance().getScoreMultiplication();
		
		System.out.println("Mon score :" + "" + score);
		
		//affiche le texte ou l'image des ballons en fonction du score
		if((score == 3))
		{
			monScore = new StringItem("",
					"\nTrès Bien, ton résultat est : " + score + " / "
							+ Business.getTotalQuestions() + " points");
			this.append(monScore);
			this.append("\n ");

			try {
				imgBalloons = Image.createImage("/balloons3.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.append(new ImageItem(null, imgBalloons, ImageItem.LAYOUT_CENTER,
					null));
		}
		else if((score == 2)){	
				monScore = new StringItem("",
						"\nBien, ton résultat est : " + score + " / "
								+ Business.getTotalQuestions() + " points");
				this.append(monScore);
				this.append("\n ");
				
				try {
					imgBalloons = Image.createImage("/balloons2.png");
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.append(new ImageItem(null, imgBalloons, ImageItem.LAYOUT_CENTER,
						null));
		}
		else if((score == 1)){	
			monScore = new StringItem("",
					"\nTon résultat est : " + score + " / "
							+ Business.getTotalQuestions() + " points");
			this.append(monScore);
			this.append("\n ");
			
			try {
				imgBalloons = Image.createImage("/balloons1.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.append(new ImageItem(null, imgBalloons, ImageItem.LAYOUT_CENTER,
					null));
		}
		
		else if((score == 0)){	
			monScore = new StringItem("",
					"\nEssaies encore, ton résultat est : " + score + " / "
							+ Business.getTotalQuestions() + " points");
			this.append(monScore);
			this.append("\n ");
		}
	}

	public void commandAction(Command cmd, Displayable display) {
		if (cmd == cmdRejouer) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Multiplication(1));
		} else if (cmd == cmdMenu) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		} else if (cmd == cmdExit) {
			CalculerAuCE1.getInstance().exitNow();
		} 
	}

}
