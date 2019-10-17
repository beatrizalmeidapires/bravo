package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Block extends GameObjects {


    public Block(Position position, String picturePath, ObjectType objectType) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picturePath), objectType);
    }
}
