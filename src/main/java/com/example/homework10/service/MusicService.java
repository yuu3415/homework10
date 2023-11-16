package com.example.homework10.service;

import com.example.homework10.entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(int id);

    Music createMusic(String title, String singer);

    Music updateMusic(int id, Music musicUpdateForm) throws Exception;

    void deleteMusic(int id);

    int createMusic(Music music) throws Exception;
}
