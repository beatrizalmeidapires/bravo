package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.thunderstructs.UtilityMethods;

public class Enemy extends GameObjects {

    private Position position;
    private Picture enemyImage;
    private boolean isDead;

    //last movement indicates the last movement through a boolean: true = left; false = right
    private boolean lastMovment;


    public Enemy(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.DARTHVADER);
        this.position = position;
        this.enemyImage = getObjectImage();

    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void move() {


        if (position.getPosX() > Game.GAME_WIDTH -200) {

            lastMovment = true;
        }

        if (position.getPosX() < 200) {

            lastMovment = false;
        }

        if (!lastMovment) {
            moveRight();

        }
        //Left
        if (lastMovment) {
            moveLeft();
        }
    }
}
