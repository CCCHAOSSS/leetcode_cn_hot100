public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m+n];
        int i=0, j=0;
        int count = 0;
        while (i<n && j<m) {
            if (nums1[i] < nums2[j]) {
                nums[count] = nums1[i];
                i++;
            }else{
                nums[count] = nums2[j];
                j++;
            }
            count++;
        }
        while (i<n) {
            nums[count++] = nums1[i++];
        }
        while (j<m) {
            nums[count++] = nums2[j++];
        }

        return  ((double)nums[(m+n)/2] + nums[(m+n-1)/2]) / 2;

    }
}
