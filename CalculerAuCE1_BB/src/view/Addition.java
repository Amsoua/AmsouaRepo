package view;

import java.util.Random;

import CalculerAuCE1;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import model.Business;

public class Addition extends Form implements CommandListener {

	private Command cmdPrecedent;
	private Command cmdValider;
	private Command cmdDebut;
	private Command cmdMenu;
	private int indexLesson;
	private TextField tfRes;
	private StringItem siAdd;
	private int sum;
	private int nb1;
	private int nb2;

	public Addition(int index) {
		super("Addition " + index);

		indexLesson = index;

		if (index == 1) {
			Business.getInstance().setScoreAddition(0);
		}

		Random r1 = new Random();
		// nextInt(n) est entre 0 et n-1
		nb1 = r1.nextInt(500) + 1; // +1 pour ne pas avoir 0
		nb2 = r1.nextInt(500) + 1;
		sum = nb1 + nb2;

		tfRes = new TextField("Entrer le résultat : ", "", 8, TextField.NUMERIC);
		this.append(tfRes);

		siAdd = new StringItem("Addition à faire : ", nb1 + " + " + nb2);
		this.append(siAdd);

		// cmdPrecedent = new Command("Précédent", Command.SCREEN, 1);
		// this.addCommand(cmdPrecedent);

		cmdValider = new Command("Valider", Command.SCREEN, 0);
		this.addCommand(cmdValider);

		cmdDebut = new Command("Début", Command.SCREEN, 3);
		this.addCommand(cmdDebut);

		cmdMenu = new Command("Menu", Command.SCREEN, 4);
		this.addCommand(cmdMenu);

		this.setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd == cmdValider) {
			if (indexLesson == Business.getTotalQuestions()) {
				String res = tfRes.getString();
				if (res != null && !"".equals(res)) {
					int resi = Integer.parseInt(res);
					String text;
					int time;
					if (resi == sum) {
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreAddition();
						Business.getInstance().setScoreAddition(
								currentScore + 1);
					} else {
						text = "Dommage ! " + nb1 + " + " + nb2 + " = " + sum; // Ajouter
						// le
						// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(new ResultAddition(),a);
				}
			} else {
				String res = tfRes.getString();
				System.out.println("res " + res);
				if (res != null && !"".equals(res)) {
					int resi = Integer.parseInt(res);
					String text;
					int time;
					if (resi == sum) {
						System.out.println("Bravo");
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreAddition();
						Business.getInstance().setScoreAddition(
								currentScore + 1);
					} else {
						System.out.println("Dommage");
						text = "Dommage ! " + nb1 + " + " + nb2 + " = " + sum; // Ajouter
																				// le
																				// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(
							new Addition(indexLesson + 1), a);
				}
			}
		} else if (cmd == cmdPrecedent) {
			if (indexLesson == 1) {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Addition(indexLesson));
			} else {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Addition(indexLesson - 1));
			}
		} else if (cmd == cmdDebut) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Addition(1));
		} else if (cmd == cmdMenu) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		}
	}
}
