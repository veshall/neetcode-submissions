class Solution {
    public int[] searchRange(int[] nums, int target) {
         int start = searchIndex(nums, target , true);
        int end = searchIndex(nums, target, false);

        int[] res = {start , end};
        
        return res;
    };

    private int searchIndex(int[] nums , int target , boolean findingStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;

                if(findingStartIndex){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        };

        return ans;
    }
}