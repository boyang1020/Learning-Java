package com.bo;

/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


 */

public class Main {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }
}


/*

public int lengthOfLongestSubstring(String s) {
    if(s==null||s.length()==0){
        return 0;
    }
    int result = 0;
    int k=0;
    HashSet<Character> set = new HashSet<Character>();
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(!set.contains(c)){
            set.add(c);
            result = Math.max(result, set.size());
        }else{
            while(k<i){
                if(s.charAt(k)==c){
                    k++;
                    break;
                }else{
                    set.remove(s.charAt(k));
                    k++;
                }
            }
        }
    }

    return result;
}

 */