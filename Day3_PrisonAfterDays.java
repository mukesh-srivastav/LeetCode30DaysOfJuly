class Day3_PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int prev[] = null;
        N=N%14==0?14:N%14;
        for (int i=0; i<N; i++) {
            prev = new int[8];
            
            for (int j=0; j<8; j++) {
                if (j==0 || j==7)
                    prev[j] = 0;
                else 
                    prev[j] = (cells[j-1] == cells[j+1]) ? 1 : 0;
            }
            cells = prev;
        }
        
        return cells;
    }
}