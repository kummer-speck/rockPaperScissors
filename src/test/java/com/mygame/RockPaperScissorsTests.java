package com.mygame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RockPaperScissorsTests {

    RockPaperScissors testGame;
    Random testRandom;
    int randomChoiceTest;
    String userInputTest;

    @BeforeEach
    public void setUpTests() {
        testGame = new RockPaperScissors();
        testRandom = new Random();
        randomChoiceTest = testRandom.nextInt(3);
    }

    @Test
    public void randomTest() {
        boolean result = (randomChoiceTest >= 0 && randomChoiceTest < 3);
        assertTrue(result);
    }

    @Test
    public void playShouldReturnInvalid() {
        String result = testGame.play("lock");
        assertEquals("null: Invalid play", result);
    }

    @Test
    public void shouldPickDraw() {
        String result = testGame.pickWinner("paper", "paper");
        assertEquals("Draw", result);
    }

    @Test
    public void shouldPickCPU1() {
        String result = testGame.pickWinner("paper", "scissors");
        assertEquals("CPU", result);
    }

    @Test
    public void shouldPickCPU2() {
        String result = testGame.pickWinner("rock", "paper");
        assertEquals("CPU", result);
    }

    @Test
    public void shouldPickCPU3() {
        String result = testGame.pickWinner("scissors", "rock");
        assertEquals("CPU", result);
    }

    @Test
    public void shouldPickPlayer1() {
        String result = testGame.pickWinner("paper", "rock");
        assertEquals("Player", result);
    }

    @Test
    public void shouldPickPlayer2() {
        String result = testGame.pickWinner("rock", "scissors");
        assertEquals("Player", result);
    }

    @Test
    public void shouldPickPlayer3() {
        String result = testGame.pickWinner("scissors", "paper");
        assertEquals("Player", result);
    }

    @Test
    public void winMessagePlayer() {
        String result = testGame.winMessage("Player");
        assertEquals("Player wins!", result);
    }

    @Test
    public void winMessageCPU() {
        String result = testGame.winMessage("CPU");
        assertEquals("CPU wins!", result);
    }

    @Test
    public void winMessageDraw() {
        String result = testGame.winMessage("Draw");
        assertEquals("It's a draw.", result);
    }

    @Test
    public void winMessageGameNumber() {
        testGame.winMessage("Player");
        int result = testGame.getGameNumber();
        assertEquals(2, result);
    }


}
