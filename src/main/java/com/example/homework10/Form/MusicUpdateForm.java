package com.example.homework10.Form;

public class MusicUpdateForm {
    private int id;
    private String title;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
