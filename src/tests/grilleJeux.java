package tests;

import java.awt.Graphics;

public class grilleJeux {

	public grilleJeux(Graphics g)
    {
      //Ligne gauche
      g.drawLine(10,10 ,10,840);
      //Ligne haut
      g.drawLine(10,10,840,10);
      //Ligne droite
      g.drawLine(840,10,840,840);
      //Ligne bas
      g.drawLine(10,840,840,840);
      //Lignes verticales
      for(int x = 140;x<840;x+=140)
          g.drawLine(x,10,x,840);
      //Lignes horizontales
      for (int y = 140;y<840;y+=140)
          g.drawLine(10,y,840,y);
    }


}
