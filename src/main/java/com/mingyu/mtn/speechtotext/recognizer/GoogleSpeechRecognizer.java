package com.mingyu.mtn.speechtotext.recognizer;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

/**
 * SingleTon - Lazy Initialization
 * Google Cloud Docs URL : https://cloud.google.com/speech-to-text/docs/client-libraries?hl=ko#client-libraries-java
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

        try (SpeechClient speechClient = SpeechClient.create()) {
            // RecognitionConfig 설정 (오디오 포맷, 언어, 샘플레이트 등)
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16) // 오디오 인코딩 형식 (예: LINEAR16)
                    .setLanguageCode("en-US")             // 언어 코드 (예: 한국어는 "ko-KR")
                    .setSampleRateHertz(16000)             // 오디오 샘플레이트 (예: 16000 Hz)
                    .build();

            // 오디오 데이터를 ByteString 으로 변환하여 RecognitionAudio 객체 생성
            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(ByteString.copyFrom(audioData))
                    .build();

            // 동기 방식으로 음성 인식 요청
            RecognizeResponse response = speechClient.recognize(config, audio);
            StringBuilder transcription = new StringBuilder();

            // 결과에서 최상의 인식 텍스트 추출
            for (SpeechRecognitionResult result : response.getResultsList()) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                transcription.append(alternative.getTranscript());
            }
            return transcription.toString();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception(exception);
        }
    }
}
