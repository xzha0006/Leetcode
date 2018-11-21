class Solution:
    def solveNQueens(self, n):
        """
        backtracking recurisive solution
        :type n: int
        :rtype: List[List[str]]
        """
        #use a 1-D array to store positions of each queen in each line. (It is impossible to have two queens in one line)
        #chess = [0] * n 
        chess, xyAdd, xyMinus, solution = [], [], [], []
        def backtrack(x):
            if x == n:
                solution.append(['.' * e + 'Q' +'.' * (n-e-1) for e in chess])
                return
            for y in range(n):
                #check the Queen on kth line safe or not  
                if y not in chess and x+y not in xyAdd and x-y not in xyMinus:
                    chess.append(y)
                    xyAdd.append(x+y)
                    xyMinus.append(x-y)
                    backtrack(x+1)
                    chess.pop()
                    xyAdd.pop()
                    xyMinus.pop()             
        backtrack(0)
        return solution
