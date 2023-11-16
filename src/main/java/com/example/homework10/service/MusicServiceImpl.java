package com.example.homework10.service;

import com.example.homework10.entity.Music;
import com.example.homework10.exception.NotMusicFoundException;
import com.example.homework10.mapper.MusicMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Music findById(int id) {
        Optional<Music> music = Optional.ofNullable(musicMapper.findById(id));
        return music.orElseThrow(() -> new NotMusicFoundException("Music not found"));
    }

    @Override
    public Music createMusic(String title, String singer) {
        Music MusicData = new Music(title, singer);
        musicMapper.createMusic(MusicData);
        return MusicData;
    }


    @Override
    public Music updateMusic(int id, Music updateMusic) throws Exception {
        musicMapper.updateMusic(updateMusic);
        return updateMusic;
    }

    @Override
    public void deleteMusic(int id) {
        musicMapper.deleteMusic(id);
    }

    @Override
    public int createMusic(Music music) throws Exception {
        try {
            musicMapper.createMusic(music);
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("ミュージックは既にあります", e);
        }
        return music.getId();
    }

}
