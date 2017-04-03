package tests;

import java.util.Random;

public class Aleatoire  {
	
	 public Aleatoire(int [][] tableauJeux,int [] nFois)
	    {
	      int randomInt = 0;
	      Random randomGenerateur = new Random();
	      for(int i = 0; i<18; i++)
	        nFois[i] = 0;
	      for(int x = 0; x < 6; x++)
	      {
	        for(int y = 0; y < 6; y++)
	        {
	          do
	          {
	            randomInt = randomGenerateur.nextInt(18);
	            if(nFois[randomInt] < 2)
	              tableauJeux[x][y] = randomInt;
	          }
	          while(nFois[randomInt] == 2);
	          if(nFois[randomInt] < 2)
	            nFois[randomInt]++;
	        }
	      }
	      
	    }
}
