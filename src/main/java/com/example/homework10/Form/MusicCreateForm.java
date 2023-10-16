package com.example.homework10.Form;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class MusicCreateForm {
    @NotBlank(message = "曲名は必須です")
    @Length(min = 1, max = 20)
    private String title;
    @NotBlank(message = "歌手名は必須です")
    @Length(min = 1, max = 20)
    private String singer;

    public MusicCreateForm(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSinger() {
        return this.singer;
    }
}
