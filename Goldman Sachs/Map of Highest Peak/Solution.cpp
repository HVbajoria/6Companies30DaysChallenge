class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>&a) {
        int n=a.size();
        int m=a[0].size();
        vector<vector<int>>dp(n,vector<int>(m,INT_MAX-1000));
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==1)
                    dp[i][j]=0;
                else
                {
                    if(i>0)
                        dp[i][j]=min(dp[i][j],dp[i-1][j]+1);
                    if(j>0)
                        dp[i][j]=min(dp[i][j],dp[i][j-1]+1);
                }
            }
        for(int i=n-1;i>=0;i--)
            for(int j=m-1;j>=0;j--)
            {
                if(i<n-1)
                   dp[i][j]=min(dp[i][j],dp[i+1][j]+1); 
                if(j<m-1)
                   dp[i][j]=min(dp[i][j],dp[i][j+1]+1);
            }
        return dp;
    }
};
