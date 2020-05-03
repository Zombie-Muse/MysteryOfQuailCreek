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
public class Monster_ChantingWizard extends Monster {
    public Monster_ChantingWizard(){
        monsterHP = 6;
        monsterDamage = diceRoll(4);
        
    }
    
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
}
