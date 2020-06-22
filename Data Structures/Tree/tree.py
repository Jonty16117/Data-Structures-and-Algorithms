n,i=map(int,input().split())
tree={}
p={}
depth = [0] * (n + 5)
sons = [0] * (n + 5)    
def insert(u,v):
    if (len(tree.get(u,[])) == 0):
        tree[u]=[v]
    else:
        tree[u].append(v)

    if (len(tree.get(v,[])) == 0):
        tree.update({v:[u]})
    else:
        tree[v].append(u)   

def dfs(u,parent):
    for i in tree[u]:
        if i == parent:
            continue
        depth[i] = depth[u] + 1
        dfs(i,u)
        sons[u] += sons[i] + 1
        

for j in range(n-1):
    u,v=map(int,input().split())
    insert(u,v)
dfs(1,0)
a = [depth[i] - sons[i] for i in range(1, n + 1)]
a.sort(reverse = True)
s = 0
for j in range(i):
    s += a[j]
print(s)
