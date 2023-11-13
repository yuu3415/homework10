package com.example.homework10.form;

public class MusicCreateForm {
    private String title;
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
