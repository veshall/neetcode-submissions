class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int s = 0;
        int e = x / 2;

        while(s <= e){
            int m = s + (e - s) / 2;
            long sqrt = (long) m * m;

            if(sqrt == x) return m;
            
            if(sqrt < x){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return e;
    }
}