package com.example.bstapplication.controller;

import com.example.bstapplication.model.TreeNode;
import com.example.bstapplication.model.TreeRecord;
import com.example.bstapplication.service.TreeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.bstapplication.repository.TreeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @Autowired
    private TreeRecordRepository treeRecordRepository;

    @RequestMapping("/enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public String processNumbers(@RequestParam("numbers") String numbers) {
        String[] numberArray = numbers.split(",");
        int[] nums = new int[numberArray.length];
        for (int i = 0; i < numberArray.length; i++) {
            nums[i] = Integer.parseInt(numberArray[i].trim());
        }
        TreeNode root = treeService.buildTree(nums);
        String treeJson = treeService.getTreeJson(root);

        // Save to database
        TreeRecord record = new TreeRecord();
        record.setNumbers(numbers);
        record.setTreeStructure(treeJson);
        treeRecordRepository.save(record);

        return treeJson;
    }

    @GetMapping("/previous-trees")
    @ResponseBody
    public String previousTrees() {
        Iterable<TreeRecord> records = treeRecordRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(records);
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
}

