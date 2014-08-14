package llc.engine;

import java.awt.Font;

import llc.LLC;
import llc.engine.gui.GUI;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;

public class GUIRenderer {

	public final TrueTypeFont arial = new TrueTypeFont(new Font("Arial", Font.PLAIN, 24), true);
	
	private GUI currentGUI;
	private LLC llc;
	
	public GUIRenderer(LLC llc) {
		this.llc = llc;
	}
	
	/**
	 * Renders the current GUI
	 */
	public void render(int width, int height, int x, int y) {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		if(this.currentGUI != null) {
			this.currentGUI.update(x, y);
			this.currentGUI.render(this, x, y);
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	/**
	 * Opens the given GUI
	 */
	public void openGUI(GUI gui) {
		this.closeCurrentGUI();
		this.currentGUI = gui;
		this.currentGUI.onOpen();
		this.llc.input.guiChange(this.currentGUI);
	}
	
	/**
	 * Closes the current GUI
	 */
	public void closeCurrentGUI() {
		if(this.currentGUI != null) {
			this.currentGUI.onClose();
			this.currentGUI = null;
		}
	}
	
	/**
	 * Gets called when the Display was resized
	 */
	public void handleDisplayResize(int width, int height) {
		if(this.currentGUI != null) this.currentGUI.onOpen();
	}
	
}
