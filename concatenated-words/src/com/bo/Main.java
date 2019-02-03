package com.bo;

/*
Given a list of words (without duplicates), please write a program that returns all
concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of
 at least two shorter words in the given array.

input
a list of words

output
list of words that meet the requirement


example
["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

example output
["catsdogcats","dogcatsdog","ratcatdogcat"]
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {



    static List<String> findAllConcatenated(String[] words) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int max = 0;
        Set<String> set = new HashSet<>();
        for(String word: words) {
            int len = word.length();
            if(len <= min) {
                secondMin = min;
                min = len;
            } else if(len < secondMin) {
                secondMin = len;
            }
            max = Math.max(max, len);
            set.add(word);
        }
        List<String> res = new ArrayList<>();
        int minLen = min + min;
        for(String w: words) {
            int len = w.length();
            if(len < minLen) continue;
            if(test(w, 0, set, min, max, 0)) {
                res.add(w);
            }
        }

        return res;
    }

    public static boolean test(String w, int start, Set<String> words, int min, int max, int cnt) {
        if(start == w.length()) {
            if(cnt > 1) return true;
            return false;
        }

        for(int i = min; i < max; i++) {
            if(start + i > w.length()) break;
            String tmp = w.substring(start, start + i);
            if(words.contains(tmp)) {
                if(test(w, start + i, words, min, max, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    /*******************************************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> res;

        int _words_size = 0;
        _words_size = Integer.parseInt(in.nextLine().trim());
        String[] _words = new String[_words_size];
        String _words_item;
        for(int _words_i = 0; _words_i < _words_size; _words_i++) {
            try {
                _words_item = in.nextLine();
            } catch (Exception e) {
                _words_item = null;
            }
            _words[_words_i] = _words_item;
        }

        res = findAllConcatenated(_words);
        for(int res_i=0; res_i < res.size(); res_i++) {
            System.out.println(String.valueOf(res.get(res_i)));
        }

    }
}
