package com.example.homework10.Form;

import com.example.homework10.Entity.Music;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class MusicUpdateForm {
    private int id;
    @NotBlank(message = "曲名は必須です")
    @Length(min = 1, max = 20)
    private String title;
    @NotBlank(message = "歌手名は必須です")
    @Length(min = 1, max = 20)
    private String singer;

    public MusicUpdateForm(int id, String title, String singer) {
        this.id = id;
        this.title = title;
        this.singer = singer;
    }

    public Music updateMusicInstance(int id, String title, String singer) {
        Music music = new Music(id, title, singer);
        return music;
    }
}
