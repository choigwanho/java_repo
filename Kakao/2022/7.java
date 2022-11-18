class Solution {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int N,M;
    boolean[][] vis = new boolean[5][5];
    int[][] block = new int[5][5];

    public boolean OOB(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    public int solve(int curx, int cury, int opx, int opy){
        if(vis[curx][cury]) return 0;
        int ret = 0;

        for (int dir=0; dir<4; dir++){
            int nx = curx+dx[dir];
            int ny = cury+dy[dir];
            if (OOB(nx,ny) || vis[nx][ny] || block[nx][ny]==0)
                continue;
            vis[curx][cury]=true;
            int val = solve(opx,opy,nx,ny)+1;
            vis[curx][cury]=false;

            if (ret % 2 ==0 && val % 2 == 1) ret = val;
            else if (ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret, val);
            else if (ret % 2 == 1 && val % 2 == 1) ret = Math.min(ret, val);
        }
        return ret;
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                block[i][j] = board[i][j];
        return solve(aloc[0],aloc[1],bloc[0],bloc[1]);
    }
}