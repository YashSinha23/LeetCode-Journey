class Solution {
    public int fib(int n) {
        int res = 0;
        if(n == 0){
            res += 0;
            return res;
        } 
        if(n == 1){
            res += 1;
            return res;
        }

        res += fib(n-1) + fib(n-2);

        return res;
    }
}