class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int miniEat = 1;
        int maxEat = 0;

        for (int pile : piles) {
            maxEat = Math.max(maxEat, pile);
        }

        while (miniEat < maxEat) {
            int leastEat = miniEat + (maxEat - miniEat) / 2;
            long hourNeeded = 0;

            for (int pile : piles) {
                hourNeeded += (pile + leastEat - 1) / leastEat;
            }

            if (hourNeeded > h) {
                miniEat = leastEat + 1;
            } else {
                maxEat = leastEat;
            }
        }

        return miniEat;
    }
}
