class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;

        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                contentChildren++;
                gi++;
            }
            si++;
        }

        return contentChildren;
    }
}
