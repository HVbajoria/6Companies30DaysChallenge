class Solution {
public:
    unordered_map <int,string> mp;
    string ans = ""; 

    void solve(int idx,string &digits,vector<string> &v){
        if(idx >= digits.size()){ 
            v.push_back(ans); 
            return;
        }    
        int num = digits[idx]-'0'; 
        string s = mp[num]; 
        for(int i=0;i<s.size();i++){
            ans += s[i];
            solve(idx+1,digits,v);
            ans.pop_back(); 
        }
    }
    vector<string> letterCombinations(string digits) {
        mp[2] = {"abc"}; 
        mp[3] = {"def"};
        mp[4] = {"ghi"};
        mp[5] = {"jkl"};
        mp[6] = {"mno"};
        mp[7] = {"pqrs"};
        mp[8] = {"tuv"};
        mp[9] = {"wxyz"};
        vector<string> v;
        if(digits.size() == 0)
            return v;
        solve(0,digits,v);
        return v;
    }
};
