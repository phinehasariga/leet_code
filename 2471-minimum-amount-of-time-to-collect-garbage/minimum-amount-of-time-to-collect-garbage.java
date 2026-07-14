class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {

        int n = garbage.length;

        // prefix[i] = time to reach house i
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + travel[i - 1];
        }

        int total = 0;

        int lastM = 0;
        int lastP = 0;
        int lastG = 0;

        for (int i = 0; i < n; i++) {

            total += garbage[i].length();

            for (char c : garbage[i].toCharArray()) {

                if (c == 'M')
                    lastM = i;
                else if (c == 'P')
                    lastP = i;
                else
                    lastG = i;
            }
        }

        total += prefix[lastM];
        total += prefix[lastP];
        total += prefix[lastG];

        return total;
    }
}