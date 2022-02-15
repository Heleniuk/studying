package searchinsertposition;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertPositionSearcherTest {
    private InsertPositionSearcher subject = new InsertPositionSearcher();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void searchInsert_whenNumsLengthIsLessThanMin() {
        int target = 0;
        int[] nums = {};

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'nums' array length must be between 1 and 10000");
        subject.searchInsert(nums, target);
    }

    @Test
    public void searchInsert_whenNumsLengthIsMoreThanMax() {
        int target = 0;
        int[] nums = new int[10001];

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'nums' array length must be between 1 and 10000");
        subject.searchInsert(nums, target);
    }

    @Test
    public void searchInsert_whenTargetIsMoreThanMax() {
        int target = 10001;
        int[] nums = new int[1];

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'target' must be between -10000 and 10000");
        subject.searchInsert(nums, target);
    }

    @Test
    public void searchInsert_whenTargetIsLessThanMin() {
        int target = -10001;
        int[] nums = new int[1];

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'target' must be between -10000 and 10000");
        subject.searchInsert(nums, target);
    }

    @Test
    public void searchInsert_1() {
        int[] nums = {1,3,5,6};
        int target = 5;
        int expected = 2;

        int actual = subject.searchInsert(nums, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void searchInsert_2() {
        int[] nums = {1,3,5,6};
        int target = 2;
        int expected = 1;

        int actual = subject.searchInsert(nums, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void searchInsert_3() {
        int[] nums = {1,3,5,6};
        int target = 7;
        int expected = 4;

        int actual = subject.searchInsert(nums, target);

        assertThat(actual).isEqualTo(expected);
    }
}