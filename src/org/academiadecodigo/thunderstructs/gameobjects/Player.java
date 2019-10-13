package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.thunderstructs.UtilityMethods;


public class Player extends GameObjects {

    private boolean right;
    private boolean left;
    private boolean jumping;
    private boolean falling;

    private Position position;
    private Picture characterImage;
    private int jumpCounter;


    public Player(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
        this.position = position;
        this.characterImage = getObjectImage();

    }

    public void tick () {
        System.out.println("Teste");
        System.out.println("Right: " + getRight());
        if (right) {
            super.getObjectImage().translate(10, 0);
            position.setPosX(position.getPosX() + 10);
        }

        if (left) {
            super.getObjectImage().translate(-10, 0);
            position.setPosX(position.getPosX() - 10);
        }
/*
        if (jumping) {
            setGravity(false);
            position.setPosY(getPosY() - 2);
            characterImage.translate(0,-2);
            UtilityMethods.pause(7);
            jumpCounter++;

            if (jumpCounter >= 45) {
                this.jumping = false;
                setGravity(true);
                jumpCounter = 0;
            }
        }

        if (falling) {

        }
*/
    }
/*
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setLeft(false);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setRight(false);
                break;
        }
    }
*/

    @Override
    public void keyReleased (KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setLeft(false);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setRight(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setLeft(true);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setRight(true);
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

        if (jumping) {
            setGravity(false);
            position.setPosY(getPosY() - 2);
            characterImage.translate(0, -2);
            UtilityMethods.pause(7);
            jumpCounter++;

        }

        if (jumpCounter >= 45) {
            jumping = false;
            setGravity(true);
            jumpCounter = 0;
        }
    }

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }

    public void setRight (boolean setStatus) {
        this.right = setStatus;
    }

    public void setLeft (boolean setStatus) {
        this.left = setStatus;
    }

    public void setJumping (boolean setStatus) {
        this.jumping = setStatus;
    }

    public void setFalling (boolean setStatus) {
        this.falling = setStatus;
    }


    public void setJump() {
        jumping = true;
    }

    public boolean getRight () {
        return this.right;
    }

}
