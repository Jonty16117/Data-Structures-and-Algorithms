#matrix representation of graphs
# graph = [
# 		[0, 1, 0, 0, 1],
# 		[1, 0, 1, 1, 1],
# 		[0, 1, 0, 1, 1],
# 		[0, 1, 1, 0, 1],
# 		[1, 1, 0, 1, 0]
# 		]

#print(graph[0][1])

#adjacency list representation
# graph2 = [[1, 4], 
# 	[0, 4, 3, 2], 
# 	[1, 3], 
# 	[1, 2, 4], 
# 	[0, 1, 3]]
# if 4 in graph2[0]:
# 	print("Exists")
# else:
# 	print("not Exists")

#edge-list representation
graph = [[0, 1], [1, 0], [0, 4], [4, 1], [4, 3], [1, 3], [1, 2], [2, 3]]
graph.sort()
vertices = set()
for i in graph:
	vertices.add(i[0])
	vertices.add(i[1])
print(vertices)
vertices.remove(3)
print(vertices)