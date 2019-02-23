package com.bo;
/*
Given an unsorted array that may contain duplicates. Also given a number k which is smaller
than size of array. Write a function that returns true if array contains duplicates within k distance.
Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {



    /**********************************************************/

    static boolean checkDuplicates(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if (i >= k)
                set.remove(arr[i - k]);
        }
        return false;


    }
    /*********************************************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = checkDuplicates(_arr, _k);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
