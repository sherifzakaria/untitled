package leetcode;

// 26. Remove Duplicates from Sorted Array
public class Problem1B {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(new Problem1B().removeDuplicates(nums1));
        System.out.println(new Problem1B().removeDuplicates(nums2));
//        System.out.println(new Problem1B().removeDuplicates(new int[]{1, 1}));
//        System.out.println(new Problem1B().removeDuplicates(new int[]{1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        int leftPointer = 1;

        for (int rightPointer = leftPointer; rightPointer < nums.length; rightPointer++) {
            if (nums[rightPointer] != nums[rightPointer - 1]) {
                nums[leftPointer] = nums[rightPointer];
                leftPointer++;
            }
        }

        return leftPointer;
    }
}
