package com.mentalabs.JoJoProject;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Calendar bd = Calendar.getInstance();
        bd.set(2002, Calendar.OCTOBER, 22);

        String[] ChineseTakeoutStats = {"D","B","A","C","B","A"};

        Stand ChineseTakeout = new Stand("Chinese Takeout",
                "Fills your body with sriracha sauce causing incredible inner-body irritations.", "ZENG POUUUUUU~",
                ChineseTakeoutStats);
        JoJo life = new JoJo("Manny Manny", bd.getTime(), ChineseTakeout);

        // JoJo life = new JoJo();
        System.out.println(life);
        //System.out.println(ChineseTakeout);
        
    }
}