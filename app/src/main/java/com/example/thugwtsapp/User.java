package com.example.thugwtsapp;

class User {

    int image;
    String name;
    int music;

    public User(int image, String name,int music) {
        this.image = image;
        this.name = name;
        this.music=music;
    }


    public int getMusic() {
        return music;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
