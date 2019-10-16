package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.*;

public class Game {

    public static final int GAME_WIDTH = 1511;
    public static final int GAME_HEIGHT = 850;
    public static final int MARGIN = 10;

    private Position playerPosition;
    private Player player;
    private ObjectBoundaries bounds;

    private Position targetPosition;
    private boolean win;



    GameMap gameBlocks = new GameMap();
    GameObjects[] blocks;
    GameObjects[] enemies;

    public Game() {
        this.targetPosition = new Position(1100, 0);
        this.win = false;
    }

    public void drawBackground() {

        Picture backgroundPicture = new Picture(MARGIN,MARGIN, "graphics/background.png");
        backgroundPicture.draw();
    }

    public void drawGame() {

        for (int i = 0; i < blocks.length; i++) {
            blocks[i].drawObject();
        }

        for (int i = 0; i < enemies.length; i++){
            enemies[i].drawObject();
        }

        player.drawObject();
    }

    public void init() {
        playerPosition = new Position(100, GAME_HEIGHT - ObjectType.PLAYER.getHeigth());
        player = new Player(playerPosition, "picture.png");

        blocks = gameBlocks.getRegularBlocks();
        enemies = gameBlocks.getEnemies();

        this.bounds = new ObjectBoundaries();


    }

    public void startMenu () {

       init();
       Rectangle menuRectangle = new Rectangle(9,10, 900, 500);
       menuRectangle.setColor(Color.BLACK);

       UtilityMethods.startKeyboard(player);

        while (!player.getQuit()) {

            menuRectangle.fill();

            int menuChoice = 0;

            if (player.getPlayGame()) {
                player.setPlayGameFalse();
                menuChoice = 1;
            }

            switch (menuChoice) {

                case 0:
                    break;

                case 1:
                    menuRectangle.delete();
                    drawGame();
                    start();
                    break;
            }
        }
    }


    public void start() {

        while (!win) {

            if (player.getPosX() >= targetPosition.getPosX()) {
                winAnimation();
                win = true;
            }

            checkAllColls(player, blocks);

            player.tick();
            player.gravity();

           for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] instanceof Enemy) {
                    enemies[i].gravity();
                    ((Enemy) enemies[i]).move();
                    checkEnemyColls(enemies[i], player);
                    checkAllColls(enemies[i], blocks);
                }
           }
            UtilityMethods.pause(7);
        }
    }



    public void checkEnemyColls (GameObjects enemy, GameObjects player){

        boolean collRight = false;
        boolean collLeft = false;
        boolean collTop = false;
        boolean collBottom = false;

        if (bounds.checkCollisionOnRight(enemy, player)) {
            win = true;
        }

        if (bounds.checkCollisionOnLeft(enemy, player)) {
            //enemy.setOppositeDirection();
            win = true;
        }

        if (bounds.checkCollisionOnTop(enemy, player)) {
            win = true;
        }

        if (bounds.checkCollisionOnBottom(enemy, player)) {
            win = true;
        }
        enemy.setCollisionOnRight(collRight);
        enemy.setCollisionOnLeft(collLeft);
        enemy.setCollisionOnTop(collTop);
        enemy.setCollisionOnBottom(collBottom);

    }

    public void checkAllColls (GameObjects movable, GameObjects[] objects) {

        boolean collRight = false;
        boolean collLeft = false;
        boolean collTop = false;
        boolean collBottom = false;
        boolean collBottomRight = false;
        boolean collBottomLeft = false;

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
            if(bounds.checkCollisionOnBottomLeft(movable, o)){
                collBottomLeft = true;
            }
            if(bounds.checkCollisionOnBottomRight(movable, o)){
                collBottomRight = true;
            }

        }

        movable.setCollisionOnRight(collRight);
        movable.setCollisionOnLeft(collLeft);
        movable.setCollisionOnTop(collTop);
        movable.setCollisionOnBottom(collBottom);
        movable.setCollisionOnBottomLeft(collBottomLeft);
        movable.setCollisionOnBottomRight(collBottomRight);

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
