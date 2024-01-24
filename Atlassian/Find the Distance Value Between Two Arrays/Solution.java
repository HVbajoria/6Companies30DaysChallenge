class Solution {
    private boolean isPassed(int n,int[] nums,int d){

        for(int i=0;i<nums.length;i++){
                if(Math.abs(n-nums[i]) <= d)
                return false;      
        }
        return true;
    } 
    
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int counter=0;
        for(int i=0;i<arr1.length;i++){
          if(isPassed(arr1[i],arr2,d))
            counter++;
        }
        return counter;
    }
}
