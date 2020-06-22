a = "ABCBDABA"
b = "BDCABAD"
d = dict()
def lcs(m, n):
    if m == 0 or n == 0:
        return 0
    key = str(m) + "|" + str(n)  
    if key not in d.keys():
        #print(key)           
        if a[m - 1] == b[n - 1]:
            d[key] = lcs(m - 1, n - 1) + 1
        else:
            d[key] = max(lcs(m - 1, n), lcs(m, n - 1))
        return d[key]
    else:
        return d[key]

lcs(len(a), len(b))
for i in d:
    print(i)
#print("lcs length =", d[str(len(a)) + "|" + str(len(b))])
#print(s)
#print("lcs =", ''.join(s.reverse()))