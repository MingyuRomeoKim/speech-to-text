package com.mingyu.mtn.speechtotext.api;

import com.mingyu.mtn.speechtotext.factory.SpeechRecognizerFactory;
import com.mingyu.mtn.speechtotext.recognizer.SpeechRecognizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speech")
public class SpeechController {

    /**
     * Provider와 오디오 데이터를 받아 음성 인식 결과를 반환합니다.
     * @param provider : google, aws, azure, naver
     * @param audioData : 오디오 데이터
     * @return : 음성 인식 결과
     */
    @PostMapping("/transcribe")
    public ResponseEntity<String> transcribe(
            @RequestParam("provider") String provider,
            @RequestBody byte[] audioData
    ) {
        SpeechRecognizer speechRecognizer = SpeechRecognizerFactory.getSpeechRecognizer(provider);

        try {
            String result = speechRecognizer.transcribe(audioData);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}
