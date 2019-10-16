package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.thunderstructs.Game;

public class GameMap {

    private RegularBlock[] blocks;
    private Enemy[] enemies;
    private Position[] blockPositions;
    private Position[] enemyPositions;
    private Position[] worldObjects;

    public GameMap(){



        blockPositions = new Position[20];
        blocks = new RegularBlock[20];

        enemyPositions = new Position[2];
        enemies = new Enemy[2];

        blockPositions[0] = new Position(ObjectType.REGULAR_BLOCK.getWidth(), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()));
        blockPositions[1] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 2), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()));
        blockPositions[2] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*2));
        blockPositions[3] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*2));
        blockPositions[4] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 7), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[5] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 11), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[6] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 12), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[7] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 13), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[8] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 14), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[9] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 15), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*4));
        blockPositions[10] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*6));
        blockPositions[11] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*6));
        blockPositions[12] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 3), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*6));
        blockPositions[13] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 10), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*8));
        blockPositions[14] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*10));
        blockPositions[15] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*10));
        blockPositions[16] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 6), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*10));
        blockPositions[17] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 7), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*10));
        blockPositions[18] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 8), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*10));
        blockPositions[19] = new Position((ObjectType.REGULAR_BLOCK.getWidth()), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()*8));

        blocks[0] = new RegularBlock(blockPositions[0], "graphics/green_block.png");
        blocks[1] = new RegularBlock(blockPositions[1], "graphics/green_block.png");
        blocks[2] = new RegularBlock(blockPositions[2], "graphics/blue_block.png");
        blocks[3] = new RegularBlock(blockPositions[3], "graphics/blue_block.png");
        blocks[4] = new RegularBlock(blockPositions[4], "graphics/green_block.png");
        blocks[5] = new RegularBlock(blockPositions[5], "graphics/blue_block.png");
        blocks[6] = new RegularBlock(blockPositions[6], "graphics/blue_block.png");
        blocks[7] = new RegularBlock(blockPositions[7], "graphics/blue_block.png");
        blocks[8] = new RegularBlock(blockPositions[8], "graphics/blue_block.png");
        blocks[9] = new RegularBlock(blockPositions[9], "graphics/blue_block.png");
        blocks[10] = new RegularBlock(blockPositions[10], "graphics/long_block_right.png");
        blocks[11] = new RegularBlock(blockPositions[11], "graphics/long_block_center.png");
        blocks[12] = new RegularBlock(blockPositions[12], "graphics/long_block_left.png");
        blocks[13] = new RegularBlock(blockPositions[13], "graphics/blue_block.png");
        blocks[14] = new RegularBlock(blockPositions[14], "graphics/blue_block.png");
        blocks[15] = new RegularBlock(blockPositions[15], "graphics/blue_block.png");
        blocks[16] = new RegularBlock(blockPositions[16], "graphics/blue_block.png");
        blocks[17] = new RegularBlock(blockPositions[17], "graphics/blue_block.png");
        blocks[18] = new RegularBlock(blockPositions[18], "graphics/blue_block.png");
        blocks[19] = new RegularBlock(blockPositions[19], "graphics/green_block.png");

        enemyPositions[0] = new Position(500, 0);
        enemyPositions[1] = new Position(1000, 0);

        enemies[0] = new Enemy(enemyPositions[0], "graphics/enemy1.png");
        enemies[1] = new Enemy(enemyPositions[1], "graphics/enemy2.png");

    }

    public RegularBlock[] getRegularBlocks(){
        return blocks;
    }
    public Enemy[] getEnemies(){
        return enemies;
    }
}
