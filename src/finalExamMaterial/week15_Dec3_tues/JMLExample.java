package finalExamMaterial.week15_Dec3_tues;

public class JMLExample {
    /*@
        requires x >= 0;
        ensures \result == x+1;
        ensures \result >= 1;
    */
    public static int plusOne(int x) {
        //what should we do here?

        int ans = x + 1;

        //what should we do here?

        return ans;
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
