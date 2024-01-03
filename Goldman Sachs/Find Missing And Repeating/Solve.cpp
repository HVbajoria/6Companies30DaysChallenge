class Solve {
    int[] findTwoElement(int arr[], int n) {
       int a=0,b=0;
       for(int i=0;i<n;i++){
           int idx=Math.abs(arr[i])-1;
           if(arr[idx]>0)
           arr[idx]=-arr[idx];
           else
           a=Math.abs(arr[i]);
       }
       
       for(int i=0;i<n;i++)
       {
           if(arr[i]>0)
           {
               b=i+1;
               break;
           }
       }
       return new int[]{a,b};
    }
}
