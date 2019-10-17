package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameObjects implements KeyboardHandler {


    private Picture objectImage;
    private Position position;
    private ObjectType objectType;

    private int width;
    private int height;

    private int gravityCounter;
    private int currentGravitySpeed;
    private boolean gravity;

    private boolean collisionOnTop;
    private boolean collisionOnBottom;
    private boolean collisionOnLeft;
    private boolean collisionOnRight;
    private boolean collisionOnBottomRight;
    private boolean collisionOnBottomLeft;



    public GameObjects (Position position, Picture objectImage, ObjectType objectType) {
        this.objectImage = objectImage;
        this.position = position;
        this.objectType = objectType;
        this.gravity = true;
        this.width = objectType.getWidth();
        this.height = objectType.getHeigth();
        this.currentGravitySpeed = 0;
    }

    public void drawObject() {
        objectImage.draw();
    }

    public void deleteObject() {
        objectImage.delete();
    }

    public void moveUp() {

        if (!(position.getPosY() <= Game.MARGIN)) {
            objectImage.translate(0, -1);
            position.setPosY(position.getPosY() - 1);
        }
    }

    public void moveDown() {

        if (!(position.getPosY() >= Game.GAME_HEIGHT - objectType.getHeigth())) {
            objectImage.translate(0, 1);
            position.setPosY(position.getPosY() + 1);
        }
    }

    public void moveLeft() {

        if (!(position.getPosX() <= Game.MARGIN)) {

            objectImage.translate(-1, 0);
            position.setPosX(position.getPosX() + -1);
        }
    }

    public void moveRight() {
        if (!(position.getPosX() >= Game.GAME_WIDTH - 60)) {

            objectImage.translate(1, 0);
            position.setPosX(position.getPosX() + 1);
        }
    }

    public void gravity() {

        if (!gravity) {
            return;
        }

        if (!isCollisionOnBottom()) {

            if (gravityCounter == 6) {
                currentGravitySpeed++;
            }

            if (gravityCounter == 14) {
                currentGravitySpeed++;
            }

            if (gravityCounter == 24) {
                currentGravitySpeed++;
            }

            gravityCounter++;

            objectImage.translate(0, +currentGravitySpeed);
            position.setPosY(position.getPosY() + currentGravitySpeed);

        } else {

            gravityCounter = 0;
            currentGravitySpeed = 0;
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

            case KeyboardEvent.KEY_R:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public Picture getObjectImage() {
        return this.objectImage;
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

    public boolean isCollisionOnBottomRight(){
        return collisionOnBottomRight;
    }

    public boolean isCollisionOnBottomLeft(){
        return collisionOnBottomLeft;
    }

    public void setGravity(boolean gravityStatus) {
        this.gravity = gravityStatus;
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

    public void setCollisionOnBottomRight(boolean collisionOnBottomRight){
        this.collisionOnBottomRight = collisionOnBottomRight;
    }

    public void setCollisionOnBottomLeft(boolean collisionOnBottomLeft){
        this.collisionOnBottomLeft = collisionOnBottomLeft;
    }
}

