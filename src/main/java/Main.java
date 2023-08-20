import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int M, N, L  = 0;
    private static final int MAX = 1000000001;
    private static int[][] grid = new int[MAX][MAX];
    private static boolean[][] visited = new boolean[MAX][MAX];
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄
        M = Integer.parseInt(st.nextToken());  // 사대의 수
        N = Integer.parseInt(st.nextToken());  // 동물의 수
        L = Integer.parseInt(st.nextToken());  // 사정거리

        st = new StringTokenizer(br.readLine());  // 두 번째 줄
        for(int i=0; i<M; i++){
            grid[0][Integer.parseInt(st.nextToken())] = 2;  // 사대 2로 초기화
        }

        for(int i=0; i<N; i++){  // 동물의 수만큼 초기화
            st = new StringTokenizer(br.readLine());
            grid[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;  // 동물 1로 초기화
        }

        for(int i=0; i<MAX; i++){
            if(grid[0][i]==2){
                bfs(0,i);
            }
        }
    }

    private static void bfs(int[][] grid, int start_i, int start_j){
        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(start_i, start_j));
        visited[start_i][start_j] = true;

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            int i = currentCell.row;
            int j = currentCell.col;
            System.out.println("Visiting cell at (" + i + ", " + j + ")"); // Print the visited cell

            for (int k = 0; k < 4; k++) { // Four directions: up, down, left, right
                int ni = i + dr[k];
                int nj = j + dc[k];

                // Check if the new cell (ni, nj) is within the grid boundaries
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && !visited[ni][nj]) {
                    queue.add(new Cell(ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }
    }

    static class Cell {
        int row;
        int col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}


public class BFSTraversalOn2DArray {

    public static void BFS_2D_Array(int[][] grid, int start_i, int start_j) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Define the directions for exploring neighbors (up, down, left, right)
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(start_i, start_j));
        visited[start_i][start_j] = true;

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            int i = currentCell.row;
            int j = currentCell.col;
            System.out.println("Visiting cell at (" + i + ", " + j + ")"); // Print the visited cell

            for (int k = 0; k < 4; k++) { // Four directions: up, down, left, right
                int ni = i + dr[k];
                int nj = j + dc[k];

                // Check if the new cell (ni, nj) is within the grid boundaries
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && !visited[ni][nj]) {
                    queue.add(new Cell(ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        int start_i = 1;
        int start_j = 2;

        System.out.println("Starting BFS traversal from cell (1, 2) in the 2D array.");
        BFS_2D_Array(grid, start_i, start_j);
    }
}