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
public class Weapon_GlowingSword extends Weapon{
    Weapon weapon;
    public Weapon_GlowingSword(){
        int damage = weapon.diceRoll(10);
        setWeaponDamage(damage);
        setWeaponName("Glowing Sword");
    }
}
