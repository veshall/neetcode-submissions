class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean seen[] = new boolean[1001];
        for (int num : nums1) {
            seen[num] = true;
        }

        int res[] = new int[nums2.length];
        int count = 0;

        for (int num : nums2) {
            if (seen[num] == true) {
                res[count++] = num;
                seen[num] = false;
            }
        }

        return Arrays.copyOf(res, count);
    }
}