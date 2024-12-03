package finalExamMaterial.week15_Dec3_tues;

public class JMLExample {
    /*@
        requires y >= 0;
        ensures \result == x*y;
    */
    public static int mult(int x, int y) {
        //what should we do here?

        int sum = 0;
        int count = 0;

        while (count < y) {
            sum = sum + x;
            count = count + 1;
        }

        //what should we do here?

        return sum;
    }

    /*@
        requires nums != null;
        ensures (\forall int k; 0 <= k && k < nums.length; nums[k] == \old(nums[k]) * 2);
    */
    public static void doubleEach(int[] nums) {
        //what should we do here?

        int[] oldElem = new int[nums.length];
        System.arraycopy(nums, 0, oldElem, 0, nums.length);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }

        //what should we do here?
    }

    /*@
        requires orig != null;
        ensures orig.length == \result.length;
        ensures ((\forall int k; k >= 0 && k < orig.length; \result[k] == orig[k].length()));
     */
    public static int[] getStringLengths(String[] orig) {
        //what should we do here?

        if (orig == null) {
            throw new IllegalArgumentException("precondition violated: array shouldn't be null");
        }

        int[] resultArray = new int[orig.length];
        for (int i = 0; i < orig.length; i++) {
            resultArray[i] = orig[i].length();
        }

        //what should we do here?

        return resultArray;
    }
}
