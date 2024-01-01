class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long d=lcm((long)divisor1, divisor2);
        int lo=1, hi=INT_MAX, n, cnt, a, b, c;
        while(lo<hi) {
            n=lo+(hi-lo)/2;
            c=n/d;
			a=n/divisor1-c;
            b=n/divisor2-c;
            cnt=min(a, uniqueCnt2)+min(b, uniqueCnt1)-a-b-c+n;
            if(cnt<uniqueCnt1+uniqueCnt2)
                lo=n+1;
            else
                hi=n;
        }
        return lo;
    }
};
