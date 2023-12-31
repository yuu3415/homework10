package com.example.homework10.service;

import com.example.homework10.entity.Music;
import com.example.homework10.exception.MusicDuplicationException;
import com.example.homework10.exception.NotMusicFoundException;
import com.example.homework10.mapper.MusicMapper;
import org.springframework.dao.DuplicateKeyException;
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
    public Music findById(int id) {
        return musicMapper.findById(id).orElseThrow(() -> new NotMusicFoundException("Music not found"));
    }

    @Override
    public Music createMusic(String title, String singer) {
        try {
            Music music = new Music();
            music.setTitle(title);
            music.setSinger(singer);
            musicMapper.createMusic(music);
            return music;
        } catch (DuplicateKeyException e) {
            throw new MusicDuplicationException("このタイトルのミュージックは既に存在しています");
        }
    }


    @Override
    public void updateMusic(int id, String title, String singer) throws NotMusicFoundException {
        musicMapper.findById(id).orElseThrow(() -> new NotMusicFoundException("Music not found"));
        musicMapper.updateMusic(id, title, singer);

    }

    @Override
    public void deleteMusic(int id) {
        musicMapper.deleteMusic(id);
    }

}
