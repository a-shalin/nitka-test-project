package ru.cloudinfosys.test;

/** Binary tree */
public class Tree {
    private String name;
    private Tree left;
    private Tree right;

    public Tree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    /** Calculate tree height */
    public static int getHeight(Tree tree) {
        return tree == null ? 0 : 1 + Math.max(getHeight(tree.getLeft()),
                getHeight(tree.getRight()));
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                (left != null ? ", left=" + left : "") +
                (right != null ? ", right=" + right : "") +
                '}';
    }
}
