package com.example.bstapplication.util;

import com.example.bstapplication.model.TreeNode;

public class TreeUtils {

    // Helper method to recursively build the HTML string for the tree
    private static void buildTreeHtml(TreeNode node, StringBuilder sb, String prefix) {
        if (node != null) {
            sb.append(prefix);
            sb.append("<div class=\"node\">");
            sb.append(node.getValue());
            sb.append("</div>\n");
            sb.append("<div class=\"children\">\n");
            buildTreeHtml(node.getLeft(), sb, prefix + "<div class=\"left\">");
            buildTreeHtml(node.getRight(), sb, prefix + "<div class=\"right\">");
            sb.append("</div>\n");
        }
    }

    public static String visualizeTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"tree\">\n");
        buildTreeHtml(root, sb, "");
        sb.append("</div>");
        return sb.toString();
    }
}
