package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Person implements KeyboardHandler {

    private Rectangle person;
    private Position position;

    public Person(Position position) {
        this.position = position;
    }

    public void drawPerson() {

        person = new Rectangle(position.getPosX(), position.getPosY(), 70, 50);
        person.setColor(Color.YELLOW);
        person.fill();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
        }
    }

    public void moveUp() {
        person.translate(0, -20);
        position.setPosY(position.getPosY() - 20);
    }

    public void moveDown() {
        person.translate(0, 20);
        position.setPosY(position.getPosY() + 20);
    }

    public void moveLeft() {
        person.translate(-20, 0);
        position.setPosX(position.getPosX() - 20);
    }

    public void moveRight() {
        person.translate(20, 0);
        position.setPosX(position.getPosX() + 20);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }


}
