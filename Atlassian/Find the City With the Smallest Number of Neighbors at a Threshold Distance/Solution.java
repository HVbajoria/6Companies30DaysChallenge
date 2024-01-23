class Solution {
    public int findTheCity(int n, int[][] cities, int distanceThreshold) {
        int arr[][] = new int[n][n];
        int m = cities.length;
        for(int i=0; i<m; i++){
            int u = cities[i][0];
            int v = cities[i][1];
            int wt = cities[i][2];
            arr[u][v] = wt;
            arr[v][u] = wt; 
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j){
                    arr[i][j] = 0;
                }else if(arr[i][j] == 0){
                    arr[i][j] = (int) 1e9;
                }
            }
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= min){
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}
