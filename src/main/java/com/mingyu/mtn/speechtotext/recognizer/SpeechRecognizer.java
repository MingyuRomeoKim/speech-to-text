package com.mingyu.mtn.speechtotext.recognizer;

public interface SpeechRecognizer {
    /**
     * 오디오 데이터를 받아 음석 인식 결과를 반환합니다.
     */
    String transcribe(byte[] audioData) throws Exception;
}
