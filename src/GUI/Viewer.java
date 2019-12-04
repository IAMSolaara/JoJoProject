import java.awt.*;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
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
			int startX = 25;
			int startY = 50;

			Stand stand = jojo.getStand();

			Font font = getFont();
			int fontSize = font.getSize();
			Color[] curColor = {getForeground(), getBackground()};

			String standMasterHeader = "「ＳＴＡＮＤ　ＭＡＳＴＥＲ」";
			String standMasterName = jojo.getName();
			String standNameHeader = "「ＳＴＡＮＤ　ＮＡＭＥ」";
			String standName = stand.getName();

			g.drawString(standMasterHeader, startX, startY);
			g.drawString(standMasterName, startX, startY+fontSize);

			g.drawString(standNameHeader, getWidth(), getHeight());
			g.drawString(standName, getWidth(), getHeight());

			//draw stats
			String[] levels = {"E","D","C","B","A"};
			double[] testCoords = {150,300};
			int[] testCoordsInt = {(int)Math.floor(testCoords[0]), (int)Math.floor(testCoords[1])};
			double[][] newCoordsArray = new double[6][2];
			newCoordsArray[0] = testCoords;
			int circleRadius = (int)Math.floor(getDistFromLevel("A"));
			int[] circleStart = {testCoordsInt[0] - circleRadius, testCoordsInt[1] - circleRadius};

			g.drawOval(circleStart[0], circleStart[1], 2 * circleRadius, 2 * circleRadius);

			for (int i = 0; i < levels.length; i++) {
				int[] curCords = {};
				int curHeight = testCoordsInt[1] - (int)Math.floor(getDistFromLevel(levels[i]));
				g.drawLine(testCoordsInt[0]-4, curHeight, testCoordsInt[0]+4, curHeight);
				g.drawString(levels[i], testCoordsInt[0]+4, (curHeight + (fontSize/2)));
			}

			for (int i = 0; i < 6; i++) {
				
				double dist = getDistFromLevel(stand.getStats()[i]);
				double curAngle = (60 * i) * Math.PI / 180;
				double[] newCoords = calculateCoords(testCoords, curAngle, dist);

				g.drawLine(testCoordsInt[0], testCoordsInt[1], (int)Math.floor(calculateCoords(testCoords, curAngle, getDistFromLevel("A"))[0]), (int)Math.floor(calculateCoords(testCoords, curAngle, getDistFromLevel("A"))[1]));
				newCoordsArray[i] = newCoords;
			}
			
			//draw stats polygon
			int[] xPoints = {(int)Math.floor(newCoordsArray[0][0]), (int)Math.floor(newCoordsArray[1][0]), (int)Math.floor(newCoordsArray[2][0]), (int)Math.floor(newCoordsArray[3][0]), (int)Math.floor(newCoordsArray[4][0]), (int)Math.floor(newCoordsArray[5][0])};
			int[] yPoints = {(int)Math.floor(newCoordsArray[0][1]), (int)Math.floor(newCoordsArray[1][1]), (int)Math.floor(newCoordsArray[2][1]), (int)Math.floor(newCoordsArray[3][1]), (int)Math.floor(newCoordsArray[4][1]), (int)Math.floor(newCoordsArray[5][1])};
			g.drawPolygon(xPoints, yPoints, 6);
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
