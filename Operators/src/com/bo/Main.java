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


        double myFirstValue = 20d;
        double mySecondValue = 80d;
        double myTotal = myFirstValue + mySecondValue * 25;
        System.out.println("myTotal = " + myTotal);
        double theReminder = myTotal % 40;
        System.out.println("theReminder = " + theReminder);
        if(theReminder <= 20)
            System.out.println("Total was over the limit");

    }
}


/*
Summary of Operators
The following quick reference summarizes the operators supported by the Java programming language.

Simple Assignment Operator
=       Simple assignment operator
Arithmetic Operators
+       Additive operator (also used
        for String concatenation)
-       Subtraction operator
*       Multiplication operator
/       Division operator
%       Remainder operator
Unary Operators
+       Unary plus operator; indicates
        positive value (numbers are
        positive without this, however)
-       Unary minus operator; negates
        an expression
++      Increment operator; increments
        a value by 1
--      Decrement operator; decrements
        a value by 1
!       Logical complement operator;
        inverts the value of a boolean
Equality and Relational Operators
==      Equal to
!=      Not equal to
>       Greater than
>=      Greater than or equal to
<       Less than
<=      Less than or equal to
Conditional Operators
&&      Conditional-AND
||      Conditional-OR
?:      Ternary (shorthand for
        if-then-else statement)
Type Comparison Operator
instanceof      Compares an object to
                a specified type
Bitwise and Bit Shift Operators
~       Unary bitwise complement
<<      Signed left shift
>>      Signed right shift
>>>     Unsigned right shift
&       Bitwise AND
^       Bitwise exclusive OR
|       Bitwise inclusive OR

 */