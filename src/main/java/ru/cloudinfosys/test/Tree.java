package ru.cloudinfosys.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
    private char letter;
    private Tree left;
    private Tree right;

    public Tree(char letter, Tree left, Tree right) {
        this.letter = letter;
        this.left = left;
        this.right = right;
    }

    public char getLetter() {
        return letter;
    }

    public interface Visitor {
        void visit(Tree tree);
    }

    public static final void traverse(Tree tree, Visitor visitor) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(tree);

        while (! queue.isEmpty()) {
            Tree current = queue.poll();
            visitor.visit(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
