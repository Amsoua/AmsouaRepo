package view;

import CalculerAuCE1;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

import model.Business;

public class Score extends Form implements CommandListener {

	private Command cmdRetour;

	public Score() {
		super("Scores");
		Business.getInstance();
		this.append("Addition - " + Business.getInstance().getScoreAddition()
				+ " / " + Business.getTotalQuestions() + " points");
		this.append("\nSoustraction - "
				+ Business.getInstance().getScoreSoustraction() + " / "
				+ Business.getTotalQuestions() + " points");
		this.append("\nMultiplication - "
				+ Business.getInstance().getScoreMultiplication() + " / "
				+ Business.getTotalQuestions() + " points");
		this.append("\nDivision - " + Business.getInstance().getScoreDivision()
				+ " / " + Business.getTotalQuestions() + " points");
		this.append("\nEn Lettres - "
				+ Business.getInstance().getScoreLettres() + " / "
				+ Business.getTotalQuestions() + " points");
		this.append("\nEncadrement - "
				+ Business.getInstance().getScoreEncadrement() + " / "
				+ Business.getTotalQuestions() + " points");

		cmdRetour = new Command("Retour", Command.BACK, 0);
		this.addCommand(cmdRetour);

		this.setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd == cmdRetour) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		}

	}

}
