package com.example.homework10.Form;

import com.example.homework10.Entity.Music;
import lombok.Data;

@Data
public class MusicUpdateForm {
    private int id;
    private String title;
    private String singer;

    public Music convertToMusic() {
        return new Music(this.id, this.title, this.singer);
    }
}
