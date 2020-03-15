package removeduplicatesfromsortedarray;

public class DuplicatesRemover {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] !=  nums[i]) {
                index++;
                nums[index] = nums[i + 1];
            }
        }
        return index + 1;
    }
}
