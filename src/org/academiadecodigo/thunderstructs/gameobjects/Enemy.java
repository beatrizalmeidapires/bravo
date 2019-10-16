package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends GameObjects {

    private Position position;
    private Picture enemyImage;
    private boolean isDead;

    public Enemy(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.ENEMY);
        this.position = position;
        this.enemyImage = getObjectImage();

    }

    //last movement indicates the last movement through a boolean: true = left; false = right
    private boolean lastMovment = false;
    public void move() {

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
