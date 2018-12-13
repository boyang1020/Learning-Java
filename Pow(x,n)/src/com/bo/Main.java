package com.bo;


//Problem:
//
//Implement pow(x, n).
//

public class Main {
    public double myPow(double x, int n){
        if(n==0)
            return 1;

        if(n<0){
            return 1/helper(x, -n);
        }

        double v = helper(x, n/2);

        if(n%2==0){
            return v*v;
        }else{
            return v*v*x;
        }
    }
}
