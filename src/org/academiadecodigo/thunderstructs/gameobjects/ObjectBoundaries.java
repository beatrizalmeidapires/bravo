package org.academiadecodigo.thunderstructs.gameobjects;

public class ObjectBoundaries {

    //Top, bottom, left and right positions of X and Y
    //Coordinates occupied by that side represented by initial and final coordinate
    //All coordinates represents a pixel location
    private int object1TopY;
    private int object1BottomY;
    private int object1InitX;
    private int object1FinalX;

    private int object1LeftX;
    private int object1RightX;
    private int object1InitY;
    private int object1FinalY;

    private int object2TopY;
    private int object2BottomY;
    private int object2InitX;
    private int object2FinalX;

    private int object2LeftX;
    private int object2RightX;
    private int object2InitY;
    private int object2FinalY;

    private void getTopBottomBounds(GameObjects gObj1, GameObjects gObj2){
        object1TopY = gObj1.getPosition().getPosY();
        object1BottomY = gObj1.getPosition().getPosY() + gObj1.getHeight();
        object1InitX = gObj1.getPosition().getPosX();
        object1FinalX = gObj1.getPosition().getPosX() + gObj1.getWidth();

        object2TopY = gObj2.getPosition().getPosY();
        object2BottomY = gObj2.getPosition().getPosY() + gObj2.getHeight();
        object2InitX = gObj2.getPosition().getPosX();
        object2FinalX = gObj2.getPosition().getPosX() + gObj2.getWidth();
    }

    private void getSideBounds(GameObjects gObj1, GameObjects gObj2){
        object1LeftX = gObj1.getPosition().getPosX();
        object1RightX = gObj1.getPosition().getPosX() + gObj1.getWidth();
        object1InitY = gObj1.getPosition().getPosY() + 2;
        object1FinalY = gObj1.getPosition().getPosY() + gObj1.getHeight() - 2;

        object2LeftX = gObj2.getPosition().getPosX();
        object2RightX = gObj2.getPosition().getPosX() + gObj2.getWidth();
        object2InitY = gObj2.getPosition().getPosY() + 2;
        object2FinalY = gObj2.getPosition().getPosY() + gObj2.getHeight() - 2;
    }

    public boolean checkCollisionOnTop(GameObjects gObj1, GameObjects gObj2){

        getTopBottomBounds(gObj1, gObj2);
        return ((object1TopY -1 == object2BottomY) || ((object1TopY) == object2BottomY) || ((object1TopY + 1) == object2BottomY)) &&
                (object1FinalX >= object2InitX && !(object1FinalX > (object2FinalX + gObj1.getWidth())));
    }

    public boolean checkCollisionOnBottom(GameObjects gObj1, GameObjects gObj2){

        getTopBottomBounds(gObj1, gObj2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) &&
                (object1FinalX >= object2InitX && !(object1FinalX > (object2FinalX + gObj1.getWidth())));
    }

    public boolean checkCollisionOnLeft(GameObjects gObj1, GameObjects gObj2){

        getSideBounds(gObj1, gObj2);
        return ((object1LeftX - 1 == object2RightX) || (object1LeftX == object2RightX) || (object1LeftX + 1 == object2RightX)) &&
                (object1FinalY >= object2InitY && !(object1FinalY > (object2FinalY + gObj1.getHeight())));
    }

    public boolean checkCollisionOnRight(GameObjects gObj1, GameObjects gObj2){

        getSideBounds(gObj1, gObj2);
        return ((object1RightX - 1 == object2LeftX) || (object1RightX == object2LeftX) || (object1RightX + 1 == object2LeftX)) &&
                (object1FinalY >= object2InitY && !(object1FinalY > (object2FinalY + gObj1.getHeight())));
    }

    public boolean checkCollisionOnBottomRight(GameObjects gObj1, GameObjects gObj2){

        getTopBottomBounds(gObj1, gObj2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) &&
                ((object1FinalX + gObj1.getWidth()) >= object2InitX && !((object1FinalX + gObj1.getWidth()) > (object2FinalX + gObj1.getWidth())));
    }

    public boolean checkCollisionOnBottomLeft(GameObjects gObj1, GameObjects gObj2){

        getTopBottomBounds(gObj1, gObj2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) &&
                ((object1FinalX - gObj1.getWidth()) >= object2InitX && !((object1FinalX - gObj1.getWidth()) > (object2FinalX + gObj1.getWidth())));
    }

    public boolean checkCollisionOnAllSides(GameObjects gObj1, GameObjects gObj2){

        return checkCollisionOnRight(gObj1, gObj2) || checkCollisionOnLeft(gObj1, gObj2) ||
                checkCollisionOnTop(gObj1, gObj2) || checkCollisionOnBottom(gObj1, gObj2);
    }
}
