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

    private int spriteCounter;


    public Player(Position position, String picturePath, Game game) {

        super(position, new Picture((position.getPosX() + 10), position.getPosY(), picturePath), ObjectType.PLAYER);
        this.characterImage = getObjectImage();
        this.position = position;
        this.maxSpeed = 3;
        this.currentJumpSpeed = 3;
        this.currentRightSpeed = 1;
        this.rightMovementCounter = 0;
        this.spriteCounter = 0;
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

    public void updateLeftImage () {

        if (spriteCounter == 10) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left1.png");
        }
        if (spriteCounter == 20) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left2.png");
        }
        if (spriteCounter == 30) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left3.png");
        }
        if (spriteCounter == 40) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left4.png");
        }
        if (spriteCounter == 50) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left5.png");
        }
        if (spriteCounter == 60) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left6.png");
        }
        if (spriteCounter == 70) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left7.png");
        }
        if (spriteCounter == 80) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left8.png");
        }
        if (spriteCounter == 90) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left9.png");
        }
        if (spriteCounter == 100) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left10.png");
        }
        if (spriteCounter == 110) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left11.png");
        }
        if (spriteCounter == 120) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left12.png");
        }
        if (spriteCounter == 130) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left14.png");
        }
        if (spriteCounter == 140) {
            super.getObjectImage().load("resources/graphics/left_sprite/run_left15.png");
            spriteCounter = 0;
        }
        spriteCounter +=2;
    }

    public void updateRightImage () {

        if (spriteCounter == 10) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run1.png");
        }
        if (spriteCounter == 20) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run2.png");
        }
        if (spriteCounter == 30) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run3.png");
        }
        if (spriteCounter == 40) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run4.png");
        }
        if (spriteCounter == 50) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run5.png");
        }
        if (spriteCounter == 60) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run6.png");
        }
        if (spriteCounter == 70) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run7.png");
        }
        if (spriteCounter == 80) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run8.png");
        }
        if (spriteCounter == 90) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run9.png");
        }
        if (spriteCounter == 100) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run10.png");
        }
        if (spriteCounter == 110) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run11.png");
        }
        if (spriteCounter == 120) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run12.png");
        }
        if (spriteCounter == 130) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run14.png");
        }
        if (spriteCounter == 140) {
            super.getObjectImage().load("resources/graphics/right_sprite/Run15.png");
            System.out.println("teste");
            spriteCounter = 0;
        }
        spriteCounter +=2;
    }



    @Override
    public void moveRight () {

        updateRightImage();

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

        System.out.println(spriteCounter);
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

        updateLeftImage();

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
