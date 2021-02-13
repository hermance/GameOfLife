package com.esgi.cucumber.features;

import com.esgi.GameOfLife;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Overcrowding {

    private GameOfLife game;
    private boolean[][] grid;

    @Given("a grid of 3 by 3")
    public void aThreeByThreeGrid() {
        grid = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false},
        };
    }

    @And("a live cell at 0x0")
    public void aLiveCellAtZeroByZero(){
        this.grid[0][0] = true;
    }

    @And("a live cell at 0x1")
    public void aLiveCellAtZeroByOne(){
        this.grid[0][1] = true;
    }

    @And("a live cell at 0x2")
    public void aLiveCellAtZeroByTwo(){
        this.grid[0][2] = true;
    }

    @And("an alive cell at 1x1")
    public void anAliveCellAtOneByOne(){
        this.grid[1][1] = true;
    }

    @And("an alive cell at 1x0")
    public void anAliveCellAtOneByZero(){
        this.grid[1][0] = true;
    }


    @When("we calculate the next generation of the grid for overcrowding")
    public void calculateNextGenerationOfGridForOvercrowding(){
        this.game = new GameOfLife(grid);
        this.game.tick();
    }


    @Then("the cell at 0x1 dies of overcrowding")
    public void cellAtZeroByOneDiesOfOverCrowding(){
        grid = new boolean[][]{
                {true, false, true},
                {true, false, true},
                {false, false, false},
        };
        Assert.assertArrayEquals(grid, this.game.getGrid());
    }
}
