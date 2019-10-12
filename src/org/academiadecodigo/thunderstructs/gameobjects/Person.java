package org.academiadecodigo.thunderstructs.gameobjects;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.thunderstructs.Game;


public class Person extends GameObjects {

    private Position position;
    private Picture character;
    private String link;
    private boolean jump;
    private int jumpCounter;

    public Person(Position position, String picture) {

        super(position, new Picture(position.getPosX(), position.getPosY(), picture));
        this.position = position;
        this.character = getPerson();


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:
                jump();
                break;
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void check() {

        System.out.println("Check");
        if (jump) {

            System.out.println("Teste Check if Jump");
            position.setPosY(getPosY() - 2);
            character.translate(0,-2);
            pause(20);
            jumpCounter++;

            System.out.println(jumpCounter);

        }

        if (jumpCounter >= 50) {
            jump = false;
            jumpCounter = 0;
        }

    }

    public void jump () {
        System.out.println("Jump = true");
        jump = true;
    }

    /*
    public void jump () {
        System.out.println("CALL");
        if(!(position.getPosY() <=  Game.MARGIN)) {

            for (int i = 0; i < 50; i++) {

                position.setPosY(getPosY() - 2);
                character.translate(0, -2);

                pause(50);
            }
        }
    }
*/

    public int getPosX() {
        return this.position.getPosX();
    }

    public int getPosY() {
        return this.position.getPosY();
    }

}
