package com.bo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*
    Given two arrays, write a function to compute their intersection.

Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2]
    **********************************************************/
    static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        while(p1< nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
                p2++;
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        while(i< list.size()){
            res[i] = list.get(i);
            i++;
        }
        return res;
    }
    /***********************************************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _nums1_size = 0;
        _nums1_size = Integer.parseInt(in.nextLine().trim());
        int[] _nums1 = new int[_nums1_size];
        int _nums1_item;
        for(int _nums1_i = 0; _nums1_i < _nums1_size; _nums1_i++) {
            _nums1_item = Integer.parseInt(in.nextLine().trim());
            _nums1[_nums1_i] = _nums1_item;
        }

        int _nums2_size = 0;
        _nums2_size = Integer.parseInt(in.nextLine().trim());
        int[] _nums2 = new int[_nums2_size];
        int _nums2_item;
        for(int _nums2_i = 0; _nums2_i < _nums2_size; _nums2_i++) {
            _nums2_item = Integer.parseInt(in.nextLine().trim());
            _nums2[_nums2_i] = _nums2_item;
        }

        res = intersect(_nums1, _nums2);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

