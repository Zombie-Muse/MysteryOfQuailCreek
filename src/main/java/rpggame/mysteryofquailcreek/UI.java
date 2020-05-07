/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.mysteryofquailcreek;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import rpggame.mysteryofquailcreek.Main.ChoiceHandler;


/**
 *
 * @author ZomB
 */
public class UI {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, mainTextPanelBattle, choiceButtonPanel, monsterPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpValueLabel, attackLabel, attackValueLabel, xpLabel, xpValueLabel, levelLabel, levelValueLabel;
    JLabel dexterityLabel, dexterityValueLabel, weaponLabel, weaponNameLabel, armorClassLabel, armorClassValueLabel;
    JLabel monsterNameLabel,monsterNameValueLabel, monsterHPLabel, monsterHPValueLabel, monsterArmorLabel, monsterArmorValueLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font playerFont = new Font("Times New Roman", Font.PLAIN, 16);
    
    
    public void createUI(ChoiceHandler ch){
        
        //Window
        window = new JFrame();
        window.setSize(1280, 720);
        window.setTitle("Mystery of Quail Creek");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        
        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(340, 100, 600, 100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("The Mystery of Quail Creek");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(590, 400, 100, 50);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(ch);
        startButton.setActionCommand("Start");
        startButtonPanel.add(startButton);
        
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        
        //Game Screen
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(320, 150, 600, 200);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);
        
        mainTextArea = new JTextArea("Main text area!");
        mainTextArea.setBounds(340, 100, 600, 200);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(390, 400, 500, 150);
        choiceButtonPanel.setBackground(Color.white);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);
        
        //Buttons for choices
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setBorderPainted(false);
        choice1.addActionListener(ch);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setBorderPainted(false);
        choice2.addActionListener(ch);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setBorderPainted(false);
        choice3.addActionListener(ch);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setBorderPainted(false);
        choice4.addActionListener(ch);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        //Player stats panels
        playerPanel = new JPanel();
        playerPanel.setBounds(290, 15, 700, 40);
        playerPanel.setBackground(Color.black);
        playerPanel.setBorder(new LineBorder(Color.white));
        playerPanel.setLayout(new GridLayout(1, 6));
        window.add(playerPanel);
        
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(playerFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        
        hpValueLabel = new JLabel();
        hpValueLabel.setFont(playerFont);
        hpValueLabel.setForeground(Color.white);
        playerPanel.add(hpValueLabel);
        
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(playerFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(playerFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);
        
        armorClassLabel = new JLabel("Armor Class: ");
        armorClassLabel.setFont(playerFont);
        armorClassLabel.setForeground(Color.white);
        playerPanel.add(armorClassLabel);
        
        armorClassValueLabel = new JLabel();
        armorClassValueLabel.setFont(playerFont);
        armorClassValueLabel.setForeground(Color.white);
        playerPanel.add(armorClassValueLabel);
        
        /*xpLabel = new JLabel("XP: ");
        xpLabel.setFont(playerFont);
        xpLabel.setForeground(Color.white);
        playerPanel.add(xpLabel);
        
        xpValueLabel = new JLabel();
        xpValueLabel.setFont(playerFont);
        xpValueLabel.setForeground(Color.white);
        playerPanel.add(xpValueLabel);
        
        levelLabel = new JLabel("Level: ");
        levelLabel.setFont(playerFont);
        levelLabel.setForeground(Color.white);
        playerPanel.add(levelLabel);
        
        levelValueLabel = new JLabel();
        levelValueLabel.setFont(playerFont);
        levelValueLabel.setForeground(Color.white);
        playerPanel.add(levelValueLabel);
        */
        
        //Monster Stats during combat
        monsterPanel = new JPanel();
        monsterPanel.setBounds(290, 70, 700, 40);
        monsterPanel.setBackground(Color.black);
        monsterPanel.setBorder(new LineBorder(Color.white));
        monsterPanel.setLayout(new GridLayout(1, 6));
        window.add(monsterPanel);
        
        monsterNameLabel = new JLabel("Monster: ");
        monsterNameLabel.setFont(playerFont);
        monsterNameLabel.setForeground(Color.white);
        monsterPanel.add(monsterNameLabel);
        
        monsterNameValueLabel = new JLabel();
        monsterNameValueLabel.setFont(playerFont);
        monsterNameValueLabel.setForeground(Color.white);
        monsterPanel.add(monsterNameValueLabel);
        
        monsterHPLabel = new JLabel("Monster HP: ");
        monsterHPLabel.setFont(playerFont);
        monsterHPLabel.setForeground(Color.white);
        monsterPanel.add(monsterHPLabel);
        
        monsterHPValueLabel = new JLabel();
        monsterHPValueLabel.setFont(playerFont);
        monsterHPValueLabel.setForeground(Color.white);
        monsterPanel.add(monsterHPValueLabel);
        
        monsterArmorLabel = new JLabel("Monster Armor Class: ");
        monsterArmorLabel.setFont(playerFont);
        monsterArmorLabel.setForeground(Color.white);
        monsterPanel.add(monsterArmorLabel);
        
        monsterArmorValueLabel = new JLabel();
        monsterArmorValueLabel.setFont(playerFont);
        monsterArmorValueLabel.setForeground(Color.white);
        monsterPanel.add(monsterArmorValueLabel);
        
        window.setVisible(true);
        
    }
    
}
