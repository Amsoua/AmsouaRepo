package view;

import java.io.IOException;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

import CalculerAuCE1;

public class Menu extends List implements CommandListener {

	private Command cmdExit;
	private Command cmdAbout;
//	private Command cmdAide;

	public static String title = "Calculer au CE1";
	public static int ADDITION = 0;
	public static int SOUSTRACTION = 1;
	public static int MULTIPLICATION = 2;
	public static int DIVISION = 3;
	public static int LETTRES = 4;
	public static int ENCADREMENT = 5;
	public static int SCORES = 6;
	
	private int index;
	private Alert alertExit;
	private Command cmdYes;
	private Command cmdNo;
	private Image imgAdd;
	private Image imgDivision;
	private Image imgEncadrement;
	private Image imgLettres;
	private Image imgMult;
	private Image imgScores;
	private Image imgSub;

	public Menu() {

		super(title, List.IMPLICIT);
		
		try {
			imgAdd = Image.createImage("/addition.png");
			imgDivision = Image.createImage("/division.png");
			imgEncadrement = Image.createImage("/encadrement.png");
			imgLettres = Image.createImage("/lettres.png");
			imgMult = Image.createImage("/multiplication.png");
			imgScores = Image.createImage("/scores.png");
			imgSub = Image.createImage("/substraction.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.append("Addition", imgAdd);
		this.append("Soustraction", imgSub);
		this.append("Multiplication", imgMult);
		this.append("Division", imgDivision);
		this.append("En lettres", imgLettres);
		this.append("Encadrement", imgEncadrement);
		this.append("Scores", imgScores);
		
		cmdAbout = new Command("A Propos", Command.SCREEN, 1);
		this.addCommand(cmdAbout);

	//	cmdAide = new Command("Aide", Command.SCREEN, 1);
	//	this.addCommand(cmdAide);

		cmdExit = new Command("Sortir", Command.EXIT, 2);
		this.addCommand(cmdExit);

		this.setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd == cmdExit) {
			alertExit = new Alert("Sortir", "Voulez-vous vraiment quitter ?",
					null, AlertType.WARNING);
			cmdYes = new Command("Oui", Command.EXIT, 0);
			alertExit.addCommand(cmdYes);
			cmdNo = new Command("Non", Command.SCREEN, 0);
			alertExit.addCommand(cmdNo);
			alertExit.setCommandListener(this);
			CalculerAuCE1.getInstance().setCurrentScreen(alertExit);
		} else if (cmd == cmdYes) {
			CalculerAuCE1.getInstance().exitNow();
		} else if (cmd == cmdNo) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		} else if (cmd == cmdAbout) {
			CalculerAuCE1.getInstance().setCurrentScreen(new About());
		} else if (cmd == List.SELECT_COMMAND) {
			index = this.getSelectedIndex();
			if (index == ADDITION) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Addition(1));
			} else if (index == SOUSTRACTION) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Soustraction(1));
			} else if (index == MULTIPLICATION) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Multiplication(1));
			} else if (index == DIVISION) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Division(1));
			} else if (index == LETTRES) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Lettres(1));
			} else if (index == ENCADREMENT) {
				CalculerAuCE1.getInstance().setCurrentScreen(new Encadrement(1));
			} else if (index == SCORES){
				CalculerAuCE1.getInstance().setCurrentScreen(new Score());
			}
		}
	}
}
