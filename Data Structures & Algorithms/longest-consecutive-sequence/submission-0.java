class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Check each number
        for (int num : set) {

            // Start only if it's the beginning
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                // Expand sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}