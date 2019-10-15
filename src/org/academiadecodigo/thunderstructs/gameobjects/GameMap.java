package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.thunderstructs.Game;

public class GameMap {

    private RegularBlock[] blocks;

    public GameMap(){

        Position[] blockPositions;

        blockPositions = new Position[10];
        blocks = new RegularBlock[10];

        blockPositions[0] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*2));
        blockPositions[1] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*2));
        blockPositions[2] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 7), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*3));
        blockPositions[3] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 8), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*3));
        blockPositions[4] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 9), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[5] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 10), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[6] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 12), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*6));
        blockPositions[7] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 13), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*6));
        blockPositions[8] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 15), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*7));
        blockPositions[9] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 16), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*7));

        blocks[0] = new RegularBlock(blockPositions[0], "brickblock.png");
        blocks[1] = new RegularBlock(blockPositions[1], "brickblock.png");
        blocks[2] = new RegularBlock(blockPositions[2], "brickblock.png");
        blocks[3] = new RegularBlock(blockPositions[3], "brickblock.png");
        blocks[4] = new RegularBlock(blockPositions[4], "brickblock.png");
        blocks[5] = new RegularBlock(blockPositions[5], "brickblock.png");
        blocks[6] = new RegularBlock(blockPositions[6], "brickblock.png");
        blocks[7] = new RegularBlock(blockPositions[7], "brickblock.png");
        blocks[8] = new RegularBlock(blockPositions[8], "brickblock.png");
        blocks[9] = new RegularBlock(blockPositions[9], "brickblock.png");

    }

    public RegularBlock[] getRegularBlocks(){
        return blocks;
    }
}
