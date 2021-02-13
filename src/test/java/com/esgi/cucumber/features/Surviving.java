package com.esgi.cucumber.features;

import com.esgi.GameOfLife;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Surviving {

    private GameOfLife game;
    private boolean[][] grid;

    @Given("a grid of 4 by 4")
    public void aFourByFourGrid() {
        grid = new boolean[][]{
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
        };
    }

    @And("a live cell at 3x2")
    public void aLiveCellAtThreeByTwo(){
        this.grid[3][2] = true;
    }

    @And("a live cell at 1x3")
    public void aLiveCellAtOneByThree(){
        this.grid[1][3] = true;
    }

    @And("a live cell at 2x3")
    public void aLiveCellAtTwoByThree(){
        this.grid[2][3] = true;
    }

    @And("a live cell at 3x3")
    public void aLiveCellAtThreeByThree(){
        this.grid[3][3] = true;
    }

    @When("we calculate the next generation of the grid for surviving")
    public void calculateNextGenerationOfGridForSurviving(){
        this.game = new GameOfLife(grid);
        this.game.tick();
    }


    @Then("the cells at 3x2, 2x3 and 3x3 survive")
    public void cellAtTrheeByTwoAndTwoByThreeAndThreeByThreeSurvive(){
        grid = new boolean[][]{
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, true},
                {false, false, true, true},
        };
        Assert.assertArrayEquals(grid, this.game.getGrid());
    }
}
