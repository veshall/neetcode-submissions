class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        return findPeakRecusively(nums, s, e);
    };

    private int findPeakRecusively(int[] arr,int s, int e){
        if(s >= e){
            return s;
        }

        int m = s + (e - s) / 2;

        if(arr[m] > arr[m + 1]){
            return findPeakRecusively(arr, s, m);
        } else {
            return findPeakRecusively(arr,m + 1, e);
        }
    }
};