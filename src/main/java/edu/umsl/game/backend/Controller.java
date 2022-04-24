package edu.umsl.game.backend;


public class Controller {
    String gameVersion;
    String userSequence = "";
    String computerSequence = "";
    String ribbonText = "";
    int playerWins = 0;
    int computerWins = 0;
    int rounds = 0;
    int playerIndex = 0;
    int computerIndex = 0;
    int lastPlayerIndex = 0;
    int lastComputerIndex = 0;


    //Takes in the user's sequence and uses getComputerSequence to return the sequence with a higher probability of winning
    //when opponent picks a sequence, example (HHT), remove last one "T" and put opposite of middle at front (H to T)
    //so it would be (THH)
    public String getComputerSequence(){
        String response = "";
        switch (userSequence){
            case "HHH":
                response = "THH";
                break;
            case "THH":
                response = "TTH";
                break;
            case "THT":
                response = "TTH";
                break;
            case "TTH":
                response = "HTT";
                break;
            case "TTT":
                response = "HTT";
                break;
            case "HTT":
                response = "HHT";
                break;
            case "HTH":
                response = "HHT";
                break;
            case "HHT":
                response = "THH";
                break;
            default:
                response = "THH";
        }
        computerSequence = response;
        return response;
    }


    //handle game logic
    public String coinFlipped(String coin){
        ribbonText = ribbonText + coin;
        //if ribbon is too long remove first char (unlikely)
        if (ribbonText.length() == 35){
            ribbonText = ribbonText.substring(1);
        }

        boolean playerWin = checkWin("player", coin);
        boolean computerWin = checkWin("computer", coin);

        if (playerWin){
            playerIndex = 0;
            computerIndex = 0;
            playerWins++;
            return "player";
        }
        else if (computerWin){
            playerIndex = 0;
            computerIndex = 0;
            computerWins++;
            return "computer";
        }
        else{
            return "";
        }

    }

    //if the coin is the next character in the player/computer sequence increase the player/computer index
    //if the player/computer index is incremented to be 3 then all 3 characters in order were found and it is a win
    //else reset player/computer index back to 0
    public boolean checkWin(String player, String coin){
        if (player == "player"){
            //checks for win
            playerIndex = 0;
            for (int i=0; i<ribbonText.length() - 2; i++){
                for (int j = i; j< i + 3; j++){
                    if (ribbonText.charAt(j) == userSequence.charAt(playerIndex)){
                        playerIndex++;
                        lastPlayerIndex = playerIndex;
                        if (playerIndex == 3){
                            return true;
                        }
                    } else{
                        playerIndex = 0;
                        lastPlayerIndex = playerIndex;
                        break;
                    }
                }
                playerIndex = 0;
            }
            //if not win check for progress
            playerIndex = 0;
            if (ribbonText.length() == 1) {
                if (ribbonText.charAt(0) == userSequence.charAt(0)) {
                    playerIndex++;
                    lastPlayerIndex = playerIndex;
                }
            }
            else {
//                System.out.println("-------------------");
                if (ribbonText.charAt(ribbonText.length()-2) == userSequence.charAt(0)){
                    playerIndex++;
                    lastPlayerIndex = playerIndex;
//                    System.out.println("1 ribbon char: " + ribbonText.charAt((ribbonText.length()-2)) + " userChar: " + userSequence.charAt(0) + " playerIndex: " + playerIndex);
                    if (ribbonText.charAt(ribbonText.length()-1) == userSequence.charAt(1)){
                        playerIndex++;
                        lastPlayerIndex = playerIndex;
//                        System.out.println("2 ribbon char: " + ribbonText.charAt((ribbonText.length()-1)) + " userChar: " + userSequence.charAt(1) + " playerIndex: " + playerIndex);
                    }
                    else {
                        playerIndex = 0;
                        lastPlayerIndex = playerIndex;
                        if (ribbonText.charAt(ribbonText.length()-1) == userSequence.charAt(0)){
                            playerIndex++;
                            lastPlayerIndex = playerIndex;
//                            System.out.println("3 ribbon char: " + ribbonText.charAt((ribbonText.length()-1)) + " userChar: " + userSequence.charAt(0) + " playerIndex: " + playerIndex);
                        }
                    }
                } else {
                    if (ribbonText.charAt(ribbonText.length()-1) == userSequence.charAt(0)){
                        playerIndex++;
                        lastPlayerIndex = playerIndex;
//                        System.out.println("4 ribbon char: " + ribbonText.charAt((ribbonText.length()-1)) + " userChar: " + userSequence.charAt(0) + " playerIndex: " + playerIndex);
                    }
                }
            }
        } else if (player == "computer") {
            //checks for win
            computerIndex = 0;
            for (int i=0; i<ribbonText.length() - 2; i++){
                for (int j = i; j< i + 3; j++){
                    if (ribbonText.charAt(j) == computerSequence.charAt(computerIndex)){
                        computerIndex++;
                        lastComputerIndex = computerIndex;
                        if (computerIndex == 3){
                            return true;
                        }
                    } else{
                        computerIndex = 0;
                        lastComputerIndex = computerIndex;
                        break;
                    }
                }
                computerIndex = 0;
            }
            //if not win check for progress
            computerIndex = 0;
            if (ribbonText.length() == 1) {
                if (ribbonText.charAt(0) == computerSequence.charAt(0)) {
                    computerIndex++;
                    lastComputerIndex = computerIndex;
                }
            }
            else {
                if (ribbonText.charAt(ribbonText.length()-2) == computerSequence.charAt(0)){
                    computerIndex++;
                    lastComputerIndex = computerIndex;
                    if (ribbonText.charAt(ribbonText.length()-1) == computerSequence.charAt(1)){
                        computerIndex++;
                        lastComputerIndex = computerIndex;
                    }
                    else {
                        computerIndex = 0;
                        lastComputerIndex = computerIndex;
                        if (ribbonText.charAt(ribbonText.length()-1) == computerSequence.charAt(0)){
                            computerIndex++;
                            lastComputerIndex = computerIndex;
                        }
                    }
                } else {
                    if (ribbonText.charAt(ribbonText.length()-1) == computerSequence.charAt(0)){
                        computerIndex++;
                        lastComputerIndex = computerIndex;
                    }
                }
            }
        }

        return false;
    }

    public String checkTotalWins(){
        if (playerWins == 6)
            return "player";
        else if (computerWins == 6)
            return "computer";
        else
            return "";
    }

    //get how many checks should be shown for each player
    public int[] getPlayerAndComputerPosition(){
//        System.out.println("calling getCheckMarks");
        int[] indexes = {lastPlayerIndex, lastComputerIndex};
        return indexes;
    }

    //set which version of the game, "manual" or "standard"
    public void setGameVersion(String version){
        this.gameVersion = version;
    }

    public void setUserSequence(String userSequence){
        this.userSequence = userSequence;
    }

    public String getUserSequence(){
        return userSequence;
    }

    public void incrementRounds(){
        rounds++;
    }

    public int getRounds(){
        return rounds;
    }

    public void setComputerChecks(int x){
        lastComputerIndex = x;
    }

    public void setPlayerChecks(int x){
        lastPlayerIndex = x;
    }

    public String getRibbonText(){ return ribbonText; }

    public void setRibbonText(String ribbonText) { this.ribbonText = ribbonText; }

    public int getPlayerWins(){ return playerWins;}

    public int getComputerWins(){ return computerWins;}

}
