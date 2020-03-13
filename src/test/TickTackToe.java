package test;

import java.util.Random;
import java.util.Scanner;

public class  TickTackToe {
    /*
    блок настроек игры
     */
    private static char[][] map;  //матрица игры
    private static int SIZE = 3;
    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'x';
    private static final char DOT_O = 'o';
    private static Scanner sc = new Scanner(System.in);
    private static Random rnd=new Random();
    private static final boolean SILLY_MODE=false;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (GameOver(DOT_X)) {
                break;
            }
           comouterTurn();
            if (GameOver(DOT_O)) {
                break;
            }
        }
        showEnd();

    }

    private static void showEnd() {
        System.out.println("ИГРА ЗАКОНЧЕНА");
    }

    private static void initMap()
        {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++)
            {
                for(int j=0;j<SIZE;j++)
                {
                        map[i][j]=DOT_EMPTY ;
                    }
                }

        }

        private static void printMap() {
        for(int i = 0; i <= SIZE; i++){
                System.out.print(i + " ");
            }
            System.out.println();

            for(int i =0; i < SIZE; i++){
                System.out.print((i+1) + " ");
                for(int j = 0; j < SIZE; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();

        }



        private static void humanTurn()
        {
            int x, y;

            do {
                System.out.println("введите координаты ячейки");
                y = sc.nextInt() - 1;
                x = sc.nextInt() - 1;
            } while (!isCellValid(x,y));
            map[y][x]=DOT_X;


        }
        private static void comouterTurn()
        {
            int x = 0;
            int y = 0;

            if(SILLY_MODE){
                do {
                    x = rnd.nextInt(SIZE);
                    y = rnd.nextInt(SIZE);
                } while(!isCellValid(x, y));
            }
            else{
                for(int i = 0; i < SIZE; i++){
                    for(int j = 0; j < SIZE; j++){
                        // Проверяем клетки по направлениям
                    if(!isCellValid(x,y)) {
                        x = j;
                        y = i;
                    }
                    }
                }
            }
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_O;


        }

        private static boolean isCellValid(int x, int y)
        {
            boolean result = true;

            if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                result = false;
            }

            if(map[y][x]!= DOT_EMPTY){
                result = false;
            }

            return result;
        }


        private static boolean GameOver(char playerSymbol)
        {
            boolean result=false;
            printMap();
            if(checkWin(playerSymbol))
            {
                System.out.println("wins "+playerSymbol);
                result=true;
            }
            if(isMapFull())
            {
                System.out.println("nichia"+playerSymbol);
                result=true;
            }
            return result;
        }

        private static boolean isMapFull()
        {
            boolean result=true;
            for(int i=0;i<SIZE;i++)
            {
                for(int j=0;j<SIZE;j++)
                {
                    if(map[i][j]==DOT_EMPTY)
                       result=false;
                }
            }
            return result;
        }
        private static boolean checkWin(char playerSymbol)
        {
            boolean result=false;
            if(
                    (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                            (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                            (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                            (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                            (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
                result = true;
            }

            return result;

        }
}
