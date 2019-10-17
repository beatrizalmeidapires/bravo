package org.academiadecodigo.thunderstructs.gameobjects;

import org.academiadecodigo.thunderstructs.Game;

public class GameMap {

    private RegularBlock[] blocks;
    private Enemy[] enemies;

    private Position[] blockPositions;
    private Position[] enemyPositions;


    public GameMap(){

        blockPositions = new Position[44];
        blocks = new RegularBlock[44];

        enemyPositions = new Position[5];
        enemies = new Enemy[5];

        blockPositions[0] = new Position(ObjectType.REGULAR_BLOCK.getWidth(), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()));
        blockPositions[1] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 2), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth()));
        blockPositions[2] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 2));
        blockPositions[3] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 2));
        blockPositions[4] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 7), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[5] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 11), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[6] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 12), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[7] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 13), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[8] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 14), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[9] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 15), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[10] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[11] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[12] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 3), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[13] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 10), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 8));
        blockPositions[14] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 4), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[15] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 5), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[16] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 6), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[17] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 7), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[18] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 8), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[19] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 2), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 8));
        blockPositions[20] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 17), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[21] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 17), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[22] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 19), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 8));
        blockPositions[23] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 20), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[24] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 21), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[25] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 22), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[26] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 23), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[27] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 26), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 8));
        blockPositions[28] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 26), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[29] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 28), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 7));
        blockPositions[30] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 29), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 2));
        blockPositions[31] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 31), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 4));
        blockPositions[32] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 31), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 8));
        blockPositions[33] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 33), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[34] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 33), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 10));
        blockPositions[35] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 35), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 12));
        blockPositions[36] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 36), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 12));
        blockPositions[37] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 37), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 12));
        blockPositions[38] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 38), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 12));
        blockPositions[39] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 40), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 9));
        blockPositions[40] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 42), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[41] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 43), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[42] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 44), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));
        blockPositions[43] = new Position((ObjectType.REGULAR_BLOCK.getWidth() * 45), Game.GAME_HEIGHT - (ObjectType.REGULAR_BLOCK.getHeigth() * 6));

        blocks[0] = new RegularBlock(blockPositions[0], "resources/graphics/green_block.png");
        blocks[1] = new RegularBlock(blockPositions[1], "resources/graphics/green_block.png");
        blocks[2] = new RegularBlock(blockPositions[2], "resources/graphics/blue_block.png");
        blocks[3] = new RegularBlock(blockPositions[3], "resources/graphics/blue_block.png");
        blocks[4] = new RegularBlock(blockPositions[4], "resources/graphics/green_block.png");
        blocks[5] = new RegularBlock(blockPositions[5], "resources/graphics/blue_block.png");
        blocks[6] = new RegularBlock(blockPositions[6], "resources/graphics/blue_block.png");
        blocks[7] = new RegularBlock(blockPositions[7], "resources/graphics/blue_block.png");
        blocks[8] = new RegularBlock(blockPositions[8], "resources/graphics/blue_block.png");
        blocks[9] = new RegularBlock(blockPositions[9], "resources/graphics/blue_block.png");
        blocks[10] = new RegularBlock(blockPositions[10], "resources/graphics/long_block_right.png");
        blocks[11] = new RegularBlock(blockPositions[11], "resources/graphics/long_block_center.png");
        blocks[12] = new RegularBlock(blockPositions[12], "resources/graphics/long_block_left.png");
        blocks[13] = new RegularBlock(blockPositions[13], "resources/graphics/blue_block.png");
        blocks[14] = new RegularBlock(blockPositions[14], "resources/graphics/blue_block.png");
        blocks[15] = new RegularBlock(blockPositions[15], "resources/graphics/blue_block.png");
        blocks[16] = new RegularBlock(blockPositions[16], "resources/graphics/blue_block.png");
        blocks[17] = new RegularBlock(blockPositions[17], "resources/graphics/blue_block.png");
        blocks[18] = new RegularBlock(blockPositions[18], "resources/graphics/blue_block.png");
        blocks[19] = new RegularBlock(blockPositions[19], "resources/graphics/green_block.png");
        blocks[20] = new RegularBlock(blockPositions[20], "resources/graphics/green_block.png");
        blocks[21] = new RegularBlock(blockPositions[21], "resources/graphics/green_block.png");
        blocks[22] = new RegularBlock(blockPositions[22], "resources/graphics/blue_block.png");
        blocks[23] = new RegularBlock(blockPositions[23], "resources/graphics/long_block_left.png");
        blocks[24] = new RegularBlock(blockPositions[24], "resources/graphics/long_block_center.png");
        blocks[25] = new RegularBlock(blockPositions[25], "resources/graphics/long_block_center.png");
        blocks[26] = new RegularBlock(blockPositions[26], "resources/graphics/long_block_right.png");
        blocks[27] = new RegularBlock(blockPositions[27], "resources/graphics/blue_block.png");
        blocks[28] = new RegularBlock(blockPositions[28], "resources/graphics/blue_block.png");
        blocks[29] = new RegularBlock(blockPositions[29], "resources/graphics/green_block.png");
        blocks[30] = new RegularBlock(blockPositions[30], "resources/graphics/green_block.png");
        blocks[31] = new RegularBlock(blockPositions[31], "resources/graphics/blue_block.png");
        blocks[32] = new RegularBlock(blockPositions[32], "resources/graphics/green_block.png");
        blocks[33] = new RegularBlock(blockPositions[33], "resources/graphics/blue_block.png");
        blocks[34] = new RegularBlock(blockPositions[34], "resources/graphics/green_block.png");
        blocks[35] = new RegularBlock(blockPositions[35], "resources/graphics/long_block_left.png");
        blocks[36] = new RegularBlock(blockPositions[36], "resources/graphics/long_block_center.png");
        blocks[37] = new RegularBlock(blockPositions[37], "resources/graphics/long_block_center.png");
        blocks[38] = new RegularBlock(blockPositions[38], "resources/graphics/long_block_right.png");
        blocks[39] = new RegularBlock(blockPositions[39], "resources/graphics/green_block.png");
        blocks[40] = new RegularBlock(blockPositions[40], "resources/graphics/blue_block.png");
        blocks[41] = new RegularBlock(blockPositions[41], "resources/graphics/blue_block.png");
        blocks[42] = new RegularBlock(blockPositions[42], "resources/graphics/blue_block.png");
        blocks[43] = new RegularBlock(blockPositions[43], "resources/graphics/green_block.png");

        enemyPositions[0] = new Position((ObjectType.ENEMY.getWidth() * 12), 0);
        enemyPositions[1] = new Position((ObjectType.ENEMY.getWidth() * 25), 0);
        enemyPositions[2] = new Position((ObjectType.ENEMY.getWidth() * 38), 0);
        enemyPositions[3] = new Position((ObjectType.ENEMY.getWidth() * 46), Game.GAME_HEIGHT - (ObjectType.ENEMY.getHeigth() * 8));
        enemyPositions[4] = new Position((ObjectType.ENEMY.getWidth() * 58), 0);

        enemies[0] = new Enemy(enemyPositions[0], "resources/graphics/enemy1.png");
        enemies[1] = new Enemy(enemyPositions[1], "resources/graphics/enemy2.png");
        enemies[2] = new Enemy(enemyPositions[2], "resources/graphics/enemy1.png");
        enemies[3] = new Enemy(enemyPositions[3], "resources/graphics/enemy2.png");
        enemies[4] = new Enemy(enemyPositions[4], "resources/graphics/enemy1.png");
    }

    public RegularBlock[] getRegularBlocks(){
        return blocks;
    }

    public Enemy[] getEnemies(){
        return enemies;
    }
}
