class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length + nums2.length;

        int idx2 = n/2;
        int idx1 = idx2-1;
        int count = 0;
        int i1 = -1;
        int i2 = -1;

        int i=0, j=0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                if(count == idx1) i1 = nums1[i];
                if(count == idx2) i2 = nums1[i];
                count++;
                i++;
            }else {
                if(count == idx1) i1 = nums2[j];
                if(count == idx2) i2 = nums2[j];
                count++;
                j++;
            }
        }

        while (i < nums1.length) {
            if (count == idx1) i1 = nums1[i];
            if (count == idx2) i2 = nums1[i];
            count++;
            i++;
        }
        while (j < nums2.length) {
            if(count == idx1) i1 = nums2[j];
            if(count == idx2) i2 = nums2[j];
            count++;
            j++;
        }

        if(n % 2 == 1){
            return (double)i2;
        }
       return (double)(i1+i2)/2.0;
    }
}


//  int [] ans = new int[nums1.length+nums2.length];
//         int i = 0;
//         int j = 0;
//         int idx = 0;
        
//         while(i<nums1.length && j<nums2.length){
//             if(nums1[i]<=nums2[j]){
//                 ans[idx++] = nums1[i++];
//             }else{
//                 ans[idx++] = nums2[j++];
//             }
//         }
//         while(i<nums1.length){
//             ans[idx++] = nums1[i++];
//         }
//          while(j<nums2.length){
//             ans[idx++] = nums2[j++];
//         }

//         int n = ans.length;
//         if (n % 2 == 1) {
//             return ans[n / 2];
//         } else {
//             int mid = n / 2 - 1;
//             return (ans[mid] + ans[mid + 1]) / 2.0; // ensure decimal result
//         }