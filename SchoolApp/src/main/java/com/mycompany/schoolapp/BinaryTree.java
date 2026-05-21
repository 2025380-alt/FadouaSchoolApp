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
    
      /**
     * Builds a complete binary tree from a list of Person objects.
     * Uses recursive construction based on array indices:
     * - root at index 0
     * - left child at 2*index+1
     * - right child at 2*index+2
     *
     * @param people list of persons (will be placed in level order)
     */
    public void buildFromList(List<Person> people) {
        
        nodeCount = people.size();
        if (people.isEmpty()) {
            root = null;
            return;
        }
        root = buildRecursive(people, 0);
    }
    
      /**
     * Recursively builds the tree using the index mapping.
     * @param people the source list
     * @param index current node's index in the array representation
     * @return TreeNode for this index, or null if index out of bounds
     */
    private TreeNode buildRecursive(List<Person> people, int index) {
        if (index >= people.size()) return null;
        TreeNode node = new TreeNode(people.get(index));
        node.left = buildRecursive(people, 2 * index + 1);
        node.right = buildRecursive(people, 2 * index + 2);
        return node;
    }
 

    /**
     * Prints the tree in level order (breadth‑first) using a queue.
     * Each node is displayed as: FullName | Role | Department
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.person.getFullName() + " | " +
                    current.person.getRole() + " | " +
                    current.person.getDepartment());
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
    
    /** Returns the height of the tree (number of nodes on the longest path from root to leaf). */
    public int height() {
        return calcHeight(root);
    }

    /** Recursive helper to compute height. */
    private int calcHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
    }
