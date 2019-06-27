class Solution:
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        if not M:
            return 0
        n = len(M)
        id = [i for i in range(n)] #Initial id list. All nodes' parents are themselves.
        count = n        
        def find(node):
            while id[node] != node: #If node is not root node
                node = id[node]
            return node
        def union(node0, node1):
            res = 0
            if find(node0) != find(node1):
                id[find(node1)] = find(node0)
                res = -1
            return res
        for i in range(n):
            for j in range(i,n):
                if i != j and M[i][j]:
                    count += union(i, j)
        return count
