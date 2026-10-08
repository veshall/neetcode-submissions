class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0; int totalWeight = 0;

        for(int weight : weights){
            if(weight >= maxWeight){
                maxWeight = weight;
            }
            totalWeight += weight;
        }

        while(maxWeight < totalWeight){
            int leastWeight = maxWeight + (totalWeight - maxWeight) / 2;
            int currWeight = 0; int dayTaken = 1;

            for(int weight : weights){
                if(currWeight + weight > leastWeight){
                    dayTaken++;
                    currWeight = 0;
                }
                currWeight += weight;
            }

            if(dayTaken > days){
                maxWeight = leastWeight + 1;
            } else {
                totalWeight = leastWeight;
            }
        }

        return maxWeight;
    }
}