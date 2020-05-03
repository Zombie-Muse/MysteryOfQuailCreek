/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 /*
 * @author ZomB
 */
public class Main {
    ChoiceHandler ch = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Player player = new Player();
    Story story = new Story(this, ui, vm, player);
    
    public static void main(String[] args){
        new Main();
            
        }
    
    public Main(){
        ui.createUI(ch);
        vm.showTitleScreen(); 
        story.playerDefault(); //This doesn't seem to override any values in the playerPanel1 or playerPanel2. WTF?
         
    }
    
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String playerChoice = event.getActionCommand();
            
            switch (playerChoice){
                case "Start":
                    vm.gameScreen();
                    break;
                case "c1":
                    break;
                case "c2":
                    break;
                case "c3":
                    break;
                case "c4":
                    break;
            }
        }
    }
}

