package com.bo;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);

        int previousResult = result;

        result = result - 1;

        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;

        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        previousResult = result;

        result = result /5;
        System.out.println(previousResult + " / 5 = " + result);

        previousResult = result;
        result = result % 3;

        System.out.println(previousResult + " % 3 = " + result);

        previousResult = result;
        result++;

        System.out.println("result now = " + result);

        result += 2;

        System.out.println("result now = " + result);


        int topScore = 100;

        if ( topScore == 100)
            System.out.println("You got the high score");

        int secondScore = 80;

        if ( topScore > 90 || secondScore <= 90)
            System.out.println("one of these tests is true");

        if ( topScore < 90 || secondScore <= 70)
            System.out.println("one of these tests is true");

        int newValue = 50;

        if (newValue == 50)
            System.out.println("This is true");

        boolean isCar = false;
        if(isCar)
            System.out.println("This is not suppose to happen");

        isCar = true;

        boolean wasCar = isCar ? true : false;
            if(wasCar)
                System.out.println("wasCar is true");


    }
}
