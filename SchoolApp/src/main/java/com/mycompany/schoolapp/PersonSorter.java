/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;
import java.util.ArrayList;

/**
 *
 * @author store one
 */
public class PersonSorter {
    
     /**
     * Recursively sorts the subarray list[left..right] (inclusive) using merge sort.
     * @param list the ArrayList to sort (modified in place)
     * @param left left index (inclusive)
     * @param right right index (inclusive)
     */
    public static void mergeSort(ArrayList<Person> list, int left, int right) {
        int mid = left + (right - left) / 2;   // avoid overflow
            mergeSort(list, left, mid);             // sort left half
            mergeSort(list, mid + 1, right);       // sort right half
            merge(list, left, mid, right);          // merge the two sorted halves
        }
    }
    
/**
     * Merges two sorted subarrays: list[left..mid] and list[mid+1..right].
     * Uses temporary ArrayLists for the two halves.
     */
    private static void merge(ArrayList<Person> list, int left, int mid, int right) {