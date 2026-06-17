class Solution {

    public boolean isPalindrome(String s) {
        
        // Convert to lowercase
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}