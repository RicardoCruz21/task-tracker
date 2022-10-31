package org.tasktracker.tasks.services;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner in = new Scanner(System.in);

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while(choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if(selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch(NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
        }
        if(choice == null) {
            System.out.println("\n*** "+userInput+" is not a valid option ***\n");
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        System.out.println();
        for(int i = 0; i < options.length; i++) {
            int optionNum = i+1;
            System.out.println(optionNum+") "+options[i]);
        }
        System.out.print("\nPlease choose an option >>> ");
        System.out.flush();
    }
}
