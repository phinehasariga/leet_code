class Solution {
    public static int gcd(int a,  int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> p = new ArrayList<>();
        int pi = gcd(nums[0],nums[0]);
        p.add(pi);
        int largest = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] >= largest){
                largest = nums[i];
            }
            p.add(gcd(nums[i],largest));
        }
        p.sort(null);
        if(p.size() % 2 != 0){
            p.remove(p.size()/2);
        }
        long g = 0;
        while(!p.isEmpty()){
            g = g + gcd(p.getFirst(),p.getLast());
            p.remove(p.getFirst());
            p.removeLast();
        }
        return g;
    }
}