class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
                Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canComplete(tasks, workers, pills, strength, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    
    private boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int k) {
        if (k == 0) {
            return true;
        }
        
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - 1, count = 0; count < k; i--, count++) {
            int worker = workers[i];
            workerMap.put(worker, workerMap.getOrDefault(worker, 0) + 1);
        }
        
        int usedPills = 0;
        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            Integer worker = workerMap.ceilingKey(task);
            if (worker != null) {
                int cnt = workerMap.get(worker);
                if (cnt == 1) {
                    workerMap.remove(worker);
                } else {
                    workerMap.put(worker, cnt - 1);
                }
            } else {
                if (usedPills >= pills) {
                    return false;
                }
                worker = workerMap.ceilingKey(task - strength);
                if (worker == null) {
                    return false;
                }
                usedPills++;
                int cnt = workerMap.get(worker);
                if (cnt == 1) {
                    workerMap.remove(worker);
                } else {
                    workerMap.put(worker, cnt - 1);
                }
            }
        }
        return true;
    }
}