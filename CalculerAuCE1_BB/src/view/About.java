package view;

import java.io.IOException;

import CalculerAuCE1;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;

public class About extends Form implements CommandListener {

	private Command cmdRetour;
	private Image imgSenmobile;

	public About() {
		super("A Propos");

		this.append("CalculerAuCE1 v1.0\n");
		this.append("SenMobile \nsenmobileapp@senmobile.com \nhttp://senmobile.com");
		try {
			imgSenmobile = Image.createImage("/senmobile.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.append(imgSenmobile);

		cmdRetour = new Command("Retour", Command.BACK, 1);
		this.addCommand(cmdRetour);

		this.setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd == cmdRetour) {
			CalculerAuCE1.getInstance().setCurrentScreen(new Menu());
		}

	}

}
