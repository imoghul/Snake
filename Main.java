import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//extends JPanel implements ActionListener
public class Main extends JPanel implements ActionListener {
	// Graphical constants
	static final long serialVersionUID = 536871008;
	public static JFrame window = new JFrame("GUI Test");
	public static TextField textField = new TextField();
	public static Main panel = new Main();
	public static Container c = window.getContentPane();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Timer clock = new Timer(Main.timerSpeed, panel);
	public static Point mousePoint = MouseInfo.getPointerInfo().getLocation();
	// Fields
	public static int displayW = 1000, displayH = 1000, timerSpeed = 300, speed = 1; // full screen:
	public static final int defaultSpeed = 50;
	// displayW=1389,displayH=855
	// Objects

	public static Collision checker = new Collision();
	public static Game game = new Game();
	public static int headX = 0;
	public static int headY = 0;
	public static Drawer lWall = new Drawer(-1, 0, 1, Main.displayH, "rect");
	public static Drawer rWall = new Drawer(Main.displayW, 0, 1, Main.displayH, "rect");
	public static Drawer tWall = new Drawer(0, -1, Main.displayW, 1, "rect");
	public static Drawer bWall = new Drawer(0, Main.displayH, Main.displayW, 1, "rect");
	public static boolean isOUT = false;
	public static int velocityX = 0;
	public static int velocityY = 0;
	public static int counter = 0;
	public static int counterSpeed = Main.defaultSpeed;
	public static int snakeLen = 1;
	public static Drawer apple = new Drawer(100, 100, 20, 20);

	public void paintComponent(Graphics g) {
		Main.apple.rect(g, Color.red, true);
		String score = "SCORE: " + new Integer(Main.snakeLen - 1);

		if (Main.isOUT) {
			g.setColor(Color.white);
			g.drawString("YOU LOST", 20, 20);

		} else {

			Main.game.drawSnake(g, Main.snakeLen);
			// Main.game.setUnit(g, Main.headX, Main.headY, true);
		}
		g.setColor(Color.blue);
		g.drawString(score, 20, 20);
	}

	public void actionPerformed(ActionEvent e) {
		// System.out.println(Main.game.isOut());

		Main.displayW = window.getContentPane().getWidth();
		Main.displayH = window.getContentPane().getHeight();

		if (!Main.isOUT) {

			Main.counter++;

			if (Main.checker.autoCollide(Main.game.getHead(), Main.apple) == true) {
				apple.setX((int) (Math.abs(Math.random()) * (Main.displayW - 20)));
				apple.setY((int) (Math.abs(Math.random()) * (Main.displayH - 20)));
				Main.snakeLen++;
				if (Main.counterSpeed >= 10) {
					Main.counterSpeed -= 10;
					if (Main.counterSpeed < 10) {
						Main.counterSpeed = 10;
					}
				}

			}

			if (game.isOut()) {

				Main.game.reset();

			} else {
				Main.isOUT = false;
				if (Main.counter % Main.counterSpeed == 0) {
					Main.headX += Main.velocityX;
					Main.headY += Main.velocityY;
				}

			}
			/*
			 * if (checker.autoCollide(lWall, game.getHead()) || checker.autoCollide(rWall,
			 * game.getHead()) || checker.autoCollide(tWall, game.getHead()) ||
			 * checker.autoCollide(bWall, game.getHead())) { System.out.println("OUT"); }
			 */
		}
		repaint();
	}

	public static void main(String[] argv) throws Exception {

		JTextField textField = new JTextField();
		textField.addKeyListener(new MKeyListener());
		// MouseListener mouse = new MouseListen();
		textField.addMouseListener(new MouseListen());
		panel.setBackground(Color.black);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(textField);
		window.setBounds(0, 0, displayW, displayH);
		c.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		clock.start();
	}
}
