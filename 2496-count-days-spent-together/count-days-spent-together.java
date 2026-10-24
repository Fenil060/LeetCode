class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceArriveDate = Integer.parseInt(arriveAlice.substring(3));

        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDate = Integer.parseInt(leaveAlice.substring(3));

        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobArriveDate = Integer.parseInt(arriveBob.substring(3));

        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDate = Integer.parseInt(leaveBob.substring(3));

        int aliceStart = aliceArriveDate;
        int aliceEnd = aliceLeaveDate;
        int bobStart = bobArriveDate;
        int bobEnd = bobLeaveDate;

        for (int i = 0; i < aliceArriveMonth - 1; i++) {
            aliceStart += days[i];
        }

        for (int i = 0; i < aliceLeaveMonth - 1; i++) {
            aliceEnd += days[i];
        }

        for (int i = 0; i < bobArriveMonth - 1; i++) {
            bobStart += days[i];
        }

        for (int i = 0; i < bobLeaveMonth - 1; i++) {
            bobEnd += days[i];
        }

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }
}