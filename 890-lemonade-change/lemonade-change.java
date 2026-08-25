class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int i=0;i<n;i++){
            if(bills[i] == 5){
                five++;
            }
            if(bills[i] == 10){
                ten++;
                if(five > 0){
                    five--;
                }else{
                    return false;
                }
            }
            if(bills[i] == 20){
                twenty++;
                if(ten >= 1 && five >= 1){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five--;
                    five--;
                    five--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}