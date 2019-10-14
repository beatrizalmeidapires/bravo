package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.*;

public class Game {

    private Position position;
    private Position blockPosition;
    private Position blockPosition2;
    private Player player;
    private RegularBlock block;
    private RegularBlock block2;

    private GameObjects[] worldObjects;

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
        position = new Position(100, GAME_HEIGHT - ObjectType.PLAYER.getHeigth());
        player = new Player(position, "picture.png");
        player.drawObject();

        blockPosition = new Position(600, GAME_HEIGHT - ObjectType.REGULAR_BLOCK.getHeigth());
        block = new RegularBlock (blockPosition,"brickblock.png");
        block.drawObject();

        blockPosition2 = new Position(800, GAME_HEIGHT - ObjectType.REGULAR_BLOCK.getHeigth());
        block2 = new RegularBlock (blockPosition2,"MiniDarthVader.png");
        block2.drawObject();

        this.bounds = new ObjectBoundaries();

        this.worldObjects = new GameObjects[]{block2, block};
    }


    public void start() {

        init();
        UtilityMethods.startKeyboard(player);
        while (!win) {

            if (player.getPosX() >= targetPosition.getPosX()) {
                winAnimation();
                win = true;
            }

            checkAllColls(player, worldObjects);


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
