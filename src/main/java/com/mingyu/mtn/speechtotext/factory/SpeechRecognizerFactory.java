package com.mingyu.mtn.speechtotext.factory;

import com.mingyu.mtn.speechtotext.recognizer.*;

public class SpeechRecognizerFactory {
    
    public static SpeechRecognizer getSpeechRecognizer(String provider) {

        switch (provider) {
            case "google":
                return GoogleSpeechRecognizer.getInstance();
            case "aws":
                return AwsSpeechRecognizer.getInstance();
            case "azure":
                return AzureSpeechRecognizer.getInstance();
            case "naver":
                return NaverSpeechRecognizer.getInstance();
            default:
                throw new IllegalArgumentException("지원하지 않는 provider: " + provider);
        }
    }
}
