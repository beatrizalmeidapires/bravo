package org.academiadecodigo.thunderstructs.development;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.Block;
import org.academiadecodigo.thunderstructs.gameobjects.ObjectType;
import org.academiadecodigo.thunderstructs.gameobjects.Position;

public class DestroyableBlock extends Block {

    private boolean destroyed = false;
    private Picture picture;
    private static int hits;

    public DestroyableBlock(Position position, String picture) {
        super(position, picture, ObjectType.DESTROYABLE_BLOCK);
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        this.destroyed = true;
    }

    public static void hitsCounter(){
        hits++;
    }

    // método que destrói um bloco caso este seja atingido por uma bala lançada pela player.
    // cada vez que esta bala atinge o bloco, o hitCounter vai ser incrementado. (if collision == true)
    // caso este bloco seja atingido 3x, será eliminado.

    /*public void destroyObject() {

        collision();

        while(!isDestroyed()){

            if (this.collision() == true && hits == 3) {
                this.setDestroyed();
                this.picture.delete();
           }
        }
    }*/
}
