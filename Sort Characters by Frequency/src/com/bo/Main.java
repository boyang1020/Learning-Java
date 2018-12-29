package com.bo;

import java.util.ArrayList;
import java.util.HashMap;

/*

Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.



Example:

"tree" -> "eert" / "eetr"

"cccaaa" -> "cccaaa" / "aaaccc"
 */
public class Main {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        HashMap<Integer, ArrayList<Character>> map2 = new HashMap<>();
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (!map2.containsKey(count)) {
                map2.put(count, new ArrayList<Character>());
            }
            map2.get(count).add(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (map2.containsKey(i)) {
                for (Character c : map2.get(i)) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
