package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.interfaces.MazeSolver;
import models.Cell;
import models.Maze;

public class MazeSolverDP implements MazeSolver {

    private Map<Cell, Boolean> memoria = new HashMap<>();

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();

        if (grid == null || grid.length == 0)
            return path;

        if (findPath(grid, start.row, start.col, end, path))
            return path;

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {

        Cell cell = new Cell(row, col);

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col] || memoria.containsKey(cell))
            return false;

        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }

        memoria.put(cell, false);


        if (findPath(grid, row, col + 1, end, path) ||  // Derecha
            findPath(grid, row + 1, col, end, path) ||  // Abajo
            findPath(grid, row, col - 1, end, path) ||  // Izquierda
            findPath(grid, row - 1, col, end, path)) {  // Arriba
            path.add(cell); 
            memoria.put(cell, true); 
            return true;
        }   
        return false;
    }
}
