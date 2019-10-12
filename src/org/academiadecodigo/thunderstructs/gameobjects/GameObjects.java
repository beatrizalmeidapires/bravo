package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameObjects implements Physics, KeyboardHandler {

    private Position position;
    private Picture person;

    public GameObjects(Position position, Picture person){
        this.position = position;
        this.person = person;
    }

    public void drawPerson() {
        person.draw();
    }

    @Override
    public void collision() {

    }

    @Override
    public void gravity() {

    }

    public void moveUp() {

        if(!(position.getPosY() <=  Game.MARGIN)) {
            person.translate(0, -10);
            position.setPosY(position.getPosY() - 10);
        }
    }

    public void moveDown() {

        if(!(position.getPosY() >= Game.GAME_HEIGHT - 40)) {
            person.translate(0, 10);
            position.setPosY(position.getPosY() + 10);
        }
    }

    public void moveLeft() {
        if(!(position.getPosX() <= Game.MARGIN)) {
            person.translate(-10, 0);
            position.setPosX(position.getPosX() - 10);
        }
    }

    public void moveRight() {
        if(!(position.getPosX() >= Game.GAME_WIDTH - 60 )) {
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
