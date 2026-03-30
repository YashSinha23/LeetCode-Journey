class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        for(int i=0; i<n; i++){
            String str = words[i];

            if(isstrvalid(str)){
                prefix[i] = (i == 0? 1 : prefix[i - 1] + 1);
            }else{
                prefix[i] = (i == 0? 0 : prefix[i - 1]);
            }
        }
        int [] res = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                res[i] = prefix[right];
            }else{
                res[i] = prefix[right] - prefix[left - 1];
            }
        }
        return res;
    }

    private boolean isstrvalid(String s){
        char f = s.charAt(0);
        char l = s.charAt(s.length() - 1);
        if(isvowel(f) && isvowel(l)){
            return true;
        }
        return false;
    }

    private boolean isvowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}