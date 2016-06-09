import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Text class draws a String to the screen.  
 * It can show or hide the text, as well as an underline.
 * Other options include changing the letter or underline
 * color, and determining if the underline or text is
 * visible or not.
 * 
 * Although intended to be used for single letters, the
 * Text class can be used to draw any length text to the
 * screen. Note that showing/hiding the text and underline
 * are independent. In other words, it is possible to
 * display the text without the underline showing, display
 * the underline without the text showing, show both, or
 * show neither. 
 * 
 * @author Jerry Alan Fails and Emily Hill
 * @version 2012-11-15
 */
public class Text extends JPanel {
	
	/////////////////////////////////////////////////////
	// CONSTANTS
	/////////////////////////////////////////////////////
	public static final int SPACE = 2;
	
    /////////////////////////////////////////////////////
    // FIELDS
    /////////////////////////////////////////////////////
	private String text;
	private boolean underline = true;
	private boolean visible = true;
	private Font font;
	private Color letterColor = Color.BLACK;
	private Color underlineColor = Color.BLACK;

    /////////////////////////////////////////////////////
    // CONSTRUCTOR
    /////////////////////////////////////////////////////
	
	/**
	 * Initializes the text, sets the font, and sets the
	 * dimensions for this panel.
	 * 
	 * @param t the text string to be displayed by this
	 * text panel
	 */
	public Text(String t) {
		text = t;
		font = new Font("default", Font.BOLD, 18);
		this.setPreferredSize(new Dimension(20,20));
	}

    /////////////////////////////////////////////////////
    // GET / CHANGE THE TEXT DISPLAYED BY THIS OBJECT
    /////////////////////////////////////////////////////
	
	/**
	 * Sets the text to be displayed by this object.
	 * 
	 * @param t the text string to be displayed by this
	 * text panel
	 */
	public void setText(String t) {
		text = t;
		repaint();
	}
	
	/**
	 * Returns the text string displayed by this text 
	 * panel when shown.
	 * 
	 * @return the text string displayed by this text
	 * panel
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Returns true if the text is whitespace consisting of 
	 * spaces, tabs, or returns. Returns false otherwise.
	 * 
	 * @return true if the text is currently whitespace, 
	 * false otherwise.
	 */
	public boolean isWhiteSpace() {
		return text == null || text.trim().equals("");
	}

    /////////////////////////////////////////////////////
    // SHOW/HIDE TEXT
    /////////////////////////////////////////////////////

	/**
	 * Causes the text to be shown the next time
	 * {@link #paintComponent(Graphics)} is called.
	 */
	public void showText() {
		visible = true;
		repaint();
	}
	
	/**
	 * Causes the text to be hidden the next time
	 * {@link #paintComponent(Graphics)} is called.
	 */
	public void hideText() {
		visible = false;
		repaint();
	}
	
	/**
	 * Returns true if the text will be shown the next time
	 * {@link #paintComponent(Graphics)} is called. This
	 * method returns false if the text will be invisible.
	 * 
	 * @return true if the text will be shown, false
	 * otherwise.
	 */
	public boolean isTextVisible() {
		return visible;
	}
	
    /////////////////////////////////////////////////////
    // SHOW/HIDE UNDERLINE
    /////////////////////////////////////////////////////
	
	/**
	 * Causes the underline to be shown the next time
	 * {@link #paintComponent(Graphics)} is called.
	 */
	public void showUnderline() {
		underline = true;
		repaint();
	}
	
	/**
	 * Causes the underline to be hidden the next time
	 * {@link #paintComponent(Graphics)} is called.
	 */
	public void hideUnderline() {
		underline = false;
		repaint();
	}
	
	/**
	 * Returns true if the underline will be shown the next
	 * time {@link #paintComponent(Graphics)} is called. 
	 * This method returns false if the underline will be 
	 * invisible.
	 * 
	 * @return true if the underline will be shown, false
	 * otherwise.
	 */
	public boolean isUnderlined() {
		return underline;
	}
	
    /////////////////////////////////////////////////////
    // LETTER & UNDERLINE COLOR METHODS
    /////////////////////////////////////////////////////
	
	/**
	 * Returns the {@code Color} object used to determine 
	 * the display color of the text. Note the color is
	 * independent of whether the text will be visible
	 * or hidden.
	 * 
	 * @return the display color of the text
	 */
	public Color getLetterColor() {
		return letterColor;
	}

	/**
	 * Sets the display color used when drawing the text.
	 * 
	 * @param letterColor the {@code Color} object to be
	 * used 
	 */
	public void setLetterColor(Color letterColor) {
		this.letterColor = letterColor;
		repaint();
	}

	/**
	 * Returns the {@code Color} object used to determine 
	 * the display color of the underline. Note the color
	 * is independent of whether the underline will be 
	 * visible or hidden.
	 * 
	 * @return the display color of the underline
	 */
	public Color getUnderlineColor() {
		return underlineColor;
	}

	/**
	 * Sets the display color used when drawing the
	 * underline.
	 * 
	 * @param underlineColor the {@code Color} object to 
	 * be used
	 */
	public void setUnderlineColor(Color underlineColor) {
		this.underlineColor = underlineColor;
		repaint();
	}
	
    /////////////////////////////////////////////////////
    // PAINT METHOD
    /////////////////////////////////////////////////////
	
	/**
	 * Draws the text panel to the screen based on the
	 * field values.
	 */
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setFont(font);
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		if (visible) {
			page.setColor(letterColor);
			page.drawString(text, SPACE, h - SPACE - 1);
		}
		
		if (underline) {
			page.setColor(underlineColor);
			page.fillRect(SPACE, h - SPACE, 
					(text.length()+1)*7, h);
		}
	}


    /////////////////////////////////////////////////////
    // MAIN METHOD FOR TESTING
    /////////////////////////////////////////////////////
	/**
	 * Main method for testing.
	 * 
	 * @param args none necessary
	 */
	public static void main(String[] args) {

	      JFrame frame = new JFrame ("Hangman Game");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      JPanel panel = new Text(" ");

	      frame.getContentPane().add(panel);

	      frame.pack();
	      frame.setVisible(true);

	}
}
