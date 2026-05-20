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
    private String schoolName;
    
    
    /**
     * Full constructor.
     * @param position may be an empty string, which will be stored as null
     */
    public Person(String firstName, String lastName, String gender, String email,
                  double salary, String department, String position, String role,
                  String schoolName) {
        
          this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position.isEmpty() ? null : position;
        this.role = role;
        this.schoolName = schoolName;
    }
     /** Returns "FirstName LastName". Used for sorting and searching. */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public String getRole() { return role; }
    public String getDepartment() { return department; }
    
    /**
     * String representation used in menus and binary tree output.
     * Format: First Last | Role | Department
     */
    @Override
    public String toString() {
        return String.format("%s %s | %s | %s",
                firstName, lastName,
                role.isEmpty() ? "(no role)" : role,
                department.isEmpty() ? "(no department)" : department);
    }
}

    }
