package machine;

import java.util.Scanner;

public class CoffeeMachine {
    
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int money = 550;
    static int cups = 9;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
             System.out.println();
            switch (action) {
                case "buy":
                    buy(scanner);
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid action");
            }
            System.out.println();
        }
        
        

    }

    private static void buy(Scanner sc){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.next();
        int waterNeeded = 0, milkNeeded = 0, coffeeNeeded = 0, cost = 0;
        switch(choice){
            case "1":
                waterNeeded = 250;
                coffeeNeeded = 16;
                cost = 4;
                break;
            case "2":
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeNeeded = 20;
                cost = 7;
                break;
            case "3":
                waterNeeded = 200;
                milkNeeded = 100;
                coffeeNeeded = 12;
                cost = 6;
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid choice");
                return;
        }

        if (water < waterNeeded) {
        System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee < coffeeNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffee -= coffeeNeeded;
            cups--;
            money += cost;
        }
                

    }

    private static void fill(Scanner sc){
        System.out.println("Write how many ml of water you want to add:"); 
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:"); 
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:"); 
        coffee += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:"); 
        cups += sc.nextInt();
    }

    private static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void printState(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    private static void calculate(Scanner scanner){
        
    }
}
