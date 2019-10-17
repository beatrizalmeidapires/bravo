package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.gameobjects.GameObjects;
import org.academiadecodigo.thunderstructs.gameobjects.ObjectType;
import org.academiadecodigo.thunderstructs.gameobjects.Position;

public class GameMenu extends GameObjects implements KeyboardHandler {

    private Position position;
    private String pictureName;

    private boolean replay;
    private boolean quit;

   public GameMenu(Position position, String pictureName, int x, int y) {

       super(position, new Picture(x,y,pictureName), ObjectType.MENU);
       this.position = position;
       this.pictureName = pictureName;
   }

   public boolean getReplay () {
       return this.replay;
   }

   public void setReplay () {
       this.replay = false;
   }

   public boolean getQuit() {
       return this.quit;
   }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                this.replay = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
