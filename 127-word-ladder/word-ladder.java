class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        HashSet<String> vis = new HashSet<>();
        vis.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                String word = q.poll();

                if(word.equals(endWord)) return level;

                char[] arr = word.toCharArray();

                for(int pos = 0; pos < arr.length; pos++){
                    char original = arr[pos];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[pos] = ch;
                        String newWord = new String(arr);

                        if(dict.contains(newWord) && !vis.contains(newWord)){
                            vis.add(newWord);
                            q.add(newWord);
                        }
                    }
                    arr[pos] = original;
                }
            }
            level++;
        }
    return 0;
    }
}