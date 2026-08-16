class Solution {
    public int maximumGap(String skill, String station) {
        int st = 0;
        int end = station.length() - 1;

        int ans = 0;

        int left[] = new int[skill.length()];
        int right[] = new int[skill.length()];

        int idx = 0;
        for (int i = 0; i < skill.length(); i++) {
            while (station.charAt(idx) != skill.charAt(i)) {
                idx++;
            }
            left[i] = idx;
            idx++;
        }

        idx = station.length() - 1;
        for (int i = skill.length() - 1; i >= 0; i--) {
            while (station.charAt(idx) != skill.charAt(i)) {
                idx--;
            }
            right[i] = idx;
            idx--;
        }

        for (int i = 0; i < skill.length() - 1; i++) {
            ans = Math.max(ans, right[i + 1] - left[i]);
        }
        return ans;
    }
}