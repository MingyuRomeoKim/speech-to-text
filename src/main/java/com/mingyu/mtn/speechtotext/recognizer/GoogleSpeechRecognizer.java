package com.mingyu.mtn.speechtotext.recognizer;

/**
 * SingleTon - Lazy Initialization
 */
public class GoogleSpeechRecognizer implements SpeechRecognizer{

    private static GoogleSpeechRecognizer instance;

    public static GoogleSpeechRecognizer getInstance() {
        if (instance == null) {
            synchronized (GoogleSpeechRecognizer.class) {
                if (instance == null) {
                    instance = new GoogleSpeechRecognizer();
                }
            }
        }
        return instance;
    }
    
    @Override
    public String transcribe(byte[] audioData) throws Exception {
        return "";
    }
}
