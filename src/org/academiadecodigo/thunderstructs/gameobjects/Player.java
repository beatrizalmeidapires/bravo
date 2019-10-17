package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.thunderstructs.Game;

public class Player extends GameObjects {

    private Picture characterImage;
    private Position position;

    private Game game;

    private boolean right;
    private boolean left;
    private boolean jumping;

    private int maxSpeed;
    private int currentJumpSpeed;
    private int jumpCounter;

    private int currentRightSpeed;
    private int rightMovementCounter;
    private int rightStoppingCounter;

    private int currentLeftSpeed;
    private int leftMovementCounter;
    private int leftStoppingCounter;


    public Player(Position position, String picturePath, Game game) {

        super(position, new Picture(position.getPosX() - 5, position.getPosY(), picturePath), ObjectType.PLAYER);
        this.characterImage = getObjectImage();
        this.position = position;
        this.maxSpeed = 3;
        this.currentJumpSpeed = 3;
        this.currentRightSpeed = 1;
        this.rightMovementCounter = 0;
        this.game = game;
    }

    public void moveWorldObjects (int x, int x2) {

        for (Object o : game.getWorldObjects()) {

            if (!(o instanceof GameObjects)) {
                return;
            }

            ((GameObjects) o).getObjectImage().translate(x, 0);
            ((GameObjects) o).getPosition().setPosX(((GameObjects) o).getPosition().getPosX() - x2);
        }
    }

    @Override
    public void moveRight () {

        rightStoppingCounter = 0;

        if (rightMovementCounter == 8) {
            currentRightSpeed++;
        }

        if (rightMovementCounter == 12) {
            currentRightSpeed++;
        }

        if (currentRightSpeed > maxSpeed) {
            currentRightSpeed = maxSpeed;
        }


        if (position.getPosX() < ((Game.GAME_WIDTH/2) + (Game.GAME_WIDTH/7))) {

            super.getObjectImage().translate(currentRightSpeed,0);
            position.setPosX(position.getPosX() + currentRightSpeed);

            rightMovementCounter++;
            return;
        }

        moveWorldObjects(-currentRightSpeed, currentRightSpeed);

        rightMovementCounter++;
    }

    public void stopRight () {

        rightMovementCounter = 0; //if > 0 (rightMovementCounter--)

        if (rightStoppingCounter == 8) {
            currentRightSpeed--;
        }

        if (rightStoppingCounter == 12) {
            currentRightSpeed--;
        }

        if (rightStoppingCounter == 16) {
            currentRightSpeed--;
        }

        if (currentRightSpeed < 0) {
            currentRightSpeed = 0;
        }

        if (position.getPosX() < (Game.GAME_WIDTH/2 + (Game.GAME_WIDTH/7))) {

            super.getObjectImage().translate(currentRightSpeed,0);
            position.setPosX(position.getPosX() + currentRightSpeed);

            rightStoppingCounter++;
            return;
        }

        moveWorldObjects(-currentRightSpeed, currentRightSpeed);

        rightStoppingCounter++;
    }

    @Override
    public void moveLeft () {

        if (position.getPosX() < 100) {
            return;
        }

        leftStoppingCounter = 0;

        if (leftMovementCounter == 8) {
            currentLeftSpeed++;
        }

        if (leftMovementCounter == 12) {
            currentLeftSpeed++;
        }

        if (currentLeftSpeed > maxSpeed) {
            currentLeftSpeed = maxSpeed;
        }

        if (position.getPosX() > (Game.GAME_WIDTH/2 - (Game.GAME_WIDTH/4))) {

            super.getObjectImage().translate(-currentLeftSpeed, 0);
            position.setPosX(position.getPosX() - currentLeftSpeed);

            leftMovementCounter++;
            return;
        }

        moveWorldObjects(currentLeftSpeed, -currentLeftSpeed);

        leftMovementCounter++;
    }

    public void stopLeft() {
        leftMovementCounter = 0;

        if (leftStoppingCounter == 8) {
            currentLeftSpeed--;
        }

        if (leftStoppingCounter == 12) {
            currentLeftSpeed--;
        }

        if (leftStoppingCounter == 16) {
            currentLeftSpeed--;
        }

        if (currentLeftSpeed < 0) {
            currentLeftSpeed = 0;
        }

        if (position.getPosX() > (Game.GAME_WIDTH/2 - (Game.GAME_WIDTH/4))) {

            super.getObjectImage().translate(-currentLeftSpeed, 0);
            position.setPosX(position.getPosX() - currentLeftSpeed);

            leftStoppingCounter++;
            return;
        }

        moveWorldObjects(currentLeftSpeed, -currentLeftSpeed);

        leftStoppingCounter++;
    }

    public void jump () {

        setGravity(false);
        smoothJump();

        position.setPosY(getPosY() - currentJumpSpeed);
        characterImage.translate(0,- currentJumpSpeed);
        jumpCounter++;

        if (jumpCounter >= 50) {
            this.jumping = false;
            setGravity(true);
            jumpCounter = 0;
            currentJumpSpeed = maxSpeed;
        }
    }


    public void tick () {

        if (right && !isCollisionOnRight()) {
            moveRight();
        }

        if (!right) {

            if (isCollisionOnRight()) {
                currentRightSpeed = 0;
            }

            stopRight();
        }

        if (left && !isCollisionOnLeft()) {
            moveLeft();
        }

        if (!left) {

            if (isCollisionOnLeft()) {
                currentLeftSpeed = 0;
            }
            
            stopLeft();
        }

        if (jumping) {

            if (!isCollisionOnTop()) {
                jump();
                return;
            }

            setJumping(false);
            jumpCounter = 0;
            setGravity(true);
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

            case KeyboardEvent.KEY_SPACE:

                if (isCollisionOnBottom()) {
                    setJumping(true);
                    break;
                }

                if (position.getPosY() < Game.GAME_HEIGHT - ObjectType.PLAYER.getHeigth()) {
                    break;
                }

                setJumping(true);
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
}
