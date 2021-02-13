package com.esgi.cucumber.features;

import com.esgi.GameOfLife;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Resuscitation {

    private GameOfLife game;
    private boolean[][] grid;

    @Given("a grid of 6 by 6")
    public void aSixBySixGrid() {
        grid = new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        };
    }

    @And("a live cell at 0x4")
    public void aLiveCellAtZeroByFour(){
        this.grid[0][4] = true;
    }

    @And("a live cell at 0x5")
    public void aLiveCellAtZeroByFive(){
        this.grid[0][5] = true;
    }

    @And("a live cell at 1x5")
    public void aLiveCellAtOneByFive(){
        this.grid[1][5] = true;
    }

    @When("we calculate the next generation of the grid for resuscitation")
    public void calculateNextGenerationOfGridForResuscitation(){
        this.game = new GameOfLife(grid);
        this.game.tick();
    }


    @Then("the cell at 1x4 resuscitates")
    public void cellAtOneByFourResuscitate(){
        grid = new boolean[][]{
                {false, false, false, false, true, true},
                {false, false, false, false, true, true},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
        };
        Assert.assertArrayEquals(grid, this.game.getGrid());
    }
}
