package com.mingyu.mtn.speechtotext.recognizer;

/**
 * SingleTon - Eager Initialization
 */
public class AwsSpeechRecognizer implements SpeechRecognizer {

    private static final AwsSpeechRecognizer INSTANCE = new AwsSpeechRecognizer();

    public static AwsSpeechRecognizer getInstance() {
        return INSTANCE;
    }

    @Override
    public String transcribe(byte[] audioData) throws Exception {
        return "";
    }
}
