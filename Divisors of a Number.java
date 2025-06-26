class Solution {
    public int[] divisors(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                ans.add(i);
                if(i != n / i){
                    ans.add(n / i);
                }
            }
        }
        Collections.sort(ans);

        int[] arr = new int[ans.length()];
        for(int i = 0 ; i < ans.length() ; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
