package com.esgi.cucumber.features;

import com.esgi.GameOfLife;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Underpopulation {

    private GameOfLife game;
    private boolean[][] grid;

    @Given("a grid of 5 by 5")
    public void aFiveByFiveGrid() {
        grid = new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
    }
    @And("a live cell at 1x1")
    public void aLiveCellAtOneByOne(){
        this.grid[1][1] = true;
    }

    @And("a live cell at 1x2")
    public void aLiveCellAtOneByTwo(){
        this.grid[1][2] = true;
    }

    @When("we calculate the next generation of the grid for underpopulation")
    public void calculateNextGenerationOfGridForUnderpopulation(){
        this.game = new GameOfLife(grid);
        this.game.tick();
    }

    @Then("both of the cells die of underpopulation")
    public void bothCellsDie(){
        grid = new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
        Assert.assertArrayEquals(grid, this.game.getGrid());
    }

}
