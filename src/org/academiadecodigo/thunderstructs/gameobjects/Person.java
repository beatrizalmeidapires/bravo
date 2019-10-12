package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.thunderstructs.Game;

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

        if(!(position.getPosY() <=  Game.margin)) {
            person.translate(0, -10);
            position.setPosY(position.getPosY() - 10);
        }
    }

    public void moveDown() {

        if(!(position.getPosY() >= 800 - 40)) {
            person.translate(0, 10);
            position.setPosY(position.getPosY() + 10);
        }
    }

    public void moveLeft() {
        if(!(position.getPosX() <= Game.margin)) {
            person.translate(-10, 0);
            position.setPosX(position.getPosX() - 10);
        }
    }

    public void moveRight() {
        if(!(position.getPosX() >= 1500 - 60 )) {
            person.translate(10, 0);
            position.setPosX(position.getPosX() + 10);
        }
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
