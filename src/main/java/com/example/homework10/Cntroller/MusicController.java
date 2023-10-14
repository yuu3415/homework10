package com.example.homework10.Cntroller;

import com.example.homework10.Entity.Music;
import com.example.homework10.Service.MusicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {

    private final MusicService musicService;


    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/music")
    public List<Music> getMusic() {
        return musicService.getMusic();
    }
}
