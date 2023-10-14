package com.example.homework10.Service;

import com.example.homework10.Entity.Music;
import com.example.homework10.Mapper.MusicMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicMapper musicMapper;

    public MusicService(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    public List<Music> getMusic() {
        List<Music> music = musicMapper.findAll();
        return music;

    }
}
