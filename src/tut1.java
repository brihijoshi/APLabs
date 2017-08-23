import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class tut1 {
	
	public tut1(){
		show();
	}
	
	public void show(){
		JFrame frame = new JFrame("Calculator");
		
		
		//Creating the calculator objects
		JTextField disp = new JTextField("",SwingConstants.RIGHT);
		String s=disp.getText();
		disp.setEnabled(false);
		JButton clear=new JButton("clr");
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton add=new JButton("+");
		JButton sub=new JButton("-");
		JButton equate=new JButton("=");
		
		
		//Making the grid
    	
    	JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();
        
        //Making the layout of the panel
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=0;
        cst.gridwidth=2;
        panel.add(disp,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=0;
        cst.gridwidth=1;
        panel.add(clear,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=1;
        cst.gridwidth=1;
        panel.add(b1,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=1;
        cst.gridwidth=1;
        panel.add(b2,cst);
		
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=1;
        cst.gridwidth=1;
        panel.add(b3,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(b4,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(b5,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=2;
        cst.gridwidth=1;
        panel.add(b6,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=3;
        cst.gridwidth=1;
        panel.add(b7,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=3;
        cst.gridwidth=1;
        panel.add(b8,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=3;
        cst.gridwidth=1;
        panel.add(b9,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=0;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(add,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=1;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(sub,cst);
        
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx=2;
        cst.gridy=4;
        cst.gridwidth=1;
        panel.add(equate,cst);
        
        b1.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'1');   	
    	    }
        });
        
        b2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'2');   	
    	    }
        });
        
        b3.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'3');   	
    	    }
        });
        
        b4.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'4');   	
    	    }
        });
        
        b5.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'5');   	
    	    }
        });
        
        b6.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'6');   	
    	    }
        });
        
        b7.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'7');   	
    	    }
        });
        
        b8.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'8');   	
    	    }
        });
        
        b9.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'9');   	
    	    }
        });
        
        add.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'+');   	
    	    }
        });
        
        sub.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText(disp.getText()+'-');   	
    	    }
        });
        
        equate.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	String s=disp.getText();
    	    	if (s.contains("+")){
    	    		String[] nums=s.split("\\+");
    	    		disp.setText("="+Integer.toString(Integer.parseInt(nums[0])+Integer.parseInt(nums[1])));
    	    	}
    	    	if (s.contains("-")){
    	    		String[] nums=s.split("\\-");
    	    		disp.setText("="+Integer.toString(Integer.parseInt(nums[0])-Integer.parseInt(nums[1])));
    	    	}
    	    }
        });
        
        clear.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
    	    	disp.setText("");   	
    	    }
        });
        
  	
        
        
        //Displaying the GUI
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new tut1();
            }
        });

	}

}
