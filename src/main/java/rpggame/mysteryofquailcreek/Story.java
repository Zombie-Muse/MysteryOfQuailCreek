/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

import Items.Monster;
import Items.Monster_ChantingWizard;
import Items.Weapon;
import Items.Weapon_GlowingSword;

/**
 *
 * @author ZomB
 */
public class Story {
    Main main;
    UI ui;
    VisibilityManager vm;
    Player player;
    Monster monster;
    Weapon weapon;
    int savingsThrow, playerHP;
    String weaponName;

    public Story(Main m, UI userInterface, VisibilityManager vManage, Player p1){
        main = m;
        ui = userInterface;
        vm = vManage;
        player = p1;
    }
    
    //So...setting the default setup in story class seems to work...maybe from constructor above?
    public void playerDefault(){
        player.buildPlayer();
        ui.hpValueLabel.setText("" + player.getPlayerHP());
        ui.attackValueLabel.setText("" + player.getPlayerAttack());
        ui.dexterityValueLabel.setText("" + player.getPlayerDexterity());
        ui.armorClassValueLabel.setText("" + player.getArmorClass());
        ui.levelValueLabel.setText("" + player.getPlayerLevel());
        intro();
    }
    //All choices for the game
    public void choice(String nextChoice){
        
        switch(nextChoice){
            case "title": playerDefault();
                break;
            case "balcony": balcony();
                break;
            case "downstairs": downstairs();
                break;
            case "chantingTalk": chantingTalk();
                break;
            case "yell": yell();
                break;
            case "sleep": sleep();
                break;
            case "bedroom": bedroom();
                break;
            case "glow": glow();
                break;
            case "coupleTalk": coupleTalk();
                break;
            case "swordBalcony": swordBalcony();
                break;
            case "swordDownstairs": swordDownstairs();
                break;
            case "threaten": threaten();
                break;
            case "reason": reason();
                break;
            case "runAway": runAway();
                break;
            case "dodgeFireball": dodgeFireball();
                break;
//            case "fireball": fireball();
//                break;
//            case "deflectFireball": deflectFireball();
//                break;
            case "sword": sword();
                break;
            case "combat": combat();
                break;
            case "attack": attack();
        }
    }
    
    //Mechanics of certain scenes
    public void combat(){
        ui.mainTextArea.setText("You are staring at a " + monster.monsterName + ", and he doesn't look happy. He brings his hands together again as a glow begins to eminate from his hands once again.");
        
        ui.choice1.setText("ATTACK");
        ui.choice2.setText("DEFEND");
        ui.choice3.setText("RUN");
        ui.choice4.setText("");
        
        main.nextChoice1 = "attack";
        main.nextChoice2 = "defend";
        main.nextChoice3 = "run";
    }
    
    public void attack(){
        int damage;
        ui.mainTextArea.setText("You swing that glowing sword so hard you closed your eyes and braced for impact...that's not how sword fighting is supposed to work.");
        savingsThrow = diceRoll(20);
        if (savingsThrow > monster.monsterArmorClass){
            damage = diceRoll(weapon.damage);
            monster.monsterHP = monster.monsterHP - damage;
            ui.mainTextArea.setText("Surprisingly, you hit the " + monster.monsterName + "and dealt " + damage + " damage." );
        }
        else {
            ui.mainTextArea.setText("You missed...of course");
        }
        
        
    }
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
    
    //Story elements
    public void intro(){
        ui.mainTextArea.setText("The sofa is comfortable. After watching hours of Netflix, sleep sounds so good. Your phone slips from your hand as you drift off to sleep. "
                + "You dream of wizards and magic and knights protecting the realm. You dream of a dark cloud rising from the earth...and spreading "
                + "You awaken to the sound of someone’s voice. He is speaking...or singing? It sounds more like chanting. You can’t really make out what he is saying though. "
                + "All you know for certain is that it’s pretty unusual for your condo complex. It’s normally very peaceful. "
                + "The chanting grows louder and you can tell that it’s fairly close outside. You pick yourself up off the couch wondering what's going on.");
        ui.choice1.setText("Go to the balcony to investigate");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "balcony";
        main.nextChoice2 = "downstairs";
    }
    
    public void balcony(){
        ui.mainTextArea.setText("You open the slider to the balcony. You are only one floor up. You see that the couple that live across from you are both standing outside and"
                + "looking up toward your neighbor’s condo. You follow their gaze and see your neighbor appearing to float on his balcony"
                + " while chanting loudly. A strange glow appears in front of him and seems to grow in intensity as he chants.");
        ui.choice1.setText("Try to talk to your chanting neighbor");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("Go inside and go back to sleep");
        ui.choice4.setText("");
        
        main.nextChoice1 = "chantingTalk";
        main.nextChoice2 = "downstairs";
        main.nextChoice3 = "sleep";
    }
    
    public void downstairs(){
        ui.mainTextArea.setText("You go out your front door and down the stairs. You can hear the chanting above you. It seems to be coming from your neighbor’s balcony. "
                + "You see the couple from the condo across the way. They are looking up at your neighbor with concerned expressions.");
        
        ui.choice1.setText("Talk to the couple");
        ui.choice2.setText("Go back upstairs to the balcony");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleTalk";
        main.nextChoice2 = "balcony";
    }
    
    public void chantingTalk(){
        ui.mainTextArea.setText("He seems completely oblivious to your presence. A strange glow begins to manifest if front of him. "
                + "Maybe if you throw something at him, you can get his attention...of course, that could also anger him.");
        
        ui.choice1.setText("Yell at him to get his attention");
        ui.choice2.setText("Go inside to find something to throw at him");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "yell";
        main.nextChoice2 = "bedroom";
    }
    
    public void yell(){
        ui.mainTextArea.setText("You yell at him. You scream. He doesn't break his trance. The glow is growing brighter. This probably isn't a good thing.");
        
        ui.choice1.setText("Go inside to find something to throw at him");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("Go back inside and go back to sleep");
        ui.choice4.setText("");
        
        main.nextChoice1 = "bedroom";
        main.nextChoice2 = "downstairs";
        main.nextChoice3 = "sleep";
    }
    
    public void bedroom(){
        ui.mainTextArea.setText("You go into your bedroom to get a shoe to throw in his direction. Perhaps if you could just break his concentration, he can return to normal..."
                + "and you can watch some more Netflix. You notice a strange glow emanating from underneath your bed. It looks like the same type of glow from outside.");
        
        ui.choice1.setText("Grab your shoe and head to the balcony");
        ui.choice2.setText("Investigate the glow");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "balcony";
        main.nextChoice2 = "glow";
    }
    
    public void glow(){
        ui.mainTextArea.setText("You look under your bed and find what appears to be a sword. You remember your grandfather giving this to you on your birthday one year. "
                + "He told you that it was a very special sword that had been in the family for generations.");
        
        ui.choice1.setText("Grab the sword");
        ui.choice2.setText("Leave the sword");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "sword";
        main.nextChoice2 = "bedroom";
    }
    
    public void sword(){
        ui.mainTextArea.setText("You pick up the glowing sword. Heat radiates through it and into your hand. It's not hot, but comfortable. "
                + "Apart from it being a glowing sword, there's something special about it.");
        
        weapon = new Weapon_GlowingSword();
        ui.weaponNameLabel.setText("" + weapon.weaponName);
        
        ui.choice1.setText("Go out to the balcony");
        ui.choice2.setText("Go downstairs");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "swordBalcony";
        main.nextChoice2 = "swordDownstairs";
    }
    
    public void swordBalcony(){
        ui.mainTextArea.setText("You return to the balcony, glowing sword in hand. The neighbor's chanting suddenly stops. He turns toward you.\n"
                + "\"The ANSWER!!\" he screams as he points his finger in your direction. His other hand seems to be holding whatever was glowing in front of him. \n"
                + "You can't help but wonder if you've made some bad life choices for you to wind up here.");
        
        ui.choice1.setText("Threaten him with the glowing sword");
        ui.choice2.setText("Try to reason with him");
        ui.choice3.setText("Run downstairs");
        ui.choice4.setText("");
        
        main.nextChoice1 = "threaten";
        main.nextChoice2 = "reason";
        main.nextChoice3 = "runAway";
    }
    
    public void threaten(){
        ui.mainTextArea.setText("You raise the sword in front of you. You've never used one, but you've seen movies. Sword fighting seems easy."
                + "\"Stay back!\" you nervously blurt out.\n"
                + "He brings his hands together as the glowing orb grows brighter then launches towards you!");
        
        ui.choice1.setText("Dodge the glowing fireball");
        ui.choice2.setText("Stand there and take it like a man");
        ui.choice3.setText("Deflect the fireball with your sword");
        ui.choice4.setText("");
        
        main.nextChoice1 = "dodgeFireball";
        main.nextChoice2 = "fireball";
        main.nextChoice3 = "deflectFireball";
    }
    
    public void reason(){
        ui.mainTextArea.setText("You lower your sword and raise your free hand in the air in an attempt to look non-threatening. He keeps screaming, \"THE ANSWER! THE ANSWER!\""
                + "He brings his hands together as the glowing orb grows brighter then launches towards you!");
        
        ui.choice1.setText("Dodge the glowing fireball");
        ui.choice2.setText("Stand there and take it like a man");
        ui.choice3.setText("Deflect the fireball with your sword");
        ui.choice4.setText("");
        
        main.nextChoice1 = "dodgeFireball";
        main.nextChoice2 = "fireball";
        main.nextChoice3 = "deflectFireball";
    }
    
    public void runAway(){
        ui.mainTextArea.setText("He brings his hands together as the glowing orb grows brighter. You turn to run back inside, but you only make it a step towards the door "
                + "before you get a fireball to the head. In an instant, the bright flash of light flickers as you find yourself floating in an endless void...\n"
                + "...forever.");
        
        ui.choice1.setText("Start over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "";
    }
    
    public void dodgeFireball(){
        savingsThrow = diceRoll(100);
        monster = new Monster_ChantingWizard();
        if (savingsThrow > 40) {
            ui.mainTextArea.setText("As the fireball hurls toward you, you manage to jump out of the way.The fireball connects with your balcony though, exploding it on contact. \n"
                    + "You fall to the ground in a daze. Your wizard neighbor jumps down after you, looking for a fight. You take 1 damage from the fall");
            playerHP = player.getPlayerHP() - 1;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + playerHP);
            
        }
        else {
                ui.mainTextArea.setText("The fireball hurls towards you, but you are unable to get out of the way in time. It connects with your chest, sending you flying off the balcony. \n"
                        + "You fall to the ground with a loud thud. Why are you not dead? You still have a death grip on the glowing sword. It must have absorbed some of the impact.\n"
                        + "Your wizard neighbor floats down from above looking for a fight.");
                    
                playerHP = player.getPlayerHP() - 2;
                player.setPlayerHP(playerHP);
                ui.hpValueLabel.setText("" + playerHP);
                    }
        
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "combat";
    }
    
    public void swordDownstairs(){
        
    }
    
    public void sleep(){
        ui.mainTextArea.setText("You go back inside, thinking all of this is too much to handle at the moment. You lay back down on the couch and attempt to fall asleep. "
                + "The chanting gets louder. The room begins to shake, and in an instant, the entire condo explodes. "
                + "You find yourself drifting into a dark, endless void...\n\n"
                + "...forever.");
        ui.choice1.setText("Start over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    
    public void coupleTalk(){
        
    }
        
}
