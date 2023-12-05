package com.example.homework10.service;

import com.example.homework10.entity.Music;
import com.example.homework10.exception.NotMusicFoundException;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(int id);

    Music createMusic(String title, String singer) throws Exception;

    void updateMusic(int id, String title, String singer) throws NotMusicFoundException;

    void deleteMusic(int id);


}
