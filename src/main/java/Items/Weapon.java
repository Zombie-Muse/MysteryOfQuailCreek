/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author xxzom
 */
public class Weapon {
    int damage;
    String weaponName;
    
    public Weapon() {
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
