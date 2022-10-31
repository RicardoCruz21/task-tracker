package org.tasktracker.tasks;

import org.tasktracker.tasks.services.ConsoleService;

public class App {

    private static final String MAIN_MENU_OPTION_TASKS = "Tasks";
    private static final String MAIN_MENU_OPTION_EMPLOYEES = "Employees";
    private static final String MAIN_MENU_OPTION_CLIENTS = "Clients";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = new String[] { MAIN_MENU_OPTION_TASKS,
                                                                     MAIN_MENU_OPTION_EMPLOYEES,
                                                                     MAIN_MENU_OPTION_CLIENTS,
                                                                     MAIN_MENU_OPTION_EXIT };

    private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to Main Menu";

    private static final String TASK_MENU_OPTION_ALL_TASKS = "Show all Tasks";
    private static final String TASK_MENU_OPTION_ASSIGNMENTS = "Assignments";
    private static final String TASK_MENU_OPTION_APPOINTMENTS = "Appointments";
    private static final String TASK_MENU_OPTION_MEETINGS = "Meetings";
    private static final String[] TASK_MENU_OPTIONS = new String[] { TASK_MENU_OPTION_ALL_TASKS,
                                                                     TASK_MENU_OPTION_ASSIGNMENTS,
                                                                     TASK_MENU_OPTION_APPOINTMENTS,
                                                                     TASK_MENU_OPTION_MEETINGS,
                                                                     MENU_OPTION_RETURN_TO_MAIN };

    private static final String MENU_OPTION_RETURN_TO_TASKS = "Return to Tasks Menu";

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
