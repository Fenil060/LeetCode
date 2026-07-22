class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                map1.put(secret.charAt(i), map1.getOrDefault(secret.charAt(i), 0)+1);
                map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0)+1);
            }
        }
        int cow = 0;
        for(char key : map1.keySet()){
            cow += Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }
    String str = bulls+"A"+cow+"B";
    return str;
    }
}