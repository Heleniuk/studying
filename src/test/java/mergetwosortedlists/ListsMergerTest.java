package mergetwosortedlists;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ListsMergerTest {
    private ListsMerger subject = new ListsMerger();

    @Test
    public void mergeTwoLists() {
        ListNode first = new ListNode(0);
        first.next = new ListNode(1);
        first.next = new ListNode(2);
        first.next = new ListNode(3);
        ListNode second = new ListNode(1);
        second.next = new ListNode(2);

        ListNode current = subject.mergeTwoLists(first, second);

        assertThat(current.val).isEqualTo(0);
        current = current.next;
        assertThat(current.val).isEqualTo(1);
        current = current.next;
        assertThat(current.val).isEqualTo(2);
        current = current.next;
        assertThat(current.val).isEqualTo(3);
    }

    @Test
    public void mergeTwoLists_whenBothAreNull_returnsNull() {
        ListNode actual = subject.mergeTwoLists(null, null);

        assertThat(actual).isNull();
    }

    @Test
    public void mergeTwoLists_whenFirstIsNull_returnsSecond() {
        ListNode actual = subject.mergeTwoLists(null, new ListNode(0));

        assertThat(actual.val).isEqualTo(0);
    }

    @Test
    public void mergeTwoLists_whenSecondIsNull_returnsFirst() {
        ListNode actual = subject.mergeTwoLists(new ListNode(0), null);

        assertThat(actual.val).isEqualTo(0);
    }
}