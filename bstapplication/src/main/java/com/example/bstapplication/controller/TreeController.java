package com.example.bstapplication.controller;

import com.example.bstapplication.model.TreeNode;
import com.example.bstapplication.model.TreeRecord;
import com.example.bstapplication.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/enter-numbers")
    public TreeNode createTree(@RequestBody List<Integer> numbers) {
        return treeService.createTree(numbers);
    }

    @GetMapping("/previous-trees")
    public List<TreeRecord> getPreviousTrees() {
        return treeService.getPreviousTrees();
    }
}

