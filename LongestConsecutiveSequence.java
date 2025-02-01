import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String in = sc.nextLine();
        String[] strs = in.split(" ");
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }
        int[] inputs = list.stream().mapToInt(i -> i).toArray();

        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        int res = lcs.longestConsecutive(inputs);
        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int res = 0;
        int nowStart = nums[0];
        for(int num :nums){
            if (set.contains(num - 1)){
                continue;
            }
            if (num == nowStart && num != nums[0]) {
                continue;
            }
            nowStart = num;
            int count = 1;
            int curNum = num;
            while (set.contains(curNum+1)) {
                count++;
                curNum++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
