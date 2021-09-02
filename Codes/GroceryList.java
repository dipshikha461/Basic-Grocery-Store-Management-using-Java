package GUIProject;

import javax.swing.JOptionPane;

public class GroceryList {
	

	   private String name;
	   private String quantity;

	   public GroceryList ()
	   {
	      name = "";
	      quantity   = "";
	   }

	   public GroceryList (String name, String quantity)
	   {

	      if (name.length () == 0)
	      {
	         JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
	         System.out.println("Error: name cannot be blank.");
	      }

	      else if (quantity.length () == 0)
	      {
	         JOptionPane.showMessageDialog (null, "Error: Quantity cannot be blank.");
	         System.out.println ("Error: Quantity cannot be blank.");
	      }

	      else
	      {
	         
	         this.name = name;
	         this.quantity   = quantity;
	      }
	   }

	   public String getName ()
	   {
	      return name;
	   }

	   public String getQuantity ()
	   {
	      return quantity;
	   }

	   public void setName (String name)
	   {
	      this.name = name;
	   }

	   public void setQuantity (String quantity)
	   {
	      this.quantity = quantity;
	   }

	   
	   public String toString ()
	   {
	       String q1=quantity;
	       int q2=Integer.parseInt(q1);	
	       String x= q1 + "\t" + name + "\t" + (q2*5) + " Rupees";
	       return x ;
	   }
	 

}