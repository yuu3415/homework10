package com.example.homework10.Service;

import com.example.homework10.Entity.Music;
import com.example.homework10.Form.MusicUpdateForm;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music createMusic(String title, String singer);

    Music updateMusic(MusicUpdateForm musicUpdateForm) throws Exception;
}
