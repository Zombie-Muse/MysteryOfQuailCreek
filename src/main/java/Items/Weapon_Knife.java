/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;
import rpggame.mysteryofquailcreek.Player;

/**
 *
 * @author xxzom
 */

//example weapon
public class Weapon_Knife extends Weapon {
    Player player1 = new Player();
    public Weapon_Knife(){
        damage = player1.diceRoll(4);
        setWeaponDamage(damage);
        setWeaponName("kitchen knife");
        
    }
}
