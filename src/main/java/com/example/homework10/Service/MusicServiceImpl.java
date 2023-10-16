package com.example.homework10.Service;

import com.example.homework10.Entity.Music;
import com.example.homework10.Mapper.MusicMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicMapper musicMapper;

    public MusicServiceImpl(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    @Override
    public List<Music> findAll() {
        return musicMapper.findAll();
    }

    @Override
    public Music createMusic(String title, String singer) {
        Music MusicData = new Music(title, singer);
        musicMapper.createMusic(MusicData);
        return MusicData;
    }

    @Override
    public Music updateMusic(int id, String title, String singer) {
        Music MusicData = new Music(id, title, singer);
        musicMapper.updateMusic(MusicData);
        return MusicData;
    }
}
