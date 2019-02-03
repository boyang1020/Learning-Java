package com.bo;
/*
Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord,
such that:

1.Only one letter can be changed at a time.

2.Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

3.If there is no transformation path, output should be 0.



Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)){
                            return level + 1;

                        }
                        nextNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }




    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _beginWord;
        try {
            _beginWord = in.nextLine();
        } catch (Exception e) {
            _beginWord = null;
        }

        String _endWord;
        try {
            _endWord = in.nextLine();
        } catch (Exception e) {
            _endWord = null;
        }

        int _wordList_size = 0;
        _wordList_size = Integer.parseInt(in.nextLine().trim());
        List<String> _wordList = new ArrayList<>();
        String _wordList_item;
        for(int _wordList_i = 0; _wordList_i < _wordList_size; _wordList_i++) {
            try {
                _wordList_item = in.nextLine();
            } catch (Exception e) {
                _wordList_item = null;
            }
            _wordList.add(_wordList_item);
        }

        res = ladderLength(_beginWord, _endWord, _wordList);
        System.out.println(String.valueOf(res));

    }
}
