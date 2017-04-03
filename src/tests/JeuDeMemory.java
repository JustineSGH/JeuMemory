package tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
 
class JeuDeMemory extends JPanel implements MouseListener, ActionListener 
{
	
  int [] nFois;
  boolean [][] tabBool;
  Image [] tableauImg; // On initialise le tableau pour y insérer les images
  int [][] tableauJeux;//On initialise le tableau qui est une grille 
  int NbrClic = 0;//On met le nombre de clic à zéro pour commencer

  public JeuDeMemory()
  {		
	this.addMouseListener(this);
    nFois = new int[18];
    tableauJeux = new int[6][6];
    tableauImg = new Image[18];
    tabBool = new boolean[6][6];//Si false l'image n'apparaît pas, si true l'image apparaît
    
    for(int i = 0;i<18;i++)
		try
    	{
			tableauImg[i] = ImageIO.read(new URL("file:/Users/justi/workspace/tests/bin/tests/images/"+i+".gif"));
		}
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
  new Aleatoire(tableauJeux , nFois);//place les images aléatoirements dans le jeux
  }
  
    public void mouseClicked(MouseEvent e)
    {    
      //Vérification, si l'endroit cliquer est valide , on met l'image a vrai sinon faux
      for(int i = 0; i<6;i++)
      {
        for(int j = 0; j<6;j++)
        {
          if(e.getX() > (i*140)+10 && e.getX() < 140*(i+1)+10)
          {
            if(e.getY() > (j*140)+10 && e.getY() < 140*(j+1)+10)
            {    
                NbrClic++;//On calcule le nombre de clic valide, pour savoir si c'est le clic1 ou le clic2
                tabBool[i][j] = true;
            }
          }
        repaint(); 
        }
      } 
        //Vérification
        if(NbrClic == 1)
        {
            e.getX();
            e.getY();
            NbrClic++;
        }
        
        if(NbrClic == 2)
        {
         repaint();
         System.out.println(NbrClic);               
         NbrClic=0;
        }
    }
  
    public void mousePressed(MouseEvent e) {
    }
 
    public void mouseReleased(MouseEvent e) {
    }
 
    public void mouseEntered(MouseEvent e) {
    }
 
    public void mouseExited(MouseEvent e) {
    }
 
    public void actionPerformed(ActionEvent e)
    {
    }

    public void afficheImage(Graphics g)
    {
      for(int i = 0;i<6;i++)
      {
        for(int j = 0;j<6;j++)
        {
          if(tabBool[i][j] == true)
          {
            if(NbrClic <= 2)
              g.drawImage(tableauImg[tableauJeux[i][j]], (i*140)+11, (j*140)+11, 120, 120, (ImageObserver) this);
          }
        }
      }
    }
   
    public void verificationImage(Graphics g)
    {
    afficheImage(g);
    }
   
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      Color background = new Color(255,255,255);
      setBackground(background);
      new grilleJeux(g);
      verificationImage(g);  
    }
  }

