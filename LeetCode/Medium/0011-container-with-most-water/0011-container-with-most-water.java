class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;


        int maxres = Integer.MIN_VALUE;
        while(left <= right){
            int leftnum = height[left];
            int rightnum = height[right];

            int min = Math.min(leftnum, rightnum);
            int area = min*(right-left);
            maxres = Math.max(maxres, area);

            if(leftnum < rightnum){
                left++;
            }else{
                right--;
            }
        }

        return maxres;
    }
}