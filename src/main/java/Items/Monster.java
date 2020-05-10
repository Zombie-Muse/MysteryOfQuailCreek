/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author ZomB
 */
public class Monster {
    public String monsterName;
    public int monsterHP, monsterDamage, monsterArmorClass, xpValue, monsterDefenseDifficulty;
    
    public void setMonsterName(String name){
        this.monsterName = name;
    }
    
    public String getMonsterName(){
        return monsterName;
    }
    
    public void setMonsterHP(int hp){
        this.monsterHP = hp;
    }
    
    public int getMonsterHP(){
        return monsterHP;
    }
    
    public void setMonsterDamage(int damage){
        this.monsterDamage = damage;
    }
    
    public int getMonsterDamage(){
        return monsterDamage;
    }
    
    public void setMonsterArmorClass(int ac){
        this.monsterArmorClass = ac;
    }
    
    public int getMonsterArmorClass(){
        return monsterArmorClass;
    }
    
    public void setMonsterXPValue(int xp){
        this.xpValue = xp;
    }
    
    public int getMonsterXPValue(){
        return xpValue;
    }
    
    public void setMonsterDefenseDifficulty(int difficulty){
        this.monsterDefenseDifficulty = difficulty;
    }
    
    public int getMonsterDefenseDifficulty(){
        return monsterDefenseDifficulty;
    }
}

