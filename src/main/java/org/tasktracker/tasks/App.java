package org.tasktracker.tasks;

import org.apache.commons.dbcp2.BasicDataSource;
import org.tasktracker.tasks.dao.*;
import org.tasktracker.tasks.services.ConsoleService;

import javax.sql.DataSource;

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

    private static final String EMPLOYEE_MENU_OPTION_ALL_EMPLOYEES = "Show all Employees";
    private static final String EMPLOYEE_MENU_OPTION_EMPLOYEE_DETAILS = "Show Employee Details";
    private static final String EMPLOYEE_MENU_OPTION_ADD_EMPLOYEE = "Add an Employee";
    private static final String EMPLOYEE_MENU_OPTION_UPDATE_EMPLOYEE = "Update an Employee";
    private static final String EMPLOYEE_MENU_OPTION_REMOVE_EMPLOYEE = "Remove an Employee";
    private static final String EMPLOYEE_MENU_OPTION_PENDING_TASKS_FOR_EMPLOYEE = "List Pending Tasks for Employee";
    private static final String EMPLOYEE_MENU_OPTION_TASKS_COMPLETED_BY_EMPLOYEE = "List Tasks Completed by Employee";
    private static final String[] EMPLOYEE_MENU_OPTIONS = new String[] { EMPLOYEE_MENU_OPTION_ALL_EMPLOYEES,
                                                                         EMPLOYEE_MENU_OPTION_EMPLOYEE_DETAILS,
                                                                         EMPLOYEE_MENU_OPTION_ADD_EMPLOYEE,
                                                                         EMPLOYEE_MENU_OPTION_UPDATE_EMPLOYEE,
                                                                         EMPLOYEE_MENU_OPTION_REMOVE_EMPLOYEE,
                                                                         EMPLOYEE_MENU_OPTION_PENDING_TASKS_FOR_EMPLOYEE,
                                                                         EMPLOYEE_MENU_OPTION_TASKS_COMPLETED_BY_EMPLOYEE,
                                                                         MENU_OPTION_RETURN_TO_MAIN };

    private static final String CLIENT_MENU_OPTION_ALL_CLIENTS = "Show all Clients";
    private static final String CLIENT_MENU_OPTION_CLIENT_DETAILS = "Show Client Details";
    private static final String CLIENT_MENU_OPTION_ADD_CLIENT = "Add a Client";
    private static final String CLIENT_MENU_OPTION_UPDATE_CLIENT = "Update a Client";
    private static final String CLIENT_MENU_OPTION_REMOVE_CLIENT = "Remove a Client";
    private static final String CLIENT_MENU_OPTION_PENDING_TASKS_FOR_CLIENT = "List Pending Tasks for Client";
    private static final String CLIENT_MENU_OPTION_TASKS_COMPLETED_FOR_CLIENT = "List Tasks Completed for Client";
    private static final String[] CLIENT_MENU_OPTIONS = new String[] { CLIENT_MENU_OPTION_ALL_CLIENTS,
                                                                       CLIENT_MENU_OPTION_CLIENT_DETAILS,
                                                                       CLIENT_MENU_OPTION_ADD_CLIENT,
                                                                       CLIENT_MENU_OPTION_UPDATE_CLIENT,
                                                                       CLIENT_MENU_OPTION_REMOVE_CLIENT,
                                                                       CLIENT_MENU_OPTION_PENDING_TASKS_FOR_CLIENT,
                                                                       CLIENT_MENU_OPTION_TASKS_COMPLETED_FOR_CLIENT,
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

    private static final String APPOINTMENT_MENU_OPTION_ALL_APPOINTMENTS = "Show all Appointments";
    private static final String APPOINTMENT_MENU_APPOINTMENT_DETAILS = "Show Appointment Details";
    private static final String APPOINTMENT_MENU_ADD_APPOINTMENT = "Add an Appointment";
    private static final String APPOINTMENT_MENU_UPDATE_APPOINTMENT = "Update an Appointment";
    private static final String APPOINTMENT_MENU_COMPLETE_APPOINTMENT = "Complete an Appointment";
    private static final String APPOINTMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_APPOINTMENT = "Assign Employee to Appointment";
    private static final String APPOINTMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_APPOINTMENT = "Remove Employee from Appointment";
    private static final String APPOINTMENT_MENU_OPTION_ADD_CLIENT_TO_APPOINTMENT = "Add Client to Appointment";
    private static final String APPOINTMENT_MENU_OPTION_REMOVE_CLIENT_FROM_APPOINTMENT = "Remove Client from Appointment";
    private static final String[] APPOINTMENT_MENU_OPTIONS = new String[] { APPOINTMENT_MENU_OPTION_ALL_APPOINTMENTS,
                                                                            APPOINTMENT_MENU_APPOINTMENT_DETAILS,
                                                                            APPOINTMENT_MENU_ADD_APPOINTMENT,
                                                                            APPOINTMENT_MENU_UPDATE_APPOINTMENT,
                                                                            APPOINTMENT_MENU_COMPLETE_APPOINTMENT,
                                                                            APPOINTMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_APPOINTMENT,
                                                                            APPOINTMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_APPOINTMENT,
                                                                            APPOINTMENT_MENU_OPTION_ADD_CLIENT_TO_APPOINTMENT,
                                                                            APPOINTMENT_MENU_OPTION_REMOVE_CLIENT_FROM_APPOINTMENT,
                                                                            MENU_OPTION_RETURN_TO_TASKS };

    private static final String MEETING_MENU_OPTION_ALL_MEETINGS = "Show all Meetings";
    private static final String MEETING_MENU_MEETING_DETAILS = "Show Meeting Details";
    private static final String MEETING_MENU_ADD_MEETING = "Add a Meeting";
    private static final String MEETING_MENU_UPDATE_MEETING = "Update a Meeting";
    private static final String MEETING_MENU_COMPLETE_MEETING = "Complete a Meeting";
    private static final String MEETING_MENU_OPTION_ASSIGN_EMPLOYEE_TO_MEETING = "Assign Employee to Meeting";
    private static final String MEETING_MENU_OPTION_REMOVE_EMPLOYEE_FROM_MEETING = "Remove Employee from Meeting";
    private static final String[] MEETING_MENU_OPTIONS = new String[] { MEETING_MENU_OPTION_ALL_MEETINGS,
                                                                        MEETING_MENU_MEETING_DETAILS,
                                                                        MEETING_MENU_ADD_MEETING,
                                                                        MEETING_MENU_UPDATE_MEETING,
                                                                        MEETING_MENU_COMPLETE_MEETING,
                                                                        MEETING_MENU_OPTION_ASSIGN_EMPLOYEE_TO_MEETING,
                                                                        MEETING_MENU_OPTION_REMOVE_EMPLOYEE_FROM_MEETING,
                                                                        MENU_OPTION_RETURN_TO_TASKS };


    private final ConsoleService consoleService;
    private final AppointmentDao appointmentDao;
    private final AssignmentDao assignmentDao;
    private final ClientDao clientDao;
    private final EmployeeDao employeeDao;
    private final MeetingDao meetingDao;
    private final TaskDao taskDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TaskTrackerDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        App app = new App(dataSource);
        app.run();
    }

    public App(DataSource dataSource) {
        this.consoleService = new ConsoleService();

        this.appointmentDao = new JdbcAppointmentDao(dataSource);
        this.assignmentDao = new JdbcAssignmentDao(dataSource);
        this.clientDao = new JdbcClientDao(dataSource);
        this.employeeDao = new JdbcEmployeeDao(dataSource);
        this.meetingDao = new JdbcMeetingDao(dataSource);
        this.taskDao = new JdbcTaskDao(dataSource);
    }

    private void run() {
        boolean running = true;
        while(running) {
            printHeading("Main Menu");
            String choice = (String)consoleService.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_TASKS)){
                handleTasks();
            } else if (choice.equals(MAIN_MENU_OPTION_EMPLOYEES)) {
                handleEmployees();
            } else if (choice.equals(MAIN_MENU_OPTION_CLIENTS)) {
                handleClients();
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
                handleAppointments();
            } else if (choice.equals(TASK_MENU_OPTION_MEETINGS)) {
                handleMeetings();
            } else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
                System.out.println("Returning to Main Menu!");
                running = false;
            }
        }
    }

    private void handleEmployees() {
        boolean running = true;
        while(running) {
            printHeading("Employees Menu");
            String choice = (String) consoleService.getChoiceFromOptions(EMPLOYEE_MENU_OPTIONS);
            if (choice.equals(EMPLOYEE_MENU_OPTION_ALL_EMPLOYEES)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_EMPLOYEE_DETAILS)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_ADD_EMPLOYEE)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_UPDATE_EMPLOYEE)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_REMOVE_EMPLOYEE)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_PENDING_TASKS_FOR_EMPLOYEE)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(EMPLOYEE_MENU_OPTION_TASKS_COMPLETED_BY_EMPLOYEE)) {
                System.out.println("Showing all Employees!");
            } else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
                System.out.println("Returning to Main Menu!");
                running = false;
            }
        }
    }

    private void handleClients() {
        boolean running = true;
        while(running) {
            printHeading("Clients Menu");
            String choice = (String) consoleService.getChoiceFromOptions(CLIENT_MENU_OPTIONS);
            if (choice.equals(CLIENT_MENU_OPTION_ALL_CLIENTS)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_CLIENT_DETAILS)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_ADD_CLIENT)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_UPDATE_CLIENT)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_REMOVE_CLIENT)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_PENDING_TASKS_FOR_CLIENT)) {
                System.out.println("Showing all Clients!");
            } else if (choice.equals(CLIENT_MENU_OPTION_TASKS_COMPLETED_FOR_CLIENT)) {
                System.out.println("Showing all Clients!");
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

    private void handleAppointments() {
        boolean running = true;
        while(running) {
            printHeading("Appointments Menu");
            String choice = (String) consoleService.getChoiceFromOptions(APPOINTMENT_MENU_OPTIONS);
            if (choice.equals(APPOINTMENT_MENU_OPTION_ALL_APPOINTMENTS)) {
                System.out.println("Showing all Appointments!");
            } else if (choice.equals(APPOINTMENT_MENU_APPOINTMENT_DETAILS)) {
                System.out.println("Showing Appointment Details!");
            } else if (choice.equals(APPOINTMENT_MENU_ADD_APPOINTMENT)) {
                System.out.println("Adding new Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_UPDATE_APPOINTMENT)) {
                System.out.println("Updating Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_COMPLETE_APPOINTMENT)) {
                System.out.println("Completing Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_OPTION_ASSIGN_EMPLOYEE_TO_APPOINTMENT)) {
                System.out.println("Assigning Employee to Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_OPTION_REMOVE_EMPLOYEE_FROM_APPOINTMENT)) {
                System.out.println("Removing Employee from Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_OPTION_ADD_CLIENT_TO_APPOINTMENT)) {
                System.out.println("Adding Client to Appointment!");
            } else if (choice.equals(APPOINTMENT_MENU_OPTION_REMOVE_CLIENT_FROM_APPOINTMENT)) {
                System.out.println("Removing Client from Appointment!");
            } else if (choice.equals(MENU_OPTION_RETURN_TO_TASKS)) {
                System.out.println("Returning to Tasks Menu!");
                running = false;
            }
        }
    }

    private void handleMeetings() {
        boolean running = true;
        while(running) {
            printHeading("Appointments Menu");
            String choice = (String) consoleService.getChoiceFromOptions(MEETING_MENU_OPTIONS);
            if (choice.equals(MEETING_MENU_OPTION_ALL_MEETINGS)) {
                System.out.println("Showing all Appointments!");
            } else if (choice.equals(MEETING_MENU_MEETING_DETAILS)) {
                System.out.println("Showing Appointment Details!");
            } else if (choice.equals(MEETING_MENU_ADD_MEETING)) {
                System.out.println("Adding new Appointment!");
            } else if (choice.equals(MEETING_MENU_UPDATE_MEETING)) {
                System.out.println("Updating Appointment!");
            } else if (choice.equals(MEETING_MENU_COMPLETE_MEETING)) {
                System.out.println("Completing Appointment!");
            } else if (choice.equals(MEETING_MENU_OPTION_ASSIGN_EMPLOYEE_TO_MEETING)) {
                System.out.println("Assigning Employee to Appointment!");
            } else if (choice.equals(MEETING_MENU_OPTION_REMOVE_EMPLOYEE_FROM_MEETING)) {
                System.out.println("Removing Employee from Appointment!");
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
