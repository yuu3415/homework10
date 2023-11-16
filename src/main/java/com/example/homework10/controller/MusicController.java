package com.example.homework10.controller;

import com.example.homework10.entity.Music;
import com.example.homework10.exception.NotMusicFoundException;
import com.example.homework10.form.MusicCreateForm;
import com.example.homework10.form.MusicUpdateForm;
import com.example.homework10.service.MusicService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Validated
@RestController
public class MusicController {

    private MusicService musicService;


    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/music")
    public List<Music> music() {
        return musicService.findAll();
    }

    @GetMapping("/music/{id}")
    public Music music(@PathVariable int id) {
        return musicService.findById(id);
    }

    @PostMapping("/music")
    public ResponseEntity<String> create(@Validated @RequestBody MusicCreateForm musicCreateForm, UriComponentsBuilder uriComponentsBuilder) {
        Music music = musicService.createMusic(musicCreateForm.getTitle(), musicCreateForm.getSinger());
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/music/" + music.getId())
                .build()
                .toUri();

        return ResponseEntity.created(url).body("music successfully created" + " id:" + music.getId());
    }


    @ExceptionHandler(value = NotMusicFoundException.class)
    public ResponseEntity<Map<String, String>> handleException(NotMusicFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", String.valueOf(System.currentTimeMillis()),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/music/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable int id, @Validated @RequestBody MusicUpdateForm musicUpdateForm) throws Exception {
        Music updateMusic = musicUpdateForm.convertToMusic(id, musicUpdateForm);
        musicService.updateMusic(id, updateMusic);
        return ResponseEntity.ok(Map.of("message", "music successfully updated"));
    }

    @DeleteMapping("/music/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable int id) throws Exception {
        musicService.deleteMusic(id);
        return ResponseEntity.ok(Map.of("message", "music successfully deleted"));
    }
}
