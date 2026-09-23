package org.example;

/*
*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and
* return this value. Any answer with a calculation error less than 10^-5 will be accepted.
*
* */

public class MaximumAverageSubarray {

    // Step 0: the method creation
    public double findMaxAvg(int[] nums, int k) {

        // Step 1: Calculate the sum of the initial window of size k, the first loop with the first window
        double currentSum = 0;
        for(int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // Step 2: the initial window end and, at this moment, we have the initial maxSum
        double maxSum = currentSum;

        // Step 3: Slide the window from index k to the end of the array
        for(int i = k; i < nums.length; i++) {
            //Add the new element entering the window , subtract the one leaving
            //With this manner, we are going each step to an item to the left
            currentSum += nums[i] - nums[i - k];

            //Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }

}
