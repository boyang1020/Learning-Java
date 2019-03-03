import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {



    /*********************************************************/
    static int[] sortFrequency(int[] arr) {
        List<Integer>[] bucket = new List[arr.length + 1];

        //For storing the mapping of elements to frequency.
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        for(int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int position = 0;

        for(int i = bucket.length-1; i >= 0; i--) {
            if(bucket[i] != null) {
                for(int item : bucket[i]) {
                    int frequency = i;
                    while(frequency != 0) {
                        arr[position++] = item;
                        --frequency;
                    }
                }
            }
        }

        return arr;
    }
    /*********************************************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = sortFrequency(_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
