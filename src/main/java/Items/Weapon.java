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

//weapon class work in progress. This will be superclass, and all weapons will be inherited from this one
public class Weapon {
    int damage;
    String weaponName;
    
    public Weapon() {
    }
    
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
    
    public void setWeaponName(String weaponName){
        this.weaponName = weaponName;
    }
    
    public String getWeaponName(){
    return weaponName;    
    }
    
    public void setWeaponDamage(int damage){
        this.damage = damage;
    }
    
    public int getWeaponDamage(){
        return damage;
    }
}
