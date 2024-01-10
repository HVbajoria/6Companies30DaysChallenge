class Solution {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        
        for(int i: nums)
            bucket[i]++;
        
        int max = 5000;
        boolean firstPass = true;
        for(int i = 1 ; i < nums.length; i+=2){ 
            while(bucket[max] == 0)
                max--;
            
            nums[i] = max;
            bucket[max]--;
            if(firstPass && i+2 >= nums.length){
                i = -2; 
                firstPass = false;
            }
        }    
    }
}
