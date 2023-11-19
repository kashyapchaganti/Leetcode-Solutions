class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
	HashSet<Character> seenCharacter = new HashSet<>();
	int left =0;
	int maxLength=0;
	for(int i=0;i<size;i++){
		char ch = s.charAt(i);
		while(seenCharacter.contains(ch)){
			char windowStartCharacter = s.charAt(left);
			seenCharacter.remove(windowStartCharacter);
			left++;
		}
seenCharacter.add(ch);
		maxLength= Math.max(maxLength, seenCharacter.size());
		
	}
return maxLength;

    }
}