import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        //...
    }

    /**
     * 数组中第k个最大元素
     * TODO：手撸小顶堆的建堆和调整堆
     * */
    public static int findKthLargest(int[] nums, int k) {
        int res = 0;
        // 用小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            }else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
