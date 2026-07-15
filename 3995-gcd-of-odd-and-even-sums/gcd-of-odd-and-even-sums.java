class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        int sumo =  n * n;
        int sume= n * (n + 1);
        while(sume != 0 ){
            int temp = sume;
            sume = sumo % sume;
            sumo = temp;
        }
        return sumo;
    }
}