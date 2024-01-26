class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

    Arrays.sort(asteroids);

    long m=(long)mass;

    for(int i=0;i<asteroids.length;i++){
        if(m<asteroids[i])return false;
        else m+=asteroids[i];
    }

    return true;
        
    }
}
