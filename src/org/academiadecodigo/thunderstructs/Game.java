package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public static final int GAME_WIDTH = 1511;
    public static final int GAME_HEIGHT = 850;
    public static final int MARGIN = 10;

    private Music enemyMusic;

    private Object[] worldObjects;
    private Picture backgroundPicture;

    private Position playerPosition;
    private Player player;

    private GameMenu menuController;
    private GameMenu firstMenuImage;
    private GameMenu secondMenuImage;
    private GameMenu gameOverImage;
    private GameMenu gameWinImage;

    private ObjectBoundaries bounds;

    private Position targetPosition;
    private boolean win;
    private boolean gameOver;
    private int menuChoice = 0;



    GameMap gameBlocks = new GameMap();
    GameObjects[] blocks;
    GameObjects[] enemies;

    public Game() {
        this.targetPosition = new Position(4500, 0);
        this.win = false;
    }

    public void drawBackground() {

        this.backgroundPicture = new Picture(MARGIN,MARGIN, "graphics/background.png");
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

    public void eraseGame() {

        for (int i = 0; i < blocks.length; i++) {
            blocks[i].getObjectImage().delete();
        }

        for (int i = 0; i < enemies.length; i++){
            enemies[i].getObjectImage().delete();
        }

        player.getObjectImage().delete();
        this.backgroundPicture.delete();

    }

    public void init() {
        playerPosition = new Position(50, 0);
        player = new Player(playerPosition, "picture.png", this);

        blocks = gameBlocks.getRegularBlocks();
        enemies = gameBlocks.getEnemies();

        //worldObjects = new GameObjects[blocks.length + enemies.length];


        List<GameObjects> list = new ArrayList<>(Arrays.asList(enemies));
        list.addAll(Arrays.asList(blocks));
        worldObjects = list.toArray();



        bounds = new ObjectBoundaries();
    }

    public void startMenu () {

        Position gameMenuPosition = new Position(0,0);
        this.menuController = new GameMenu(gameMenuPosition, "graphics/background.png", 0,0);
        menuController.drawObject();

        Position menuPosition = new Position((GAME_WIDTH/2) - (ObjectType.MENU.getWidth()/2),(GAME_HEIGHT/2) - (ObjectType.MENU.getHeigth()/2));
        this.firstMenuImage = new GameMenu(menuPosition, "graphics/corn_foot_2.jpg",menuPosition.getPosX(),menuPosition.getPosY());
        this.secondMenuImage = new GameMenu(menuPosition, "graphics/corn_foot_1.png", menuPosition.getPosX(), menuPosition.getPosY());
        this.gameOverImage = new GameMenu(menuPosition, "graphics/game_over.jpg", menuPosition.getPosX(), menuPosition.getPosY());
        this.gameWinImage = new GameMenu(menuPosition, "graphics/win.jpg", menuPosition.getPosX(), menuPosition.getPosY());

        int imageFlashCounter = 0;
        boolean imageFlashCondition = false;

        UtilityMethods.startKeyboard(menuController);

        while (!this.menuController.getQuit()) {

            menuController.drawObject();
            firstMenuImage.drawObject();

            imageFlashCounter++;

            if (imageFlashCounter > 1888999) { //Define Utility Constant
                secondMenuImage.drawObject();
                imageFlashCounter = 0;
                imageFlashCondition = true;
            }

            if (imageFlashCounter > 1888998 && imageFlashCondition) {
                imageFlashCounter = 0;
                secondMenuImage.deleteObject();
                imageFlashCondition = false;
            }

            if (this.menuController.getReplay()) {
                this.menuController.setReplay();
                menuChoice = 1;
            }

            switch (menuChoice) {

                case 0: //Game menu
                    break;

                case 1: //Game play
                    firstMenuImage.deleteObject();
                    this.drawBackground();
                    menuController.deleteObject();
                    start();
                    win = false;
                    eraseGame();

                    if (gameOver) {
                        menuChoice = 2;
                    } else {
                        menuChoice = 3;
                    }
                    break;

                case 2:
                    gameOverImage.drawObject();
                    UtilityMethods.pause(5000);
                    menuChoice = 0;
                    gameOverImage.deleteObject();
                    gameOver = false;
                    win = false;
                    break;

                case 3:
                   gameWinImage.drawObject();
                   UtilityMethods.pause(5000);
                   menuChoice = 0;
                   gameWinImage.deleteObject();
                   gameOver = false;
                   win = false;
                   break;
            }
        }
    }



    public void start() {

        init();
        drawGame();
        UtilityMethods.startKeyboard(player);

        while (!win) {

            if (player.getPosY() > (GAME_HEIGHT - ObjectType.PLAYER.getHeigth())) {
                win = true;
                gameOver = true;
            }

            if (player.getPosX() >= blocks[42].getPosition().getPosX()) {
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
        enemyMusic = new Music();
        boolean collRight = false;
        boolean collLeft = false;
        boolean collTop = false;
        boolean collBottom = false;


        if (bounds.checkCollisionOnRight(enemy, player)) {
            enemyMusic.startMusic("/resourses/music/XXX.wav");
            win = true;
            gameOver = true;
            UtilityMethods.pause(700);


            enemyMusic.stopMusic();

        }

        if (bounds.checkCollisionOnLeft(enemy, player)) {
            enemyMusic.startMusic("/resourses/music/XXX.wav");
            win = true;
            gameOver = true;
            UtilityMethods.pause(700);
            enemyMusic.stopMusic();

        }

        if (bounds.checkCollisionOnTop(enemy, player)) {
            win = true;
            gameOver = true;

        }

        if (bounds.checkCollisionOnBottom(enemy, player)) {
            win = true;
            gameOver = true;

        }
        enemy.setCollisionOnRight(collRight);
        enemy.setCollisionOnLeft(collLeft);
        enemy.setCollisionOnTop(collTop);
        enemy.setCollisionOnBottom(collBottom);
        //enemyMusic.stopMusic();
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

    public Object[] getWorldObjects () {
        return this.worldObjects;
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
