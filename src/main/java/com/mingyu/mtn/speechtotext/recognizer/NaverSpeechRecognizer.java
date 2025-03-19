package com.mingyu.mtn.speechtotext.recognizer;

/**
 * SingleTon - Lazy Holder
 */
public class NaverSpeechRecognizer implements SpeechRecognizer {

    private static class LazyHolderNaver {
        private static final NaverSpeechRecognizer INSTANCE = new NaverSpeechRecognizer();
    }

    public static NaverSpeechRecognizer getInstance() {
        return LazyHolderNaver.INSTANCE;
    }

    @Override
    public String transcribe(byte[] audioData) throws Exception {
        return "";
    }
}
