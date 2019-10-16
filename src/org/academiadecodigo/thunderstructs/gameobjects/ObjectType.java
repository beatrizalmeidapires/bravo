package org.academiadecodigo.thunderstructs.gameobjects;

public enum ObjectType {
    PLAYER(70, 80, "graphics/hero2.png"),
    ENEMY(50, 50, "MiniDarthVader.png"),
    REGULAR_BLOCK(80, 50, "bricket-block.jpeg"),

    DESTROYABLE_BLOCK(50, 80, "bricket-block.jpeg"),
    SNIPPET_BLOCK(50, 50, "bricket-block.jpeg");


    private int height;
    private int width;
    private String picture;


    ObjectType(int width, int height, String picture) {
        this.width = width;
        this.height = height;
        this.picture = picture;


    }

    public int getHeigth() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getPictureString() {
        return picture;
    }
}
