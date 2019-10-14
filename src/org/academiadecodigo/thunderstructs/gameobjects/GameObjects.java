package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.thunderstructs.UtilityMethods;

public class GameObjects implements Physics, KeyboardHandler {

    private Position position;
    private Picture objectImage;
    private boolean gravity;

    private int maxGravitySpeed;
    private int currentGravitySpeed;
    private int gravityCounter;

    private boolean collisionOnTop;
    private boolean collisionOnBottom;
    private boolean collisionOnLeft;
    private boolean collisionOnRight;


    private int width;
    private int height;



    public GameObjects (Position position, Picture objectImage, ObjectType objectType) {
        this.position = position;
        this.objectImage = objectImage;
        this.gravity = true;
        this.width = objectType.getWidth();
        this.height = objectType.getHeigth();

        this.currentGravitySpeed = 0;
        this.maxGravitySpeed = 3;
    }

    public void drawObject() {
        objectImage.draw();
    }

    @Override
    public void collision() {

    }

    @Override
    public void gravity() {

        if (!gravity) {
            return;
        }
/*
        if (position.getPosY() >= Game.GAME_HEIGHT - 80) {
            currentGravitySpeed = 0;
            return;
        }

        if (isCollisionOnBottom()) {
            currentGravitySpeed = 0;
            return;
        }
*/
        if (!(position.getPosY() >= Game.GAME_HEIGHT - 80) && !isCollisionOnBottom()) {

            if (gravityCounter == 4) {
                currentGravitySpeed++; //1
            }

            if (gravityCounter == 8) {
                currentGravitySpeed++; //2
            }

            if (gravityCounter == 12)
                currentGravitySpeed++; //3

            System.out.println(currentGravitySpeed);

            gravityCounter++;
            objectImage.translate(0, +currentGravitySpeed);
            position.setPosY(position.getPosY() + currentGravitySpeed);
        } else {
            gravityCounter = 0;
            currentGravitySpeed = 0;
        }


        UtilityMethods.pause(7);
    }

    public void moveUp() {

        if (!(position.getPosY() <= Game.MARGIN)) {
            objectImage.translate(0, -10);
            position.setPosY(position.getPosY() - 10);
        }
    }

    public void moveDown() {

        if (!(position.getPosY() >= Game.GAME_HEIGHT - ObjectType.PLAYER.getHeigth())) {
            objectImage.translate(0, 10);
            position.setPosY(position.getPosY() + 10);
        }
    }

    public void moveLeft() {
        if (!(position.getPosX() <= Game.MARGIN)) {
            objectImage.translate(-10, 0);
            position.setPosX(position.getPosX() - 10);
        }
    }

    public void moveRight() {
        if (!(position.getPosX() >= Game.GAME_WIDTH - 60)) {
            objectImage.translate(10, 0);
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

    public Picture getObjectImage() {
        return this.objectImage;
    }

    public void setGravity(boolean gravityStatus) {
        this.gravity = gravityStatus;
    }

    public Position getPosition () {
        return this.position;
    }

    public int getWidth () {
        return this.width;
    }

    public int getHeight () {
        return this.height;
    }

    public void setCollisionOnTop(boolean collisionOnTop) {
        this.collisionOnTop = collisionOnTop;
    }

    public void setCollisionOnBottom(boolean collisionOnBottom) {
        this.collisionOnBottom = collisionOnBottom;
    }

    public void setCollisionOnLeft(boolean collisionOnLeft) {
        this.collisionOnLeft = collisionOnLeft;
    }

    public void setCollisionOnRight(boolean collisionOnRight) {
        this.collisionOnRight = collisionOnRight;
    }

    public boolean isCollisionOnTop() {
        return collisionOnTop;
    }

    public boolean isCollisionOnBottom() {
        return collisionOnBottom;
    }

    public boolean isCollisionOnLeft() {
        return collisionOnLeft;
    }

    public boolean isCollisionOnRight() {
        return collisionOnRight;
    }
}

