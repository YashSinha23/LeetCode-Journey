class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target > letters[letters.length-1]) return letters[0];

        int left = 0;
        int right = letters.length - 1;
        char ans = letters[0];
        while(left <= right){
            int mid = left + (right - left)/2;
            int tar = target - 'a';

            if(letters[mid] - 'a' > tar){
                ans = letters[mid];
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }
        return ans;
    }
}