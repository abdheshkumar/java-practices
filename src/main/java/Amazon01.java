class CountryNumberCal {
    private int m;
    private int n;
    private int matrix[][];
    private boolean visited[][];

    CountryNumberCal(int matrix[][], int m, int n) {
        this.matrix = matrix; this.m = m; this.n = n;

        visited = new boolean[m][n];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                visited[i][j] = false;
    }

    private boolean canMove(int i, int j, int v){
        if (i<0 || j<0 || i>=m || j>=n) return false;
        if ((!isVisited(i,j)) &&  v==matrix[i][j])
            return true;
        return false;
    }

    private void DFS(int i, int j, int v){
        if (canMove(i,j, v)){
            visited[i][j] = true;

            DFS(i-1,j, v); // up
            DFS(i+1,j, v); // down
            DFS(i,j-1, v); // left
            DFS(i,j+1, v); // right
        }
    };

    private boolean isVisited(int i, int j) {
        return visited[i][j];
    }
    public int getCountryNumber(){
        int count = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (!isVisited(i,j)){
                    count ++;
                    DFS(i,j, matrix[i][j]);
                }

        return count;
    }

    public static void main(String[] args) {
        int m1[][]= {{1,1,1,0},{1,1,0,0},{0,0,0,1}};

        CountryNumberCal m = new CountryNumberCal(m1, 3, 4);
        System.out.println(m.getCountryNumber());

        int m2[][]= {{1,1,1,1},{0,0,0,0},{1,0,0,1}};

        m = new CountryNumberCal(m2, 3, 4);
        System.out.println(m.getCountryNumber());

        int m3[][]= {{1,0,1,1},{0,1,0,0},{0,0,1,1},{1,1,0,1}};

        m = new CountryNumberCal(m3, 4, 4);
        System.out.println(m.getCountryNumber());

    }

    /**
     *Use a array to find set of points in the island
     *for each point that is not zero
     *try to get corresponding set from the map, otherwise create new set
     *add point to set and map point to set
     *Use DFS get surrounding points (i.e., check left, right, up, down -
     *  or optimize since you know you've already checked the points that come before it in the array)
     *  and for each one that is not zero add it to the set and map it to the set
     */
}