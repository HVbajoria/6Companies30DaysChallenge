class Solution {
    public String frequencySort(String s) {
        String ans="";
       char a[]=s.toCharArray();
	    ArrayList<Character>al=new ArrayList<>();
	    for(int i=0;i<a.length;i++){
	        al.add(a[i]);
	    }
	    
	    TreeSet<Character>t2=new TreeSet<>(al);
int k[]=new int[t2.size()];
char c[]=new char[t2.size()];
int x=0;
	    for(char i:t2){
	        c[x]=i;
	k[x]=Collections.frequency(al,i);
	x++;
	    }
	    for(int i=0;i<k.length;i++){
	        for(int j=i+1;j<k.length;j++){
	            if(k[i]<k[j]){
	                int t=k[i];
	                k[i]=k[j];
	                k[j]=t;
	                char t1=c[i];
	                c[i]=c[j];
	                c[j]=t1;
	            }
	        }
	        
	    }
	    for(int i=0;i<k.length;i++){
	        int l=k[i];
	        while(l>0){
                ans+=c[i];
	            l--;
	        }
	       
	    }
	   return ans;
    }
}
