import java.util.Scanner;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Both sections must contain the same number of items.");
        }
        if (sectionA.length == 0) {
            System.out.println("Inventory arrays cannot be empty.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int index = 0; index < sectionA.length; index++) {
            totalA += sectionA[index];
            totalB += sectionB[index];

            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
            }
            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestIndex + 1);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of items: ");
            int itemCount = scanner.nextInt();
            int[] sectionA = new int[itemCount];
            int[] sectionB = new int[itemCount];

            System.out.println("Enter quantities for Section A:");
            for (int index = 0; index < itemCount; index++) {
                sectionA[index] = scanner.nextInt();
            }
            System.out.println("Enter quantities for Section B:");
            for (int index = 0; index < itemCount; index++) {
                sectionB[index] = scanner.nextInt();
            }
            analyzeInventory(sectionA, sectionB);
        }
    }
}