package com.esgi;

public class GameOfLife {

    // this is the grid that will contain our cells
    private boolean[][] grid;
    private int generation = 0;

    public static void main(String[] args) {
        // we populate our grid of 7*7 with those starting cells
        // a cell at true is alive, a cell at false is dead
        /*
        boolean[][] grid = new boolean[][]{
                {true, true, false, true, false, false, false},
                {true, false, true, false, false, false, false},
                {true, false, false, true, false, true, true},
                {true, false, false, false, false, true, false},
                {false, false, false, true, true, false, true},
                {true, true, false, false, false, true, true},
                {true, true, true, false, false, true, true}
        };
        */
        boolean[][] grid = new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, false, false},
        };

        // we launch the game of life by initializing it
        GameOfLife game = new GameOfLife(grid);

        // we will calculate (and display) the grid for four next generations
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
    private void tick() {
        this.generation ++;
        System.out.println("Tick ! This is generation number " + this.generation);

        // we apply the four rules of this game of life
        applyUnderpopulation();
        applyOvercrowding();
        applySurviving();
        applyResuscitation();

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

    // Rule 1 : Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    private void applyUnderpopulation(){
        int width = this.grid[0].length;
        int length = this.grid[1].length;
        boolean[][] newGrid = new boolean[width][length];

        // we will explore our grid cell by cell, line by line
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                // this is the cell we are looking at
                boolean currentCell = this.grid[i][j];
                // those are the neighbour cell that we want to check to apply the rule
                int aliveCloser = getAliveNeighbours(i, j, width, length);
                if(currentCell && aliveCloser < 2){
                    // that cell will die of underpopulation
                    newGrid[i][j] = false;
                }else{
                    // if this rule doesn't apply, we keep the old state (alive or dead)
                    newGrid[i][j] = this.grid[i][j];
                }
            }
        }
        this.grid = newGrid;
    }

    private void applyOvercrowding(){

    }

    private void applySurviving(){

    }

    private void applyResuscitation(){

    }

}
