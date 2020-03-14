s = "abazzzzasddskbkkkljfababababa"
def manachers(s):
	new = '#'.join('^{}$'.format(s))
	n = len(new)
	P = [0] * n
	c = r = 0
	
	for i in range(1, n-1):
		P[i] = (r > i) and min(r - i, P[c - (i - c)])

		while (i - 1 - P[i]) >= 0 and (i + 1 + P[i]) \
		< n and new[i - 1 - P[i]] == new[i + 1 + P[i]]:
			P[i] += 1

		if i + P[i] > r:
			c, r = i, i + P[i] 

	max_count = max(P)
	max_index = P.index(max_count)
	return (s[(max_index - max_count)/2:(max_index + max_count + 1)/2])

print(manachers(s))
#>output:
#>ababababa