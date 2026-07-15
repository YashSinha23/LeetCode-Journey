class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumofodd = 0;
        int sumofeven = 0;

        for(int i=1; i<=n*2; i++){
            if(i%2==0){
                sumofeven += i;
            }else{
                sumofodd += i;
            }
        }

        while(sumofodd != 0){
            int temp = sumofeven % sumofodd;
            sumofeven = sumofodd;
            sumofodd = temp;
        }

        return sumofeven;
    }
}