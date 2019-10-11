package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Person implements KeyboardHandler {

    private Rectangle person;

    public void drawPerson(){

        person = new Rectangle(750, 400,70,50);
        person.setColor(Color.YELLOW);
        person.fill();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_LEFT:
                person.translate(-20, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:
                person.translate(20,0);
                break;
            case KeyboardEvent.KEY_DOWN:
                person.translate(0, 20);
                break;
            case KeyboardEvent.KEY_UP:
                person.translate(0, -20);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
