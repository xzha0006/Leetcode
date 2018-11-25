# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        stack1 = []
        stack2 = []
        while l1:
            stack1.append(l1.val)
            l1 = l1.next
        while l2:
            stack2.append(l2.val)
            l2 = l2.next
            
        node = ListNode(0)
        sum = 0
        while stack1 or stack2:
            if stack1:
                sum += stack1.pop()
            if stack2:
                sum += stack2.pop()
            node.val = sum % 10
            head = ListNode(sum//10)
            head.next = node
            node = head
            sum = node.val
        return node if node.val != 0 else node.next
