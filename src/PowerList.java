public class PowerList {
        public ListNode create(int n){
                if (n == 1) return null;
                ListNode front = new ListNode(1,null);
                ListNode last = front;
                int pow = 2;
                while (pow < n){
                        last.next = new ListNode(pow,null);
                        last = last.next;
                        pow *= 2;
                }
                return front;
        }
}
