package controllers;

import controllers.interfaces.MazeSolver;
import java.util.ArrayList;
import java.util.List;
import models.Cell;

public class MazeSolverBFS implements MazeSolver{
     @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end){
        System.out.println("Implementacion recursiva");
        List<Cell> lista = new ArrayList<>();
        return lista;
    }
}
