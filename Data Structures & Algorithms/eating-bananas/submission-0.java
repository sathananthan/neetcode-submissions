class Solution {
    public long hoursNeeded(int[] piles, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += ((long) pile + k - 1) / k;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find the largest pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = hoursNeeded(piles, mid);

            if (hours <= h) {
                right = mid;      // Speed works, try slower
            } else {
                left = mid + 1;   // Speed too slow, increase it
            }
        }

        return left;
    }
}
