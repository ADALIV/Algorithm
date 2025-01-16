class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt1 = 0;  // nums1 배열의 인덱스
        int cnt2 = 0;  // nums2 배열의 인덱스
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;  // 두 배열의 총 길이
        double median = 0;

        // 홀수 길이일 때
        if (totalLength % 2 == 1) {
            int index = totalLength / 2;
            while (true) {
                if (cnt2 == n || (cnt1 < m && nums1[cnt1] < nums2[cnt2])) {
                    if (cnt1 + cnt2 == index) {
                        median = nums1[cnt1];
                        break;
                    }
                    cnt1++;
                } else {
                    if (cnt1 + cnt2 == index) {
                        median = nums2[cnt2];
                        break;
                    }
                    cnt2++;
                }
            }
        } else {  // 짝수 길이일 때
            int index1 = totalLength / 2 - 1;
            int index2 = totalLength / 2;
            int first = -1, second = -1;

            while (cnt1 < m || cnt2 < n) {
                if (cnt2 == n || (cnt1 < m && nums1[cnt1] < nums2[cnt2])) {
                    if (cnt1 + cnt2 == index1) {
                        first = nums1[cnt1];
                    }
                    if (cnt1 + cnt2 == index2) {
                        second = nums1[cnt1];
                        break;
                    }
                    cnt1++;
                } else {
                    if (cnt1 + cnt2 == index1) {
                        first = nums2[cnt2];
                    }
                    if (cnt1 + cnt2 == index2) {
                        second = nums2[cnt2];
                        break;
                    }
                    cnt2++;
                }
            }
            median = (first + second) / 2.0;
        }

        return median;
    }
}
