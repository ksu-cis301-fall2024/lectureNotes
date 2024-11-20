package finalExamMaterial.week15_Dec3_tues;

public class Termination {
    //@ requires y >= 0;
    //@ ensures \result == x*y;
    public static int mult(int x, int y) {
        int sum = 0;
        int count = 0;

        //measure of work?
        //initially? y
        //after 1 iteration? y-1

        //@ loop_invariant sum == x*count;
        while (count < y) {

            sum = sum + x;
            count = count + 1;

            //measure of work: y-count

            //measure should decrease with each iteration
            //it does! count gets bigger with each iteration
            //so y-count gets smaller

            //when I have no work left,
            //y - count = 0
            //y = count

            // then my loop should be done
            //it will! when y = count, the loop condition
            //will be false
        }

        return sum;
    }

    //@requires y >= 0;
    //@ensures \result == x*y;
    public static int multRec(int x, int y) {
        //what happens here if we don't enforce our precondition?

        /*
            How to show termination with recursive method?

            Base case: we must show that multRec(x, 0) terminates
                because 0 is the smallest allowable value of y.
                Our if condition is true when y is 0, and we
                immediately return. Thus multRec(x, 0) terminates.

            Inductive step: we assume the inductive hypothesis --
                that is, assume multRec(x, k) where k is some
                fixed nonnegative integer. We must show that
                multRec(x, k+1) terminates. k+1 is at least 1,
                so we would go into the else and make
                the recursive call multRec(x, k). By our
                inductive hypothesis, multRec(x,k) terminates
                and so we know we will return from the else.
        */

        if (y == 0) {
            return 0;
        }
        else {
            return x + multRec(x, y-1);
        }
    }

    //@requires n > 0;
    //@ensures \result == 1;
    public static int collatz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("parameter should be positive");
        }

        //cur = 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16
        //8->4->2->1

        int cur = n;
        while (cur > 1) {
            if (cur % 2 == 0) {
                cur = cur / 2;
            }
            else {
                cur = 3 * cur + 1;
            }
        }

        return cur;
    }
}