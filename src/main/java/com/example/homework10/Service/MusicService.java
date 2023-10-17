package com.example.homework10.Service;

import com.example.homework10.Entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music createMusic(String title, String singer);

    void updateMusic(int id, String title, String singer) throws Exception;
}
