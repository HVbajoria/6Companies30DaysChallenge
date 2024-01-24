class Solution {
    public int countCollisions(String directions) {
        char pre = 'N';
        int rnt = 0;
        int res = 0;
        for(int i=0; i<directions.length(); i++){
            if(directions.charAt(i)== 'R'){
                rnt++;
                pre = 'R';
                continue;
            }else if(directions.charAt(i)== 'L'){
                if(pre == 'R'){
                    res+=rnt+1;
                    pre = 'S';
                    rnt=0;
                }else if(pre == 'S'){
                    res++;
                }
            }else if(directions.charAt(i)== 'S'){
                res+=rnt;
                pre = 'S';
                rnt= 0;
            }
        }
        return res;
    }
}
