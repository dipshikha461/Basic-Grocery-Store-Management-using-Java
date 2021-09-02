package GUIProject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GroceryListGUI extends JFrame {
	 JTextArea  ItemTextArea   = new JTextArea ();

	   JLabel     QuantityLabel           = new JLabel     ("Quantity: ");
	   JTextField QuantityTextField       = new JTextField (10);
	   JLabel     ItemNameLabel         = new JLabel     ("Item Name: ");
	   JTextField ItemNameTextField     = new JTextField (10);

	   JButton    testDataButton    = new JButton ("Test Data");
	   JButton    addButton         = new JButton ("Add");
	   JButton    deleteButton      = new JButton ("Delete");
	   JButton    editButton        = new JButton ("Edit");
	   JButton    editSaveButton    = new JButton ("Save");
	   JButton    displayAllButton  = new JButton ("Display All");
	   JButton    exitButton        = new JButton ("Exit");


	   
	   private LinkedList<GroceryList> GroceryLinkedList = new LinkedList<GroceryList> ();
	   private int editIndex;


	   public GroceryListGUI ()
	   {
	      JPanel flow1Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
	      JPanel flow2Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
	      JPanel gridPanel  = new JPanel (new GridLayout (2, 1));

	      ItemTextArea.setEditable (false);

	      flow1Panel.add (QuantityLabel);
	      flow1Panel.add (QuantityTextField);
	      flow1Panel.add (ItemNameLabel);
	      flow1Panel.add (ItemNameTextField);

	      flow2Panel.add (testDataButton);
	      flow2Panel.add (addButton);
	      flow2Panel.add (editButton);
	      flow2Panel.add (editSaveButton);
	      flow2Panel.add (deleteButton);
	      flow2Panel.add (displayAllButton);
	      flow2Panel.add (exitButton);

	      gridPanel.add (flow1Panel);
	      gridPanel.add (flow2Panel);

	      editSaveButton.setEnabled (false);

	      add (ItemTextArea, BorderLayout.CENTER);
	      add (gridPanel,       BorderLayout.NORTH);


	      addButton.addActionListener        (event -> addItem ());
	      displayAllButton.addActionListener (event -> displayAll ());
	      editButton.addActionListener       (event -> editList ());
	      editSaveButton.addActionListener   (event -> editSaveList ());
	      exitButton.addActionListener       (event -> exitApplication ());
	      deleteButton.addActionListener     (event -> deleteItem ());
	      testDataButton.addActionListener   (event -> addTestData ());

	      setTitle ("Customer Grocery List");
	   }

	   private boolean isItemInLinkedList (String Str)
	   {
	      boolean inList = false;

	      for (GroceryList items : GroceryLinkedList)
	      {
	         if (items.getName ().contains (Str))
	         {
	            inList = true;
	         }
	      }

	      return inList;
	   }

	   private void addItem ()
	   {
	      if (isItemInLinkedList (ItemNameTextField.getText()) == true)
	      {
	         JOptionPane.showMessageDialog (GroceryListGUI.this,
	                              "Error: Item is already in the database.");
	      }
	      else
	      {
	         
	            GroceryList item = new GroceryList (ItemNameTextField.getText(),
	                                                  QuantityTextField.getText());

	            GroceryLinkedList.add (item);

	            displayAll ();

	            ItemNameTextField.setText("");
	            QuantityTextField.setText("");

	      }
	   }

	   private void deleteItem ()
	   {
	      if (GroceryLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog (GroceryListGUI.this,
	                                        "Error: Database is empty.");
	      }
	      else if (isItemInLinkedList (ItemNameTextField.getText()) == false)
	      {
	         JOptionPane.showMessageDialog (GroceryListGUI.this,
	                                       "Error: Item is not in the database.");
	      }
	      else
	      {
	         for (int s = 0; s < GroceryLinkedList.size(); s++)
	         {
	            String currItem = GroceryLinkedList.get (s).getName ();

	            if (currItem.compareToIgnoreCase (ItemNameTextField.getText()) == 0)
	            {
	               GroceryLinkedList.remove (s);
	            }
	         }

	         displayAll ();

	         ItemNameTextField.setText("");
	         QuantityTextField.setText("");
	      }
	   }

	   private void editList ()
	   {
	      if (GroceryLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog (GroceryListGUI.this,
	                                        "Error: Database is empty.");
	      }
	      else if (isItemInLinkedList (QuantityTextField.getText()) == false && isItemInLinkedList (ItemNameTextField.getText()) == false)
	      {
	         JOptionPane.showMessageDialog (GroceryListGUI.this,
	                                        "Error: Item is not in the database.");
	      }
	      else
	      {
	         editIndex = -1;

	         for (int s = 0; s < GroceryLinkedList.size(); s++)
	         {
	            String currItem = GroceryLinkedList.get (s).getQuantity();
	            //String qtty= GroceryLinkedList.get (s).getQuantity ();
	           // System.out.println(currItem);

	            if (currItem.contains(QuantityTextField.getText()) )
	            {
	               editIndex = s;
	               s = GroceryLinkedList.size(); 
	            }
	            
	         }

	         
	         if (editIndex >= 0)
	         {
	            editSaveButton.setEnabled   (true);

	            editButton.setEnabled       (false);
	            testDataButton.setEnabled   (false);
	            addButton.setEnabled        (false);
	            deleteButton.setEnabled     (false);
	            displayAllButton.setEnabled (false);
	            exitButton.setEnabled       (false);

	            //ItemNameTextField.setText (GroceryLinkedList.get (editIndex).getName () );
	            QuantityTextField.setText   (GroceryLinkedList.get (editIndex).getQuantity () );
	         }


	      }

	   }

	   private void editSaveList ()
	   {
	      

	      GroceryLinkedList.get (editIndex).setName (ItemNameTextField.getText() );
	      GroceryLinkedList.get (editIndex).setQuantity (QuantityTextField.getText() );

	      displayAll ();

	      ItemNameTextField.setText ("");
	      QuantityTextField.setText ("");

	      editSaveButton.setEnabled   (false);

	      editButton.setEnabled       (true);
	      testDataButton.setEnabled   (true);
	      addButton.setEnabled        (true);
	      deleteButton.setEnabled     (true);
	      displayAllButton.setEnabled (true);
	      exitButton.setEnabled       (true);
	   }

	   private void addTestData ()
	   {
	      ItemNameTextField.setText ("Rice");
	      QuantityTextField.setText   ("10");
	      addItem ();

	      ItemNameTextField.setText ("Dal");
	      QuantityTextField.setText   ("8");
	      addItem ();
	      
	      ItemNameTextField.setText ("Sugar");
	      QuantityTextField.setText   ("5");
	      addItem ();
	      
	      ItemNameTextField.setText ("Salt");
	      QuantityTextField.setText   ("3");
	      addItem ();
	      
	      ItemNameTextField.setText ("Tea");
	      QuantityTextField.setText   ("2");
	      addItem ();
	      
	      ItemNameTextField.setText ("Coffee");
	      QuantityTextField.setText   ("9");
	      addItem ();
	      
	      ItemNameTextField.setText ("Flour");
	      QuantityTextField.setText   ("7");
	      addItem ();
	   }

	   private void displayAll ()
	   {
	      ItemTextArea.setText ("");

	      for (GroceryList items : GroceryLinkedList)
	      {
	         ItemTextArea.append (items + "\n");
	      }
	   }
	   
	   private void exitApplication ()
	   {
	      System.exit (0); 
	   }

	   public static void main (String[] args)
	   {
	      GroceryListGUI app = new GroceryListGUI ();
	      app.setVisible  (true);
	      app.setSize     (500, 310);
	      app.setLocation (200, 100);
	      app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	   }

}

