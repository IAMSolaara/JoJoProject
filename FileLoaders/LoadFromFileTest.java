import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadFromFileTest {
    public static void main(String[] args) {
        String filePath = "./objtest.bin";
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            JoJo life = (JoJo)objStream.readObject();
            objStream.close();
            System.out.println("Succesfully read object to file.");
            System.out.println(life);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}