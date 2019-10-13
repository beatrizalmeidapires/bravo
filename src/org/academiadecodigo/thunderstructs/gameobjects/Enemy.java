package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Game;
import org.academiadecodigo.thunderstructs.UtilityMethods;

public class Enemy extends GameObjects {

    private Position position;
    private Picture enemyImage;
    private boolean isDead;
    private int speed = 10;


    public Enemy(Position position, String picture) {
        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
        this.position = position;
        this.enemyImage = getObjectImage();

    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void move() {

        while (!isDead) {

            int random = (int) (Math.random() * 2 + 1);

            //Right
            if (random == 1 && position.getPosX() < Game.GAME_WIDTH - (ObjectType.DARTHVADER.getWidth()) + Game.MARGIN) {
                //while (!collision())
                position.setPosX(position.getPosX() + speed);
                enemyImage.translate(+speed, 0);

            }
            //Left
            if (random == 2 && position.getPosX() > Game.MARGIN) {
                //while (!collision())
                position.setPosX(position.getPosX() - speed);
                enemyImage.translate(-speed, 0);
            }
            UtilityMethods.pause(40);

        }


    }
}
