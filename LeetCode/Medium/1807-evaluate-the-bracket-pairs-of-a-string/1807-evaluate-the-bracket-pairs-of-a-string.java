class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        for(List<String> lt: knowledge){
            map.put(lt.get(0),lt.get(1));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean bf = false;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                bf = true;
                continue;
            }
            if(ch == ')'){
                bf = false;
                if(map.containsKey(sb.toString())){
                    result.append(map.get(sb.toString()));
                }else{
                    result.append("?");
                }
                sb.setLength(0);
                continue;
            }

            if(bf){
                sb.append(ch);
            }else{
                result.append(ch);
            }
        }

        return result.toString();
    }
}