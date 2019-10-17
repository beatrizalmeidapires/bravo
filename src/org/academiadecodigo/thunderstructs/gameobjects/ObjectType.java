package org.academiadecodigo.thunderstructs.gameobjects;

public enum ObjectType {
    PLAYER(40, 80),
    ENEMY(50, 50),
    REGULAR_BLOCK(80, 50),

    DESTROYABLE_BLOCK(50, 80),
    SNIPPET_BLOCK(50, 50),
    MENU(1000, 500);


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
