import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 8, 9, 10, 3, 19, 4, 33, 20};
        System.out.println(findKthLargest(nums, 3));
    }

    /**
     * 数组中第k个最大元素
     * TODO：手撸小顶堆的建堆和调整堆
     * */
    public static int findKthLargest(int[] nums, int k) {
        int res = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if(pq.peek() < num){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }

    /**
     * 建堆
     * */
    public static void buildHeap(int[] nums, int heapSize) {
        // 从非叶子节点开始
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, heapSize);
        }

    }

    /**
     * d堆调整
     * */
    public static void adjustHeap(int[] nums, int root, int heapSize) {
        int l = root*2 + 1, r = root*2 + 2;
        int least = root;
        if (l < heapSize && nums[l] < nums[least]) {
            least = l;
        }
        if (r < heapSize && nums[r] < nums[least]) {
            least = r;
        }
        if (least != root) {
            swap(nums, root, least);
        }
        adjustHeap(nums, least, heapSize);
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
