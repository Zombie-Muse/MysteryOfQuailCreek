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
    public int damage;
    public String weaponName;
 
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setWeaponName(String name){
        this.weaponName = name;
    }
    
    public String getWeaponName(){
        return weaponName;
    }
}
