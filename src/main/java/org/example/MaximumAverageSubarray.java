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

            /*
            When the window moves one position to the right, it loses the leftmost element
            and gains a new element on the right. Instead of recalculating the entire sum,
            subtract the element that dropped off and add the one that came in. This is the
            fixed-size sliding window pattern: compute the sum of the first window once, then
            move it across the array with a single addition and subtraction per step.
            * */
            currentSum += nums[i] - nums[i - k];

            //Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        // Final Step: instead of dividing every window's sum by k during comparison, track the maximum sum and divide once at the end.
        return (double) maxSum / k;
    }

}
