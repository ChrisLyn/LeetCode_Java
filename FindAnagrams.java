class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return list;
        }       
        int[] dict = new int[256];
        int[] pair = new int[256];
        for (char c : p.toCharArray()) {
            dict[c]++;
        }
        int count = p.length();
        int left = 0;
        int right = 0;
        int start = 0;
        while (right < s.length()) {
            if (dict[s.charAt(right)] > 0) {
                count--;
            }
            dict[s.charAt(right)]--;
            right++;
            
            if (count == 0) {
                list.add(left);
            }
            
            if (right - left == p.length()) {
                if (dict[s.charAt(left)] >= 0) {
                    count++;
                }
                dict[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }
}