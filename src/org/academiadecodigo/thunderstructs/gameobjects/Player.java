package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.thunderstructs.UtilityMethods;

public class Player extends GameObjects {

    private boolean right;
    private boolean left;
    private boolean jumping;
    private boolean falling;

    private int currentJumpSpeed;
    private int speed;
    private int jumpCounter;

    private int health;
    private Position position;
    private Picture characterImage;


    public Player(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.PLAYER);
        this.position = position;
        this.characterImage = getObjectImage();
        this.speed = 3;
        this.currentJumpSpeed = 3;

    }

    public void tick () {
        if (right) {
            super.getObjectImage().translate(speed, 0);
            position.setPosX(position.getPosX() + speed);
        }

        if (left) {
            super.getObjectImage().translate(-speed, 0);
            position.setPosX(position.getPosX() - speed);
        }

        if (jumping) {
            setGravity(false);
            smoothJump();

            position.setPosY(getPosY() - currentJumpSpeed);
            characterImage.translate(0,- currentJumpSpeed);
            UtilityMethods.pause(7);
            jumpCounter++;

            if (jumpCounter >= 50) {
                this.jumping = false;
                setGravity(true);
                jumpCounter = 0;
                currentJumpSpeed = speed;
            }
        }

        if (falling) {

        }

    }

    public void smoothJump () {
        if (jumpCounter == 30) {
            currentJumpSpeed--;
        }

        if (jumpCounter == 36) {
            currentJumpSpeed--;
        }

        if (jumpCounter == 44) {
            currentJumpSpeed--;
        }
    }

//TODO: Change KEY_SPACE with KEY_UP; Erase commented code; Improve jump smoothness (using speed...).
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

                if (position.getPosY() < Game.GAME_HEIGHT - ObjectType.PLAYER.getHeigth()) { //TODO: Change 2nd value once Collisions are working properly
                    break; //Send condition to "jumping" to allow continuous jumping while pressing up.
                }
                setJumping(true);
                break;
            case KeyboardEvent.KEY_SPACE:
                break;
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
