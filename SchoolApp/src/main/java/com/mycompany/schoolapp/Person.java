/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;

/**
 *
 * @author store one
 */
public class Person {
    
    /**
 * Represents a person (staff member or student) in the school.
 * Holds personal information, role, department, and school name.
 * The toString method provides a concise representation.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;           // can be stipend or 0 for volunteers
    private String department;
    private String position;         // e.g., senior, middle, intern – may be empty
    private String role;             // Principal, Teacher, etc. (from Role enum)
    
}
