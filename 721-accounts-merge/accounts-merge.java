class Solution {

    static class DSU {
        int parent[];
        int size[];

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DSU dsu = new DSU(n);

        HashMap<String, Integer> emailMap = new HashMap<>();

        for(int i=0; i<n; i++){
            List<String> account = accounts.get(i);

            for(int j=1; j<account.size(); j++){
                String email = account.get(j);

                if(!emailMap.containsKey(email)){
                    emailMap.put(email, i);
                }else{
                    dsu.union(i, emailMap.get(email));
                }
            }
        }

        HashMap<Integer, List<String>> merged = new HashMap<>();

        for(String email : emailMap.keySet()){
            int accountIdx = emailMap.get(email);
            int parent = dsu.find(accountIdx);
            merged.putIfAbsent(parent, new ArrayList<>());
            merged.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int parent : merged.keySet()){
            List<String> emails = merged.get(parent);

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(parent).get(0));

            temp.addAll(emails);
            ans.add(temp);
        }

    return ans;
    }
}