/*
 * Brihi Joshi
 * 2016142
 * CSE
 * Refresher Module - Lab 3
 * 
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.*;


public class lab3 {
	
	//Costructor
	public lab3(){
		show();
	}

	//Function for all the GUI
	public void show(){

    	//Declaring all the variables. Will be using Text Fields
    	JFrame frame = new JFrame("IIITD Fruit Stall");
    	
    	//Setting up the Header Panel
    	JLabel inven = new JLabel("Inventory",SwingConstants.CENTER);	
    	JLabel user = new JLabel("User",SwingConstants.CENTER);
    	JTextField i1 = new JTextField("Items",SwingConstants.CENTER);
    	i1.setEnabled(false);
    	JTextField q1 = new JTextField("Quantity",SwingConstants.CENTER);
    	q1.setEnabled(false);
    	JTextField i2 = new JTextField("Items",SwingConstants.CENTER);
    	i2.setEnabled(false);
    	JTextField q2 = new JTextField("Quantity",SwingConstants.CENTER);
    	q2.setEnabled(false);
    	
    	
    	//Making the grid
    	
    	JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
        
        
        
      
        /* ----------------------------------------------------------
         * MAKING THE HEADER PANELS
         * ----------------------------------------------------------
         */
        
        
        //Adding the Inventory and the User Grids
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=0;
        cst.gridwidth=2;
        panel.add(inven,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=0;
        cst.gridwidth=2;
        panel.add(user, cst);
        
        
        //Adding the Items and Quantity tags
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(i1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(q1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(i2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(q2,cst);
             
        
        /* ----------------------------------------------------------
         * FOR THE INVENTORY
         * ----------------------------------------------------------
         */
        
        //Fruit and Quantity list 
        JTextField a1 = new JTextField("Apple",SwingConstants.CENTER);	
        a1.setEnabled(false);
    	
    	JTextField m1 = new JTextField("Mango",SwingConstants.CENTER);	
    	m1.setEnabled(false);
    	
    	JTextField o1 = new JTextField("Orange",SwingConstants.CENTER);	
    	o1.setEnabled(false);
    	
    	JTextField p1 = new JTextField("Pineapple",SwingConstants.CENTER);	
    	p1.setEnabled(false);
    	
    	JTextField b1 = new JTextField("Banana",SwingConstants.CENTER);	
    	b1.setEnabled(false);
    	
    	JTextField aq1 = new JTextField("10");	
     	aq1.setEnabled(false);
     	
     	JTextField mq1 = new JTextField("6");	
     	mq1.setEnabled(false);
     	
     	JTextField oq1 = new JTextField("8");	
     	oq1.setEnabled(false);
     	
     	JTextField pq1 = new JTextField("2");	
     	pq1.setEnabled(false);
     	
     	JTextField bq1 = new JTextField("4");	
     	bq1.setEnabled(false);
     	
     	//Displaying the inventory lists
     	
     	cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(a1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=5;
        cst.gridwidth=1;
        panel.add(m1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=6;
        cst.gridwidth=1;
        panel.add(o1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=7;
        cst.gridwidth=1;
        panel.add(p1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=8;
        cst.gridwidth=1;
        panel.add(b1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(aq1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=5;
        cst.gridwidth=1;
        panel.add(mq1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=6;
        cst.gridwidth=1;
        panel.add(oq1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=7;
        cst.gridwidth=1;
        panel.add(pq1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=8;
        cst.gridwidth=1;
        panel.add(bq1,cst);
    	
        /* ----------------------------------------------------------
         * FOR THE USER
         * ----------------------------------------------------------
         */
        
        JTextField a2 = new JTextField("Apple");	
        a2.setEnabled(false);
    	
    	JTextField m2 = new JTextField("Mango");	
    	m2.setEnabled(false);
    	
    	JTextField o2 = new JTextField("Orange");	
    	o2.setEnabled(false);
    	
    	JTextField p2 = new JTextField("Pineapple");	
    	p2.setEnabled(false);
    	
    	JTextField b2 = new JTextField("Banana");	
    	b2.setEnabled(false);
    	
    	JTextField aq2 = new JTextField("0");	
    	
     	
     	JTextField mq2 = new JTextField("0");	
     	
     	
     	JTextField oq2 = new JTextField("0");	
     	
     	
     	JTextField pq2 = new JTextField("0");	
     	
     
     	JTextField bq2 = new JTextField("0");	
   
        
     	
     	//Displaying the user lists
     	
     	
     	cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(a2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=5;
        cst.gridwidth=1;
        panel.add(m2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=6;
        cst.gridwidth=1;
        panel.add(o2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=7;
        cst.gridwidth=1;
        panel.add(p2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=8;
        cst.gridwidth=1;
        panel.add(b2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(aq2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=5;
        cst.gridwidth=1;
        panel.add(mq2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=6;
        cst.gridwidth=1;
        panel.add(oq2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=7;
        cst.gridwidth=1;
        panel.add(pq2,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=3;
        cst.gridy=8;
        cst.gridwidth=1;
        panel.add(bq2,cst);
        
        /* ----------------------------------------------------------
         * Total Fields
         * ----------------------------------------------------------
         */
        
        JTextField t1 = new JTextField("Total");	
        t1.setEnabled(false);
    	
    	JTextField tq1 = new JTextField("30");	
    	tq1.setEnabled(false);
    	
    	JTextField t2 = new JTextField("Total");	
    	t2.setEnabled(false);
    	
    	final JTextField tq2 = new JTextField("0");	
    	tq2.setEditable(false);
     
    	//Displaying the total cells 
    	
    	 cst.fill = GridBagConstraints.HORIZONTAL;
         cst.gridx=0;
         cst.gridy=9;
         cst.gridwidth=1;
         panel.add(t1,cst);
         
         
         cst.fill = GridBagConstraints.HORIZONTAL;
         cst.gridx=1;
         cst.gridy=9;
         cst.gridwidth=1;
         panel.add(tq1,cst);
         
         cst.fill = GridBagConstraints.HORIZONTAL;
         cst.gridx=2;
         cst.gridy=9;
         cst.gridwidth=1;
         panel.add(t2,cst);
         
         cst.fill = GridBagConstraints.HORIZONTAL;
         cst.gridx=3;
         cst.gridy=9;
         cst.gridwidth=1;
         panel.add(tq2,cst);
         
         /*
          * The following commented code was written in order to change the "Total" field dynamically.
          * Changed after a query raised on BackPack.
          */
         
         /*DocumentFilter df = new DocumentFilter() {
             @Override
             public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {

                 if (isDigit(string)) {
                     super.insertString(fb, i, string, as);
                     calcAndSetTotal();
                 }
             }

             @Override
             public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
                 super.remove(fb, i, i1);
                 calcAndSetTotal();
             }

             @Override
             public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
                 if (isDigit(string)) {
                     super.replace(fb, i, i1, string, as);
                     calcAndSetTotal();

                 }
             }

             private boolean isDigit(String string) {
                 for (int n = 0; n < string.length(); n++) {
                     char c = string.charAt(n);                  
                     if (!Character.isDigit(c)) {
                         return false;
                     }
                 }
                 return true;
             }

             void calcAndSetTotal() {
                 int sum = 0;

                 if (!aq2.getText().isEmpty()) {
                     sum += Integer.parseInt(aq2.getText());//we must add this
                 }
                 if (!mq2.getText().isEmpty()) {
                     sum += Integer.parseInt(mq2.getText());//we must add this
                 }
                 if (!oq2.getText().isEmpty()) {
                     sum += Integer.parseInt(oq2.getText());//we must add this
                 }
                 if (!pq2.getText().isEmpty()) {
                     sum += Integer.parseInt(pq2.getText());//we must add this
                 }
                 if (!bq2.getText().isEmpty()) {
                     sum += Integer.parseInt(bq2.getText());//we must add this
                 }
                 
                 tq2.setText(String.valueOf(sum));
             }
         };
         
         ((AbstractDocument) (aq2.getDocument())).setDocumentFilter(df);
         ((AbstractDocument) (mq2.getDocument())).setDocumentFilter(df);
         ((AbstractDocument) (oq2.getDocument())).setDocumentFilter(df);
         ((AbstractDocument) (pq2.getDocument())).setDocumentFilter(df);
         ((AbstractDocument) (bq2.getDocument())).setDocumentFilter(df);
       
       	*/
         
         
         /* ----------------------------------------------------------
          * MAKING THE SUBMIT BUTTON
          * ----------------------------------------------------------
          */
    	
         JButton b = new JButton("Submit");
         
         /*
          * Adding the Action listener on the Button   --------------------
          * 
          */
         
         b.addActionListener(new ActionListener(){
        	    public void actionPerformed(ActionEvent e){
        	    	int sum=0;
        	        int v1=Integer.parseInt(aq2.getText());
        	        int v2=Integer.parseInt(mq2.getText());
        	        int v3=Integer.parseInt(oq2.getText());
        	        int v4=Integer.parseInt(pq2.getText());
        	        int v5=Integer.parseInt(bq2.getText());
        	        
        	        int a= Integer.parseInt(aq1.getText());
        	        int m=Integer.parseInt(mq1.getText());
        	        int o=Integer.parseInt(oq1.getText());
        	        int p=Integer.parseInt(pq1.getText());
        	        int b=Integer.parseInt(bq1.getText());
        	        
        	        if (v1<=a){
        	        	sum+=v1;
        	        	a=a-v1;
        	        	if (a==0){
        	        		aq2.setEnabled(false);
        	        	}
        	        	aq1.setText(Integer.toString(a));
        	        }
        	        if (v2<=m){
        	        	sum+=v2;
        	        	m=m-v2;
        	        	if (m==0){
        	        		mq2.setEnabled(false);
        	        	}
        	        	mq1.setText(Integer.toString(m));
        	        }
        	        if (v3<=o){
        	        	sum+=v3;
        	        	o=o-v3;
        	        	if (o==0){
        	        		oq2.setEnabled(false);
        	        	}
        	        	oq1.setText(Integer.toString(o));
        	        }
        	        if (v4<=p){
        	        	sum+=v4;
        	        	p=p-v4;
        	        	if (p==0){
        	        		pq2.setEnabled(false);
        	        	}
        	        	pq1.setText(Integer.toString(p));
        	        }
        	        if (v5<=b){
        	        	sum+=v5;
        	        	b=b-v5;
        	        	if (b==0){
        	        		bq2.setEnabled(false);
        	        	}
        	        	bq1.setText(Integer.toString(b));
        	        }
        	        aq2.setText("0");
        	        mq2.setText("0");
        	        oq2.setText("0");
        	        pq2.setText("0");
        	        bq2.setText("0");
        	        
        	       tq1.setText(Integer.toString(a+m+o+p+b));
        	       tq2.setText(Integer.toString(sum));
        	    }

        });
         
         // Displaying the Button
         
         cst.fill = GridBagConstraints.HORIZONTAL;
         cst.gridx=3;
         cst.gridy=13;
         cst.gridwidth=1;
         panel.add(b,cst);

     
        //Displaying the Whole Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        
        
        
	}
	
	
    public static void main(String[] args) { 
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new lab3();
            }
        }); 
    } 
    
}  
