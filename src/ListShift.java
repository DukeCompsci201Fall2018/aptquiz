
public class ListShift {
	public ListNode shift(ListNode start, int key) {
		ListNode less = null;
		ListNode lless = null;
		ListNode greater = null;
		ListNode lgreater = null;
		while (start != null) {
			if (start.info > key) {
				if (lgreater == null) {
					greater = new ListNode(start.info);
					lgreater = greater;
				}
				else {
					lgreater.next = new ListNode(start.info);
					lgreater = lgreater.next;
				}
			}
			else {
				if (lless == null) {
					less = new ListNode(start.info);
					lless = less;
				}
				else {
					lless.next = new ListNode(start.info);
					lless = lless.next;
				}
			}
			start = start.next;
		}
		if (greater == null)  return less;
		lgreater.next = less;
		return greater;
	}
}
