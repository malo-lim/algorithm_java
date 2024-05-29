package practice.algorithm.leetcode.string;

public class LongestPalindromicSubstring_5 {
  int maxLength, left;

  private void extendPalindrome(String s, int j, int k) {

    // 투 포인터가 유효한 범위 내에 있고, 양쪽 끝 문자가 일치하는 팰린드롬의 경우 범위 확장
    // 위의 말은 즉 슬라이딩 윈도우 범위를 확장(앞은 빼주고, 뒤는 늘어나고)
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }

    // 기존 최대 길이보다 큰 경우 값 교체
    // 슬라이딩 윈도우로 하기 때문에 앞에걸 빼주는것.
    if (maxLength < k - j - 1) {
      left = j + 1;
      maxLength = k - j - 1;
    }
  }

  public String longestPalindrome(String s) {
    // 문자 길이 저장
    int len = s.length();

    // 길이가 1이면 바로 return
    if (s.length() < 2) {
      return s;
    }

    // 우측으로 한칸씩 이동하면서 투 포인터 조사(슬라이딩 윈도우)
    for (int i = 0; i < len - 1; i++) {
      extendPalindrome(s, i, i + 1); // 2 칸 짜리 투포인터
      extendPalindrome(s, i, i + 2); // 3 칸 짜리 투포인터
    }

    return s.substring(left, left + maxLength);
  }
}
