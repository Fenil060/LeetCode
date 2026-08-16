class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0; i<drones.length; i++){
            int x1 = drones[i][0];
            int y1 = drones[i][1];
            int r1 = drones[i][2];

            int x2 = target[0];
            int y2 = target[1];

            int d = Math.abs(x2-x1) + Math.abs(y2-y1);
            if(d <= r1){
                if(d < dist){
                    dist = d;
                    idx = i;
                }
            }
        }
    return idx;
    }
}