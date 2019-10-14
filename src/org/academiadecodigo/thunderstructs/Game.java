package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.*;

public class Game {

    private Position position;
    private Position position1;
    private Position blockPosition;
    private Position blockPosition2;
    private Player player;
    private Player player1;
    private RegularBlock block;
    private RegularBlock block2;
    private ObjectBoundaries bounds;

    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 624;
    public static final int MARGIN = 10;
    private Position targetPosition;
    private boolean win;

    public Game() {
        this.targetPosition = new Position(1100, 0);
        this.win = false;
    }

    public void drawBackground() {

        Picture backgroundPicture = new Picture(MARGIN,MARGIN, "beautiful.png");
        backgroundPicture.draw();
    }

    public void init() {
        position = new Position(100, GAME_HEIGHT - ObjectType.PLAYER.getHeigth() + MARGIN);
        player = new Player(position, "picture.png");
        player.drawObject();

        blockPosition = new Position(600, GAME_HEIGHT - 70);
        block = new RegularBlock (blockPosition,"brickblock.png");
        block.drawObject();


        //blockPosition2 = new Position(550, GAME_HEIGHT - ObjectType.REGULAR_BLOCK.getHeigth());
        //block2 = new RegularBlock (blockPosition2,"brickblock.png");
        //block2.drawObject();


        this.bounds = new ObjectBoundaries();
    }


    public void start() {

        init();
        startKeyboard();
        while (!win) {

            if (player.getPosX() >= targetPosition.getPosX()) {
                Text winMessage = new Text(500, 500, "You win bro");
                winMessage.draw();
                winMessage.grow(300, 300);

                win = true;
            }

            player.gravity();
            player.tick();

            player.setCollisionOnTop(bounds.checkCollisionOnTop(player, block));
            player.setCollisionOnBottom(bounds.checkCollisionOnBottom(player,block));
            player.setCollisionOnLeft(bounds.checkCollisionOnLeft(player, block));
            player.setCollisionOnRight(bounds.checkCollisionOnRight(player, block));

            //player.setCollisionOnTop(bounds.checkCollisionOnTop(player, block2));
            //player.setCollisionOnBottom(bounds.checkCollisionOnBottom(player,block2));
            //player.setCollisionOnLeft(bounds.checkCollisionOnLeft(player, block2));
            //player.setCollisionOnRight(bounds.checkCollisionOnRight(player, block2));
        }
    }

    public void startKeyboard() {

        Keyboard keyboard = new Keyboard(player);

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent leftReleased = new KeyboardEvent();

        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent rightReleased = new KeyboardEvent();

        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent jump = new KeyboardEvent();

        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        jump.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(left);
        keyboard.addEventListener(leftReleased);

        keyboard.addEventListener(right);
        keyboard.addEventListener(rightReleased);


        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(jump);
    }
}
