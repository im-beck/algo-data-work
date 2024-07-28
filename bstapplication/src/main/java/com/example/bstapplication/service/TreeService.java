package com.example.bstapplication.service;

import com.example.bstapplication.model.TreeNode;
import com.example.bstapplication.model.TreeRecord;
import com.example.bstapplication.repository.TreeRecordRepository;
import com.example.bstapplication.util.BinarySearchTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    public TreeNode createTree(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);
        TreeNode root = bst.getRoot();
        TreeRecord treeRecord = new TreeRecord(numbers, root);
        treeRecordRepository.save(treeRecord);
        return root;
    }

    public List<TreeRecord> getPreviousTrees() {
        return treeRecordRepository.findAll();
    }
}

