class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1]-a[1]);

        int ans = 0;

        for(int[] types : boxTypes){
            int boxes = types[0];
            int units = types[1];

            if(truckSize == 0)break;

            int take = Math.min(boxes,truckSize);

            ans += take*units;
            truckSize -= take;
        }
        return ans;
    }
}