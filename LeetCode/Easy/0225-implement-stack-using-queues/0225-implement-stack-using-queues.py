class MyStack(object):

    def __init__(self):
        self.q = collections.deque()

    def push(self, x):
        self.q.append(x)
        
        for _ in range(len(self.q) - 1):
            self.q.append(self.q.popleft())

    def pop(self):
        return self.q.popleft()
        

    def top(self):
        return self.q[0]
        

    def empty(self):
        return len(self.q) == 0
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()