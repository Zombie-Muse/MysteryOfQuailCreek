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
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel1, playerPanel2;
    JLabel titleNameLabel, hpLabel, hpValueLabel, attackLabel, attackValueLabel, xpLabel, xpValueLabel, levelLabel, levelValueLabel;
    JLabel dexterityLabel, dexterityValueLabel, weaponLabel, weaponNameLabel, armorClassLabel, armorClassValueLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font playerFont = new Font("Times New Roman", Font.PLAIN, 16);
    
    
    public void createUI(ChoiceHandler ch){
        
        //Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        
        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 150, 600, 500);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("The Mystery of Quail Creek");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
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
        mainTextPanel.setBounds(100, 150, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);
        
        mainTextArea = new JTextArea("Main text area!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);
        
        //Buttons for choices
        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(ch);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(ch);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(ch);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(ch);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        //Player stats panels
        playerPanel1 = new JPanel();
        playerPanel1.setBounds(50, 15, 700, 40);
        playerPanel1.setBackground(Color.black);
        playerPanel1.setBorder(new LineBorder(Color.white));
        playerPanel1.setLayout(new GridLayout(1, 6));
        window.add(playerPanel1);
        
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(playerFont);
        hpLabel.setForeground(Color.white);
        playerPanel1.add(hpLabel);
        
        hpValueLabel = new JLabel();
        hpValueLabel.setFont(playerFont);
        hpValueLabel.setForeground(Color.white);
        playerPanel1.add(hpValueLabel);
        
        xpLabel = new JLabel("XP: ");
        xpLabel.setFont(playerFont);
        xpLabel.setForeground(Color.white);
        playerPanel1.add(xpLabel);
        
        xpValueLabel = new JLabel();
        xpValueLabel.setFont(playerFont);
        xpValueLabel.setForeground(Color.white);
        playerPanel1.add(xpValueLabel);
        
        levelLabel = new JLabel("Level: ");
        levelLabel.setFont(playerFont);
        levelLabel.setForeground(Color.white);
        playerPanel1.add(levelLabel);
        
        levelValueLabel = new JLabel();
        levelValueLabel.setFont(playerFont);
        levelValueLabel.setForeground(Color.white);
        playerPanel1.add(levelValueLabel);
        
        playerPanel2 = new JPanel();
        playerPanel2.setBounds(50, 70, 700, 40);
        playerPanel2.setBackground(Color.black);
        playerPanel2.setBorder(new LineBorder(Color.white));
        playerPanel2.setLayout(new GridLayout(1, 6));
        window.add(playerPanel2);
        
        attackLabel = new JLabel("Attack: ");
        attackLabel.setFont(playerFont);
        attackLabel.setForeground(Color.white);
        playerPanel1.add(attackLabel);
        
        attackValueLabel = new JLabel();
        attackValueLabel.setFont(playerFont);
        attackValueLabel.setForeground(Color.white);
        playerPanel1.add(attackValueLabel);
        
        dexterityLabel = new JLabel("Dexterity: ");
        dexterityLabel.setFont(playerFont);
        dexterityLabel.setForeground(Color.white);
        playerPanel1.add(dexterityLabel);
        
        dexterityValueLabel = new JLabel();
        dexterityValueLabel.setFont(playerFont);
        dexterityValueLabel.setForeground(Color.white);
        playerPanel1.add(dexterityValueLabel);
        
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(playerFont);
        weaponLabel.setForeground(Color.white);
        playerPanel2.add(weaponLabel);
        
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(playerFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel2.add(weaponNameLabel);
        
        armorClassLabel = new JLabel("Armor Class: ");
        armorClassLabel.setFont(playerFont);
        armorClassLabel.setForeground(Color.white);
        playerPanel2.add(armorClassLabel);
        
        armorClassValueLabel = new JLabel();
        armorClassValueLabel.setFont(playerFont);
        armorClassValueLabel.setForeground(Color.white);
        playerPanel2.add(armorClassValueLabel);
        
        window.setVisible(true);
        
    }
    
}
