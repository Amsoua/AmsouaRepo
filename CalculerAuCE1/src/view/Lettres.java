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

public class Lettres extends Form implements CommandListener {

	private Command cmdPrecedent;
	private Command cmdValider;
	private Command cmdDebut;
	private Command cmdMenu;
	private int indexLesson;
	private TextField tfRes;
	private StringItem siAdd;
	private String nb1;
	private int nb3;
	private int nb2;
	private String T1[] = { "Treize", "cinquante-deux", "cent trente",
			"trois cents un", "cinq cent", "quatre-vingt quinze",
			"deux cent douze", "mille deux", "soixante douze",
			"cent quatre-vingt douze" };
	private int T2[] = { 13, 52, 130, 301, 500, 95, 212, 1002, 72, 192 };

	public Lettres(int index) {
		super("Lettres " + index);

		indexLesson = index;

		if (index == 1) {
			Business.getInstance().setScoreLettres(0);
		}

		Random r1 = new Random();
		// nextInt(n) est entre 0 et n-1
		nb3 = r1.nextInt(T1.length); // +1 pour ne pas avoir 0
		// nb2 = r1.nextInt(500) + 1;
		nb1 = T1[nb3];
		nb2 = nb3;
		// sum = nb1 + nb2;

		tfRes = new TextField("Entrer le résultat : ", "", 8, TextField.NUMERIC);
		this.append(tfRes);

		siAdd = new StringItem("Nombre correspondant à : ", nb1);
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
					if (resi == T2[nb2]) {
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreLettres();
						Business.getInstance()
								.setScoreLettres(currentScore + 1);
					} else {
						System.out.println("Dommage");
						text = "Dommage ! " + nb1 + " en nombre est : "
								+ T2[nb2]; // Ajouter
											// le
											// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(new ResultLettres(), a);
				}
			} else {
				String res = tfRes.getString();
				if (res != null && !"".equals(res)) {
					int resi = Integer.parseInt(res);
					String text;
					int time;
					if (resi == T2[nb2]) {
						System.out.println("Bravo");
						text = "Bravo !";
						time = 3000;
						int currentScore = Business.getInstance()
								.getScoreLettres();
						Business.getInstance()
								.setScoreLettres(currentScore + 1);
					} else {
						System.out.println("Dommage");
						text = "Dommage ! " + nb1 + " en nombre est : "
								+ T2[nb2]; // Ajouter
											// le
											// message
						time = 10000;
					}
					Alert a = new Alert("Alerte", text, null, AlertType.INFO);
					a.setTimeout(time);
					CalculerAuCE1.getInstance().setCurrentScreen(
							new Lettres(indexLesson + 1), a);
				}
			}
		} else if (cmd == cmdPrecedent) {
			if (indexLesson == 1) {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Lettres(indexLesson));
			} else {
				CalculerAuCE1.getInstance().setCurrentScreen(
						new Lettres(indexLesson - 1));
			}
		} else if (cmd == cmdDebut) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Lettres(1));
		} else if (cmd == cmdMenu) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		}
	}
}
