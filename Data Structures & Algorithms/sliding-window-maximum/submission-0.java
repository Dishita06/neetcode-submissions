class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] answer = new int[nums.length - k + 1];

        int index = 0;

        for (int i = 0; i <= nums.length - k; i++) {

            int max = nums[i];

            for (int j = i; j < i + k; j++) {

                max = Math.max(max, nums[j]);

            }

            answer[index] = max;
            index++;
        }

        return answer;
    }
}