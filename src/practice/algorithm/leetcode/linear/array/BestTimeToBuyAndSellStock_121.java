package practice.algorithm.leetcode.linear.array;

public class BestTimeToBuyAndSellStock_121 {
  public int maxProfit(int[] prices) {
    // 고점과 저점 설정
    int maxProfit = 0, minProfit = prices[0];

    // 값 계산
    for (int price: prices) {
      // 저점 계산
      minProfit = Math.min(minProfit, price);
      // 현재 값과 저점의 차이가 최대 이익인 경우 조회
      maxProfit = Math.max(maxProfit, price - minProfit);
    }

    return maxProfit;
  }
}
