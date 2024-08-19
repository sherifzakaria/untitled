package leetcode;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// 26. Remove Duplicates from Sorted Array
public class Problem1A {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Problem1A().removeDuplicates(nums1));
        System.out.println(new Problem1A().removeDuplicates(nums2));
        System.out.println(new Problem1A().removeDuplicates(new int[]{1, 1}));
        System.out.println(new Problem1A().removeDuplicates(new int[]{1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> numsSet = new LinkedHashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int index = 0;
        for (Integer integer : numsSet) {
            nums[index] = integer;
            index++;
        }
        return numsSet.size();
    }
}
