class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode();
        ListNodeIterator iterator1 = new ListNodeIterator(l1);
        ListNodeIterator iterator2 = new ListNodeIterator(l2);

        int num1 = l1.val;
        int num2 = l2.val;
        int sum = num1 + num2;
        int temp = 0;
        if (sum >= 10) {
            sum-=10;
            temp = 1;
        }
        resultList.val = sum;
        ListNode first = resultList;
        while (iterator1.hasNext() || iterator2.hasNext()) {
            num1 = iterator1.next();
            num2 = iterator2.next();
            sum = num1 + num2 + temp;
            if (sum >= 10) {
                sum-=10;
                temp = 1;
            } else {
                temp = 0;
            }
            ListNode current = new ListNode(sum);
            resultList.next = current;
            resultList = current;
        }
        if (temp != 0) {
            ListNode current = new ListNode(temp);
            resultList.next = current;
        }
        return first;
    }

    class ListNodeIterator {
        private ListNode current;

        public ListNodeIterator(ListNode current) {
            this.current = current;
        }

        public int next() {
            if (current.next != null) {
                current = current.next;
                return current.val;
            }
            return 0;
        }

        public boolean hasNext() {
            return current.next != null ? true : false;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        listNode1 = new ListNode(0);
        listNode2 = new ListNode(0);



//

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(listNode1, listNode2);
        while (true) {
            System.out.println(result.val);
            if (result.next == null) {
                break;
            }
            result = result.next;
        }
    }
}

//Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.
//        Example 2:
//
//        Input: l1 = [0], l2 = [0]
//        Output: [0]
//        Example 3:
//
//        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        Output: [8,9,9,9,0,0,0,1]