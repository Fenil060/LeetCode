class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int st = 0;
        int end = period;

        Arrays.sort(lights);
        Arrays.sort(arrivalTime);
        int ans = Integer.MAX_VALUE;

        while(st < end){
            int mid = st + (end-st)/2;

            if(possible(mid, period, lights, arrivalTime)){
                ans = mid;
                end = mid;
            }else{
                st = mid+1;
            }
        }
    return ans;
    }

    public boolean possible(int m, int p, int []l, int []a){

        for(int i=0; i<a.length; i++){
            int rem = a[i] % p;
            int maxLight = l[l.length-1];

            if(rem >= maxLight){
                int waitingTime = p - rem;
                if(waitingTime > m){
                    return false;
                }
            }
        }
    return true;
    }
}