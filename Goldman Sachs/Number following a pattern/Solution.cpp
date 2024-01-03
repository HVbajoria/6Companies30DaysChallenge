class Solution{   
public:
    string printMinNumberForPattern(string S){
        S += 'I';  
        int n = S.length();
        int MinDigit = 1;
        string out;
        for(int i=0; i<n; i++) out += '0'; 
        for(int i=0; i<n; i++)
        {
            if(S[i]=='I')
            {
                out[i] = ('0' + MinDigit);
                MinDigit++;
                int j = i-1;
                while(j>=0 && S[j]=='D')
                {
                    out[j] = ('0' + MinDigit);
                    MinDigit++;
                    j--;
                }
            }
        }
         
        return out;
    }
};
