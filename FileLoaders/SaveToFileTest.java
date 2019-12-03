import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class SaveToFileTest {
    public static void main(String[] args) {
        String filePath = "./objtest.bin";
        Calendar bd = Calendar.getInstance();
        bd.set(2002, Calendar.OCTOBER, 22);

        String[] ChineseTakeoutStats = {"D","B","A","C","B","A"};

        Stand ChineseTakeout = new Stand("Chinese Takeout",
                "Fills your body with sriracha sauce causing incredible inner-body irritations.", "ZENG POUUUUUU~",
                ChineseTakeoutStats);
        JoJo life = new JoJo("Manny Manny", bd.getTime(), ChineseTakeout);
        try {
            FileOutputStream fileStream = new FileOutputStream(filePath);
            ObjectOutputStream objOutStream = new ObjectOutputStream(fileStream);
            objOutStream.writeObject(life);
            objOutStream.close();
            System.out.println("Succesfully wrote object to file.");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
