public class Solution {
    public static void nTriangle(int n) {
        // Write your code here
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j <= i){
                System.out.print(i + 1 + " ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
