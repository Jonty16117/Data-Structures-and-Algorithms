#Given a string of brackets (, ), {, }, [, ], find the position in the string where the orders of brackets breaks.

#I/p: ())

#O/p: 3

 

#I/p: (){[]}(

#O/p: 8

dic = {'(':')', '[':']', '{':'}'}
closing_brackets = [')', ']', '}']

#take input from user
s = raw_input()

class Stack:
    def __init__(self):
        self._stack = []
        self._size = 0

    def push(self, x):
        self._stack.append(x)
        self._size += 1

    def pop(self):
        self._stack.pop()
        self._size -= 1

    def top(self):
        if self._size == 0:
            return -1
        else:
            return self._stack[self._size-1]

def solve(string):
    ls = list(string)
    size = len(ls)

    #if the string contains only one bracket
    if size == 1:
        return 1

    #if the string starts with the closing bracket
    if ls[0] in closing_brackets:
        return 1

    #else use stack method
    stk = Stack()
    stk.push(ls[0])
    for i in range(1, size):
        if ls[i] == dic.get(stk.top()):
            stk.pop()
            ls[i] = 0
            m = i
            while (m >= 0):
                if ls[m] != 0:
                    ls[m] = 0
                    break
                m -= 1 
        
        #return if we see any closing bracket
        elif ls[i] in closing_brackets:
            return i + 1
        
        #else push the next closing bracket in stack
        else:
            stk.push(ls[i])
    
    #check if the string is symmetric
    ans = True
    for i in ls:
        if i != 0:
            ans = False
    if ans:
        return -1

    #filter out the wrong bracket position from all opening brackets
    #if the symmetry starts from 0 index
    if ls[0] == 0:
        import math
        j = 0
        while(j < size):
            if ls[j] != 0:
                break
            j += 1
        return j + int(math.ceil(((size - 1) - j)//2)) + 1 
    
    #if there are some unmatched brackets at the front
    else:
        j = ls.index(0)
        while(j < size):
            if ls[j] != 0:
                return j + 1
            j += 1

ans = solve(s)
print(ans)
