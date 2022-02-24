package ru.korolkovrs;

import java.util.HashMap;
import java.util.Map;

public class Task {

//    {3,15,2,6,7}, 10, new int[]{3, 7}
    public static int[] findTwo(int[] nums, int targetSum) {
        if (nums == null) {
            return new int[]{};
        }
        Map<Integer, Integer> numsAndCount = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (numsAndCount.containsKey(nums[i])) {
                int val = numsAndCount.get(nums[i]);
                numsAndCount.put(nums[i], ++val);
            } else {
                numsAndCount.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int secondNum = targetSum - nums[i];
            if (numsAndCount.containsKey(secondNum)) {
                if (secondNum == nums[i] && numsAndCount.get(secondNum) == 1) {
                    continue;
                }
                return new int[]{nums[i], secondNum};
            }
        }
        return new int[]{};
    }
}
