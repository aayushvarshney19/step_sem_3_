public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int lowestPrice = prices[0];
        int maximumProfit = 0;
        for (int day = 1; day < prices.length; day++) {
            int currentProfit = prices[day] - lowestPrice;
            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
            if (prices[day] < lowestPrice) {
                lowestPrice = prices[day];
            }
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}