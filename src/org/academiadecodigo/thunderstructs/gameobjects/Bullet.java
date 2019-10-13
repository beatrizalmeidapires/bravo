package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends GameObjects implements Physics {

    private Picture picture;


    public Bullet(Position position, String picture){
        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
    }

    @Override
    public void collision(){
    }

    //direcção.
    //As balas podem ser disparadas para a esquerda ou para a direita.


}
