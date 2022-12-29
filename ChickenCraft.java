import java.util.ArrayList;
import java.util.Scanner;
/**
 * ChickenCraft class implements "view" that consists of a text-based conversation with the user
 *
 * @author Harshadkumar Patel, 000852665
 *
 * /

/**
 * ChickenCraft is the main Class
 */
public class ChickenCraft {
    static ArrayList<Chicken> chickenArrayList = new ArrayList<>(); // declare array of Chicken list
    static int choiceInput = 0; // use to store choice of user input for the operation
    static int whichChicken = 0; // use to store to perform operation on specific chicken

    /**
     * @param args main method of the class ChickenCraft
     */
    public static void main(String[] args) {
        //This code is used to create object
        Chicken chicken1 = new Chicken();
        chicken1.initData(true, true, "Nancy", 4, 0.1);
        Chicken chicken2 = new Chicken();
        chicken2.initData(true, true, "Nancy", 4, 0.1);
        Chicken chicken3 = new Chicken();
        chicken3.initData(true, true, "Nancy", 4, 0.1);


        //This code is used to add object in the list
        chickenArrayList.add(chicken1);
        chickenArrayList.add(chicken2);
        chickenArrayList.add(chicken3);


        /** Do while loop is checking the condition for the user input and user have to select between 0 and 5 */
        do {
            getInputFromUser();
        } while (choiceInput < 5);
    }

    /**
     * @getInputFromUser method is used to get data from the user
     **/
    static void getInputFromUser() {
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        for (int i = 0; i < chickenArrayList.size(); i++) {
            Chicken chicken = chickenArrayList.get(i);
            System.out.println((i + 1) + ". " + (chicken.isHappy() ? "Happy" : "Unhappy") + " " + (chicken.isAlive() ? "Alive" : "Dead") + " " + chicken.getName() + " : " + chicken.getSeeds() + " kg seeds, " + chicken.getHeart() + " hearts");
        }
        System.out.println();
        System.out.println();
        System.out.println("0. Name   1. Feed   2. Play   3. Hit   4. Get Eggs   5. Quit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choice: "); // asking user to choice from 0 to 5
        choiceInput = scanner.nextInt(); //choiceInput is storing data enter by user
        if (choiceInput == 0 || choiceInput == 1 || choiceInput == 3 || choiceInput == 4) {
            System.out.print("Which Chicken?: "); // ask user to enter chicken number in whichChicken
            whichChicken = scanner.nextInt(); // whichChicken variable is stored data enter by user
        }
        //if user choice 5 then program is return print quit.
        if (choiceInput >= 5) {
            System.out.println("quit");
            return;
        }
        if (choiceInput == 2 || chickenArrayList.get(whichChicken - 1).isAlive()) {  // This condition will allow only operation on live chicken
            if (choiceInput == 0) { // Allow user to update chicken name if condition true
                System.out.print("Name: ");
                String name = scanner.next();
                chickenArrayList.get(whichChicken - 1).setName(name);
            } else if (choiceInput == 1) {  // Allow user to feed amount of seed in kg to a chicken if condition true
                System.out.print("Feed amount: ");
                double feedValue = scanner.nextDouble();
                chickenArrayList.get(whichChicken - 1).setSeeds(feedValue + chickenArrayList.get(whichChicken - 1).getSeeds());
                if (chickenArrayList.get(whichChicken - 1).getSeeds() > 2) {  // This condition check seed size entered by user if the size is greater than 2 than chicken will be dead
                    chickenArrayList.get(whichChicken - 1).setAlive(false);

                }
            } else if (choiceInput == 2) { // This condition is checking if user want to play two chicken together
                System.out.println("Which two chicken you want to play:");
                System.out.print("Enter first chicken number:");
                int chicken1 = scanner.nextInt();
                System.out.print("Enter second chicken number:");
                int chicken2 = scanner.nextInt();

                if (chickenArrayList.get(chicken1 - 1).isAlive() && chickenArrayList.get(chicken2 - 1).isAlive()) {  //This condition is checking is alive or dead if alive then set happy both chicken
                    chickenArrayList.get(chicken1 - 1).setHappy(true);
                    chickenArrayList.get(chicken2 - 1).setHappy(true);
                } else {
                    System.out.println("Ouch!"); // If chicken dead then print this message
                }
            } else if (choiceInput == 3) {   // When chicken hit then heart goes down
                chickenArrayList.get(whichChicken - 1).setHappy(false);
                chickenArrayList.get(whichChicken - 1).setHeart(chickenArrayList.get(whichChicken - 1).getHeart() - 1);
                if (chickenArrayList.get(whichChicken - 1).getHeart() == 0) { // Chicken will be dead if hart is zero
                    chickenArrayList.get(whichChicken - 1).setAlive(false);
                }
            } else if (choiceInput == 4) { // This condition is checking if user want eggs from the chicken
                double value = chickenArrayList.get(whichChicken - 1).getSeeds();
                chickenArrayList.get(whichChicken - 1).setSeeds(Double.parseDouble(String.format("%.2f", value % 0.25)));
                value = (int) value / 0.25;
                if (chickenArrayList.get(whichChicken - 1).isHappy()) { // If chicken happy then gives double eggs or as per seeds value
                    System.out.println("You got " + value * 2 + " eggs.");
                } else {
                    System.out.println("You got " + (int) value + " eggs."); // Chicken gives eggs based on seeds value
                }
                chickenArrayList.get(whichChicken - 1).setHappy(false);
            }
        } else {
            System.out.println("Ouch!");
        }
    }
}
