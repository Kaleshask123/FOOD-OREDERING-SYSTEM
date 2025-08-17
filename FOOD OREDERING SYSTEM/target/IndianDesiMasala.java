import java.util.Scanner;

public class IndianDesiMasala {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepOrdering = true;

        printWelcomeMessage();

        while (keepOrdering) {
            // Menu Items
            String[] bases = {"Steamed Rice", "Jeera Rice", "Veg Pulao", "Butter Naan", "Tandoori Roti"};
            double[] basePrices = {40.0, 50.0, 70.0, 30.0, 25.0};

            String[] proteins = {"Paneer Butter Masala", "Chicken Curry", "Dal Tadka", "Mutton Rogan Josh", "Fish Curry"};
            double[] proteinPrices = {120.0, 150.0, 90.0, 180.0, 200.0};

            String[] sides = {"Raita", "Papad", "Mixed Veg Sabzi", "Aloo Gobi", "Kachumber Salad"};
            double[] sidePrices = {30.0, 20.0, 60.0, 50.0, 40.0};

            String[] drinks = {"Masala Chai", "Sweet Lassi", "Buttermilk", "Cold Drink", "Mango Lassi"};
            double[] drinkPrices = {20.0, 40.0, 30.0, 25.0, 50.0};

            String[] desserts = {"Gulab Jamun", "Rasgulla", "Jalebi", "Kheer"};
            double[] dessertPrices = {60.0, 55.0, 70.0, 65.0};

            // Choices
            int baseChoice = getChoice(sc, "Choose your Base", bases, basePrices);
            int proteinChoice = getChoice(sc, "Choose your Protein", proteins, proteinPrices);
            int sideChoice = getChoice(sc, "Choose your Side", sides, sidePrices);
            int drinkChoice = getChoice(sc, "Choose your Drink", drinks, drinkPrices);
            int dessertChoice = getChoice(sc, "Choose your Dessert", desserts, dessertPrices);

            // Receipt
            printReceipt(
                new String[]{
                    bases[baseChoice], proteins[proteinChoice], sides[sideChoice], drinks[drinkChoice], desserts[dessertChoice]
                },
                new double[]{
                    basePrices[baseChoice], proteinPrices[proteinChoice], sidePrices[sideChoice], drinkPrices[drinkChoice], dessertPrices[dessertChoice]
                }
            );

            // Repeat?
            System.out.print("\nWould you like to order another meal? (yes/no): ");
            String again = sc.next().trim().toLowerCase();
            keepOrdering = again.equals("yes");
            System.out.println();
        }

        printThankYou();
        sc.close();
    }

    public static int getChoice(Scanner sc, String title, String[] items, double[] prices) {
        System.out.println("\n--- " + title + " ---");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-25s (%.2f)\n", i + 1, items[i], prices[i]);
        }
        System.out.print("Enter your choice: ");

        int choice;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= items.length) break;
            } else {
                sc.next(); // skip invalid input
            }
            System.out.print("Invalid input. Please enter a number from the list: ");
        }

        System.out.println("Selected: " + items[choice - 1]);
        return choice - 1;
    }

    public static void printReceipt(String[] items, double[] prices) {
        System.out.println("\n=========== Your Order Receipt ===========");
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            System.out.printf("- %-25s (%.2f)\n", items[i], prices[i]);
            total += prices[i];
        }
        System.out.println("------------------------------------------");
        System.out.printf("Total Amount: %.2f\n", total);
        System.out.println("==========================================\n");
    }

    public static void printWelcomeMessage() {
        System.out.println("==============================================");
        System.out.println("       Welcome to Indian Desi Masala Spices");
        System.out.println("       Flavours of India, Served with Love!");
        System.out.println("==============================================\n");
    }

    public static void printThankYou() {
        System.out.println("Thank you for dining with Indian Desi Masala Spices!");
        System.out.println("May your soul be as full as your stomach!");
        System.out.println("Visit again — your table will always be ready!\n");
    }
}
