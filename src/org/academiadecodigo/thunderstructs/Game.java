package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.ObjectType;
import org.academiadecodigo.thunderstructs.gameobjects.Player;
import org.academiadecodigo.thunderstructs.gameobjects.Position;
import org.academiadecodigo.thunderstructs.gameobjects.RegularBlock;

public class Game {

    private Position position;
    private Position position1;
    private Position blockPosition;
    private Player player;
    private Player player1;
    private RegularBlock block;

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
        //Rectangle background = new Rectangle(MARGIN, MARGIN, GAME_WIDTH, GAME_HEIGHT);
        //background.setColor(Color.DARK_GRAY);
        //background.fill();

        Picture backgroundPicture = new Picture(MARGIN,MARGIN, "beautiful.png");
        backgroundPicture.draw();
    }

    public void init() {
        position = new Position(100, GAME_HEIGHT - ObjectType.PLAYER.getHeigth() + MARGIN);
        position1 = new Position(400, 200);
        player = new Player(position, "picture.png");
        player1 = new Player(position1, "character2.png");
        player1.drawObject();
        player.drawObject();

        blockPosition = new Position(600, GAME_HEIGHT - ObjectType.REGULAR_BLOCK.getHeigth() + MARGIN);
        block = new RegularBlock (blockPosition,"brickblock.png");
        block.drawObject();
    }


    public void start() {

        init();
        startKeyboard();
        while (!win) {

            if (player.getPosX() >= targetPosition.getPosX()) {
                Text winMessage = new Text(500, 500, "You win bro");
                winMessage.draw();
                winMessage.grow(300, 300);

                System.out.println("Agora é que é!!");
                win = true;

            }
            player.jump();
            player.gravity();
            //System.out.println(player.getPosY() + 134);
        }

    }

    public void startKeyboard() {

        Keyboard keyboard = new Keyboard(player);

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent jump = new KeyboardEvent();

        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        jump.setKey(KeyboardEvent.KEY_SPACE);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(jump);
    }
}
