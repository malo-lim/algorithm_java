package practice.algorithm.leetcode.string;

public class ReverseString_344 {
  public void reverseString(char[] s) {
    int start = 0;
    int end = s.length - 1;
    char temp;

    while (start < end) {
      temp = s[start];
      s[start] = s[end];
      s[end] = temp;
      start++;
      end--;
    }
  }
}
