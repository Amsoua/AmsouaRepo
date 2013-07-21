import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import model.Business;


public class CalculerAuCE1 extends MIDlet {

	private static CalculerAuCE1 instance;

	public static CalculerAuCE1 getInstance() {
		return instance;
	}

	public CalculerAuCE1() {
		instance = this;
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// Save data
	}

	protected void pauseApp() {
		// Save data
	}

	protected void startApp() throws MIDletStateChangeException {
		Business.createBusiness();
		this.setCurrentScreen(new SplashScreen());
		// Load data
	}

	public void setCurrentScreen(Displayable d) {
		Display.getDisplay(this).setCurrent(d);
	}

	public void setCurrentScreen(Displayable d, Alert a) {
		Display.getDisplay(this).setCurrent(a, d);
	}

	public void exitNow() {
		// Save data
		this.notifyDestroyed();
	}

}