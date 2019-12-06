package com.mentalabs.JoJoProject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javazoom.jlgui.basicplayer.BasicPlayer;

public class SpeechSynthesizer {
    private String apiKey;

    public SpeechSynthesizer(String apiKey) {
        if (apiKey != null) {
            this.apiKey = apiKey;
        } else {
            this.apiKey = null;
        }
    }

    public void speak(String toSpeak) {
        try {
            //prepare voiceRSS api url string
            String urlString = "https://api.voicerss.org/?key=" + apiKey + "&hl=en-us&src=" + urlEncode(toSpeak);
            System.out.println(urlString);
            //create BasicPlayer object
            BasicPlayer player = new BasicPlayer();
            //open voiceRSS java file from url string
            player.open(new URL(urlString));
            //play that
            player.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String urlEncode(String toEncode) {
        try {
            return URLEncoder.encode(toEncode, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}