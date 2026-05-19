/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolapp;

/**
 *
 * @author store one
 */
public enum MenuOptions {

    SORT(1, "Sort a Dummy List of People"),
    SEARCH(2, "Search in the List and Return Relevant Information"),
    ADD_RECORD(3, "Add Records"),
    CREATE_BINARY_TREE(4, "Create Binary Tree"),
    EXIT(5, "Exit");

    private final int option;          // numeric code for menu selection
    private final String description;   // human‑readable description

    MenuOptions(int option, String description) {
        this.option = option;
        this.description = description;
    }

    /** Returns the numeric code of this menu option. */
    public int getOption() { return option; }

       /**
     * Returns the MenuOption corresponding to an integer choice.
     * @param choice integer entered by user
     * @return matching MenuOption or null if none found
     */
    public static MenuOptions fromInt(int choice) {
        for (MenuOptions m : values()) {
            if (m.option == choice) return m;
        }
        return null;
    }

    @Override
    public String toString() {
        return option + ". " + description;
    }
}
