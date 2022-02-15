package searchinsertposition;

public class InsertPositionSearcher {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10000;
    private static final int MIN_NUMBER = -10000;
    private static final int MAX_NUMBER = 10000;

    public int searchInsert(int[] nums, int target) {
        if (nums.length < MIN_LENGTH || nums.length > MAX_LENGTH) {
            String message = String.format("'nums' array length must be between %s and %s", MIN_LENGTH, MAX_LENGTH);
            throw new IllegalArgumentException(message);
        }

        if (target < MIN_NUMBER || target > MAX_NUMBER) {
            String message = String.format("'target' must be between %s and %s", MIN_NUMBER, MAX_NUMBER);
            throw new IllegalArgumentException(message);
        }

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int lowerBound, int upperBound, int target) {
        if (upperBound < lowerBound) {
            return lowerBound;
        }
        int middleIndex = lowerBound + (upperBound - lowerBound) / 2;
        int middle = nums[middleIndex];

        if (target == middle) {
            return middleIndex;
        }
        if (target < middle) {
            return binarySearch(nums, lowerBound, middleIndex - 1, target);
        } else {
            return binarySearch(nums, middleIndex + 1, upperBound, target);
        }
    }
}
