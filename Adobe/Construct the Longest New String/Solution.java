class Solution {
    public int longestString(int x, int y, int z) {
     if(x == y) return (x + y + z) * 2;
     else return (Math.min(x, y) + Math.min(x, y) + 1 + z) * 2;
    }
}
