class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] == pivot){
                equal.add(nums[i]);
            }else if(nums[i] > pivot){
                more.add(nums[i]);
            }else{
                less.add(nums[i]);
            }
        }
        int size = less.size();
        int j = 0;
        for(int i=0; i<less.size(); i++){
            nums[i] = less.get(j++);
        }

        size = equal.size() + less.size();
        j = 0;
        for(int i=less.size(); i<size; i++){
            nums[i] = equal.get(j++);
        }

        size = equal.size() + less.size() + more.size();
        j = 0;
        for(int i=equal.size() + less.size(); i<size; i++){
            nums[i] = more.get(j++);
        }
        return nums;
    }
}