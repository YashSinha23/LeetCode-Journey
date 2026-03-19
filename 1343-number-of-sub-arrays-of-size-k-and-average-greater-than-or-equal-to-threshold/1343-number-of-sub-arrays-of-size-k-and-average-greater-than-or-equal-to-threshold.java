class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int sum = 0;
        int count = 0;

        int winsize = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            winsize = i - left + 1;

            if(winsize == k){
                int avg = sum/winsize;
                if(avg >= threshold){
                    count++;
                }
                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
}