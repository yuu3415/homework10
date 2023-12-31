package com.example.homework10.form;

import com.example.homework10.entity.Music;
import lombok.Data;

@Data
public class MusicUpdateForm {
    private int id;
    private String title;
    private String singer;

    public Music convertToMusic(int id, MusicUpdateForm musicUpdateForm) {
        return new Music(id, this.title, this.singer);
    }
}
