/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;

/**
 *
 * @author store one
 */
/**
 * Enum representing possible roles (job titles) of a person in a school.
 * Used for display and user selection when adding a new record.
 */
public enum Role {
    PRINCIPAL("Principal"),
    VICE_PRINCIPAL("Vice Principal"),
    HEAD_OF_DEPARTMENT("Head of Department"),
    TEACHER("Teacher"),
    ASSISTANT_TEACHER("Assistant Teacher"),
    SUBSTITUTE_TEACHER("Substitute Teacher"),
    COUNSELOR("Counselor"),
    LIBRARIAN("Librarian"),
    ADMIN("Administrative Staff"),
    INTERN("Intern");
    
    
    private final String label;   // user‑friendly name

    Role(String label) { this.label = label; }

     public String getLabel() { return label; }

    /**
     * Returns the Role that corresponds to a 1‑based index.
     * Used when the user picks from a numbered list.
     */
    public static Role fromIndex(int index) {
        Role[] values = values();
        if (index >= 1 && index <= values.length) {
            return values[index - 1];
        }
        return null;
    }
}