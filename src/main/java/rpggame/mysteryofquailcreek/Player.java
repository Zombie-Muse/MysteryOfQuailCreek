/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

/**
 *
 * @author xxzom
 */
public class Player {
    String playerName, playerStats, weaponName;
    int playerHP, playerArmor, playerAttack, playerLevel, playerXP, playerDexterity, stats, weaponDamage, armorClass;
    UI ui = new UI();
    
    public Player(){
   
    }
    
    public void playerDefault(){
        playerHP = 10;
        ui.hpValueLabel.setText("" + playerHP);
    }
    
    public void buildPlayer(){
        
        int hp = diceRoll(10);
        System.out.println(hp);
        if (hp < 3){
            hp = 3;
        }
        
        setPlayerLevel(1);
        setPlayerXP(0);
        setWeaponName("nothing");
        setPlayerHP(hp);
        setPlayerAttack(rollStats());
        setPlayerDexterity(rollStats());
        setPlayerArmor(0);
        setWeaponName("None");
        hp = getPlayerHP();
        
        ui.hpValueLabel.setText("wtf");
        ui.attackValueLabel.setText("" + getPlayerAttack());
        ui.dexterityValueLabel.setText("" + getPlayerDexterity());
        
    }
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
    public String printPlayerStats(){
        return "--------------------------------------------------" + "\n" +
                "HP:            " + getPlayerHP() + "\n" +
                "Attack:        " + getPlayerAttack() + "\n" +
                "Dexterity:     " + getPlayerDexterity() + "\n" +
                "Armor Class:   " + getPlayerArmor() + "\n" +
                "Weapon:        " + getWeaponName() + "\n" +
                "--------------------------------------------------";
    }
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
    
    public void setPlayerDexterity(int playerDexterity){
        this.playerDexterity = playerDexterity;
    }
    
    public int getPlayerDexterity(){
        return playerDexterity;
    }
    
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
}