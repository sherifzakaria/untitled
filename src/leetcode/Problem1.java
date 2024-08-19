package leetcode;

// 26. Remove Duplicates from Sorted Array
public class Problem1 {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Problem1().removeDuplicates(nums1));
        System.out.println(new Problem1().removeDuplicates(nums2));
        System.out.println(new Problem1().removeDuplicates(new int[]{1, 1}));
        System.out.println(new Problem1().removeDuplicates(new int[]{1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        int index1 = 0;
        int index2 = 1;

        for (int i = index1; i < nums.length && nums[index1] != 101; i++, index1++) {
            while (index2 < nums.length && nums[index1] == nums[index2]) {
                index2++;
            }
            removeAll(index1 + 1, index2 - 1, nums);
            index2 = index1 + 1;
        }

        return index1;
    }

    private void removeAll(int start, int end, int[] arr) {
        for (int i = end; i >= start; i--) {
            if (i == arr.length - 1) {
                arr[i] = 101;
            } else {
                arr[i] = arr[i + 1];
            }
        }
    }
}
