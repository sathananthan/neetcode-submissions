public class Solution {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {

            int mid = left + (right - left) / 2;

            min = Math.min(min, nums[mid]);

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}