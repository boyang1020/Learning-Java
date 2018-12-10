package com.bo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j) {
            int mid = (i + j)/2;
            if(target > nums[mid]){
                i = mid + 1;
            }else if(target < nums[mid]){
                j = mid - 1;
            }else return mid;
        }
        return i;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _nums_size = 0;
        _nums_size = Integer.parseInt(in.nextLine().trim());
        int[] _nums = new int[_nums_size];
        int _nums_item;
        for(int _nums_i = 0; _nums_i < _nums_size; _nums_i++) {
            _nums_item = Integer.parseInt(in.nextLine().trim());
            _nums[_nums_i] = _nums_item;
        }

        int _target;
        _target = Integer.parseInt(in.nextLine().trim());

        res = searchInsert(_nums, _target);
        System.out.println(String.valueOf(res));

    }
}



/*
*
* solution 2
* public int searchInsert(int[] nums, int target) {
    if(nums==null)
        return -1;
    if(target>nums[nums.length-1]){
        return nums.length;
    }

    int i=0;
    int j=nums.length;

    while(i<j){
        int m=(i+j)/2;
        if(target>nums[m]){
            i=m+1;
        }else{
            j=m;
        }
    }

    return j;
}
*
*
*
*
*
* */