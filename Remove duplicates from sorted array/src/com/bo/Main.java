package com.bo;

public class Main {

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public class Main {
        static int removeDuplicates(int[] nums) {
            // Fill in your solution here.

            if (nums.length < 2) {
                return nums.length;
            }
            int j = 0;
            int i = 1;

            while (i< nums.length) {
                if(nums[i] == nums[j]) {
                    i++;
                }else {
                    j++;
                    nums[j] = nums[i];
                    i++;
                }
            }
            return j + 1;
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

            res = removeDuplicates(_nums);
            System.out.println(String.valueOf(res));

        }
    }

    }
}



/* // Create an array with all unique elements
public static int[] removeDuplicates(int[] A) {
	if (A.length < 2)
		return A;

	int j = 0;
	int i = 1;

	while (i < A.length) {
		if (A[i] == A[j]) {
			i++;
		} else {
			j++;
			A[j] = A[i];
			i++;
		}
	}

	int[] B = Arrays.copyOf(A, j + 1);

	return B;
}

public static void main(String[] args) {
	int[] arr = { 1, 2, 2, 3, 3 };
	arr = removeDuplicates(arr);
	System.out.println(arr.length);
}
In this method, a new array is created and returned.




 solution 3

If we only want to count the number of unique elements, the following method is good enough.

// Count the number of unique elements
public static int countUnique(int[] A) {
	int count = 0;
	for (int i = 0; i < A.length - 1; i++) {
		if (A[i] == A[i + 1]) {
			count++;
		}
	}
	return (A.length - count);
}

public static void main(String[] args) {
	int[] arr = { 1, 2, 2, 3, 3 };
	int size = countUnique(arr);
	System.out.println(size);
}
 */