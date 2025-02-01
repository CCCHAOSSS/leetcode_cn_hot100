public class MaxProductSubarray {
    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int[] inputs = new int[]{2,3,-2,4};
        System.out.println(maxProductSubarray.maxProduct(inputs));
    }
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];

        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length; i++){
            int curmin = nums[i] * min[i-1];
            int curmax = nums[i] * max[i-1];

            min[i] = Math.min(Math.min(curmin, nums[i]), curmax);
            max[i] = Math.max(Math.max(curmin, nums[i]), curmax);

            res = Math.max(max[i], res);
        }

        return res;
    }
}
