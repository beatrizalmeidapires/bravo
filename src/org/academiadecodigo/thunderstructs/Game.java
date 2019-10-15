package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.*;

public class Game {

    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 624;
    public static final int MARGIN = 10;

    private Position playerPosition;
    private Player player;
    private ObjectBoundaries bounds;

    private Position targetPosition;
    private boolean win;

    GameMap gameBlocks = new GameMap();
    RegularBlock[] blocks;

    public Game() {
        this.targetPosition = new Position(1100, 0);
        this.win = false;
    }

    public void drawBackground() {

        Picture backgroundPicture = new Picture(MARGIN,MARGIN, "beautiful.png");
        backgroundPicture.draw();
    }

    public void init() {
        playerPosition = new Position(100, GAME_HEIGHT - ObjectType.PLAYER.getHeigth());
        player = new Player(playerPosition, "picture.png");
        player.drawObject();

        blocks = gameBlocks.getRegularBlocks();

        for (int i = 0; i < blocks.length; i++) {
            blocks[i].drawObject();
        }

        this.bounds = new ObjectBoundaries();
    }


    public void start() {

        init();
        UtilityMethods.startKeyboard(player);
        while (!win) {

            if (player.getPosX() >= targetPosition.getPosX()) {
                winAnimation();
                win = true;
            }

            checkAllColls(player, blocks);

            player.tick();
            player.gravity();

            UtilityMethods.pause(7);
        }
    }

    public void checkAllColls (GameObjects movable, GameObjects[] objects) {

        boolean collRight = false;
        boolean collLeft = false;
        boolean collTop = false;
        boolean collBottom = false;

        for (GameObjects o : objects) {

            if (bounds.checkCollisionOnRight(movable, o)) {
                collRight = true;
            }

            if (bounds.checkCollisionOnLeft(movable, o)) {
                collLeft = true;
            }

            if (bounds.checkCollisionOnTop(movable, o)) {
                collTop = true;
            }

            if (bounds.checkCollisionOnBottom(movable, o)) {
                collBottom = true;
            }

        }

        movable.setCollisionOnRight(collRight);
        movable.setCollisionOnLeft(collLeft);
        movable.setCollisionOnTop(collTop);
        movable.setCollisionOnBottom(collBottom);
    }

    private void winAnimation(){

        Text winMessage = new Text(600, 300, "You win bro");
        winMessage.setColor(Color.GREEN);
        winMessage.draw();
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
        UtilityMethods.pause(100);
        winMessage.grow(50, 50);
    }

}
