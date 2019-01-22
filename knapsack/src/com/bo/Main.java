package com.bo;

//Given a set of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.





import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public ArrayList<ArrayList<Integer>> knapsack(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        knapsack(candidates, 0, target, results, cur);
        return results;
    }
    public void knapsack(int[] candidates, int index, int target,
                         ArrayList<ArrayList<Integer>> results,
                         ArrayList<Integer> cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            knapsack(candidates, i, target-candidates[i], results, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
