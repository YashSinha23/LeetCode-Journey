class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int max = Integer.MIN_VALUE;
        for(int right=0; right<fruits.length; right++){
            int val = fruits[right];

            map.put(val, map.getOrDefault(val, 0)+1);

            while(map.size() > 2){
                int lftch = fruits[left];
                map.put(lftch, map.get(lftch) - 1);
                if(map.get(lftch) == 0){
                    map.remove(lftch);
                }
                left++;
            }
            max = Math.max(right-left+1, max);
        }
        return max;
    }
}