package com.example.homework10.Form;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSinger() {
        return this.singer;
    }
}
