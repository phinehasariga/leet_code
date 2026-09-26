class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb1 =  new StringBuilder();
        HashMap<String,String> map = new HashMap<>();
        int left = 0;
        int right = -1;
        int idx = 0;
        StringBuilder ans = new StringBuilder();
        List<String> res = new ArrayList<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left = i+1;
            }
            if(s.charAt(i) == ')'){
                right = i-1;
            }
            while(left <= right){
                sb1.append(s.charAt(left));
                left++;
            }
            if(sb1.length() != 0){
                res.add(sb1.toString());
                sb1.setLength(0);
            }
        }
        for(int i=0;i<s.length();i++){
            int pres = 0;
            if(s.charAt(i) == '('){
                while(s.charAt(i) != ')'){
                    i++;
                }
                if(map.containsKey(res.get(idx))){
                    ans.append(map.get(res.get(idx)));
                    pres = 1;
                }
                if(pres == 0){
                    ans.append('?');
                }else{
                    pres = 0;
                }
                idx++;
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}