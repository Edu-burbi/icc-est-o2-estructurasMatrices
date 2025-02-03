import java.util.Arrays;
import java.util.List;
import controllers.MazeSolverBFS;
import controllers.MazeSolverRecursivo;
import controllers.interfaces.MazeSolver;
import models.Cell;
import models.Maze;

public class App {
    public static void main(String[] args) throws Exception {

        boolean[][] Laberinto = {

            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        Maze maze = new Maze(Laberinto);
        System.out.println("\nLaberinto");
        maze.printMaze();

        Cell start = new Cell(0,3);
        Cell end = new Cell(3,3);

        List<MazeSolver> soluciones = Arrays.asList(new MazeSolverRecursivo(), new MazeSolverBFS());

        int opcion = 1;

        MazeSolver solver = soluciones.get(1-1);
        List<Cell> path = solver.getPath(Laberinto, start, end);

        System.out.println("\nCamino Encontrado");
        System.out.println(path);


    }
}
