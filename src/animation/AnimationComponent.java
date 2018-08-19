package animation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class AnimationComponent extends JComponent {
	
	Image[] imgBackground = null, imgActionWalking = null, imgActionStop = null;
	
	int curMainCharacterIndex = 0, curBackIndex = 0;
	int bgPx0 = 0, bgPx1 = 0;
	int bgPy0 = -100, bgPy1 = -100;
	
	int test = 0;
	
	Timer timer = null;

	
	// timer event
	class TimerHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// character index
			curMainCharacterIndex++;
			curMainCharacterIndex %= imgActionWalking.length;
			
			// background index
			curBackIndex++;
			curBackIndex %= imgBackground.length;
			repaint();
		}
	}
	
	AnimationComponent(){
		
		initComponent();
		setImage();
	}
	
	/*
	 * initialize
	 */	
	private void initComponent() {
		
		bgPx1 = Variable.BG_X_SIZE;
		timer = new Timer(Variable.ANI_SPEED, new TimerHandler()); // create timer object
	}
	private void setImage() {
		
		// read image( set image array )
		try {
			
			// background
			imgBackground = new Image[Variable.BG_INDEX];
			for (int i = 0; i < imgBackground.length; i++) {
				imgBackground[i] = ImageIO.read(new File(Variable.BG + i + Variable.IMG_EXTENSION));
			}
			
			// action walking
			imgActionWalking = new Image[Variable.CHAR_WALK_INDEX];
			for (int i = 0; i < imgActionWalking.length; i++) {
				imgActionWalking[i] = ImageIO.read(new File(Variable.ACT_WALKING + i 
						+ Variable.IMG_EXTENSION));
			}
			
			// action stop
			imgActionStop = new Image[Variable.CHAR_STOP_INDEX];
			for (int i = 0; i < imgActionStop.length; i++) {
				imgActionStop[i] = ImageIO.read(new File(Variable.ACT_STOP + i 
						+ Variable.IMG_EXTENSION));
			}
			
		} catch (IOException e) {
		}
	}
	
	// draw image
	public void paintComponent(Graphics g) {
		
		drawBackgroundComponent(g);
		drawCharacter(g);
		test++;
	}
	
	/*
	 * Draw Method
	 */	
	private void drawBackgroundComponent(Graphics g) {
		
		g.drawImage(imgBackground[0], bgPx0, bgPy0, null);
		g.drawImage(imgBackground[1], bgPx1, bgPy1, null);
		
		bgPx0 += Variable.BG_DEC;
		bgPx1 += Variable.BG_DEC;
		if (bgPx0 < -Variable.BG_X_SIZE)
			bgPx0 = Variable.BG_X_SIZE;
		if (bgPx1 < -Variable.BG_X_SIZE)
			bgPx1 = Variable.BG_X_SIZE;
		
	}
	
	private void drawCharacter(Graphics g) {
		
		if( test < 100)
			g.drawImage(imgActionWalking[curMainCharacterIndex], Variable.WINDOWS_X / 4,
					Variable.WINDOWS_Y * 2 / 3, null);
		else
			g.drawImage(imgActionStop[0], Variable.WINDOWS_X / 4,
					Variable.WINDOWS_Y * 2 / 3, null);
	}
	
	/*
	 * Timer Method
	 */
	public void start() {
		// start timer operation
		timer.start(); 
	}

	public void stop() {
		// stop timer operation
		timer.stop(); 
	}

	boolean isRunning() {
		// alternative timer operation
		return timer.isRunning();
	}
}