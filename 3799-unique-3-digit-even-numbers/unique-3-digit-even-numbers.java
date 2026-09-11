class Solution {
    public int totalNumbers(int[] d) {
        int n = d.length;
        boolean[] seen = new boolean[1000];
        int count = 0;
        for(int i=0;i<n;i++){
            if(d[i] == 0){
                continue;
            }
            for(int j=0;j<n;j++){
                if(i == j){
                    continue;
                }
                for(int k=0;k<n;k++){
                    if(k == i || k == j){
                        continue;
                    }
                    if(d[k] % 2 != 0){
                        continue;
                    }
                    int num = d[i]*100+d[j]*10+d[k];
                    if(!seen[num]){
                        seen[num] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}