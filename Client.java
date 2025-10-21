package Elevator;
import java.util.*;

// A program that simulates an elevator. Users can enter how many floors the building has, 
// if there is a basement, and which floor is the main floor. 
public class Client {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("How many above-ground floors does your building have?");
        int aboveLevels = Integer.parseInt(console.nextLine().trim());

        System.out.println("How many below-ground floors does your building have (basement levels)?");
        int undergroundLevels = Integer.parseInt(console.nextLine().trim());

        System.out.println("Which floor is your main floor? (press 'Enter' to default 1)");
        String mainInput = console.nextLine().trim();
        int mainFloor = mainInput.isEmpty() ? 1 : Integer.parseInt(mainInput);

        System.out.println("Elevator starting...");

        Elevator elevator = new Elevator(aboveLevels, undergroundLevels, mainFloor);
        elevator.printElevator();

        while (true) {
            System.out.println("\nEnter a floor number to move the elevator, or 'q' to quit:");
            String input = console.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                System.out.println("Exiting elevator... Goodbye!");
                break;
            }

            try {
                int newFloor = Integer.parseInt(input);
                if (!elevator.changeLevels(newFloor)) {
                    System.out.println("Invalid floor number! Please enter a valid floor.");
                } else {
                    System.out.println("Moving to floor " + newFloor + "...");
                    elevator.printElevator();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number or 'q' to quit.");
            }
        }

        console.close();
    }
}
