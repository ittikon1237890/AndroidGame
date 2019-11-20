package com.example.mygame;

public class Data {
    private String playerName ="";
    private int playerHP = 3;
    private int stage = 0;
    private int myscore = 0;

    private int bg ;
    private String enemyname ="";

    public void setPlayerName(String playername){
        this.playerName = playername;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerHP(int playerHP){
        this.playerHP = playerHP;
    }
    public int getPlayerHP(){
        return playerHP;
    }

    public void setStage(int stage){
        this.stage=stage;
    }

    public int getStage() {
        return stage;
    }

    public void setMyScore(int myscore){
        this.myscore=myscore;
    }
    public int getMyScore(){
        return myscore;
    }


    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public void setEnemyName(String enemyname) {
        this.enemyname = enemyname;
    }

    public String getEnemyName() {
        return enemyname;
    }
}
