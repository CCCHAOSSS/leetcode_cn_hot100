import java.util.Scanner;

public class MaxSubarray {
    public static void main(String[] args) {
        MaxSubarray maxSubarray = new MaxSubarray();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strs = input.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(maxSubarray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
