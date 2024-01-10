class Solution {
    Map<List<Integer>, Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ans = base(price, needs);
        if(map.get(needs) != null) return map.get(needs);
        for(int i = 0; i < special.size(); i++){
            int j = 0;
            for(j = 0; j < needs.size(); j++){
                if(needs.get(j) - special.get(i).get(j) < 0)
                    break;
            }
            if(j != needs.size()) continue;
            List<Integer> clone = new ArrayList<>(needs.size());
            for(j = 0; j < needs.size(); j++) {
                clone.add(needs.get(j) - special.get(i).get(j));
            }
            ans = Math.min(ans, special.get(i).get(j) + 
                    shoppingOffers(price, special, clone));
        }
        map.put(needs, ans);
        return ans; 
    }

    int base(List<Integer> price, List<Integer> needs){
        int ans = 0;
        for(int i = 0; i < price.size(); i++){
            ans += price.get(i) * needs.get(i);
        }
        return ans;
    }
}
