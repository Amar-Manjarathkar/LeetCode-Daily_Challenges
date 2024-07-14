class Solution:
    def countOfAtoms(self, s: str) -> str:
        return [s:=re.sub('\((\w+)\)(\d*)',lambda m:re.sub('([A-Z][a-z]*)(\d*)',lambda mm:mm[1]+str(int(mm[2] or '1')*int(m[2] or '1')),m[1]),s) for _ in s] and \
            ''.join(e+str(c)*(c>1) for e,c in sorted(sum((Counter({m[1]:int(m[2] or 1)}) for m in finditer('([A-Z][a-z]*)(\d*)',s)),Counter()).items()))
