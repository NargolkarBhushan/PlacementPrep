class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Logic : create a hashSet of s = "abcabcbb" which will contain set = {a,b,c} 
        //initiate maxLength, left and right pointers
        //left pointer will point to 0th index and right pointer will be used to iterate over the string till its end
        // inside the for loop check if set contains the right pointer of s
        //if yes then that means that left pointer of the string s has that letter
        //then 
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1); 
        }
        return maxLen;
    }
}
