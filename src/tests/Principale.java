package tests;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Principale {
	  public static void main(String[] args)
	    {
	      JeuDeMemory JDM = new JeuDeMemory();
	      JFrame frame = new JFrame();
	      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      frame.getContentPane().add(JDM, BorderLayout.CENTER);
	      frame.setTitle( "Jeu de memoire" );
	      frame.setSize(900, 900);
	      frame.setVisible(true);
	    }
}
