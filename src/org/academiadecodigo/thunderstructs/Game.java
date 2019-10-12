package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.thunderstructs.gameobjects.Person;
import org.academiadecodigo.thunderstructs.gameobjects.Position;

public class Game {

    private Position position;
    private Position position1;
    private Person person;
    private Person person1;

    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 600;
    public static final int MARGIN = 10;
    private Position targetPosition;
    private boolean win;

    public Game(){
        this.targetPosition = new Position(1100, 0);
        this.win = false;
    }

    public void drawBackground() {
        Rectangle background = new Rectangle(MARGIN, MARGIN, GAME_WIDTH, GAME_HEIGHT);
        background.setColor(Color.DARK_GRAY);
        background.fill();
    }

    public void init() {
        position = new Position(900, 200);
        position1 = new Position(400, 200);
        person = new Person(position, "character1.png");
        person1 = new Person(position1, "character2.png");
        person1.drawPerson();
        person.drawPerson();
    }


    public void start() {

        init();
        startKeyboard();
        while (!win) {

            System.out.println(person.getPosX());
            System.out.println(person.getPosY());
            if (person.getPosX() >= targetPosition.getPosX()) {
                Text winMessage = new Text(500, 500, "You win bro");
                winMessage.draw();
                winMessage.grow(300, 300);

                System.out.println("Agora é que é!!");
                win = true;

            }

        }

    }

    public void startKeyboard(){

        Keyboard keyboard = new Keyboard(person);

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();

        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

}
