package controllers;

import controllers.interfaces.MazeSolver;
import java.util.ArrayList;
import java.util.List;
import models.Cell;
import models.Maze;

public class MazeSolverBFS implements MazeSolver{
     @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end){
        System.out.println("Implementacion recursiva");
        List<Cell> lista = new ArrayList<>();
        return lista;
    }
}
