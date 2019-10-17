import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class TextEditor implements Runnable, ActionListener
{
        JFrame frame = new JFrame("Text Editor");
        JTextArea textArea = new JTextArea();

    public static void main(String[] args) 
    {
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        SwingUtilities.invokeLater(new TextEditor());
    }
    
    public void run()
    {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu1 = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("New");
        JMenuItem menuItem2 = new JMenuItem("Open");
        JMenuItem menuItem3 = new JMenuItem("Save");
        JMenuItem menuItem4 = new JMenuItem("Print");
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);
        
        JMenu menu2 = new JMenu("Edit");
        JMenuItem menuItem5 = new JMenuItem("Cut");
        JMenuItem menuItem6 = new JMenuItem("Copy");
        JMenuItem menuItem7 = new JMenuItem("Paste");
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
        menuItem7.addActionListener(this);
        menu2.add(menuItem5);
        menu2.add(menuItem6);
        menu2.add(menuItem7);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        
        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s = e.getActionCommand();
        
        if(s.equals("Cut"))
        {
            textArea.cut();
        }else
        if(s.equals("Copy"))
        {
            textArea.copy();
        }else
        if(s.equals("Paste"))
        {
            textArea.copy();
        }else
        if(s.equals("Save"))
        {
            JFileChooser fileChooser = new JFileChooser("f:");
            int r = fileChooser.showSaveDialog(null);
            if(r == JFileChooser.APPROVE_OPTION)
            {
                File fi = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    FileWriter wr = new FileWriter(fi, false); 
   
                    BufferedWriter w = new BufferedWriter(wr); 
  
                    w.write(textArea.getText()); 
  
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(frame, evt.getMessage()); 
                } 
            }
        }else
        if(s.equals("Print"))
        {
            try{textArea.print();}
            catch (Exception evt) 
            {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        }else
        if(s.equals("Open"))
        {
            JFileChooser fileChooser = new JFileChooser("f:");
            int r = fileChooser.showOpenDialog(null);
            if(r == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try
                {
                    Scanner fileReader = new Scanner(file);
                    while(fileReader.hasNext())
                    {
                        String line = fileReader.nextLine();
                        textArea.append(line);
                    }
                }
                catch (Exception evt)
                {
                    JOptionPane.showMessageDialog(frame, "Could not find file");
                }
            }
        }else
        if(s.equals("New"))
        {
            textArea.setText("");
        }
    }

}
