package ru.cloudinfosys.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
    private int unbalance = 0;

    private Tree prepareTree(int level, String name) {
        int newLevel = level - 1;

        if (newLevel < 0) return null;

        Tree leftNode = prepareTree(newLevel, "leftNode" + newLevel);
        Tree rightNode = prepareTree(newLevel, "rightNode" + newLevel);

        Tree tree = new Tree(name);
        tree.setLeft(leftNode);
        tree.setRight(rightNode);

        if (newLevel == 1 && unbalance != 0) {
            if (unbalance < 0) tree.setLeft(null);
            if (unbalance > 0) tree.setRight(null);
        }

        return tree;
    }

    @Test
    public void calcHeightEqualBalance() {
        Tree tree = prepareTree(20,"root");
        assertEquals(20, Tree.getHeight(tree));
    }

    @Test
    public void calcHeightLeftShorter() {
        unbalance = -1;

        Tree tree = prepareTree(20,"root");
        assertEquals(20, Tree.getHeight(tree));
    }

    @Test
    public void calcHeightRightShorter() {
        unbalance = 1;

        Tree tree = prepareTree(20,"root");
        assertEquals(20, Tree.getHeight(tree));
    }

    @Test
    public void checkUnbalance() {
        unbalance = 0;
        assertEquals("Tree{name='tree', left=Tree{name='leftNode1'}, right=Tree{name='rightNode1'}}",
                prepareTree(2, "tree").toString());

        unbalance = -1;
        assertEquals("Tree{name='tree', right=Tree{name='rightNode1'}}",
                prepareTree(2, "tree").toString());

        unbalance = 1;
        assertEquals("Tree{name='tree', left=Tree{name='leftNode1'}}",
                prepareTree(2, "tree").toString());

    }

}
