class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for(int num : quantities){
            right = Math.max(right, num);
        }
        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left)/2;
            int ns = 0;
            int remst = n;
            for(int num : quantities){
                ns = (int)Math.ceil((double)num/mid);
                remst = remst - ns; 
            }
            if(remst >= 0){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}