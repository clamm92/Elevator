package Elevator;

/**
 * This class represents a simple elevator simulation. 
 * It allows users to move the elevator between floors, 
 * including above-ground and underground levels. 
 * The elevator displays its current and main floors 
 * when printed to the console.
 */
public class Elevator {
    private int currentLevel;
    private int topLevel;
    private int bottomLevel;
    private int mainLevel;

    // Behavior:
    //   - Creates a new Elevator with the specified number of 
    //     above-ground and underground levels, and a given main floor.
    //   - The current level of the elevator starts at the main floor.
    // Parameters:
    //   - int aboveLevels: number of above-ground levels in the building
    //   - int undergroundLevels: number of below-ground levels in the building
    //   - int mainFloor: the floor where the elevator starts
    public Elevator(int aboveLevels, int undergroundLevels, int mainFloor) {
        this.topLevel = aboveLevels;
        this.bottomLevel = undergroundLevels * -1;
        this.mainLevel = mainFloor;
        this.currentLevel = mainFloor;
    }

    // Behavior:
    //   - Changes the elevator’s current level to the specified new floor.
    //   - The elevator cannot move to a floor above the top level, 
    //     below the bottom level, or to floor 0.
    // Parameters:
    //   - int newFloor: the target floor the elevator should move to
    // Returns:
    //   - boolean: true if the elevator successfully moves to the new floor,
    //     false if the target floor is invalid.
    public boolean changeLevels(int newFloor) {
        if (newFloor > topLevel || newFloor < bottomLevel || newFloor == 0) {
            return false;
        }
        this.currentLevel = newFloor;
        return true;
    }

    // Behavior:
    //   - Prints a visual representation of the elevator and its floors.
    //   - The current floor and main floor are marked distinctly.
    //   - The top floor appears first in the printed output.
    public void printElevator() {
        for (int i = topLevel; i >= bottomLevel; i--) {
            if (i == 0) {
                continue;
            }
            if (i == currentLevel && i == mainLevel) {
                System.out.println("Level " + i + ": Current Level " + "*");
            } else if (i == mainLevel) {
                System.out.println("Level " + i + "*");
            } else if (i == currentLevel) {
                System.out.println("Level " + i + ": Current Level");
            } else {
                System.out.println("Level " + i);
            }
        }
    }
}