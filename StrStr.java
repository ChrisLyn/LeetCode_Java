class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0)
            return 0;
        if(needle.length()==0)
            return 0;
        if(haystack.length()==needle.length())
            return haystack.equals(needle)?0:-1;
        int start = 0;
        int index = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(start)) {
                index = i;
                while (start < needle.length()) {
                    if (haystack.charAt(i) != needle.charAt(start)) {
                        break;
                    }
                    start++;
                    i++;
                }
                if (start == needle.length()) {
                    return index;
                } else {
                    i = index;
                    start = 0;
                }
            }
        }
        return -1;
    }
}