class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];

        arr[0] = findleft(nums, target);
        arr[1] = findright(nums, target);

        return arr;
    }

    public int findleft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }  
        return ans;
    }

    public int findright(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }  
        return ans;
    }
}