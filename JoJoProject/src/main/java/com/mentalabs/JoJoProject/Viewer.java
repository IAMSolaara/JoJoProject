package com.mentalabs.JoJoProject;
import java.awt.*;
import java.io.IOException;
import java.util.Base64;
import java.io.*;
import javax.imageio.ImageIO;

public class Viewer extends Canvas {

	private static final long serialVersionUID = 6305371708070821094L;
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

			String standMasterHeader = "「STAND MASTER」";
			String standMasterName = jojo.getName();
			String standNameHeader = "「STAND NAME」";
			String standName = stand.getName();

			Polygon statsPolygon = new Polygon();

			g.setColor(Color.WHITE);

			g.drawString(standMasterHeader, startX, startY);
			g.drawString(standMasterName, startX, startY+fontSize);

			g.drawString(standNameHeader, getWidth() - (fontSize * standNameHeader.length()), getHeight() - fontSize * 3);
			g.drawString(standName, getWidth() - (fontSize * standName.length()), getHeight() - fontSize * 2);

			//draw stats
			String[] levels = {"E","D","C","B","A"};
			double[] statsOrigin = {150,300};
			int[] statsOriginInt = {(int)Math.floor(statsOrigin[0]), (int)Math.floor(statsOrigin[1])};
			double[][] newCoordsArray = new double[6][2];
			newCoordsArray[0] = statsOrigin;
			int circleRadius = (int)Math.floor(getDistFromLevel("A"));
			int[] circleStart = {statsOriginInt[0] - circleRadius, statsOriginInt[1] - circleRadius};

			//draw stats outer circle
			g.drawOval(circleStart[0], circleStart[1], 2 * circleRadius, 2 * circleRadius);

			//draw stats legend
			for (int i = 0; i < levels.length; i++) {
				int curHeight = statsOriginInt[1] - (int)Math.floor(getDistFromLevel(levels[i]));
				g.drawLine(statsOriginInt[0]-4, curHeight, statsOriginInt[0]+4, curHeight);
				g.drawString(levels[i], statsOriginInt[0]+4, (curHeight + (fontSize/2)));
			}
			for (int i = 0; i < 6; i++) {				
				double curAngle = (60 * i) * Math.PI / 180;
				g.drawLine(statsOriginInt[0], statsOriginInt[1], (int)Math.floor(calculateCoords(statsOrigin, curAngle, getDistFromLevel("A"))[0]), (int)Math.floor(calculateCoords(statsOrigin, curAngle, getDistFromLevel("A"))[1]));
			}

			for (int i = 0; i < 6; i++) {				
				double dist = getDistFromLevel(stand.getStats()[i]);
				double curAngle = (60 * i) * Math.PI / 180;
				double[] newCoords = calculateCoords(statsOrigin, curAngle, dist);
				statsPolygon.addPoint((int)Math.floor(newCoords[0]) , (int)Math.floor(newCoords[1]));
			}
			
			//draw stats polygon
			g.drawPolygon(statsPolygon);
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
