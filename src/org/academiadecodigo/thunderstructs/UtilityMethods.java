package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.thunderstructs.gameobjects.GameObjects;

public final class UtilityMethods {


    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void startKeyboard(GameObjects gameObject) {

        Keyboard keyboard = new Keyboard(gameObject);

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent leftReleased = new KeyboardEvent();

        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent rightReleased = new KeyboardEvent();

        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent jump = new KeyboardEvent();

        KeyboardEvent replay = new KeyboardEvent();
        KeyboardEvent quit = new KeyboardEvent();


        //Menu keys
        replay.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        replay.setKey(KeyboardEvent.KEY_R);
        quit.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));
        quit.setKey(KeyboardEvent.KEY_Q);


        //Player keys
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);

        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        jump.setKey(KeyboardEvent.KEY_SPACE);


        //Keyboard listeners
        keyboard.addEventListener(replay);
        keyboard.addEventListener(quit);

        keyboard.addEventListener(left);
        keyboard.addEventListener(leftReleased);

        keyboard.addEventListener(right);
        keyboard.addEventListener(rightReleased);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(jump);
    }
}
