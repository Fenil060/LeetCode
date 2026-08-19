class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashSet<Integer> row = new HashSet<>();

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int r = seat[0];
            int c = seat[1];
            row.add(r);
            map.putIfAbsent(r, new HashSet<>());
            map.get(r).add(c);
        }

        int count = 0;
        for (int key : map.keySet()) {
            Set<Integer> set = map.get(key);
            boolean first = true;
            boolean second = true;
            boolean third = true;
            for (int i = 2; i <= 5; i++) {
                if (set.contains(i)) {
                    first = false;
                    break;
                }
            }
            //first true check third
            if (first) {
                count++;
                for (int i = 6; i <= 9; i++) {
                    if (set.contains(i)) {
                        third = false;
                        break;
                    }
                }
                if (third) {
                    count++;
                }
            } else { //first false check second
                for (int i = 4; i <= 7; i++) {
                    if (set.contains(i)) {
                        second = false;
                        break;
                    }
                }
                if (second) {
                    count++;
                } else {
                    for (int i = 6; i <= 9; i++) {
                        if (set.contains(i)) {
                            third = false;
                            break;
                        }
                    }
                    if(third){
                        count++;
                    }
                }
            }
        }

        int remaining = n - row.size();
        return count + (remaining * 2);
    }
}

//  int mat[][] = new int[n][11];
//         int count = 0;

//         for (int i = 0; i < reservedSeats.length; i++) {
//             int r = reservedSeats[i][0];
//             int c = reservedSeats[i][1];
//             mat[r - 1][c] = -1;
//         }

//         for (int i = 0; i < mat.length; i++) {
//             boolean first = true;
//             boolean second = true;
//             boolean third = true;
//             for (int j = 2; j <= 5; j++) {
//                 if (mat[i][j] == -1) {
//                     first = false;
//                     break;
//                 }
//             }

//             if (first) {
//                 count++;
//                 for (int j = 6; j <= 9; j++) {
//                     if (mat[i][j] == -1) {
//                         third = false;
//                         break;
//                     }
//                 }
//                 if (third) {
//                     count++;
//                 }
//             } else {
//                 for (int j = 4; j <= 7; j++) {
//                     if (mat[i][j] == -1) {
//                         second = false;
//                         break;
//                     }
//                 }
//                 if (second) {
//                     count++;
//                 } else {
//                     for (int j = 6; j <= 9; j++) {
//                         if (mat[i][j] == -1) {
//                             third = false;
//                             break;
//                         }
//                     }
//                     if (third) {
//                         count++;
//                     }
//                 }
//             }

//         }
//         return count;