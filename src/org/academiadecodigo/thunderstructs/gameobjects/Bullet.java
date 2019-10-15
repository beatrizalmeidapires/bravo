package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends GameObjects implements Physics {

    private Picture picture;
    private Position position;
    private int speed;
    private boolean hitted;
    private boolean shoot;


    public Bullet(Position position, String picture, int speed) {
        super(position, new Picture(position.getPosX(), position.getPosY(), picture), ObjectType.REGULAR_BLOCK);
        this.position = position;
        this.speed = speed;
    }

    /*
    public void shoot () {

        if (player.isShooting()) {
            Position bulletPosition = new Position(player.getPosX(), player.getPosY());
            this.bullet = new Bullet (bulletPosition, "destroyableblock.png", 7 );
            bullet.drawObject();
        }

    }
    */
}

//As balas podem ser disparadas para a esquerda ou para a direita.
//As balas devem estar associadas a uma tecla (space)
//Cada vez que a tecla for primida uma bala vai ser instanciada.
//a bala deve ter speed constante quando for instanciada.
