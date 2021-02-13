package com.esgi;

public class GameOfLife {

    // this is the grid that will contain our cells
    private boolean[][] grid;
    private int generation = 0;

    public static void main(String[] args) {
        // we populate our grid of 7*7 with those starting cells
        // a cell at true is alive, a cell at false is dead

        boolean[][] grid = new boolean[][]{
                {true, true, false, true, false, false, false},
                {true, false, true, false, false, false, false},
                {true, false, false, true, false, true, true},
                {true, false, false, false, false, true, false},
                {false, false, false, true, true, false, true},
                {true, true, false, false, false, true, true},
                {true, true, true, false, false, true, true}
        };

        // we launch the game of life by initializing it
        GameOfLife game = new GameOfLife(grid);

        // we will calculate (and display) the grid for 5 next generations
        game.tick();
        game.tick();
        game.tick();
        game.tick();
        game.tick();

    }

    public GameOfLife(final boolean[][] grid) {
        System.out.println("Starting grid : ");
        this.grid = grid;
        this.displayGrid();
    }

    // this function allows to display our global grid at any given time and state
    private void displayGrid(){
        for (int i = 0; i < this.grid[0].length; i++)
        {
            // separator between cells for more visibility
            System.out.print(" | ");
            for (int j = 0; j <  this.grid[1].length; j++)
            {
                // we go through all our cells
                // and display if they are alive or not
                if(this.grid[i][j]){
                    // the cell is alive (at this position, we have a true boolean)
                    System.out.print("X");
                }else{
                    // the cell is dead (at this position, we have a false boolean)
                    System.out.print("O");
                }
                // separator between cells for more visibility
                System.out.print(" | ");
            }
            // jumps a line
            System.out.println();
        }
        // jumps a line
        System.out.println();
    }

    // this represents a tick or jump to the next generation of the grid
    public void tick() {
        this.generation ++;
        System.out.println("Tick ! This is generation number " + this.generation);

        int width = this.grid[0].length;
        int length = this.grid[1].length;
        boolean[][] newGrid = new boolean[width][length];

        // we will explore our grid cell by cell, line by line
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                // with that boolean we will know if a cell was modified by one of the laws
                boolean wasModified = false;

                // this is the cell we are looking at
                boolean currentCell = this.grid[i][j];
                // those are the neighbour cells that we want to check to apply the rule
                int aliveCloser = getAliveNeighbours(i, j, width, length);

                if(currentCell && aliveCloser < 2){
                    // Rule 1 : Any live cell with fewer than two live neighbours dies, as if caused by underpopulation
                    newGrid[i][j] = false;
                    wasModified = true;
                }
                if(currentCell && aliveCloser > 3){
                    // Rule 2 : Any live cell with more than three live neighbours dies, as if by overcrowding
                    newGrid[i][j] = false;
                    wasModified = true;
                }
                if(currentCell && (aliveCloser == 2 || aliveCloser == 3)){
                    // Rule 3 : Any live cell with two or three live neighbours lives on to the next generation
                    newGrid[i][j] = true;
                    wasModified = true;
                }
                if(!currentCell && aliveCloser == 3){
                    // Rule 4 : Any dead cell with exactly three live neighbours becomes a live cell.
                    newGrid[i][j] = true;
                    wasModified = true;
                }
                if(!wasModified){
                    // if no rule has been applied
                    // the cell of the new grid is initialize at the state of the previous grid (alive or dead)
                    newGrid[i][j] = this.grid[i][j];
                }
            }
        }
        this.grid = newGrid;

        // we want to see what that generation is like (new alive and dead cells)
        displayGrid();
    }

    private int getAliveNeighbours(int i, int j, int width, int length){
        int[][] cellsToCheck = {
                {i - 1, j - 1},
                {i - 1, j},
                {i - 1, j + 1},
                {i, j + 1},
                {i + 1, j + 1},
                {i + 1, j},
                {i + 1, j - 1},
                {i, j - 1},
        };
        // we will add any alive neighbour to this count
        int aliveCloser = 0;

        // we loop on the neighbours to chek if they are alive
        for (int[] ints : cellsToCheck) {
            int rowToCheck = ints[0];
            int colToCheck = ints[1];
            // we check if we are inside the grid and if the checked cell is alive
            if (rowToCheck >= 0 && colToCheck >= 0 && rowToCheck < width && colToCheck < length) {
                boolean cellToCheck = this.grid[rowToCheck][colToCheck];
                if (cellToCheck) {
                    aliveCloser++;
                }
            }
        }
        return aliveCloser;
    }

    public boolean[][] getGrid() {
        return grid;
    }
}
