class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[q.poll()]= deck[i];
            q.add(q.poll());
        }
        return res;
    }
}

/*

2 3 5 7 11 13 17

2 13 3 11 5 17 7

2 3 5 7 
0 2 4 6

11 13 17

3  


13 11 
*/