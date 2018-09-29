package com.algorithms.btree.controllers;

import com.algorithms.btree.services.BtreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("binary-tree")
public class BtreeController {

    @Autowired
    private BtreeService btreeService;

    @ResponseBody
    @PostMapping("create")
    public String create(@RequestBody List<Integer> request){
        btreeService.newBinaryTree(request);
        return "binary tree created";
    }

    @ResponseBody
    @GetMapping("closest-ancestor/{value1}/{value2}")
    public String closestAncestor(@PathVariable Integer value1, @PathVariable Integer value2){
        if (!btreeService.checkExistance(value1)){
            return "el numero "+value1+" no existe en el arbol";
        }else if (!btreeService.checkExistance(value2)){
            return "el numero "+value2+" no existe en el arbol";
        }

        return "el ancestro mas cercano de "
                + value1
                + " y "
                + value2
                + " es el "
                + btreeService.getClosestAncestor(value1, value2);
    }
}
