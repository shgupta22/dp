public class MedianOf2SortedArray {

    public static double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int lo = 0;
        int hi = n1;

        while (lo <= hi) {
            int cut1 = (lo+hi)/2;
            int cut2 = (n1+n2)/2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 > r2) {
                hi = cut1 -1;
            } else if (l2 > r1) {
                lo = cut1 +1;
            } else {
                return (n1+n2) %2 == 0 ? ((Math.max(l1, l2) + Math.min(r1,r2))/2.0) : Math.min(r1, r2);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,5,8,10,18,20};
        int[] arr2 = new int[]{2,3,6,7};

        System.out.println(median(arr1, arr2));
    }
}
