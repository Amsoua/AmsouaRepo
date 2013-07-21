package view;

import CalculerAuCE1;

import java.util.Random;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import model.Business;

public class Multiplication extends Form implements CommandListener {

	private Command cmdPrecedent;
	private Command cmdValider;
	private Command cmdDebut;
	private Command cmdMenu;
	private int indexLesson;
	private TextField tfRes;
	private StringItem siAdd;
	private int prod;
	private int nb1;
	private int nb2;

	public Multiplication(int index) {
		super("Multiplication " + index);

		indexLesson = index;

		if (index == 1) {
			Business.getInstance().setScoreMultiplication(0);
		}

		Random r1 = new Random();
		// nextInt(n) est entre 0 et n-1
		nb1 = r1.nextInt(98) + 1; // +1 pour ne pas avoir 0
		nb2 = r1.nextInt(6) + 1;
		prod = nb1 * nb2;

		tfRes = new TextField("Entrer le résultat : ", "", 8, TextField.NUMERIC);
		this.append(tfRes);

		siAdd = new StringItem("Multiplication à faire : ", nb1 + " x " + nb2);
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
				String text;
				int time;
				if (res != null && !"".equals(res)) {
					int resi = Integer.parseInt(res);
					if (resi == prod) {
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreMultiplication();
						Business.getInstance().setScoreMultiplication(
								currentScore + 1);

					} else {
						System.out.println("Dommage");
						text = "Dommage ! " + nb1 + " x " + nb2 + " = " + prod; // Ajouter
																				// le
																				// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(new ResultMultiplication(), a);
				}
			} else {
				String res = tfRes.getString();
				if (res != null && !"".equals(res)) {
					int resi = Integer.parseInt(res);
					String text;
					int time;
					if (resi == prod) {
						System.out.println("Bravo");
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreMultiplication();
						Business.getInstance().setScoreMultiplication(
								currentScore + 1);
					} else {
						System.out.println("Dommage");
						text = "Dommage ! " + nb1 + " x " + nb2 + " = " + prod; // Ajouter
																				// le
																				// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(
							new Multiplication(indexLesson + 1), a);
				}
			}
		} else if (cmd == cmdPrecedent) {
			if (indexLesson == 1) {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Multiplication(indexLesson));
			} else {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Multiplication(indexLesson - 1));
			}
		} else if (cmd == cmdDebut) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Multiplication(1));
		} else if (cmd == cmdMenu) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		}
	}
}
