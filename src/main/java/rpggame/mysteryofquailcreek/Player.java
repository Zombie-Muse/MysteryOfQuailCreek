/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

/**
 *
 * @author ZomB
 */
public class Player {
    String playerName, playerStats, weaponName;
    int bonus, playerHP, playerArmor, playerAttack, playerAttackBonus, playerLevel, playerXP, playerDexterity, playerDexterityBonus, stats, weaponDamage, armorClass;
    UI ui;
    
    public Player(){
   
    }
    
    //Main player builder methods from previous version of game and modified for the gui version
    public void buildPlayer(){
        int hp = diceRoll(10);
        if (hp < 5){
            hp = 5;
        }
        
        setPlayerLevel(1);
        setPlayerXP(0);
        setPlayerHP(hp);
        setPlayerAttack(rollStats());
        setPlayerAttackBonus(rollBonus(getPlayerAttack()));
        setPlayerDexterity(rollStats());
        setPlayerDexterityBonus(rollBonus(getPlayerDexterity()));
        setArmorClass(2);
        setWeaponName("None");
        
    }
    
    //takes the highest 3rolls out of 4d6
    public int rollStats(){
    int[] rolls = new int[4];
        int min = 6;
        int sum = 0;
        
        
        for (int i = 0; i < rolls.length; i++){
            rolls[i] = diceRoll(6);
            if (rolls[i] < min){
                min = rolls[i];
            }  
        }
        for (int j = 0; j < rolls.length; j++){
            sum = sum + rolls[j];
        }
        
        stats = sum - min;
        return stats;
    }
    
    public int rollBonus(int attribute){
        bonus = (attribute - 10) / 2;
        return bonus;
    }
    
    public void levelUp(){
        if (playerXP < 100){
            setPlayerLevel(1);
        }
        else if (playerXP < 200){
            setPlayerLevel(2);
            setPlayerAttack(getPlayerAttack() + 2);
            setPlayerDexterity(getPlayerDexterity() + 2);
        }
        else if (playerXP < 400){
            setPlayerLevel(3);
            setPlayerAttack(getPlayerAttack() + 2);
            setPlayerDexterity(getPlayerDexterity() + 2);
        }
        else if (playerXP < 800){
            setPlayerLevel(4);
            setPlayerAttack(getPlayerAttack() + 2);
            setPlayerDexterity(getPlayerDexterity() + 2);
        }
    }
    
    //For previous version of game
    /*public String printPlayerStats(){
        return "--------------------------------------------------" + "\n" +
                "HP:            " + getPlayerHP() + "\n" +
                "Attack:        " + getPlayerAttack() + "\n" +
                "Dexterity:     " + getPlayerDexterity() + "\n" +
                "Armor Class:   " + getPlayerArmor() + "\n" +
                "Weapon:        " + getWeaponName() + "\n" +
                "--------------------------------------------------";
    }*/
    
    //set/get methods
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerLevel(int playerLevel){
        this.playerLevel = playerLevel;
    }
    
    public int getPlayerLevel(){
        return playerLevel;
    }
    
    public void setPlayerXP(int playerXP){
        this.playerXP= playerXP;
    }
    
    public int getPlayerXP(){
        return playerXP;
    }
    
    public void setPlayerHP(int playerHP){
        this.playerHP = playerHP;
    }
    
    public int getPlayerHP(){
        return playerHP;
    }
    
    public void setPlayerArmor(int playerArmor){
        this.playerArmor = playerArmor;
    }
    
    public int getPlayerArmor(){
        return playerArmor;
    }
    
    public void setArmorClass(int armorClass){
        this.armorClass = armorClass;
    }
    
    public int getArmorClass(){
        return armorClass;
    }
    public void setWeaponName(String weaponName){
        this.weaponName = weaponName;
    }
    
    public String getWeaponName(){
        return weaponName;
    }
    
    public void setWeaponDamage(int weaponDamage){
        this.weaponDamage = weaponDamage;
    }
    
    public int getWeaponDamage(){
        return weaponDamage;
    }
    
    public void setPlayerAttack(int playerAttack){
        this.playerAttack = playerAttack;
    }
    
    public int getPlayerAttack(){
        return playerAttack;
    }
    
    public void setPlayerAttackBonus(int attackBonus){
        this.playerAttackBonus = attackBonus;
    }
    
    public int getPlayerAttackBonus(){
        return playerAttackBonus;
    }
    
    public void setPlayerDexterity(int playerDexterity){
        this.playerDexterity = playerDexterity;
    }
    
    public int getPlayerDexterity(){
        return playerDexterity;
    }
    
    public void setPlayerDexterityBonus(int dexterityBonus){
        this.playerDexterityBonus = dexterityBonus;
    }
    
    public int getPlayerDexterityBonus(){
        return playerDexterityBonus;
    }
    
    //Dice roll method...thanks Chris
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
}
