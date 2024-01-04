/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int ans = 0;
    
    pair<int, pair<int,int>> solve(TreeNode* root){
        if(!root->left && !root->right){
            ans = max(ans, root->val);
            return {root->val, {root->val, root->val}};
        }
        pair<int,pair<int,int>> left = {0,{INT_MAX,INT_MIN}}, right = {0,{INT_MAX,INT_MIN}};
        if(root->left) left = solve(root->left);
        if(root->right) right = solve(root->right);
        if(root->val>left.second.second && root->val<right.second.first){
            ans = max(ans, left.first+right.first+root->val);
            return {left.first+right.first+root->val, {min(left.second.first, root->val), max(right.second.second, root->val)}};
        }
        else return {0, {INT_MIN,INT_MAX}};
    }
    
    int maxSumBST(TreeNode* root) {
        auto x = solve(root);
        return ans;
    }
};
