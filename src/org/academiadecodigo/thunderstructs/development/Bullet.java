package org.academiadecodigo.thunderstructs.development;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.GameObjects;
import org.academiadecodigo.thunderstructs.gameobjects.ObjectType;
import org.academiadecodigo.thunderstructs.gameobjects.Position;

public class Bullet extends GameObjects {

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


    //player method
    /*private boolean shoot = false;

    public void bulletShoot() {
        if (hitted) {
            this.picture.delete();
        }
    } */
}

//As balas podem ser disparadas para a esquerda ou para a direita.
//As balas devem estar associadas a uma tecla (space)
//Cada vez que a tecla for primida uma bala vai ser instanciada.
//a bala deve ter speed constante quando for instanciada.
