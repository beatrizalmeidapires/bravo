package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Person extends GameObjects {

    private Position position;

    public Person(Position position) {

        super(position, new Rectangle(position.getPosX(), position.getPosY(), 70, 50));
        this.position = position;

    }

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }

}
