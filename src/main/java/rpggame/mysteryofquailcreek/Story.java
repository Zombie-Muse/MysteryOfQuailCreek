/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

/**
 *
 * @author xxzom
 */
public class Story {
    Main main;
    UI ui;
    VisibilityManager vm;

    public Story(Main m, UI userInterface, VisibilityManager vManage){
        main = m;
        ui = userInterface;
        vm = vManage;
    }
    
    //Story elements were from previous version of game. The choices will be controled differently for current version
    public String intro(){
        return "The sofa is comfortable. After watching hours of Netflix, sleep sounds so good. Your phone slips from your hand as you drift off to sleep. \n"
                + "You dream of wizards and magic and knights protecting the realm. You dream of a dark cloud rising from the earth. Then the chanting starts. \n"
                + "You awaken to the sound of someone’s voice. He is speaking...or singing? It sounds more like chanting. You can’t really make out what he is saying though. \n"
                + "All you know is that it’s pretty unusual for your condo complex. It’s usually very peaceful. \n"
                + "The chanting grows louder and you can tell that it’s fairly close outside. You pick yourself up off the couch wondering what's going on.\n\n"
                + "1]   Go to the balcony to investigate\n"
                + "2]   Go downstairs to investigate\n";
        
    }
    
    public String balcony(){
        return "You open the slider to the balcony. You are only one floor up. You see that the couple that live across from you are both standing outside \n"
                + "looking up toward your neighbor’s condo. You turn to the direction they are looking and see your neighbor appearing to float on his balcony\n"
                + " while chanting loudly. A strange glow appears in front of him and seems to grow in intensity as he chants\n\n"
                + "1]   Try to talk to your chanting neighbor\n"
                + "2]   Go downstairs to investigate\n"
                + "3]   Go inside and go back to sleep\n";
    }
    
    public String downstairs(){
        return "You go out your front door and down the stairs. You can hear the chanting above you. It seems to be coming from your neighbor’s balcony. \n"
                + "You see the couple from the condo across the way. They are looking up at your neighbor with concerned expressions.\n\n";
    }
    
    public String chantingTalk(){
        return "He seems completely oblivious to your presence. A strange glow begins to manifest if front of him. \n"
                + "Maybe if you throw something at him, you can get his attention...of course, that could also anger him. \n"
                + "1]   Yell at him to get his attention\n"
                + "2]   Go inside to find something to throw at him\n";
    }
    
    public String yell(){
        return "You yell at him. You scream. He doesn't break his trance. The glow is growing brighter. This probably isn't a good thing.\n"
                + "1]   Go inside to find somethingto throw at him\n"
                + "2]   Go downstairs to investigate\n"
                + "3]   Go back inside and go back to sleep\n";
    }
    
    public String sleep(){
        return "You go back inside, thinking all of this is too much to handle at the moment. You lay back down on the couch and attempt to fall asleep. \n"
                + "The chanting gets louder. The room begins to shake, and in an instant, the entire condo explodes. \n"
                + "You find yourself drifting into a dark, endless void...\n\n"
                + "...forever.";
    }
        
}
