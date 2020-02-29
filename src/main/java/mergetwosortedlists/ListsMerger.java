package mergetwosortedlists;

public class ListsMerger {
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.val < second.val) {
            first.next = mergeTwoLists(first.next, second);
            return first;
        } else {
            second.next = mergeTwoLists(first, second.next);
            return second;
        }
    }
}
