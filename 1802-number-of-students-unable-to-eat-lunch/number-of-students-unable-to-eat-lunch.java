class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for(int student : students){
            queue.offer(student);
        }

        int index = 0;
        int unabletoeat = 0;

        while(!queue.isEmpty() && unabletoeat < queue.size()){
            if(queue.peek()==sandwiches[index]){
                queue.poll();
                index++;
                unabletoeat=0;
            }
            else{
                queue.offer(queue.poll());
                unabletoeat++;
            }
        }
        return queue.size();
    }
}