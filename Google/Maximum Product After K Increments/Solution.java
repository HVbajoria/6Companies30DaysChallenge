class Solution {
    public int maximumProduct(int[] nums, int k) {
        final int mod = 1000000007;
        long ans = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : nums) pq.add(v);
        for (int i = 0; i < k; i++) pq.add(pq.poll() + 1);
        for (int val : pq) ans = ans * val % mod;
        return (int) ans;
    }
}
