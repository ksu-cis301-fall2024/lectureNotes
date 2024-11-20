package finalExamMaterial.week15_Dec3_tues;

public class JMLExample {
    //@ requires x >= 0;
    //@ ensures \result == x+1;
    //@ ensures \result >= 1;
    public static int plusOne(int x) {
        //what should we do here?

        //precondition is not met
        if (x < 0) {
            throw new IllegalArgumentException("precondition failed");
        }

        int ans = x + 1;

        //what should we do here?

        assert ans == x+1;
        assert ans >= 1;

        return ans;
    }

    //@ requires nums != null;
    //@ ensures (\forall int k; 0 <= k && k < nums.length; nums[k] == \old(nums[k]) * 2);
    public static void doubleEach(int[] nums) {
        //what should we do here?

        if (nums == null) {
            throw new IllegalArgumentException("array should not be null");
        }

        int[] oldElem = new int[nums.length];
        System.arraycopy(nums, 0, oldElem, 0, nums.length);

        //how will we know if postcondition is satisfied?

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }

        //what should we do here?
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] == 2*oldElem[i];
        }
    }

    //what should our function contract be?

    /*@
        requires y >= 0;
        ensures \result == x*y;
     */
    public static int mult(int x, int y) {
        //what should we do here?

        if (y < 0) {
            throw new IllegalArgumentException("precondition failed");
        }

        int product = 0;
        for (int i = 0; i < y; i++) {
            product += x;
        }

        //what should we do here?

        assert product == x * y;

        return product;
    }
}
