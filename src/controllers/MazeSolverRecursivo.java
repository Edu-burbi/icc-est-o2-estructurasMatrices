package controllers;

import controllers.interfaces.MazeSolver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.Cell;
import models.Maze;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();

        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(maze, grid, start.row, start.col, end, start, path, visitadas)) {
            return path;
        }

        /*    return new ArrayList<>();    */
        return path;
    }

    private boolean findPath(Maze maze, boolean[][] grid, int row, int col, Cell end,Cell start, List<Cell> path, Set<Cell> visitadas) {

        Cell cell = new Cell(row, col);

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) 
        return false;
        
        if (visitadas.contains(cell)) {
            return false;
        }

        visitadas.add(cell);
        path.add(cell);  // Agregar la celda al camino mientras la exploramos
        maze.updateMaze(cell, start, end);



        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }

/* 
        if (findPath(grid, row + 1, col, end, path) ||  // Abajo
        findPath(grid, row, col + 1, end, path) ||  // Derecha
        findPath(grid, row - 1, col, end, path) ||  // Arriba
        findPath(grid, row, col - 1, end, path)) {  // Izquierda

        // Si encontramos un camino válido, agregamos la celda al camino
        path.add(cell);
        memoria.put(cell, true); // Marcamos como exitosa
        return true;
    }
*/
        if (findPath(maze, grid, row, col + 1, end, start, path, visitadas) ||  // Derecha
            findPath(maze, grid, row + 1, col, end, start, path, visitadas) ||  // Abajo
            findPath(maze, grid, row, col - 1, end, start, path, visitadas) ||  // Izquierda
            findPath(maze, grid, row - 1, col, end, start, path, visitadas)) {  // Arriba

            path.add(cell); 
            return true;
        }

        visitadas.remove(cell);
        /*   path.remove(cell);   */
        return false;
    }
}
