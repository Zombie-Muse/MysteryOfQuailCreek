/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

import Items.Monster;

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
        }
    }
    
    //Story elements
    public void intro(){
        ui.mainTextArea.setText("The sofa is comfortable. After watching hours of Netflix, sleep sounds so good. Your phone slips from your hand as you drift off to sleep. "
                + "You dream of wizards and magic and knights protecting the realm. You dream of a dark cloud rising from the earth. Then the chanting starts. "
                + "You awaken to the sound of someone’s voice. He is speaking...or singing? It sounds more like chanting. You can’t really make out what he is saying though. "
                + "All you know is that it’s pretty unusual for your condo complex. It’s usually very peaceful. "
                + "The chanting grows louder and you can tell that it’s fairly close outside. You pick yourself up off the couch wondering what's going on.");
        ui.choice1.setText("Go to the balcony to investigate");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("");
        ui.choice4.setText("");
        
        main.nextChoice1 = "balcony";
        main.nextChoice2 = "downstairs";
    }
    
    public void balcony(){
        ui.mainTextArea.setText("You open the slider to the balcony. You are only one floor up. You see that the couple that live across from you are both standing outside "
                + "looking up toward your neighbor’s condo. You turn to the direction they are looking and see your neighbor appearing to float on his balcony"
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
        
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
    }
    
    public void chantingTalk(){
        ui.mainTextArea.setText("He seems completely oblivious to your presence. A strange glow begins to manifest if front of him.");
        
        ui.choice1.setText("Maybe if you throw something at him, you can get his attention...of course, that could also anger him.");
        ui.choice2.setText("Yell at him to get his attention");
        ui.choice3.setText("Go inside to find something to throw at him");
    }
    
    public void yell(){
        ui.mainTextArea.setText("You yell at him. You scream. He doesn't break his trance. The glow is growing brighter. This probably isn't a good thing.\n");
        
        ui.choice1.setText("Go inside to find something to throw at him");
        ui.choice2.setText("Go downstairs to investigate");
        ui.choice3.setText("Go back inside and go back to sleep");
    }
    
    public void sleep(){
        ui.mainTextArea.setText("You go back inside, thinking all of this is too much to handle at the moment. You lay back down on the couch and attempt to fall asleep. "
                + "The chanting gets louder. The room begins to shake, and in an instant, the entire condo explodes. "
                + "You find yourself drifting into a dark, endless void...\n"
                + "...forever.");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
    }
        
}
