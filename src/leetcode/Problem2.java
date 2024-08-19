package leetcode;

// 27. Remove Element
public class Problem2 {

    public static void main(String[] args) {
        System.out.println(new Problem2().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new Problem2().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer < rightPointer) {
            if (nums[leftPointer] == val && nums[rightPointer] != val) {
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
                leftPointer++;
                rightPointer--;
            } else if (nums[leftPointer] == val && nums[rightPointer] == val) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }
        return rightPointer + 1;
    }
}
