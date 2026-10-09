class Solution {
    public int arrangeCoins(int n) {
        int s = 0; 
        int availableCoins = n;
        int lastStair = 0;

        while(lastStair < availableCoins){
            lastStair++;
            availableCoins -= lastStair;
        }
        return lastStair;
    }
}