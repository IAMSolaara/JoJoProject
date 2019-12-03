import java.awt.*;
import java.io.IOException;
import java.io.*;

import javax.imageio.ImageIO;

public class Viewer extends Canvas {
	private JoJo jojo;
	private Image wallpaper;

	public Viewer() {
		jojo = null;
		wallpaper = null;
	}

	public void addJoJo(JoJo in) {
		jojo = new JoJo(in);
	}

	public void loadWallPaper(String filepath) {
		try {
			File file = new File(filepath);
			wallpaper = ImageIO.read(file);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		if (wallpaper != null) g.drawImage(wallpaper, 0, 0,getWidth(), getHeight(), null );
		if (jojo != null) {
			int startX = 50;
			int startY = 50;

			Stand stand = jojo.getStand();

			g.drawString("「Ｓｔａｎｄ　ｕｓｅｒ：　" + jojo.getName() + "」", startX, startY);
			g.drawString("「Ｓｔａｎｄ　ｎａｍｅ：　" + stand.getName() + "」", startX, startY+10);

			double[] testCoords = {150,300};

			
			for (int i = 0; i < 6; i++) {
				double dist = getDistFromLevel(stand.getStats()[i]);
				double curAngle = (60 * i) * Math.PI / 180;
				double[] newCoords = calculateCoords(testCoords, curAngle, dist);

				g.drawLine((int)Math.floor(testCoords[0]), (int)Math.floor(testCoords[1]), (int)Math.floor(newCoords[0]), (int)Math.floor(newCoords[1]));
				g.drawString(stand.getStats()[i], (int)Math.floor(newCoords[0]), (int)Math.floor(newCoords[1]));
			}
		}
		else repaint();
	}

	public double[] calculateCoords(double[] coords, double angle, double dist) {
		double[] out = {coords[0] + dist * Math.sin(angle), coords[1] + dist * Math.cos(angle)};
		return out;
	}

	public double getDistFromLevel(String level){
		double out = 20;

		String[] levels = {"E","D","C","B","A"};

		if (level != null) {
			for (int i = 0; i < levels.length; i++) {
				if (level.equals(levels[i])) {
					out *= (i + 1);
				}

			}
		}
		return out;
	}

}
