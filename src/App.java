import controllers.MazeSolverBFS;
import controllers.MazeSolverDFS;
import controllers.MazeSolverDP;
import controllers.MazeSolverRecursivo;
import controllers.interfaces.MazeSolver;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import models.Cell;
import models.Maze;

public class App {
    public static void main(String[] args) throws Exception {

        boolean[][] Laberinto = {
            {true, true, true, true},
            {false, true, true, true},
            {true, false, false, false},
            {true, true, true, true}
        };

        Maze maze = new Maze(Laberinto);
        System.out.println("\nLaberinto:");
        maze.printMaze();

        Cell start = new Cell(0, 3);
        Cell end = new Cell(3, 3);

        List<MazeSolver> soluciones = Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverBFS(),
            new MazeSolverDP(),
            new MazeSolverDFS()
        );

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nSeleccione un algoritmo para resolver el laberinto:");
            System.out.println("1. Recursivo");
            System.out.println("2. BFS ");
            System.out.println("3. DP ");
            System.out.println("4. DFS..");

            int opcion = scanner.nextInt(); // Puedes cambiar la opción a 2 o 3 para probar otros solucionadores
            MazeSolver solver = soluciones.get(opcion - 1); // La opción debe ser 1, 2 o 3
            List<Cell> path = solver.getPath(maze, Laberinto, start, end);

            // Imprimir el camino encontrado
            System.out.println("\nCamino Encontrado:");
            System.out.println(path);

            // Imprimir el laberinto con el camino encontrado
            System.out.println("\nLaberinto con el Camino Encontrado:");
            maze.printMazeSolver(path);
        }
    }
}
