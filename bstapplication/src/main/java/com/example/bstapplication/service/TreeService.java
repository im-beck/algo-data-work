package com.example.bstapplication.service;

import com.example.bstapplication.model.TreeNode;
import com.example.bstapplication.model.TreeRecord;
import com.example.bstapplication.repository.TreeRecordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TreeService {

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    // Build binary search tree from an array of numbers
    public TreeNode buildTree(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insertIntoBST(root, num);
        }
        return root;
    }

    // Insert a new value into the BST
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.getValue()) {
            root.setLeft(insertIntoBST(root.getLeft(), val));
        } else {
            root.setRight(insertIntoBST(root.getRight(), val));
        }
        return root;
    }

    // Convert the tree to JSON format
    public String getTreeJson(TreeNode root) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(root);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    // Save the tree and input numbers to the database
    public void saveTree(int[] nums, TreeNode root) {
        // Save input numbers and tree structure to the database
        TreeRecord treeRecord = new TreeRecord();
        treeRecord.setNumbers(Arrays.toString(nums));
        treeRecord.setTreeStructure(getTreeJson(root));
        treeRecordRepository.save(treeRecord);
    }

    public String getAllTrees() {
        Iterable<TreeRecord> records = treeRecordRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(records);
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
    
    // Convert JSON representation of tree to TreeNode object
    public TreeNode getTreeFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, TreeNode.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

