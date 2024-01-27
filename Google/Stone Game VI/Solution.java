class Solution {
    public int stoneGameVI(int[] av, int[] bv) {
        List<Integer> a[] = new ArrayList[201]; 
        int n = av.length;
        for(int i = 0; i < n;i++){
            int sum = av[i] + bv[i];
            if(a[sum] == null){
                a[sum] = new ArrayList<Integer>();
                a[sum].add(i);
            }
            else{
                a[sum].add(i);
            }
        }

        int[] aa = new int[n];
        int x = 0;
        for(int i = 200; i >= 0; i--){
            if(a[i] != null){
                for(int p : a[i]){
                    aa[x] = p;
                    x++;
                }
            }
        }

        int as = 0;
        int bs = 0;
        int xx = 0;
        while(xx < n){
            as += av[aa[xx]];
            if(xx+1 < n){
            bs += bv[aa[xx+1]];
            }
            xx += 2;
        }
                
        if(as > bs){
            return 1;
        }
        if(bs > as){
            return -1;
        }
        return 0;

    }
}
