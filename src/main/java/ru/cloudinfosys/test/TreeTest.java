package ru.cloudinfosys.test;

import org.junit.jupiter.api.Test;

public class TreeTest {
    @Test
    public void traverse() {
        Tree tree = new Tree('g',
            new Tree('e',
                    new Tree('c',null, null),
                    new Tree('d',null, null)
            ),
            new Tree('f',
                    new Tree('a',null, null),
                    new Tree('b',null, null)
            )
        );

        Tree.traverse(tree, node -> System.out.println(node.getLetter()));
    }
}
