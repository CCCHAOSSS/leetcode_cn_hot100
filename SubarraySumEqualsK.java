import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        // 暴力
//        int res = 0;
//        for(int i=0; i<nums.length; i++){
//            int summ = 0;
//            for(int j=i+1; j<nums.length; j++){
//                summ += nums[j];
//                if (summ == k){
//                    res++;
//                }
//            }
//        }
//        return res;

        //前缀和
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int count = 0;
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            pre += nums[i];
            int key = pre - k;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
