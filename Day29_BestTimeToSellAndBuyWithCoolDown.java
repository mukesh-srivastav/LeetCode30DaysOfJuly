/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class Day29_BestTimeToSellAndBuyWithCoolDown {
    public int maxProfit(int[] prices) {
        
        int endWithSell = 0;
        int endWithBuy = Integer.MIN_VALUE;;
        int prevBuy =0, prevSell = 0;
        
        for(int i =0;i<prices.length;i++){
            prevBuy = endWithBuy;
            endWithBuy = Math.max(endWithBuy,prevSell - prices[i]);
            prevSell = endWithSell;
            endWithSell = Math.max(endWithSell, prevBuy + prices[i]);
        }
        
        return endWithSell;
    }
}