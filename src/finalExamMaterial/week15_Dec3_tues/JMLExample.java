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
        requires nums.length >= 2;
        ensures (nums[0] == \old(nums[nums.length-1]));
        ensures (nums[nums.length-1] == \old(nums[0]));
        ensures (\forall int k; 1 <= k && k < nums.length-1; nums[k] == \old(nums[k]));
    */
    public static void changeArray(int[] nums) {
        //what should we do here?

        int[] oldElem = new int[nums.length];
        System.arraycopy(nums, 0, oldElem, 0, nums.length);

        int temp = nums[0];
        nums[0] = nums[nums.length-1];
        nums[nums.length-1] = temp;

        //what should we do here?
    }
}
