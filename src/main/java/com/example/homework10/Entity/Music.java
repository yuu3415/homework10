package com.example.homework10.Entity;


public class Music {
    private int id;

    private String title;

    private String singer;


    public Music(String title, String singer) {

        this.title = title;
        this.singer = singer;

    }


    public Music(int id, String title, String singer) {
        this.id = id;
        this.title = title;
        this.singer = singer;

    }

    public Music() {
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {

        return singer;
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
