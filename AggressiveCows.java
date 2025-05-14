class Solution {
  public static boolean canplace(int nums[], int dist, int k) {
    int n = nums.length;
    int count = 1;
    int place = nums[0];
    for (int i = 1 ; i < n; i++) {
      if (nums[i] - place >= dist) {
        count++;
        place = nums[i];
      }
    }

    return count >= k;
  }

  public int aggressiveCows(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);
    int s = 1;
    int e = nums[n - 1] - nums[0];
    int ans = - 1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (canplace(nums, mid, k) == true) {
        s = mid + 1;
        ans = mid; 
      }
      else{
        e = mid - 1;
      }
    }
    return ans;
  }
}
