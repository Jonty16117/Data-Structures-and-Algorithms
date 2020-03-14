grid = [
	['S', 0, 0, 0, 0],
	[0, 1, 'D', 1, 0],
	[0, 1, 0, 0, 1],
	[0, 0, 1, 0, 1],
	[0, 0, 0, 0, 0]
	]
cr = 0
cc = 0
rq = []
cq = []
visited = [[False] * len(grid[0]) for _ in range(len(grid))]
nodes_in_curr_layer = 1
nodes_in_next_layer = 0

def get_next_layer_of_nodes(curr_layer_row, curr_layer_col):
	rv = [-1, +1, 0, 0]
	cv = [0, 0, -1, +1]

	global nodes_in_next_layer	

	for i in range(4):
		tr = curr_layer_row + rv[i]
		tc = curr_layer_col + cv[i]

		#check for bound in grid
		if tr < 0 or tc < 0: continue
		if tr >= len(grid) or tc >= len(grid[0]): continue

		#check if the node is alread visited
		if visited[tr][tc]: continue

		#check for obstacles
		if grid[tr][tc] == 1: continue

		#else visit the current node
		visited[rq[0]][cq[0]] = True
		
		#else add this node to the queue
		rq.append(tr)
		cq.append(tc)

		#increase the nodes in the next layer by 1
		nodes_in_next_layer += 1

def find_shortest_path(grid):
	global nodes_in_curr_layer
	global nodes_in_next_layer
	reached_destination = False
	rq.append(cr)
	cq.append(cc)
	
	move_count = 0

	while len(rq) != 0:
		#check if reached destination
		if grid[rq[0]][cq[0]] == "D":
			reached_destination = True
			break

		#add next layer to queue
		get_next_layer_of_nodes(rq[0], cq[0])
		
		#check if this layer is over. If yes, then increase move_count by 1
		nodes_in_curr_layer -= 1
		if nodes_in_curr_layer == 0:
			move_count += 1
			nodes_in_curr_layer = nodes_in_next_layer
			nodes_in_next_layer = 0

		#dequeue the current node
		rq.pop(0)
		cq.pop(0)

	if reached_destination:
		return move_count
	else:
		return -1


print("Grid: ")
for i in grid:
	print(i)
print("Least steps required to get to the target position: ")
print(find_shortest_path(grid))