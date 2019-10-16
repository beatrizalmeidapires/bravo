package org.academiadecodigo.thunderstructs.gameobjects;

public class ObjectBoundaries {

    // Top, bottom, left and right positions of X and Y
    // coordinates occupied by that side represented by initial and final coordinate
    // all coordinates represents a pixel location
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

    private void getTopBottomBounds(GameObjects gb1, GameObjects gb2){
        object1TopY = gb1.getPosition().getPosY();
        object1BottomY = gb1.getPosition().getPosY() + gb1.getHeight();
        object1InitX = gb1.getPosition().getPosX();
        object1FinalX = gb1.getPosition().getPosX() + gb1.getWidth();

        object2TopY = gb2.getPosition().getPosY();
        object2BottomY = gb2.getPosition().getPosY() + gb2.getHeight();
        object2InitX = gb2.getPosition().getPosX();
        object2FinalX = gb2.getPosition().getPosX() + gb2.getWidth();
    }

    private void getSideBounds(GameObjects gb1, GameObjects gb2){
        object1LeftX = gb1.getPosition().getPosX();
        object1RightX = gb1.getPosition().getPosX() + gb1.getWidth();
        object1InitY = gb1.getPosition().getPosY() + 2;
        object1FinalY = gb1.getPosition().getPosY() + gb1.getHeight() - 2;

        object2LeftX = gb2.getPosition().getPosX();
        object2RightX = gb2.getPosition().getPosX() + gb2.getWidth();
        object2InitY = gb2.getPosition().getPosY() + 2;
        object2FinalY = gb2.getPosition().getPosY() + gb2.getHeight() - 2;
    }

    public boolean checkCollisionOnTop(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        getTopBottomBounds(gb1, gb2);
        return ((object1TopY -1 == object2BottomY) || ((object1TopY) == object2BottomY) || ((object1TopY + 1) == object2BottomY)) && (object1FinalX >= object2InitX && !(object1FinalX > (object2FinalX + gb1.getWidth())));
    }

    public boolean checkCollisionOnBottom(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        getTopBottomBounds(gb1, gb2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) && (object1FinalX >= object2InitX && !(object1FinalX > (object2FinalX + gb1.getWidth())));
    }

    public boolean checkCollisionOnLeft(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        getTopBottomBounds(gb1, gb2);
        return ((object1LeftX - 1 == object2RightX) || (object1LeftX == object2RightX) || (object1LeftX + 1 == object2RightX)) && (object1FinalY >= object2InitY && !(object1FinalY > (object2FinalY + gb1.getHeight())));
    }

    public boolean checkCollisionOnRight(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        return ((object1RightX - 1 == object2LeftX) || (object1RightX == object2LeftX) || (object1RightX + 1 == object2LeftX)) && (object1FinalY >= object2InitY && !(object1FinalY > (object2FinalY + gb1.getHeight())));
    }

    public boolean checkCollisionOnBottomRight(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        getTopBottomBounds(gb1, gb2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) && ((object1FinalX + gb1.getWidth()) >= object2InitX && !((object1FinalX + gb1.getWidth()) > (object2FinalX + gb1.getWidth())));
    }

    public boolean checkCollisionOnBottomLeft(GameObjects gb1, GameObjects gb2){
        getSideBounds(gb1, gb2);
        getTopBottomBounds(gb1, gb2);
        return ((object1BottomY - 1 == object2TopY) || (object1BottomY == object2TopY) || (object1BottomY + 1 == object2TopY)) && ((object1FinalX - gb1.getWidth()) >= object2InitX && !((object1FinalX - gb1.getWidth()) > (object2FinalX + gb1.getWidth())));
    }

}
