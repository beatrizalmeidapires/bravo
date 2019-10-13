package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Block extends GameObjects {

    private Position position;


    public Block(Position position, String picture) {
        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
        this.position = position;
    }

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }

}
