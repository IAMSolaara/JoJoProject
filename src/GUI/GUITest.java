import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class GUITest{
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        Frame fr = new Frame("JOJOVisualizer by lorecast162");

        fr.setSize(width, height);
        fr.setVisible(true);
        fr.addWindowListener(new GestoreFinestra());

        Viewer v = new Viewer();
        v.addJoJo(getJoJoFromFile("./objtest.bin"));
        //v.loadWallPaper("./bg.png");
        fr.add(v);

        v.setSize(width, height);
    }

    public static JoJo getJoJoFromFile (String filePath) {
        JoJo out = null;
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            out = (JoJo)objStream.readObject();
            objStream.close();
            System.out.println("Succesfully read object to file.");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }
}
