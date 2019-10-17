package org.academiadecodigo.thunderstructs.development;

import org.academiadecodigo.thunderstructs.gameobjects.Block;
import org.academiadecodigo.thunderstructs.gameobjects.ObjectType;
import org.academiadecodigo.thunderstructs.gameobjects.Position;

public class SnippetBlock extends Block {

    public SnippetBlock(Position position, String picture) {
        super(position, picture, ObjectType.SNIPPET_BLOCK);
    }


}
