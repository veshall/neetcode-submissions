class Solution {
    public int search(int[] nums, int target) {

        int rotationInd = rotationIndice(nums);
        
        int firstTry = binarySearch(nums, target, 0, rotationInd - 1);

        if(firstTry != -1){
            return firstTry;
        } else {
            return binarySearch(nums, target, rotationInd, nums.length - 1);
        }
    }

    private int rotationIndice(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < nums[end]){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target == nums[mid]){
                return mid;
            } 
            
            if(target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            };
        };

        return -1;
    }
}
