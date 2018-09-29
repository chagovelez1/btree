package com.algorithms.btree.services;

import com.algorithms.btree.entities.BinaryTree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtreeService {
    private BinaryTree binaryTree = new BinaryTree();

    public void newBinaryTree(List<Integer> values) {
        this.binaryTree = new BinaryTree();
        values.forEach(value->{
            this.binaryTree.add(value);
        });
    }

    public Integer getClosestAncestor(int value1, int value2){
        return this.binaryTree.closestCommonAncestor(value1, value2);
    }

    public boolean checkExistance(int value){
        return this.binaryTree.checkExistance(value);
    }

}
