import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import BreezySwing.*;

public class Main extends GBFrame{
	
	int userSize = Integer.parseInt(JOptionPane.showInputDialog("How many integers would you like to enter?"));	//ask user for size of array
	JLabel instructions = addLabel("Enter an integer to get started",	1,1,1,1);	//collect user inputs
	IntegerField userInput = addIntegerField(0,	1,1,1,1);
	JLabel addNumberInstruc = addLabel("Click the button on the right to add a number to the array",	2,1,1,1);
	JButton takeInput = addButton("Add number",	2,2,1,1);
	JLabel mergeInstruc = addLabel("Click the button on the right to see the list in numerical order",	3,1,1,1);
	JButton showMerged = addButton ("Show sorted list",	3,2,1,1);
	int[] integerList;
	int currentInputIndex = 0;
	JLabel searchInstruc = addLabel("Click the button on the right to find what index a number is at",	4,1,1,1);
	JButton showBinarySearch = addButton("Search for element",	4,2,1,1);
	public int sortedArr[];
	
	public void buttonClicked(JButton buttonOBJ) {
		
	}
	
	public Main() {	//action listener for when buttons are pressed
		takeInput.setActionCommand("add");
		takeInput.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   addNumber();
				  }
				} );
		showMerged.setActionCommand("add");
		showMerged.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   displaySort();
				  }
				} );
		showBinarySearch.setActionCommand("add");
		showBinarySearch.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   displaySearch();
				  }
				} );
		initalizeArray(userSize);
	}
	
	public void initalizeArray(int size) {	//method to initalize array
		integerList = new int[size];
	}
	
	public void addNumber() {	//add user input to an array
		int input = userInput.getNumber();
		
		integerList[currentInputIndex] = input;
		currentInputIndex++;
		
		userInput.setNumber(0);
		
		System.out.println(Arrays.toString(integerList));
		
	}

	
	String printArray(int arr[])	//print array
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
           System.out.print(arr[i] + " ");
        System.out.println();
        return Arrays.toString(arr);
    }
	
	int[] printDupArray(int arr[]) {
		int n = arr.length;
        for (int i = 0; i < n; ++i)
           System.out.print(arr[i] + " ");
        System.out.println();
		return arr;
	}
	
	public void displaySort() {	//display sorted array
		int arr[] = integerList;
  
        mergeSort ob = new mergeSort();
        ob.sort(arr, 0, arr.length - 1);
        
        JDialog zMessageDialog = new JDialog((java.awt.Frame) null, true);
		zMessageDialog.setTitle("Sorted Array");
		zMessageDialog.setLayout(new BorderLayout());
		JTextArea zTextArea = new JTextArea("The sorted array is: " + printArray(arr));
		zTextArea.setEditable(false);
		zTextArea.setColumns(40);
		zTextArea.setRows(10);
		zTextArea.setBackground(null);
		JScrollPane zScrollPane = new JScrollPane(zTextArea);
		zMessageDialog.add(zScrollPane, BorderLayout.CENTER);
		zMessageDialog.revalidate();
		zMessageDialog.pack();
		zMessageDialog.setVisible(true);

        
        sortedArr = printDupArray(arr);
  
	}
	
	 public void main1(String args[])	//method for binary search
	    {
	        BinarySearch ob = new BinarySearch();
	        int arr[] = sortedArr;
	        int n = arr.length;
	        int x = 10;
	        int result = ob.binarySearch(arr, 0, n - 1, x);
	        if (result == -1)
	            System.out.println("Element not present");
	        else
	            System.out.println("Element found at index "
	                               + result);
	    }
	 
	public void displaySearch() {	//method to display what number the user input and looked for
		int lookFor = Integer.parseInt(JOptionPane.showInputDialog("Which number would you like to look for?"));
		BinarySearch ob = new BinarySearch();
		int arr[] = sortedArr;
        int n = arr.length;
        int x = lookFor;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1) {
            JDialog zMessageDialog = new JDialog((java.awt.Frame) null, true);
    		zMessageDialog.setTitle("Element Not Present");
    		zMessageDialog.setLayout(new BorderLayout());
    		JTextArea zTextArea = new JTextArea("Element not present");
    		zTextArea.setEditable(false);
    		zTextArea.setColumns(40);
    		zTextArea.setRows(10);
    		zTextArea.setBackground(null);
    		JScrollPane zScrollPane = new JScrollPane(zTextArea);
    		zMessageDialog.add(zScrollPane, BorderLayout.CENTER);
    		zMessageDialog.revalidate();
    		zMessageDialog.pack();
    		zMessageDialog.setVisible(true);
        } else {
            JDialog zMessageDialog = new JDialog((java.awt.Frame) null, true);
    		zMessageDialog.setTitle("Element Present");
    		zMessageDialog.setLayout(new BorderLayout());
    		JTextArea zTextArea = new JTextArea("Element found at index "
                    + result);
    		zTextArea.setEditable(false);
    		zTextArea.setColumns(40);
    		zTextArea.setRows(10);
    		zTextArea.setBackground(null);
    		JScrollPane zScrollPane = new JScrollPane(zTextArea);
    		zMessageDialog.add(zScrollPane, BorderLayout.CENTER);
    		zMessageDialog.revalidate();
    		zMessageDialog.pack();
    		zMessageDialog.setVisible(true);
        }
        
      
        
	}
	
	public static void main(String[] args) {
    	JFrame frm = new Main();
        frm.setTitle("merge sort");
        frm.setSize (300, 200);
        frm.setVisible (true);
    	
    }

}
