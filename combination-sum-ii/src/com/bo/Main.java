package com.bo;
/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.

Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The solution set must not contain duplicate combinations.

 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*******************************************************/

    static List<List<Integer>> subsetSums(int[] elements, int K) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(elements);
        helper(res, curr, 0, K, elements);
        return res;
    }
    static void helper(List<List<Integer>> res, List<Integer> curr, int start, int K, int[]
            elements){
        if(K == 0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if(K < 0){
            return;
        }
        int prev = -1;
        for (int i = start; i < elements.length; i++){
            if(prev!= elements[i]){
                curr.add(elements[i]);
                helper(res, curr, i+1, K-elements[i], elements);
                curr.remove(curr.size()-1);
                prev = elements[i];
            }
        }
    }

    /****************************TEST*****************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<List<Integer>> res;

        int _elements_size = 0;
        _elements_size = Integer.parseInt(in.nextLine().trim());
        int[] _elements = new int[_elements_size];
        int _elements_item;
        for(int _elements_i = 0; _elements_i < _elements_size; _elements_i++) {
            _elements_item = Integer.parseInt(in.nextLine().trim());
            _elements[_elements_i] = _elements_item;
        }

        int _K;
        _K = Integer.parseInt(in.nextLine().trim());

        res = subsetSums(_elements, _K);

        for(int i = 0; i < res.size(); i ++) {
            for(int j = 0; j < res.get(i).size(); j ++) {
                System.out.println(String.valueOf(res.get(i).get(j)) + " ");
            }
        }
    }
}