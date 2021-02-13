package com.esgi.cucumber.features;

import com.esgi.GameOfLife;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class General {

    private GameOfLife game;
    private boolean[][] grid;

    @Given("a 7x7 grid")
    public void aSevenBySevenGrid() {
        grid = new boolean[][]{
                {true, true, false, true, false, false, false},
                {true, false, true, false, false, false, false},
                {true, false, false, true, false, true, true},
                {true, false, false, false, false, true, false},
                {false, false, false, true, true, false, true},
                {true, true, false, false, false, true, true},
                {true, true, true, false, false, true, true}
        };
    }


    @When("we calculate the next generation of the grid")
    public void calculateNextGenerationOfGrid(){
        this.game = new GameOfLife(grid);
        this.game.tick();
    }


    @Then("the grid will be")
    public void resultGrid(){
        grid = new boolean[][]{
                {true, true, true, false, false, false, false},
                {true, false, true, true, true, false, false},
                {true, false, false, false, true, true, true},
                {false, false, false, true, false, false, false},
                {true, true, false, false, true, false, true},
                {true, false, false, true, false, false, false},
                {true, false, true, false, false, true, true}
        };
        Assert.assertArrayEquals(grid, this.game.getGrid());
    }
}
