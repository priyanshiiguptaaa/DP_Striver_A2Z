class Solution {
    public boolean isPrime(int n) {
          //your code goes here
          if(n == 1 || n == 2){
            return true;
          }
          for(int i = 2 ; i < n / 2 ; i++){
            if(i % 2 == 0){
                return false;
            }
            
          }
          return true;
    }
}
