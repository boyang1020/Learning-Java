package com.bo;


/*
Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T.

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Notes:​

- If there is no such window in S that covers all characters in T, return the empty string "".

- You are guaranteed that there will always be only one unique minimum window in S, if exist.
*/
public class Main {
    public static String minWindow(String s, String t) {
        int[] expected = new int[256];
        int[] visited = new int[256];
        for (int i = 0; i < t.length(); i++) {
            expected[(int)t.charAt(i)]++;
        }
        int end = 0, minLength = Integer.MAX_VALUE, count = 0;
        String result = "";
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length() && count != t.length()) {
                visited[s.charAt(end)]++;
                if (visited[s.charAt(end)] <= expected[s.charAt(end)]) {
                    count++;
                }
                end++;
            }
            if (count == t.length()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    result = s.substring(start, end);
                }
            }
            if (expected[s.charAt(start)] > 0) {
                visited[s.charAt(start)]--;
                if (visited[s.charAt(start)] < expected[s.charAt(start)]) {
                    count--;
                }
            }
        }
        return result;
    }

}
