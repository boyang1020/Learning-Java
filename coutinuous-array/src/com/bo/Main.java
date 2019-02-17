package com.bo;

import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] diff = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            diff[i] = diff[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            if(!map.containsKey(diff[i]))
                map.put(diff[i], i);
            else
                res = Math.max(res, i - map.get(diff[i]));
        }
        return res;
    }
}