public class BuySellStock {

    public static int buyLowSellHigh(int[] price) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for (int j : price) {
            if (j < min) {
                min = j;
            } else if (j - min > profit) {
                profit = j - min;
            }
        }
        return profit;
    }

    public static int buyAnyDayAndSellAnyDay(int[] price) {
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i-1]) {
                profit += price[i] - price[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(buyLowSellHigh(new int[]{7,1,5,3,6,4}));
        System.out.println(buyAnyDayAndSellAnyDay(new int[]{7,1,5,3,6,4}));
    }
}
