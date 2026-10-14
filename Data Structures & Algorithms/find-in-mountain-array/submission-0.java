/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int pivotInArr = peakInMountain(mountainArr);

        int firstTry = orderAgnoisticBS(mountainArr, 0, pivotInArr, target, true);

        if(firstTry != -1) return firstTry;

        return orderAgnoisticBS(mountainArr, pivotInArr + 1, mountainArr.length() - 1, target, false);
    }

    private int peakInMountain(MountainArray arr){
        int start = 0; int end = arr.length() - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr.get(mid) < arr.get(mid + 1)){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private int orderAgnoisticBS(MountainArray arr, int start, int end, int target, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int eleAtMid = arr.get(mid);

            if (eleAtMid == target) {
                return mid;
            }

            if (isAsc) {
                if (target < eleAtMid) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < eleAtMid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}