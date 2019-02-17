package com.bo;

class Solution {
    public String minWindow(String s, String t) {
        int[] pattern = new int[256];
        int[] text = new int[256];
        for(int i = 0; i < t.length(); i ++) {
            pattern[t.charAt(i)] ++;
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLen = s.length() + 1;
        int count = t.length();
        boolean isIncluded = false;
        text[s.charAt(0)] ++;
        if(pattern[s.charAt(0)] >= 1) count --;
        while(true) {
            if(count == 0) {
                isIncluded = true;
                while(text[s.charAt(start)] > pattern[s.charAt(start)]) {
                    text[s.charAt(start ++)] --;
                }
                if(minLen > end - start + 1) {
                    minStart = start;
                    minEnd = end;
                    minLen = end - start + 1;
                }
            }
            if(end < s.length() - 1) {
                text[s.charAt(++end)] ++;
                if(pattern[s.charAt(end)] >= text[s.charAt(end)]) count --;
            }
            else break;
        }
        if(isIncluded) {
            return s.substring(minStart, minEnd + 1);
        }
        else return "";
    }
}