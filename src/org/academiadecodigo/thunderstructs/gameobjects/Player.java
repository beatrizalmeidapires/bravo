package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.thunderstructs.UtilityMethods;


public class Player extends GameObjects {

    private Position position;
    private Picture characterImage;
    private boolean jump;
    private int jumpCounter;


    public Player(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
        this.position = position;
        this.characterImage = getObjectImage();


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
            case KeyboardEvent.KEY_SPACE:
                setJump();
                break;
        }
    }

    public void jump() {

        if (jump) {
            setGravity(false);
            position.setPosY(getPosY() - 2);
            characterImage.translate(0, -2);
            UtilityMethods.pause(7);
            jumpCounter++;

        }

        if (jumpCounter >= 45) {
            jump = false;
            setGravity(true);
            jumpCounter = 0;
        }
    }

    public void setJump() {
        jump = true;
    }

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }

}
