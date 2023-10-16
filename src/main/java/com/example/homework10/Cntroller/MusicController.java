package com.example.homework10.Cntroller;

import com.example.homework10.Entity.Music;
import com.example.homework10.Form.MusicCreateForm;
import com.example.homework10.Service.MusicServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Validated
@RestController
public class MusicController {

    private final MusicServiceImpl musicService;


    public MusicController(MusicServiceImpl musicServiceImpl) {
        this.musicService = musicServiceImpl;
    }

    @GetMapping("/music")
    public List<Music> music() {
        return musicService.findAll();
    }

    @PostMapping("/music")
    public ResponseEntity<String> create(@Validated @RequestBody MusicCreateForm musicCreateForm, UriComponentsBuilder uriComponentsBuilder) {
        Music music = musicService.createMusic(musicCreateForm.getTitle(), musicCreateForm.getSinger());
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/music/" + music.getId())
                .build()
                .toUri();

        return ResponseEntity.created(url).body("music successfully created");
    }

    @ControllerAdvice
    public class MethodArgumentNotValidExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<String> handleValidationExceptions(
                MethodArgumentNotValidException ex) {
            String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                    .map(x -> x.getDefaultMessage())
                    .reduce("エラー", (a, b) -> {
                        if (a.isEmpty()) {
                            return b;
                        } else {
                            return a + ", " + b;
                        }
                    });

            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
