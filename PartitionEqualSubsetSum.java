public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    /**
     * 分割等和子集
     * 先算总和 然后得到一半
     * 然后动态规划看有没有能等于一半的
     * */
    public static boolean canPartition(int[] nums) {
        int sums = 0;
        for (int num : nums) {
            sums += num;
        }
        if (sums % 2 != 0) {
            return false;
        }

        int target = sums / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) {
            return true;
        }

        return false;
    }
}
