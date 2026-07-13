class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] c = Arrays.copyOf(arr,n);
        Arrays.sort(c);

        HashMap<Integer,Integer> map = new HashMap<>();
        int currrank = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(c[i])){
                map.put(c[i],currrank);
                currrank++;
            }
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}