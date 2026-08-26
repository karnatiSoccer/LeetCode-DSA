class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l =0 , r = arr.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
            if(mid ==0 || mid == arr.length-1) return mid;
            if(mid != 0 && mid != arr.length-1 &&arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }
            // else if(arr[mid] == arr[mid+1]){

            // }
            else if(arr[mid] > arr[mid+1]){
                r= mid;
            }
            else{
                l =mid+1;
            }
        }
        return -1;

    }
}