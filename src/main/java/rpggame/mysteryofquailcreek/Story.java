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
import Items.Weapon_Knife;
import Items.Weapon_Shoe;
import Items.Weapon_Sword;

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
    int abilityCheck, abilityCheckRoll, playerHP;
    boolean hasTalk = false;
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
//        ui.attackValueLabel.setText("" + player.getPlayerAttack());
//        ui.dexterityValueLabel.setText("" + player.getPlayerDexterity());
        ui.armorClassValueLabel.setText("" + player.getArmorClass());
        ui.levelValueLabel.setText("" + player.getPlayerLevel());
        ui.xpValueLabel.setText("" + player.getPlayerXP());
//        hasTalk = false;
        intro();
    }
    //All choices for the game
    public void choice(String nextChoice){
        
        switch(nextChoice){
            case "introCont": introCont(); break;
            case "title": playerDefault(); break;
            case "balcony": balcony(); break;
            case "balconyShoe": balconyShoe(); break;
            case "downstairs": downstairs(); break;
            case "chantingTalk": chantingTalk(); break;
            case "yell": yell(); break;
            case "sleep": sleep(); break;
            case "bedroom": bedroom(); break;
            case "glow": glow(); break;
            case "coupleTalk": coupleTalk(); break;
            case "coupleTalkCont": coupleTalkCont(); break;
            case "coupleTalkAgain": coupleTalkAgain(); break;
            case "coupleFollow": coupleFollow(); break;
            case "coupleGlow": coupleGlow(); break;
            case "knock": knock(); break;
            case "runForHelp": runForHelp(); break;
            case "swordBalcony": swordBalcony(); break;
            case "swordDownstairs": swordDownstairs(); break;
            case "threaten": threaten(); break;
            case "reason": reason(); break;
            case "runAway": runAway(); break;
            case "dodgeFireball": dodgeFireball(); break;
            case "dodgeFireball2": dodgeFireball2(); break;
            case "fireball": fireball(); break;
            case "deflectFireball": deflectFireball(); break;
            case "deflectFireball2": deflectFireball2(); break;
            case "combat": combat(); break;
            case "sword": sword(); break;
            case "attack": combatPlayerAttack(); break;
            case "monsterAttack": combatMonsterAttack(); break;
            case "defend": combatDefend(); break;
            case "run": combatRun(); break;
            case "win": combatWin(); break;
            case "lose": combatLose(); break;
            case "findWeapon": findWeapon(); break;
            case "balconyFight": balconyFight(); break;
            case "kitchen": kitchen(); break;
            case "bedroomHum": bedroomHum(); break;
            case "coupleSword": coupleSword(); break;
            case "helpWife": helpWife(); break;
            case "helpWifeCont": helpWifeCont(); break;
            case "coupleFight": coupleFight(); break;
            case "reason2": reason2(); break;
            case "apologize": apologize(); break;
            case "apologizeCont": apologizeCont(); break;
            case "attackAdvantage": combatAttackAdvantage(); break;
        }
    }
    
    //Mechanics of certain scenes
    public void combat(){
        vm.combatScreen();
        ui.monsterHPValueLabel.setText("" + monster.getMonsterHP());
        ui.monsterNameValueLabel.setText(monster.getMonsterName());
        ui.monsterArmorValueLabel.setText("" + monster.getMonsterArmorClass());
        ui.mainTextArea.setText("You are staring at a " + monster.getMonsterName() + ", and he doesn't look happy...I would say a bit threatening...aggressive even. "
                + "Yeah, he's definitely going to kill you if you don't do something.");
        
        ui.choice1.setText("ATTACK");
        ui.choice2.setText("DEFEND");
        ui.choice3.setText("RUN");
        ui.choice4.setText("");
        
        main.nextChoice1 = "attack";
        main.nextChoice2 = "defend";
        main.nextChoice3 = "run";
    }
    
    //combat attack method
    public void combatPlayerAttack(){
        abilityCheckRoll = diceRoll(20);
        if (abilityCheckRoll > monster.getMonsterArmorClass()) {
            int playerDamage = diceRoll(weapon.getDamage());
            int playerBonus = player.getPlayerAttackBonus();
            int damage = playerDamage + playerBonus;
            ui.mainTextArea.setText("You attack!! Your " + player.getWeaponName() + " connects with your target and you deal " + damage + " damage");
            monster.setMonsterHP(monster.getMonsterHP() - playerDamage);
            ui.monsterHPValueLabel.setText("" + monster.getMonsterHP());
            ui.choice1.setText(">>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "monsterAttack";
            if (monster.getMonsterHP() < 1){
                main.nextChoice1 = "win";
                
            }
        }
        else {
            ui.mainTextArea.setText("You miss! This is so much harder in real life.");
            
            ui.choice1.setText(">>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "monsterAttack";
        }
    }
    
    //combat monster attack method
    public void combatMonsterAttack(){
        abilityCheckRoll = diceRoll(20);
        if (abilityCheckRoll > player.getArmorClass()) {
            int monsterDamage = diceRoll(monster.getMonsterDamage());
            ui.mainTextArea.setText(monster.getMonsterName() + " attacks!\nYou're hit! Oh, the humanity! You take " + monsterDamage + " damage!");
            playerHP = player.getPlayerHP() - monsterDamage;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("RUN");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
            main.nextChoice3 = "run";
            if (playerHP < 1){
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
                main.nextChoice1 = "lose";
            }
        }
        else {
            ui.mainTextArea.setText("The " + monster.getMonsterName() + " misses!");
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("RUN");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
            main.nextChoice3 = "run";
        } 
    }
    
    public void combatDefend(){
        for (int i = 0; i < 2; i++){
        int lowest = 20;
        int roll = diceRoll(20);
        if (roll < lowest){
            lowest = roll;
        }
        abilityCheck = lowest;
        
    }
        
        if (abilityCheck > player.getArmorClass()) {
            
            int monsterDamage = diceRoll(monster.getMonsterDamage());
            ui.mainTextArea.setText(monster.monsterName + " attacks!\nYou're hit! Oh, the humanity! You take " + monsterDamage + " damage!");
            playerHP = player.getPlayerHP() - monsterDamage;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("RUN");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
            main.nextChoice3 = "run";
            if (playerHP < 1){
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
                main.nextChoice1 = "lose";
            }
        }
        else {
            ui.mainTextArea.setText("The " + monster.getMonsterName() + " misses!");
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("RUN");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
            main.nextChoice3 = "run";
        } 
    }
    
    public void combatRun(){
        ui.mainTextArea.setText("You cannot run from this fight! The developer hasn't coded that in yet!");
        
        ui.choice1.setText("ATTACK");
        ui.choice2.setText("DEFEND");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "attack";
        main.nextChoice2 = "defend";
    }
    
    public void combatAttackAdvantage(){
        monster = new Monster_ChantingWizard();
        vm.combatScreen();
        ui.monsterHPValueLabel.setText("" + monster.getMonsterHP());
        ui.monsterNameValueLabel.setText(monster.getMonsterName());
        ui.monsterArmorValueLabel.setText("" + monster.getMonsterArmorClass());
        abilityCheck = 16;
        abilityCheckRoll = diceRoll(20) + player.getPlayerDexterityBonus();
        if (abilityCheckRoll > abilityCheck){
            int playerDamage = diceRoll(weapon.getDamage());
            int playerBonus = player.getPlayerAttackBonus();
            int damage = playerDamage + playerBonus;
            ui.mainTextArea.setText("You leap forward with you " + player.getWeaponName() + " overhead, and come crashing down on the unsuspecting neighbor! You deal " + damage + " damage! "
                    + "That's gonna leave a mark!");
            monster.setMonsterHP(monster.getMonsterHP() - damage);
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
        }
        else {
            int monsterDamage = diceRoll(monster.getMonsterDamage());
            ui.mainTextArea.setText("You pounce like a cat attacking it's prey...\n"
                + "...well, more like a kitten attacking the foot of person climbing the stairs...more of an annoyance. You leap forward with your " + player.getWeaponName() + " overhead! The neighbor turns"
                        + "towards you and waves his hand in front of him, sending you flying back with " + monsterDamage + " damage!");
            player.setPlayerHP(player.getPlayerHP() - monsterDamage);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            
            ui.choice1.setText("ATTACK");
            ui.choice2.setText("DEFEND");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "attack";
            main.nextChoice2 = "defend";
        }
    }
    public void combatWin(){
        int level = player.getPlayerLevel();
        int newLevel;
        ui.mainTextArea.setText("You win!! But...everything explodes because I haven't coded anything further than this.\n\n");
        player.setPlayerXP(player.getPlayerXP() + monster.getMonsterXPValue());
        
        player.levelUp();
        newLevel = player.getPlayerLevel();
//        ui.mainTextArea.append("player XP: " + player.getPlayerXP() + " and player level: " + player.getPlayerLevel() + "\n");
        ui.levelValueLabel.setText("" + player.getPlayerLevel());
        ui.xpValueLabel.setText("" + player.getPlayerXP());
        if (newLevel > level){
            ui.mainTextArea.append("Congratulations, though! You leveled up!");
        }
        
        ui.choice1.setText("Start Over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    
    public void combatLose(){
        ui.mainTextArea.setText("You lose!! But...everything explodes because I haven't coded anything further than this.");
        
        ui.choice1.setText("Start Over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    public int diceRoll(int side){
        int roll;
        roll = (int) (Math.random() * side + 1);
        return roll;
    }
    
    //Story elements
    public void intro(){
//        hasTalk = false;
        vm.gameScreen();
        ui.mainTextArea.setText("The sofa is comfortable. After watching hours of Netflix, sleep sounds so good. Your phone slips from your hand as you drift off to sleep. "
                + "You dream of wizards and magic and knights protecting the realm. You dream of a dark cloud rising from the earth...and spreading. "
                + "You awaken to the sound of someone’s voice. He is speaking...or singing? It sounds more like chanting. You can’t really make out what he is saying though.");
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "introCont";
    }
    
    public void introCont(){
        ui.mainTextArea.setText("All you know for certain is that it’s pretty unusual for your condo complex. It’s normally very peaceful. "
                + "The chanting grows louder and you can tell that it’s fairly close outside. You pick yourself up off the couch wondering what's going on.");
        ui.choice1.setText("Go to the balcony to investigate");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "balcony";
        main.nextChoice2 = "coupleTalk";
    }
    
    public void balcony(){
        ui.mainTextArea.setText("You open the slider to the balcony. You are only one floor up. You see that the couple that live across from you are both standing outside and "
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
    
    public void balconyShoe(){
        weapon = new Weapon_Shoe();
        ui.weaponNameLabel.setText(weapon.weaponName);
        ui.mainTextArea.setText("You go back out to the balcony with your old, dirty shoe in hand. You yell out one last time before tossing the shoe at him. It hits the glowing "
                + "orb in front of him and disappears with a small pop. He is unfazed. The glowing gets brighter. Maybe you should check the similar glow under your bed.");
        
        ui.choice1.setText("Go back and investigate glow");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "glow";
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
        
        main.nextChoice1 = "balconyShoe";
        main.nextChoice2 = "glow";
    }
    
    public void glow(){
        ui.weaponNameLabel.setText("");
        ui.mainTextArea.setText("You look under your bed and find what appears to be a sword. You remember your grandfather giving this to you on your birthday one year. "
                + "He told you that it was a very special sword that had been in the family for generations. It never glowed or hummed before, but today is strange.");
        
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
        player.setWeaponName(weapon.weaponName);
        ui.weaponNameLabel.setText("" + weapon.weaponName);
        
        ui.choice1.setText("Go out to the balcony");
        ui.choice2.setText("Go downstairs");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "swordBalcony";
        main.nextChoice2 = "swordDownstairs";
    }
    
    public void swordBalcony(){
        ui.mainTextArea.setText("You return to the balcony, glowing sword in hand. The neighbor's chanting suddenly stops. He turns toward you. "
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
    
    public void swordDownstairs(){
        ui.mainTextArea.setText("Why would you go downstairs? I haven't coded this part of the story yet. Go back...off ya go. \n"
                + "...\n"
                + "...Go on! Git!");
        ui.choice1.setText("Pretend like this didn't happen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "sword";
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
    
    public void reason2(){
        monster = new Monster_ChantingWizard();
        if (player.getWeaponName() == "Glowing Sword"){
        ui.mainTextArea.setText("You lower your weapon and raise your free hand in the air in an attempt to look non-threatening. He turns to face you and looks at the glowing "
                + "sword in your hand. \"The answer!\" he yells, pointing in your direction. You start to think this dude has some serious communication issues. ");
            
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "combat";
        }
        else{
        ui.mainTextArea.setText("You lower your weapon and raise your free hand in the air in an attempt to look non-threatening. He turns to face you, but you can see in his eyes that "
                + "there is no talking to him right now.");
        
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "combat";
        }
    }
    
    public void runAway(){
        ui.mainTextArea.setText("He brings his hands together as the glowing orb grows brighter. You turn to run back inside, but you only make it a step towards the door "
                + "before you get a fireball to the head. In an instant, the bright flash of light flickers as you find yourself floating in an endless void...\n"
                + "...forever.");
        
        ui.choice1.setText("Start over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    
    public void dodgeFireball(){
        monster = new Monster_ChantingWizard();
        abilityCheck = monster.monsterDefenseDifficulty;
        if (abilityCheck < player.getPlayerDexterity() + player.getPlayerDexterityBonus()) {
            ui.mainTextArea.setText("As the fireball hurls toward you, you manage to jump out of the way. The fireball connects with your balcony though, exploding it on contact. "
                    + "You fall to the ground in a daze. Your wizard neighbor jumps down after you, looking for a fight. You take 1 damage from the fall");
            playerHP = player.getPlayerHP() - 1;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + playerHP);
            
        }
        else {
                ui.mainTextArea.setText("The fireball hurls towards you, but you are unable to get out of the way in time. It connects with your chest, sending you flying off the balcony. "
                        + "You fall to the ground with a loud thud. Why are you not dead? You still have a death grip on the glowing sword. It must have absorbed some of the impact. "
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
    
    public void dodgeFireball2(){
        abilityCheck = diceRoll(20) + player.getPlayerDexterityBonus();
        monster = new Monster_ChantingWizard();
        if (abilityCheck > 13) {
            ui.mainTextArea.setText("As the fireball hurls toward you, you manage to jump out of the way. The fireball blasts through the wall, sending debris to the walkway below.");  
        }
        else {
                ui.mainTextArea.setText("The fireball hurls towards you, but you are unable to get out of the way in time. It connects with your chest, sending you flying through the wall "
                        + "onto the walkway below taking 3 damage. You fall to the ground with a loud thud. Why are you not dead? Your wizard neighbor floats down from above looking "
                        + "for a fight.");
                    
                playerHP = player.getPlayerHP() - 3;
                player.setPlayerHP(playerHP);
                ui.hpValueLabel.setText("" + playerHP);
                    }
        
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "combat";
    }
    
    public void fireball(){
        ui.mainTextArea.setText("You brace for impact. For a split second you feel the heat radiating from it like a furnace on a hot day. You remember a time "
                + "when you were a kid and at a friend's pool party. The sunburn from that day stayed for an eternity. Your skin blistered up and the pain was almost too much to wear a shirt. "
                + "Well, that was a tickle in comparison to the pain you feel at this moment, as you float in an endless darkness. The void swallowed you. Sometimes it's better to fight.");
        
        ui.choice1.setText("Start over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    
    public void deflectFireball(){
        int damage = diceRoll(4) + diceRoll(4);
        monster = new Monster_ChantingWizard();
        abilityCheck = monster.monsterDefenseDifficulty;
        if (abilityCheck > player.getPlayerDexterity() + player.getPlayerDexterityBonus()){
            ui.mainTextArea.setText("You try to block a speeding ball of fire with a glowing sword you found under your bed. When you say like that, it sounds like a stupid thing to do.\n"
                    + "You get hit and take " + damage + " damage.");
            playerHP = player.getPlayerHP() - damage;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            if (playerHP < 1){
                ui.mainTextArea.append("Unfortunately, the damge was too much. You pass out from the pain. You wake up floating in an endless void...\n...forever.");
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
        
                main.nextChoice1 = "lose";
            }
            else{
                ui.mainTextArea.append("You look up and see your neighbor float down from above. He looks angry.");
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
        
                main.nextChoice1 = "combat";    
            }
        }
        else {
            ui.mainTextArea.setText("You swing your glowing sword like a baseball bat, striking the fireball before it reaches you. It explodes, sending you flyin gover the balcony! "
                    + "Luckily, the hard ground and shrubs below break your fall. You take 1 damage. You look up and see your neighbor float down from above. He looks angry.");
            playerHP = player.getPlayerHP() - 1;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            ui.choice1.setText(">>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "combat";
        }
    }
    
    public void deflectFireball2(){
        int damage = diceRoll(4) + diceRoll(4);
        monster = new Monster_ChantingWizard();
        abilityCheck = monster.monsterDefenseDifficulty;
        if (abilityCheck > player.getPlayerDexterity() + player.getPlayerDexterityBonus()){
            ui.mainTextArea.setText("You try to block a speeding ball of fire with a sharp piece of metal with a handle you found on the floor. When you say like that, "
                    + "it sounds like a stupid thing to do.\n"
                    + "You get hit and take " + damage + " damage.");
            playerHP = player.getPlayerHP() - damage;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            if (playerHP < 1){
                ui.mainTextArea.append("Unfortunately, the damge was too much. You pass out from the pain. You wake up floating in an endless void...\n...forever.");
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
        
                main.nextChoice1 = "lose";
            }
            else{
                ui.mainTextArea.append("You look up and see your neighbor float down from above. He looks angry.");
                ui.choice1.setText(">>");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
        
                main.nextChoice1 = "combat";    
            }
        }
        else {
            ui.mainTextArea.setText("You swing your sword like a baseball bat, striking the fireball before it reaches you. It explodes, sending you flying into the wall!  "
                    + "In retrospect, you probably should've just gotten out of the way, but hitting a fireball with your sword looks so much cooler! Unfortunately. "
                    + "you take 3 damage. As you regain your composure, you see your neighbor gearing up for another attack.");
            playerHP = player.getPlayerHP() - 3;
            player.setPlayerHP(playerHP);
            ui.hpValueLabel.setText("" + player.getPlayerHP());
            ui.choice1.setText(">>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "combat";
        }
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
        /*if (hasTalk = true){
            ui.mainTextArea.setText("You go back down the stairs, defeated and a bit frustrated. You explain to them that he isn't answering. They look at each "
                + "other. You look up to see an intense glow coming from your neighbor's balcony. You get knocked to the side as the couple bounds upstairs together, "
                + "with what appears to be swords in their hands. Swords? You are completely confused now.");
        
        ui.choice1.setText("Follow the couple");
        ui.choice2.setText("Go up to your condo");
        ui.choice3.setText("Run to get help");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleFollow";
        main.nextChoice2 = "";
        }
        else {*/
        ui.mainTextArea.setText("You approach the couple outside. They are looking up at your neighbor talking quietly with each other as if not to let anyone know what they are saying. "
                + "You ask what was going on as you try to see what's happening above. ");
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleTalkCont";
       // }
    }
    
    public void coupleTalkCont(){
        hasTalk = true;
        ui.mainTextArea.setText("\"He’s been at this a while. He’s a strange one and is possibly mentally disturbed,\" the wife tells you not breaking her gaze from the balcony.\n\n"
                + "\"Have you tried to talk to him,\" the husband asks curiously. \"I mean, did you knock on his door or anything?\"");
        
        ui.choice1.setText("Go knock on the door");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "knock";
        main.nextChoice2 = "";
    }
    
    public void knock(){
        ui.mainTextArea.setText("You ascend the stairs to knock on your neighbor's door. The chanting grows louder and remains steady despite your repeated pounding on his door. "
                + "Your effort will be better spent doing literally anything else. Really...stop knocking.");
        
        ui.choice1.setText("Go back and talk to the couple");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleTalkAgain";
        main.nextChoice2 = "";
    }
    
    public void coupleTalkAgain(){
        ui.mainTextArea.setText("You go back down the stairs, defeated and a bit frustrated. You explain to them that he isn't answering. They look at each "
                + "other. You look up to see an intense glow coming from your neighbor's balcony. You get knocked to the side as the couple bounds upstairs together, "
                + "with what appears to be swords in their hands. Swords? You are completely confused now.");
        
        ui.choice1.setText("Follow the couple");
        ui.choice2.setText("Run to get help!");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleFollow";
        main.nextChoice2 = "runForHelp";
    }
    
    public void runForHelp(){
        ui.mainTextArea.setText("As you watch the couple run upatairs with swords, the thought crosses your mind that you might be in over your head. You decide to run for help. "
                + "Unfortunately, you don't get far. You hear a crash from upstairs and screaming. The glows burns brighter until the inevitable explosion sends mountains of shrapnel upon you."
                + " You black out, only to awaken in a dark void, where you will float for eternity.");
        
        ui.choice1.setText("Start Over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
    }
    
    public void coupleFollow(){
        ui.mainTextArea.setText("You follow the couple upstairs. They crash through the neighbor's front door and run to his balcony before you even reach the top. You hear yelling, "
                + "screaming, a struggle, and flashes of light. You wonder if you should run in and help or go find a weapon first.");
        
        ui.choice1.setText("Run into battle");
        ui.choice2.setText("Go find a weapon");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "balconyFight";
        main.nextChoice2 = "findWeapon";
    }
    
    public void balconyFight(){
        ui.mainTextArea.setText("You charge in after the couple...unarmed, which was a mistake...obviously. As you round the corner to the balcony, you only catch a glimpse of a bright, "
                + "white hot orb of fire speeding towards your face. Your head disintegrates upon impact, but your spirit, or whatever you are now, floats in a vast darkness. You are stuck "
                + "in the endless void...\n...forever.");
        
        ui.choice1.setText("Start Over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "title";
        main.nextChoice2 = "";
    }
    
    public void findWeapon(){
        ui.mainTextArea.setText("You run into your condo to look for a weapon. You hear the struggle next door. Was that an explosion? A strange hum is coming from your bedroom.");
        
        ui.choice1.setText("Get a knife from the kitchen");
        ui.choice2.setText("Investigate the hum");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "kitchen";
        main.nextChoice2 = "bedroomHum";
    }
    
    public void kitchen(){
        Weapon weapon = new Weapon_Knife();
        player.setWeaponName(weapon.getWeaponName());
        ui.weaponNameLabel.setText(player.getWeaponName());
        ui.mainTextArea.setText("You enter the kitchen looking for a weapon. You grab a kitchen knife from the knife block on the counter. You can still hear the struggle happening next "
                + "door. You take a deep breath before running next door armed with your knife. ");
        
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleFight";
    }
    
    public void bedroomHum(){
        ui.mainTextArea.setText("You go into your bedroom and notice that there is an intense glow eminating from underneath your bed. ");
        
        ui.choice1.setText("Investigate the glow");
        ui.choice2.setText("Go to the kitchen and get a knife");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleGlow";
        main.nextChoice2 = "kitchen";
    }
    
    public void coupleGlow(){
        weapon = new Weapon_GlowingSword();
        player.setWeaponName(weapon.weaponName);
        ui.weaponNameLabel.setText("" + weapon.getWeaponName());
        ui.mainTextArea.setText("You look under your bed and find what appears to be a sword. You remember your grandfather giving this to you on your birthday one year. "
                + "He told you that it was a very special sword that had been in the family for generations. It never glowed or hummed before, but today is strange.");
        
        ui.choice1.setText("Go help the couple");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleFight";
        main.nextChoice2 = "";
    }
    
    public void coupleFight(){
        ui.mainTextArea.setText("You barge into the condo and see your neighbor fighting the wife on the balcony. Her husband is laying on the floor of the living room, not moving. "
                + "A sword is next to him.");
        
        ui.choice1.setText("Swap your weapon with the sword");
        ui.choice2.setText("Help the wife");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "coupleSword";
        main.nextChoice2 = "helpWife";
        
    }
    
    public void coupleSword(){
        weapon = new Weapon_Sword();
        player.setWeaponName(weapon.weaponName);
        ui.weaponNameLabel.setText("Sword");
        
        ui.mainTextArea.setText("You pick up the husband's sword. It doesn't look like he's going to need it anymore. You look up just in time to see the chanting neighbor fling "
                + "a glowing orb of fire in your direction!");
        
        ui.choice1.setText("Dodge fireball");
        ui.choice2.setText("Stand there and take it like a man");
        ui.choice3.setText("Deflect the fireball with your sword");
        ui.choice4.setText("");
        
        main.nextChoice1 = "dodgeFireball2";
        main.nextChoice2 = "fireball";
        main.nextChoice3 = "deflectFireball2";
    }
    
    public void helpWife(){
        ui.mainTextArea.setText("There's no time to waste! You bound out toward the balcony heroically as the the neighbor and the wife battle each other! The wife handles the sword "
                + "like a pro, swinging that thing around like she's a ninja. Unfortunately, she finds out that you shouldn't bring a sword to a fireball fight as she takes fireball to "
                + "the chest, knocking her off of the balcony to the path below!");
        
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "helpWifeCont";
    }
    
    public void helpWifeCont(){
        ui.mainTextArea.setText("You might be able to get the jump on the neighbor if you attack now, but he could also turn you into a pile of ashes...ahh, choices.");
        
        ui.choice1.setText("Sneak attack the wizard neighbor!");
        ui.choice2.setText("Try to reason with him");
        ui.choice3.setText("Apologize and see yourself out? I mean, worth a try, right?");
        ui.choice4.setText("");
        
        main.nextChoice1 = "attackAdvantage";
        main.nextChoice2 = "reason2";
        main.nextChoice3 = "apologize";
    }
    
    public void apologize(){
        ui.mainTextArea.setText("You look at the neighbor, being as still as possible. He turns toward you, fireball hovering in his hand. \"Look,\" you say as you put the sword "
                + "gently on the floor, \"I just wanted to take a nap. I was...um...concerned for you.\"\n"
                + "He doesn't look like he's buying it...You could tell by the fireball speeding towards your face.");
        ui.choice1.setText(">>");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "apologizeCont";
    }
    
    public void apologizeCont(){
        monster = new Monster_ChantingWizard();
        monster.setMonsterDefenseDifficulty(16);
        abilityCheck = monster.getMonsterDefenseDifficulty();
        abilityCheckRoll = diceRoll(20) + player.getPlayerDexterityBonus();
        if (abilityCheckRoll > abilityCheck){
            ui.mainTextArea.setText("You instinctively duck and the fireball whizzes past your head. You notice the smell of burnt hair as you grab the " + player.getWeaponName()
                + "from the floor.");
            
            ui.choice1.setText(">>");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "combat";
        }
        else {
            ui.mainTextArea.setText("Unfortunately, your reflexes aren't as good as your gaming skills. You take full force of the fireball to the face. Ouch. After your head disintegrates, "
                    + "you're left alone, floating in an empty void...\n"
                    + "...forever.");
            
            ui.choice1.setText("Start Over");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        
            main.nextChoice1 = "title";
        }
        ui.mainTextArea.setText("");
    }
        
}
