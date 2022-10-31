package org.tasktracker.tasks;

import org.tasktracker.tasks.services.ConsoleService;

public class App {

    private static final String MAIN_MENU_OPTION_TASKS = "Tasks Menu";
    private static final String MAIN_MENU_OPTION_EMPLOYEES = "Employees Menu";
    private static final String MAIN_MENU_OPTION_CLIENTS = "Clients Menu";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_TASKS,
                                                                     MAIN_MENU_OPTION_EMPLOYEES,
                                                                     MAIN_MENU_OPTION_CLIENTS,
                                                                     MAIN_MENU_OPTION_EXIT };

    private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";

    private static final String TASK_MENU_OPTION_ALL_TASKS = "Show all tasks";
    private static final String TASK_MENU_OPTION_ASSIGNMENTS = "Assignments Menu";
    private static final String TASK_MENU_OPTION_APPOINTMENTS = "Appointments Menu";
    private static final String TASK_MENU_OPTION_MEETINGS = "Meetings Menu";
    private static final String[] TASK_MENU_OPTIONS = new String[] { TASK_MENU_OPTION_ALL_TASKS,
                                                                     TASK_MENU_OPTION_ASSIGNMENTS,
                                                                     TASK_MENU_OPTION_APPOINTMENTS,
                                                                     TASK_MENU_OPTION_MEETINGS,
                                                                     MENU_OPTION_RETURN_TO_MAIN };

    private static final String MENU_OPTION_RETURN_TO_TASKS = "Return to Tasks Menu";

    private static final String ASSIGNMENT_MENU_OPTION_ALL_ASSIGNMENTS = "Show all Assignments";
    private static final String ASSIGNMENT_MENU_ASSIGNMENT_DETAILS = "Show Assignment Details";
    private static final String ASSIGNMENT_MENU_ADD_ASSIGNMENT = "Add an Assignment";
    private static final String ASSIGNMENT_MENU_UPDATE_ASSIGNMENT = "Update an Assignment";
    private static final String ASSIGNMENT_MENU_COMPLETE_ASSIGNMENT = "Complete an Assignment";
    private static final String ASSIGNMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_ASSIGNMENT = "Assign Employee to Assignment";
    private static final String ASSIGNMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_ASSIGNMENT = "Remove Employee from Assignment";
    private static final String ASSIGNMENT_MENU_OPTION_ADD_CLIENT_TO_ASSIGNMENT = "Add Client to Assignment";
    private static final String ASSIGNMENT_MENU_OPTION_REMOVE_CLIENT_FROM_ASSIGNMENT = "Remove Client from Assignment";
    private static final String[] ASSIGNMENT_MENU_OPTIONS = new String[] { ASSIGNMENT_MENU_OPTION_ALL_ASSIGNMENTS,
                                                                           ASSIGNMENT_MENU_ASSIGNMENT_DETAILS,
                                                                           ASSIGNMENT_MENU_ADD_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_UPDATE_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_COMPLETE_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_OPTION_ADD_CLIENT_TO_ASSIGNMENT,
                                                                           ASSIGNMENT_MENU_OPTION_REMOVE_CLIENT_FROM_ASSIGNMENT,
                                                                           MENU_OPTION_RETURN_TO_TASKS };


    private final ConsoleService consoleService;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public App() {
        this.consoleService = new ConsoleService();
    }

    private void run() {
        boolean running = true;
        while(running) {
            printHeading("Main Menu");
            String choice = (String)consoleService.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_TASKS)){
                handleTasks();
            } else if (choice.equals(MAIN_MENU_OPTION_EMPLOYEES)) {
                System.out.println("You selected Employees!");
            } else if (choice.equals(MAIN_MENU_OPTION_CLIENTS)) {
                System.out.println("You selected Clients!");
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println("Goodbye!");
                running = false;
            }
        }
    }

    private void handleTasks() {
        boolean running = true;
        while(running) {
            printHeading("Tasks Menu");
            String choice = (String) consoleService.getChoiceFromOptions(TASK_MENU_OPTIONS);
            if (choice.equals(TASK_MENU_OPTION_ALL_TASKS)) {
                System.out.println("Showing all Tasks!");
            } else if (choice.equals(TASK_MENU_OPTION_ASSIGNMENTS)) {
                handleAssignments();
            } else if (choice.equals(TASK_MENU_OPTION_APPOINTMENTS)) {
                System.out.println("You selected Appointments!");
            } else if (choice.equals(TASK_MENU_OPTION_MEETINGS)) {
                System.out.println("You selected Meetings!");
            } else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
                System.out.println("Returning to Main Menu!");
                running = false;
            }
        }
    }

    private void handleAssignments() {
        boolean running = true;
        while(running) {
            printHeading("Assignments Menu");
            String choice = (String) consoleService.getChoiceFromOptions(ASSIGNMENT_MENU_OPTIONS);
            if (choice.equals(ASSIGNMENT_MENU_OPTION_ALL_ASSIGNMENTS)) {
                System.out.println("Showing all Assignments!");
            } else if (choice.equals(ASSIGNMENT_MENU_ASSIGNMENT_DETAILS)) {
                System.out.println("Showing Assignment Details!");
            } else if (choice.equals(ASSIGNMENT_MENU_ADD_ASSIGNMENT)) {
                System.out.println("Adding new Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_UPDATE_ASSIGNMENT)) {
                System.out.println("Updating Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_COMPLETE_ASSIGNMENT)) {
                System.out.println("Completing Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_ASSIGNMENT)) {
                System.out.println("Assigning Employee to Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_ASSIGNMENT)) {
                System.out.println("Removing Employee from Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_OPTION_ADD_CLIENT_TO_ASSIGNMENT)) {
                System.out.println("Adding Client to Assignment!");
            } else if (choice.equals(ASSIGNMENT_MENU_OPTION_REMOVE_CLIENT_FROM_ASSIGNMENT)) {
                System.out.println("Removing Client from Assignment!");
            } else if (choice.equals(MENU_OPTION_RETURN_TO_TASKS)) {
                System.out.println("Returning to Tasks Menu!");
                running = false;
            }
        }
    }

    private void printHeading(String headingText) {
        System.out.println("\n"+headingText);
        for(int i = 0; i < headingText.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
