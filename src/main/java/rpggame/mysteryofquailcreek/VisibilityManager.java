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
public class VisibilityManager {
    UI ui;
    
    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }
    
    public void showTitleScreen(){
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel1.setVisible(false);
        ui.playerPanel2.setVisible(false);
    }
    
    public void gameIntro(){
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel1.setVisible(true);
        ui.playerPanel2.setVisible(true);
    }
}
