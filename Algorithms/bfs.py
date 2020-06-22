tree = { 1:[2, 3], 2:[1, 4, 5], 3:[6, 1], 5:[2], 6:[3], 4:[2]}
q = []
visited = [False] * 10000
def bfs(u):
    q.append(u)
    while q:
        print("Visited ", q[0])
        u = q.pop(0)
        for i in tree[u]:
            if (visited[i]):
                continue
            visited[i] = True
            q.append(i)
#       space complex   time complex
#dfs    O(1)            O(n^2) - O(|V| + |E|)   
#bfs    O(n)            O(n^2) - O(|V| + |E|)

bfs(1)