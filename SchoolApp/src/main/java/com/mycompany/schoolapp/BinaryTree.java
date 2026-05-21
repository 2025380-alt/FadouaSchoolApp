/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;

import java.util.*;

/**
 *
 * @author store one
 */

/**
 * Represents a complete binary tree where each node stores a Person.
 * The tree is built using level‑order insertion (index‑based recursive construction)
 * from a flat list. This guarantees a complete tree (all levels filled except possibly the last,
 * and last level has all nodes as far left as possible).
 *
 * <p>Methods provide level‑order traversal, height calculation, and total node count.
 */
public class BinaryTree {
    private TreeNode root;      // root node of the tree
    private int nodeCount;      // total number of nodes

    /** Inner class representing a single node. */
    private static class TreeNode {
        Person person;
        TreeNode left, right;

        TreeNode(Person person) {
            this.person = person;
        }
    }
}
