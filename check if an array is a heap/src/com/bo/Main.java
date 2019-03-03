import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {



    /**********************************************************/
    static boolean isMaxHeap(int[] arr) {
        int N = arr.length;
        for (int i = (N - 2) / 2; i > -1; --i) {
            int j = 2 * i + 1;
            if (j < N - 1 && arr[i] < arr[j+1]) j++;
            if (arr[i] < arr[j]) return false;
        }
        return true;

    }
    /***********************************************************/


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

        res = isMaxHeap(_arr);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
