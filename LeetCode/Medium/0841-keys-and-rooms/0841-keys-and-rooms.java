class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isOpen = new boolean[rooms.size()];
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);
        isOpen[0] = true;

        while(!queue.isEmpty()){
            int index = queue.poll();
            List<Integer> inner = rooms.get(index);

            for(int num : inner){
                if(set.contains(num)){
                    continue;
                }else{
                    queue.add(num);
                    set.add(num);
                    isOpen[num] = true;
                }
            }
        }

        for(int i=0; i<isOpen.length; i++){
            if(isOpen[i] == false){
                return false;
            }
        }

        return true;
    }
}