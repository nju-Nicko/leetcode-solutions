package com.huawei.nlz.leetcode.solution;//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

public class RemoveNthFromEnd {
    /**
     * 题19：删除链表的倒数第n个节点
     *
     * @param head 链表头
     * @param n    n
     * @return 删除后的链表头部
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        ListNode slow = head;
        ListNode fast = head;

        int counter = 0;

        while (fast != null && counter < n) {
            fast = fast.next;
            counter++;
        }

        /*
         * 三种场景：
         * 1. fast == null && counter < n，说明待返回的倒数第n个节点的n比链表总长度还要长，这种场景返回null。
         * 2. fast == null && counter == n，说明待返回的倒数第n个节点刚好是首节点，这种情况直接移动首节点指针为下一个并返回。
         * 3. fast != null && counter == n，正常场景，接下来让慢指针快指针一起行进。
         */

        if (fast == null && counter < n) {
            return null;
        }

        if (fast == null && counter == n) {
            ListNode oldHead = head;
            head = head.next;
            oldHead = null;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode old = slow.next;
        ListNode slowNextNext = slow.next.next;
        slow.next = slowNextNext;
        old = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
