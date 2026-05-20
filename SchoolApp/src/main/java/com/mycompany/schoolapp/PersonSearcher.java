/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;

/**
 *
 * @author store one
 */
public class PersonSearcher {
    
      /**
     * Recursively searches for a person with the given full name.
     * @param list sorted ArrayList of Person objects
     * @param fullName the name to search for (case‑insensitive)
     * @param low lower bound index (inclusive)
     * @param high upper bound index (inclusive)
     * @return index of the found Person, or -1 if not found
     */
    public static int binarySearch(ArrayList<Person> list, String fullName,
                                   int low, int high) {
        
         if (low > high) return -1;                     // base case: not found
    }
    
}
