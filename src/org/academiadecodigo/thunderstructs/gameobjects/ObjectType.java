package org.academiadecodigo.thunderstructs.gameobjects;

public enum ObjectType {
    PERSON(50,50),
    MINIDARTHVADER(50,50),
    BLOCK(50,50);


    private int height;
    private int width;


    ObjectType(int height , int width){
        this.height = height;
        this.width = width;

    }

    public int getHeigth() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
