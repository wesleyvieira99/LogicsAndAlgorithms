package org.example;

public class FixedSlidingWindow {
    public int[] fixedSlidingWindow (int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[0]; //In this case, if we have a subarray bigger than array, return none

        //Step 1: calculate the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        //Step 2: Process the first window as the initial maxSum that we have encountered
        int maxSum = windowSum;

        //Step 3: iterate with sliding window until the final o the array
        for (int i = k; i < n; i++) {
            //Add new elements entering the window
            windowSum += nums[i];

            //Remove old elements leaving the window
            windowSum -= nums[i - k];

            //Process the current window
            maxSum = Math.max(maxSum, windowSum);
        }

        return new int[]{maxSum};
    };
}
