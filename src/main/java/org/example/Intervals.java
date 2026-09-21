package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intervals {

    /**
     * Merge all overlapping intervals.
     *
     * Example:
     *
     * Input:
     * [[1,3], [2,6], [8,10], [15,18]]
     *
     * Output:
     * [[1,6], [8,10], [15,18]]
     *
     * Why?
     *
     * [1,3] and [2,6] overlap because:
     *
     *      [1-----3]
     *         [2----------6]
     *
     * So they become:
     *
     *      [1-------------6]
     */
    public int[][] merge(int[][] intervals) {

        // Edge case:
        // If there are no intervals, there is nothing to merge.
        if (intervals.length == 0) {
            return new int[0][];
        }

        /*
         * STEP 1: Sort intervals by their starting point.
         *
         * Before:
         * [[8,10], [1,3], [15,18], [2,6]]
         *
         * After:
         * [[1,3], [2,6], [8,10], [15,18]]
         *
         * Sorting is important because now we can process
         * intervals from left to right.
         */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        /*
         * This list will contain our final merged intervals.
         *
         * We use a List because we don't know beforehand
         * exactly how many intervals will remain after merging.
         */
        List<int[]> result = new ArrayList<>();

        /*
         * Start with the first interval.
         *
         * Example:
         *
         * current = [1,3]
         */
        int[] current = intervals[0];

        // The first interval is automatically part of the result.
        result.add(current);

        /*
         * Start checking from the SECOND interval.
         */
        for (int i = 1; i < intervals.length; i++) {

            // This is the interval we want to compare with "current".
            int[] next = intervals[i];

            /*
             * Check if the intervals overlap.
             *
             * Example:
             *
             * current = [1,3]
             * next    = [2,6]
             *
             * next[0] = 2
             * current[1] = 3
             *
             * 2 <= 3  -> they overlap.
             *
             * Another example:
             *
             * current = [1,6]
             * next    = [8,10]
             *
             * 8 <= 6 -> false
             *
             * Therefore they DON'T overlap.
             */
            if (next[0] <= current[1]) {

                /*
                 * They overlap, so extend the current interval.
                 *
                 * Example:
                 *
                 * current = [1,3]
                 * next    = [2,6]
                 *
                 * We want:
                 *
                 * [1,6]
                 *
                 * Math.max is important because sometimes
                 * the next interval is completely inside current.
                 *
                 * Example:
                 *
                 * current = [1,10]
                 * next    = [2,5]
                 *
                 * We should keep [1,10], not change it to [1,5].
                 */
                current[1] = Math.max(current[1], next[1]);

            } else {

                /*
                 * No overlap.
                 *
                 * Example:
                 *
                 * current = [1,6]
                 * next    = [8,10]
                 *
                 * Since 8 > 6, there is a gap:
                 *
                 * [1------6]   [8----10]
                 *
                 * So next becomes our new current interval.
                 */
                current = next;

                // Add this new independent interval to the result.
                result.add(current);
            }
        }

        /*
         * Convert:
         *
         * List<int[]>
         *
         * into:
         *
         * int[][]
         *
         * because that is the return type expected by the method.
         */
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {

        Intervals solution = new Intervals();

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] merged = solution.merge(intervals);

        System.out.println(Arrays.deepToString(merged));

        // Output:
        // [[1, 6], [8, 10], [15, 18]]
    }
}