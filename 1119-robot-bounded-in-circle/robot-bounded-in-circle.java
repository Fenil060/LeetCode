class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;

        int dir = 0; //0=N 1=E 2=S 3=W

        for (int i = 0; i < 4; i++) {
            for (char ch : instructions.toCharArray()) {
                if (ch == 'G') {
                    if (dir == 0)
                        y++;
                    else if (dir == 1)
                        x++;
                    else if (dir == 2)
                        y--;
                    else
                        x--;
                } else if (ch == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

            if (x == 0 && y == 0)
                return true;
        }
        return false;
    }
}
