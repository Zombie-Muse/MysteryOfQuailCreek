/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

/**
 *
 * @author ZomB
 */
public class VisibilityManager {
    UI ui;
    
    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }
    
    //Title Screen...obviously
    public void showTitleScreen(){
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.monsterPanel.setVisible(false);
    }
    
    //Main game screen
    public void gameScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.monsterPanel.setVisible(false);
    }
    
    //Combat game screen
    public void combatScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.monsterPanel.setVisible(true);
    }
}
