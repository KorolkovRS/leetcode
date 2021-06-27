import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Solution {
    private int[][] grid;
    private int count;
    private List<Point> points = new LinkedList<>();

    class Point{
        private int i;
        private int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        boolean isFresh;
        while (true) {
//            print();
            isFresh = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        isFresh = true;
                    }
                    if (grid[i][j] == 2) {
                        messUp(i, j);
                    }
                }
            }
            if (!isFresh) {
                break;
            }
            if (points.size() == 0) {
                return -1;
            }
            update();
            points.clear();
            count++;
        }
        return count;
    }

    private void update() {
        for (Point point:points) {
            grid[point.i][point.j] = 2;
        }
    }

    private void messUp(int i, int j) {
        boolean changed = false;
        if (i > 0) {
            if (grid[i - 1][j] == 1) {
                points.add(new Point(i - 1,j));
            }
        }
        if (i < grid.length - 1)
            if (grid[i + 1][j] == 1) {
                points.add(new Point(i + 1,j));
            }

        if (j > 0) {
            if (grid[i][j - 1] == 1) {
                points.add(new Point(i,j-1));
            }
        }
        if(j < grid[i].length - 1) {
            if (grid[i][j + 1] == 1) {
                points.add(new Point(i,j+1));
            }
        }
    }

//    private void print() {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                System.out.print(grid[i][j]);
//                System.out.print(", ");
//            }
//            System.out.println();
//        }
//        System.out.println("________");
//    }

//    public static void main(String[] args) {
//        int[][] orangeMatrix = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        Solution solution = new Solution();
//        System.out.println(solution.orangesRotting(orangeMatrix));
//    }
}

//    Вам предоставляется сетка mxn, в которой каждая ячейка может иметь одно из трех значений:
//
//        0 представляет пустую ячейку,
//        1 представляет свежий апельсин или
//        2 представляет гнилой апельсин.
//        Каждую минуту любой свежий апельсин, расположенный в 4 направлениях рядом с гнилым апельсином, становится гнилым.
//
//        Верните минимальное количество минут, которое должно пройти до тех пор, пока ни в одной ячейке не появится свежий апельсин. Если это невозможно, верните значение -1.
//
//
//
//        Пример 1:
//
//
//        Вход: сетка = [[2,1,1],[1,1,0],[0,1,1]]
//        Выход: 4
//        Пример 2:
//
//        Вход: сетка = [[2,1,1],[0,1,1],[1,0,1]]
//        Выход: -1
//        Пояснение: Апельсин в левом нижнем углу (строка 2, столбец 0) никогда не гниет, потому что гниение происходит только в 4 направлениях.
//        Пример 3:
//
//        Вход: сетка = [[0,2]]
//        Выход: 0
//        Пояснение: Поскольку на 0-й минуте уже нет свежих апельсинов, ответ просто 0.
//
//
//        Ограничения:
//
//        m == сетка.длина
//        n == сетка[i].длина
//        1 <= m, n <= 10
//        сетка[i][j] равна 0, 1 или 2.
