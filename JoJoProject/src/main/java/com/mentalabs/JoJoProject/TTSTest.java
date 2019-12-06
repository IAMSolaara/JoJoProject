package com.mentalabs.JoJoProject;

public class TTSTest {
    public static void main(String[] args) {
        SpeechSynthesizer Synth = new SpeechSynthesizer("ece84e0fb0de41dba61e03622adf0559");
        Synth.speak("TEST");
    }
}