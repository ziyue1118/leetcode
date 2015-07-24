public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return maxProfit;
        }
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        
        for (int j = 0; j < diff.length; j++) {
            if (diff[j] > 0) {
                maxProfit += diff[j];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bns = new BestTimeToBuyAndSellStock();
        // The max profit should be 82
        int[] prices = {10, 20, 40, 60, 45, 18, 50, 28};
        System.out.println(bns.maxProfit(prices));
    }
}