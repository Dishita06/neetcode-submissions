class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            // Count characters
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append("#");
                keyBuilder.append(count[i]);
            }

            String key = keyBuilder.toString();

            // Add to map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
