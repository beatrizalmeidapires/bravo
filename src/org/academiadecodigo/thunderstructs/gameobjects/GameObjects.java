package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameObjects implements Physics, KeyboardHandler {

    private Position position;
    private Rectangle person;

    public GameObjects(Position position, Rectangle person){
        this.position = position;
        this.person = person;
    }

    public void drawPerson() {
        person.setColor(Color.YELLOW);
        person.fill();
    }

    @Override
    public void collision() {

    }

    @Override
    public void gravity() {

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

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
