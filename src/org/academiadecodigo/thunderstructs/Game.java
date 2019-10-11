package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Game {

public void drawBackground(){

    int margin = 10;

    Rectangle background = new Rectangle(margin,margin,1500,800);
    background.setColor(Color.DARK_GRAY);
    background.fill();
}

}
