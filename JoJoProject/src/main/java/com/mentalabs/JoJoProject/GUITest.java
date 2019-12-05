package com.mentalabs.JoJoProject;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Base64;


import org.json.*;


public class GUITest{
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        String JSONPath = "./jojotest.json";
        Frame fr = new Frame("JOJOVisualizer by lorecast162");

        fr.setSize(width, height);
        fr.setVisible(true);
        fr.addWindowListener(new GestoreFinestra());

        Viewer v = new Viewer();
        JoJo toView = getJoJoFromFile(JSONPath);
        v.addJoJo(toView);
        v.loadWallPaper("./bg.png");
        v.setSize(width, height);
        v.setFont(new Font("Noto",0,20));
        fr.add(v);

        
    }

    public static JoJo getJoJoFromFile (String filePath) {
        JSONObject JSJoJo = null;
        JoJo out = null;
        String JSJoJoFileContens = "";
        try {
            File JSFile = new File(filePath);
            Scanner scanner = new Scanner(JSFile);
            while (scanner.hasNextLine()) {
                JSJoJoFileContens += scanner.nextLine();
            }
            scanner.close();

            JSJoJo = new JSONObject(JSJoJoFileContens);
            JSONObject JSONJoJoStats = JSJoJo.getJSONObject("stats");
            String jojoName = JSJoJo.getString("jojoName");
            String standName = JSJoJo.getString("standName");
            String standAbility = JSJoJo.getString("standAbility");
            String battleCry = JSJoJo.getString("battleCry");
            String[] stats = {JSONJoJoStats.getString("power"), JSONJoJoStats.getString("speed"), JSONJoJoStats.getString("range"), JSONJoJoStats.getString("durability"), JSONJoJoStats.getString("precision"), JSONJoJoStats.getString("potential")};
            Stand stand = new Stand(standName, standAbility, battleCry, stats);
            String JSONJoJoBirthDay = JSJoJo.getString("jojoBirthDay");
            Date birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(JSONJoJoBirthDay);
            out = new JoJo(jojoName, birthDay, stand);
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }
}
