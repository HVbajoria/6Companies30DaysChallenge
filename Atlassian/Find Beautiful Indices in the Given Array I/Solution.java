class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int idxA=-1, idxB = s.indexOf(b);
        List<Integer> ans = new ArrayList<>();
        while (true){
            idxA = s.indexOf(a,idxA+1); 
            if (idxA == -1) break; 
            while ((idxB!=-1) && (idxB <idxA-k))
                idxB = s.indexOf(b,idxB+1); 
            if (idxB==-1) break; 
            if (idxB<=idxA+k) 
                ans.add(idxA);
        }
        return ans;
    }
}
