class Solution {
    public String bestHand(int[] rank, char[] card) {
        if (allCardSame(card)) return "Flush";
        if (threeOfKind(rank)) return "Three of a Kind";
        if (pair(rank)) return "Pair";
        if (highCard(rank)) return "High Card";
        return "";
    }

    private static boolean highCard(int[] rank) {
        for (int i = 0; i < rank.length - 1; i++) {
            for (int j = i+1; j < rank.length; j++) {
                if (rank[i] == rank[j]) return false;
            }
        }
        return true;
    }

    private static boolean pair(int[] rank) {
        int two = 0;
        for (int i = 0; i < rank.length - 1; i++) {
            int n = 1;
            for (int j = i+1; j < rank.length; j++) {
                if (rank[i] == rank[j]) {
                    n++;
                }
            }
            if (n < 2) continue;
            if (n > 2) return false;
            two = n;
        }
        return two == 2;
    }

    private static boolean threeOfKind(int[] rank) {
        for (int i = 0; i < rank.length - 1; i++) {
            int n = 1;
            for (int j = i+1; j < rank.length; j++) {
                if (rank[i] == rank[j]) n++;
            }
            if (n >= 3) return true;
        }
        return false;
    }

    private static boolean allCardSame(char[] card) {
        for (char c : card) {
            if (card[0] != c) return false;
        }
        return true;
    }
}