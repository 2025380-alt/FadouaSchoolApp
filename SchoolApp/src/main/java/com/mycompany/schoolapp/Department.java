/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;


/**
 * Enum representing academic or administrative departments in a school.
 * Used when adding a person to assign them to a department.
 */
public enum Department {
    
    MATHEMATICS("Mathematics"),
    SCIENCE("Science"),
    ENGLISH("English"),
    HISTORY("History"),
    COMPUTER_SCIENCE("Computer Science"),
    PHYSICAL_EDUCATION("Physical Education"),
    ART("Art"),
    MUSIC("Music"),
    FOREIGN_LANGUAGES("Foreign Languages"),
    SPECIAL_EDUCATION("Special Education");
    
    private final String name;

    Department(String name) { this.name = name; }

    public String getName() { return name; }

}