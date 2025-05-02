class Solution {
    public String pushDominoes(String dominoes) {
                int n = dominoes.length();
        int[] leftForces = new int[n];
        int[] rightForces = new int[n];
        
        // Left to right pass to calculate right forces (distance from nearest R on the left)
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            rightForces[i] = force;
        }
        
        // Right to left pass to calculate left forces (distance from nearest L on the right)
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            leftForces[i] = force;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (rightForces[i] > leftForces[i]) {
                result.append('R');
            } else if (leftForces[i] > rightForces[i]) {
                result.append('L');
            } else {
                result.append('.');
            }
        }
        return result.toString();
    }
}