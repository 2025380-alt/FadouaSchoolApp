/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.schoolapp;

import java.io.*;
import java.util.*;


/**
 * Main application for school person management.
 * Provides:
 * - CSV file reading
 - Recursive merge sort (by full name)
 * - Recursive binary search (by full name)
 * - Add new person records (with role & department chosen from enums)
 * - Build complete binary tree from the list (requires at least 20 records)
 * - Display level‑order traversal, height, and total nodes of the tree
 */
public class SchoolApp {

    private static ArrayList<Person> people = new ArrayList<>();   // main data store
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Step 1: read CSV file
        System.out.print("Please enter the filename to read: ");
        String filename = scanner.nextLine();
        if (!readCSV(filename)) {
            System.out.println("Failed to read file. Exiting.");
            return;
        }
        System.out.println("File read successfully. Loaded " + people.size() + " records.\n");

        // Step 2: main menu loop
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Your choice: ");
            MenuOption option = MenuOption.fromInt(choice);
            if (option == null) {
                System.out.println("Invalid option, try again.\n");
                continue;
            }

            switch (option) {
                case SORT:
                    sortPeople();
                    break;
                case SEARCH:
                    searchPerson();
                    break;
                case ADD_RECORD:
                    addPerson();
                    break;
                case CREATE_BINARY_TREE:
                    createAndDisplayTree();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }

    /**
     * Reads CSV file with the expected columns:
     * First,Last,Gender,Email,Salary,Department,Position,Role,School
     * Handles missing fields gracefully.
     */
    private static boolean readCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();   // skip header line if present
            if (header == null) return false;
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                if (fields.length < 9) continue;   // skip malformed rows
                String firstName = fields[0].trim();
                String lastName = fields[1].trim();
                String gender = fields[2].trim();
                String email = fields[3].trim();
                double salary = Double.parseDouble(fields[4].trim());
                String department = fields[5].trim();
                String position = fields[6].trim();
                String role = fields[7].trim();
                String school = fields[8].trim();
                people.add(new Person(firstName, lastName, gender, email,
                        salary, department, position, role, school));
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return false;
        }
    }

    /** Displays the main menu using the MenuOption enum. */
    private static void displayMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        for (MenuOption m : MenuOption.values()) {
            System.out.println(m);
        }
    }

    /** Sorts the people list using recursive merge sort and shows first 20 records. */
    private static void sortPeople() {
        if (people.isEmpty()) {
            System.out.println("No records to sort.");
            return;
        }
        PersonSorter.mergeSort(people, 0, people.size() - 1);
        System.out.println("Sorted " + people.size() + " records alphabetically by full name.");
        int limit = Math.min(20, people.size());
        System.out.println("First " + limit + " records:");
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + people.get(i));
        }
    }

    /**
     * Searches for a person by full name using recursive binary search.
     * Ensures list is sorted before searching.
     */
    private static void searchPerson() {
        if (people.isEmpty()) {
            System.out.println("List is empty. Load data first.");
            return;
        }
        // Binary search requires sorted list
        if (!isSorted()) {
            System.out.println("List not yet sorted; sorting now...");
            PersonSorter.mergeSort(people, 0, people.size() - 1);
        }
        System.out.print("Enter full name to search (e.g., Maria Gonzalez): ");
        String name = scanner.nextLine().trim();
        int index = PersonSearcher.binarySearch(people, name, 0, people.size() - 1);
        if (index != -1) {
            Person p = people.get(index);
            System.out.println("Found: " + p);
            System.out.println("Role: " + p.getRole());
            System.out.println("Department: " + p.getDepartment());
        } else {
            System.out.println("Name not found in the list.");
        }
    }

    /** Checks if the people list is already sorted by full name. */
    private static boolean isSorted() {
        for (int i = 0; i < people.size() - 1; i++) {
            if (people.get(i).getFullName().compareToIgnoreCase(
                    people.get(i + 1).getFullName()) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a new person record interactively.
     * The user chooses a role (from Role enum) and department (from Department enum).
     * After adding, the list is automatically resorted.
     */
    private static void addPerson() {
        System.out.print("Enter full name (FirstName LastName): ");
        String fullName = scanner.nextLine().trim();
        String[] parts = fullName.split("\\s+", 2);
        if (parts.length < 2) {
            System.out.println("Please provide both first and last name.");
            return;
        }
        String firstName = parts[0];
        String lastName = parts[1];

        // Role selection
        System.out.println("\nSelect Role:");
        Role.displayOptions();
        int roleChoice = getIntInput("Enter choice: ");
        Role role = Role.fromIndex(roleChoice);
        if (role == null) {
            System.out.println("Invalid role. Aborting.");
            return;
        }

        // Department selection
        System.out.println("\nSelect Department:");
        Department.displayOptions();
        int depChoice = getIntInput("Enter choice: ");
        Department dep = Department.fromIndex(depChoice);
        if (dep == null) {
            System.out.println("Invalid department. Aborting.");
            return;
        }

        // Create new Person object (some fields set to default/N/A)
        Person newPerson = new Person(firstName, lastName, "N/A", "unknown@school.edu",
                0.0, dep.getName(), "", role.getLabel(), "Springfield School");
        people.add(newPerson);
        // Keep list sorted for future binary searches
        PersonSorter.mergeSort(people, 0, people.size() - 1);
        System.out.println("\"" + fullName + "\" added as \"" + role.getLabel() +
                "\" to \"" + dep.getName() + "\" successfully!");
        System.out.println("Newly added record: " + newPerson);
    }

    /**
     * Builds a complete binary tree from the people list and displays it.
     * Requires at least 20 records; otherwise prints an error message.
     */
    private static void createAndDisplayTree() {
        final int MIN = 20;
        if (people.size() < MIN) {
            System.out.println("Need at least " + MIN + " records. Currently have " +
                    people.size() + ". Add more or choose a file with enough data.");
            return;
        }
        BinaryTree tree = new BinaryTree();
        tree.buildFromList(people);
        System.out.println("Binary Tree built from " + tree.totalNodes() + " persons.");
        System.out.println("Level Order Traversal:");
        tree.levelOrderTraversal();
        System.out.println("Tree Height: " + tree.height());
        System.out.println("Total Nodes: " + tree.totalNodes());
    }

    /**
     * Utility method to safely read an integer from the console.
     * Loops until a valid integer is entered.
     */
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}