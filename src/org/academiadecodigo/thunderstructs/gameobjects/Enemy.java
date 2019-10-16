package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;

public class Enemy extends GameObjects {

    private Position position;
    private Picture enemyImage;
    private boolean isDead;
    private int speed;

    public Enemy(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.DARTHVADER);
        this.position = position;
        this.enemyImage = getObjectImage();
        this.speed = 2;

    }

    //last movement indicates the last movement through a boolean: true = left; false = right
    private boolean lastMovment = false;
    public void move() {

        /*
        if (position.getPosX() > Game.GAME_WIDTH - 200 || isCollisionOnRight()) {
            lastMovment = true;
        }

        if (position.getPosX() < 200 || isCollisionOnLeft()) {

            lastMovment = false;

        }*/



        if (!lastMovment) {
            if (isCollisionOnBottomRight()) {
                moveRight();
                return;
            }
            lastMovment = true;
        }

            if (isCollisionOnBottomLeft()) {
                moveLeft();
                return;
            }
            lastMovment = false;

        }


}
