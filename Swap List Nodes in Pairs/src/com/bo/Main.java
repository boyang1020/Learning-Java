package com.bo;

pimport java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(pre.next != null && pre.next.next != null){
            ListNode p1 = pre;
            pre= pre.next;
            p1.next = pre.next;

            ListNode p2 = pre.next.next;
            pre.next.next = pre;
            pre.next = p2;
        }
        return dummy.next;
    }


    /*

    solution two

     public ListNode swapPairs(ListNode head) {
    if(head==null || head.next==null)
        return head;

    //a fake head
    ListNode h = new ListNode(0);
    h.next = head;

    ListNode p1 = head;
    ListNode p2 = head.next;

    ListNode pre = h;
    while(p1!=null && p2!=null){
        pre.next = p2;

        ListNode t = p2.next;
        p2.next = p1;
        pre = p1;
        p1.next = t;

        p1 = p1.next;

        if(t!=null)
            p2 = t.next;
    }

    return h.next;
}
*/
    /******************************结束写代码******************************/


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

        ListNode head = createLinkedList(_nums);
        head = swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode createLinkedList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
}
