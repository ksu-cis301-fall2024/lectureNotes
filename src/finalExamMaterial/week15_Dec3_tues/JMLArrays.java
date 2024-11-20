package finalExamMaterial.week15_Dec3_tues;

public class JMLArrays {
    /*@
        requires orig != null;
        ensures orig.length == \result.length;
        ensures ((\forall int k; k >= 0 && k < orig.length; \result[k] == orig[k].length()));
     */
    public static int[] getStringLengths(String[] orig) {
        if (orig == null) {
            throw new IllegalArgumentException("precondition violated: array shouldn't be null");
        }

        int[] resultArray = new int[orig.length];
        for (int i = 0; i < orig.length; i++) {
            resultArray[i] = orig[i].length();
        }

        assert resultArray.length == orig.length;

        for (int i = 0; i < orig.length; i++) {
            assert resultArray[i] == orig[i].length();
        }

        return resultArray;
    }
}
