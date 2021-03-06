package com.mygame;

import java.util.*;

public class RockPaperScissors {

    private final List<String> PLAYS = new ArrayList<>(Arrays.asList("rock", "paper", "scissors"));
    private final List<String> OUTCOMES = new ArrayList<>(Arrays.asList("Draw", "CPU", "Player"));
    private final Random random = new Random();
    private int gameNumber = 1;
    private int randomChoice;
    private String userInput;
    private String playerName;
    private char playAgain;
    private int cpuWins = 0;
    private int playerWins = 0;
    private int numOfDraws = 0;


    public void start() {
        System.out.println("====================================\n" +
                "| Welcome to Rock, Paper, Scissors |" +
                "\n====================================");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your name:");
        playerName = keyboard.next();

        do {
            System.out.printf("************\nMake your play:\n");
            userInput = keyboard.next();

            System.out.println(play(userInput));

            System.out.printf("%s's wins: %d | CPU wins: %d | Draws: %d\n%s, would you like to play again? (y/n)\n",
                    playerName,
                    playerWins,
                    cpuWins,
                    numOfDraws,
                    playerName);

            playAgain = keyboard.next().toLowerCase().charAt(0);


        } while (playAgain == 'y');

    }

    public String play(String userInput) {
        String playerChoice = userInput.toLowerCase();

        if(validPlayCheck(playerChoice)) {
            randomChoice = random.nextInt(3);
            String cpuChoice = PLAYS.get(randomChoice);

            System.out.printf("\nGAME: %d\nCPU played: %s\n",
                    gameNumber,
                    cpuChoice);

            String winner = pickWinner(playerChoice, cpuChoice);

            return winMessage(winner);
        }

        return playerName + ": Invalid play";

    }

    public boolean validPlayCheck(String choice) {
        return PLAYS.contains(choice);

    }

    public String pickWinner(String playerThrow, String cpuThrow) {

        if(playerThrow.equals(cpuThrow)){
            return OUTCOMES.get(0);
        } else if(playerThrow.equals(PLAYS.get(0))) {
            if(cpuThrow.equals(PLAYS.get(1))){
                return OUTCOMES.get(1);
            } else {
                return OUTCOMES.get(2);
            }
        } else if(playerThrow.equals(PLAYS.get(1))) {
            if(cpuThrow.equals(PLAYS.get(2))) {
                return OUTCOMES.get(1);
            } else {
                return OUTCOMES.get(2);
            }
        } else {
            //player throws scissors
            if(cpuThrow.equals(PLAYS.get(0))) {
                return OUTCOMES.get(1);
            } else {
                return OUTCOMES.get(2);
            }
        }

    }


    public String winMessage(String winner) {
        gameNumber++;
        String draw = "It's a draw.";
        String player = "Player wins!\n";
        String cpu = "CPU wins!\n";
        String winGraphic = "                                   .''.       \n" +
                "       .''.      .        *''*    :_\\/_:     . \n" +
                "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\n" +
                "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\n" +
                " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\n" +
                " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\n" +
                "  '..'  ':::'     * /\\ *     .'/.\\'.   '\n" +
                "      *            *..*         :\n" +
                "        *\n" +
                "        *\n";

        String loseGraphic = "      _____                   _______                   _____                            _____           _______                   _____                    _____          \n" +
                "     |\\    \\                 /::\\    \\                 /\\    \\                          /\\    \\         /::\\    \\                 /\\    \\                  /\\    \\         \n" +
                "     |:\\____\\               /::::\\    \\               /::\\____\\                        /::\\____\\       /::::\\    \\               /::\\    \\                /::\\    \\        \n" +
                "     |::|   |              /::::::\\    \\             /:::/    /                       /:::/    /      /::::::\\    \\             /::::\\    \\              /::::\\    \\       \n" +
                "     |::|   |             /::::::::\\    \\           /:::/    /                       /:::/    /      /::::::::\\    \\           /::::::\\    \\            /::::::\\    \\      \n" +
                "     |::|   |            /:::/~~\\:::\\    \\         /:::/    /                       /:::/    /      /:::/~~\\:::\\    \\         /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" +
                "     |::|   |           /:::/    \\:::\\    \\       /:::/    /                       /:::/    /      /:::/    \\:::\\    \\       /:::/__\\:::\\    \\        /:::/__\\:::\\    \\    \n" +
                "     |::|   |          /:::/    / \\:::\\    \\     /:::/    /                       /:::/    /      /:::/    / \\:::\\    \\      \\:::\\   \\:::\\    \\      /::::\\   \\:::\\    \\   \n" +
                "     |::|___|______   /:::/____/   \\:::\\____\\   /:::/    /      _____            /:::/    /      /:::/____/   \\:::\\____\\   ___\\:::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" +
                "     /::::::::\\    \\ |:::|    |     |:::|    | /:::/____/      /\\    \\          /:::/    /      |:::|    |     |:::|    | /\\   \\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\ \n" +
                "    /::::::::::\\____\\|:::|____|     |:::|    ||:::|    /      /::\\____\\        /:::/____/       |:::|____|     |:::|    |/::\\   \\:::\\   \\:::\\____\\/:::/__\\:::\\   \\:::\\____\\\n" +
                "   /:::/~~~~/~~       \\:::\\    \\   /:::/    / |:::|____\\     /:::/    /        \\:::\\    \\        \\:::\\    \\   /:::/    / \\:::\\   \\:::\\   \\::/    /\\:::\\   \\:::\\   \\::/    /\n" +
                "  /:::/    /           \\:::\\    \\ /:::/    /   \\:::\\    \\   /:::/    /          \\:::\\    \\        \\:::\\    \\ /:::/    /   \\:::\\   \\:::\\   \\/____/  \\:::\\   \\:::\\   \\/____/ \n" +
                " /:::/    /             \\:::\\    /:::/    /     \\:::\\    \\ /:::/    /            \\:::\\    \\        \\:::\\    /:::/    /     \\:::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\     \n" +
                "/:::/    /               \\:::\\__/:::/    /       \\:::\\    /:::/    /              \\:::\\    \\        \\:::\\__/:::/    /       \\:::\\   \\:::\\____\\       \\:::\\   \\:::\\____\\    \n" +
                "\\::/    /                 \\::::::::/    /         \\:::\\__/:::/    /                \\:::\\    \\        \\::::::::/    /         \\:::\\  /:::/    /        \\:::\\   \\::/    /    \n" +
                " \\/____/                   \\::::::/    /           \\::::::::/    /                  \\:::\\    \\        \\::::::/    /           \\:::\\/:::/    /          \\:::\\   \\/____/     \n" +
                "                            \\::::/    /             \\::::::/    /                    \\:::\\    \\        \\::::/    /             \\::::::/    /            \\:::\\    \\         \n" +
                "                             \\::/____/               \\::::/    /                      \\:::\\____\\        \\::/____/               \\::::/    /              \\:::\\____\\        \n" +
                "                              ~~                      \\::/____/                        \\::/    /         ~~                      \\::/    /                \\::/    /        \n" +
                "                                                       ~~                               \\/____/                                   \\/____/                  \\/____/";



        if(winner.equals(OUTCOMES.get(0))) {
            numOfDraws++;
            return draw;
        } else if(winner.equals(OUTCOMES.get(2))) {
            playerWins++;
            return player + winGraphic;
        } else {
            cpuWins++;
            return cpu + loseGraphic;
        }
    }

    public int getGameNumber() {
        return gameNumber;
    }
}
