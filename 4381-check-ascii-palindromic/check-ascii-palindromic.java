class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            String binary = generate(ascii);
            sb.append(binary);
        }

        int st = 0;
        s = sb.toString();
        int end = s.length() - 1;

        while (st < end) {
            if (s.charAt(st) != s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public String generate(int ascii) {
        String binary = "";

        while (ascii > 0) {
            binary = (ascii % 2) + binary;
            ascii /= 2;
        }

        while (binary.length() < 8) {
            binary = "0" + binary;
        }

        return binary;
    }
}