import java.util.Scanner;

/*
<4179번 불!>
미로
사람
사람의 위치, 불이 붙은 위치
불이 붙기 전에 탈출할 수 있는지
얼마나 빨리 탈출할 수 있는지
불은 각 지점에서 네 방향으로 확산
사람은 미로의 가장자리에 접한 공간에서 탈출 가능
사람과 불은 벽이 있는 공간은 통과할 수 없음
*/
public class Main{

    private static Scanner scan = new Scanner(System.in);

    private static int r,c; // 미로 행의 개수, 열의 개수
    private static char[][] maze; // 미로

    private static void input(){
        r = scan.nextInt();
        c = scan.nextInt();
        maze = new char[r][c];
        String row;
        char block;
        for (int i = 0; i < r; i++){
            row = scan.nextLine();
            for (int j = 0; j < c; j++){
                block = row.charAt(j);
                maze[i][j] = block;
                if (block == '#'){

                }else if(block == '.'){

                }else if(block == 'J'){

                }else if(block == 'F'){

                }
            }
        }
    }

    public static void main(String[] args){
        input();
    }
}