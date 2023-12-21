package com.keyin.insertNumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    private final BinarySearchTree binarySearchTree = new BinarySearchTree();

    @PostMapping("/enter-numbers")
    public ResponseEntity<String> enterNumbers(@RequestBody List<String> values) {
        for (String value : values) {
            binarySearchTree.insert(Integer.parseInt(value));
        }
        binaryTreeService.processNumbers(binarySearchTree);
        return ResponseEntity.ok("Numbers entered successfully.");
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<BinarySearchTree> processNumbers() {
        BinarySearchTree result = binaryTreeService.processNumbers(binarySearchTree);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<BinaryTreeResult>> showPreviousTrees() {
        List<BinaryTreeResult> previousTrees = binaryTreeService.getPreviousTrees();
        return ResponseEntity.ok(previousTrees);
    }
}

