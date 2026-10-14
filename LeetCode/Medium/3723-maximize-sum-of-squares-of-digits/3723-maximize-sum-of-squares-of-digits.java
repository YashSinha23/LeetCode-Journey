class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int rem = sum % 9;
        int nines = sum / 9;
        for (int i = 0; i < nines; i++) {
            sb.append("9");
        }
        if (rem > 0) {
            sb.append(rem);
        }
        int totlen = num - sb.length();
        for (int i = 0; i < totlen; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}