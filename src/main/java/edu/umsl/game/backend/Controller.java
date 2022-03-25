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
        if (ribbonText.length() == 47){
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
            //if less than or equal to 3 characters
            if (ribbonText.length() <= 3){
                if (coin.charAt(0) == userSequence.charAt(playerIndex)){
                    playerIndex++;
                    if (playerIndex == 3)
                        return true;
                } else{
                    playerIndex = 0;
                }
            }
            else {
                playerIndex = 0;
                //check each letter index if it is the first char in sequence that the next 2 characters contain the next 2 values
                for (int i = 0; i < ribbonText.length(); i++) {
                    for (int j = i; j < ribbonText.length(); j++) {
                        if (ribbonText.charAt(j) == userSequence.charAt(playerIndex)) {
                            playerIndex++;
                            if (playerIndex == 3)
                                return true;
                        } else {
                            playerIndex = 0;
                        }
                    }
                    playerIndex = 0;
                }
            }
        } else if (player == "computer") {
            if (ribbonText.length() <= 3){
                if (coin.charAt(0) == computerSequence.charAt(computerIndex)){
                    computerIndex++;
                    if (computerIndex == 3)
                        return true;
                } else{
                    computerIndex = 0;
                }
            } else{
                computerIndex = 0;
                for (int i=0; i<ribbonText.length(); i++){
                    for (int j = i; j< ribbonText.length(); j++){
                        if (ribbonText.charAt(j) == computerSequence.charAt(computerIndex)){
                            computerIndex++;
                            if (computerIndex == 3)
                                return true;
                        } else{
                            computerIndex = 0;
                        }
                    }
                    computerIndex = 0;
                }
            }
        }

        return false;
    }

    public String checkTotalWins(){
        if (playerWins == 10)
            return "player";
        else if (computerWins == 10)
            return "computer";
        else
            return "";
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

    public String getRibbonText(){ return ribbonText; }

    public void setRibbonText(String ribbonText) { this.ribbonText = ribbonText; }

    public int getPlayerWins(){ return playerWins;}

    public int getComputerWins(){ return computerWins;}

}
