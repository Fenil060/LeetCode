class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (List<String> access : access_times) {
            String name = access.get(0);
            String time = access.get(1);

            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(2));

            int totalMinute = hour * 60 + minute;

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(totalMinute);
        }

        List<String> ans = new ArrayList<>();

        for (String employee : map.keySet()) {
            List<Integer> times = map.get(employee);

            if (times.size() < 3)
                continue;

            Collections.sort(times);

            for (int i = 0; i <= times.size() - 3; i++) {
                if (times.get(i + 2) - times.get(i) < 60) {
                    ans.add(employee);
                    break;
                }
            }
        }
        return ans;
    }
}