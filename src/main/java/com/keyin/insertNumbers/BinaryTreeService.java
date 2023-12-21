package com.keyin.insertNumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BinaryTreeService {

    @Autowired
    private BinaryTreeRepository binaryTreeRepository;

    public BinarySearchTree processNumbers(BinarySearchTree numbers) {
        binaryTreeRepository.save(numbers);
        return numbers;
    }

    public List<BinaryTreeResult> getPreviousTrees() {
        Iterable<BinarySearchTree> binarySearchTreeIterable = binaryTreeRepository.findAll();
        List<BinaryTreeResult> resultList = new ArrayList<>();

        for (BinarySearchTree binarySearchTree : binarySearchTreeIterable) {
            BinaryTreeResult result = convertToBinaryTreeResult(binarySearchTree);
            resultList.add(result);
        }

        return resultList;
    }

    private BinaryTreeResult convertToBinaryTreeResult(BinarySearchTree binarySearchTree) {
        return null;
    }
}

