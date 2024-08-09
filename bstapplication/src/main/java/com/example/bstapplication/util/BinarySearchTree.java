package com.example.bstapplication.util;

import com.example.bstapplication.model.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void insert(Integer value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, Integer value) {
        if (root == null) {
            root = new TreeNode();
            root.setValue(value);
            return root;
        }
        if (value < root.getValue()) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insertRec(root.getRight(), value));
        }
        return root;
    }
}

