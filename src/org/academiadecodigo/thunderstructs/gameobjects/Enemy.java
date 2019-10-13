package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.thunderstructs.UtilityMethods;

public class Enemy extends GameObjects {

    private Position position;
    private Picture enemyImage;
    private boolean isDead;


    public Enemy(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.DARTHVADER);
        this.position = position;
        this.enemyImage = getObjectImage();

    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void move() {

        while (!isDead) {

            int random = (int) (Math.floor(Math.random() + 1.5));

            //Right
            if (random == 1) {
                while (!(position.getPosX() >= Game.GAME_WIDTH - (ObjectType.DARTHVADER.getWidth() + Game.MARGIN))) {
                    UtilityMethods.pause(70);
                    moveRight();
                }


            }
            //Left
            if (random == 2) {
                while (!(position.getPosX() <= Game.MARGIN)) {
                    UtilityMethods.pause(70);
                    moveLeft();
                }

            }
        }
    }
}
