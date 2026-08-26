class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int i = 3;
        while(num > 0){
            int d = num % 10;
            arr[i] = d;
            i--;
            num = num / 10;
        }
        Arrays.sort(arr);

        StringBuilder sb1 = new StringBuilder();
        sb1.append(arr[0]);
        sb1.append(arr[2]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(arr[1]);
        sb2.append(arr[3]);

        int val1 = Integer.parseInt(sb1.toString());
        int val2 = Integer.parseInt(sb2.toString());

        return val1+val2;
        
    }
}