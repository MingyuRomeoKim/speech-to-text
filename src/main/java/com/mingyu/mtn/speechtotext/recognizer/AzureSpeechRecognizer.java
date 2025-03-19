package com.mingyu.mtn.speechtotext.recognizer;

/**
 * SingleTon - Lazy Holder
 */
public class AzureSpeechRecognizer implements SpeechRecognizer {

    private static class LazyHolderAzure {
        private static final AzureSpeechRecognizer INSTANCE = new AzureSpeechRecognizer();
    }

    public static AzureSpeechRecognizer getInstance() {
        return LazyHolderAzure.INSTANCE;
    }

    @Override
    public String transcribe(byte[] audioData) throws Exception {
        return "";
    }
}
