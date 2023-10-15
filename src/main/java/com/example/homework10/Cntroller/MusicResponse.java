package com.example.homework10.Cntroller;

public class MusicResponse {
    private String title;
    private String singer;

    public MusicResponse(String title, String singer) {
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
