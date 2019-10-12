package org.academiadecodigo.thunderstructs.gameobjects;

public enum ObjectType {
    PLAYER(50, 90),
    DARTHVADER(50, 50),
    REGULAR_BLOCK(50, 50),
    DESTROYABLE_BLOCK(50,50),
    SNIPPET_BLOCK(50,50);


    private int height;
    private int width;


    ObjectType(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public int getHeigth() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
