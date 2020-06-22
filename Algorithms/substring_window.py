def mws(s, t):
    expd=[0 for i in range(26)]
    curd=[0 for i in range(26)]

    for i in t:
        expd[ord(i)-97]+=1

    ms,mw,st,i,c=0,float('inf'),0,0,0

    while i < len(s):
        
        curd[ord(s[i])-97]+=1
        if curd[ord(s[i])-97]<=expd[ord(s[i])-97]:
            c+=1

        if c==len(t):
            while expd[ord(s[st])-97]==0 or curd[ord(s[st])-97]>expd[ord(s[st])-97]:
                curd[ord(s[st])-97]-=1
                st+=1
            if mw>i-st+1:
                mw=i-st+1
                ms=st
        i+=1
    if mw==float('inf'):
        return ''
    return s[ms:ms+mw]
print(mws("ADOBECODEBANC".lower(), "ABC".lower()))

