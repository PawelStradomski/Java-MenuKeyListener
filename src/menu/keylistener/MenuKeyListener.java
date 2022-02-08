
package menu.keylistener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author pawelstradomski
 */

//Wlasne menu - FocusListener, KeyListener,VirtualKeys, GridLayout - Moj sposob :)
//FocusListener not working on Mac

public class MenuKeyListener extends JFrame
{
    MenuKeyListener()
    {
        super("WlasneMenu");
        this.setBounds(600, 300, 200, 300);
        initComponent();
        this.setDefaultCloseOperation(3);
    }
    public void initComponent()
    {
        budujButton("Dodaj", Color.cyan);
        budujButton("Usuń", Color.cyan);
        budujButton("Zmień", Color.cyan);        
    }
    public void budujButton(String nazwa, final Color k)
    {
        JButton przycisk = new JButton(nazwa);
        this.getContentPane().add(panel);
        panel.add(przycisk);
        panel.setLayout(new GridLayout(3, 1));//3-wiersze, 1-kolumna
        
        przycisk.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                przycisk.setBackground(k);
                przycisk.setOpaque(true);
                przycisk.setBorderPainted(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                przycisk.setBackground(Color.white);
            }
        });
        przycisk.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int lenghtMenu = panel.getComponentCount();
                if(i==0) i=lenghtMenu; //aby nie wyrzucalo kodu bledu jak i=minusowe
                if(e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    panel.getComponent(++i%lenghtMenu).requestFocus();
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    panel.getComponent(--i%lenghtMenu).requestFocus();
                }
                else if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    przycisk.doClick();  
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Wcisnales Enter lub klawisz myszy");
                JOptionPane.showMessageDialog(przycisk, (przycisk.getText()));
            }
        });
        
    }   
    JPanel panel = new JPanel(); 
    private int i=0;  
        
    public static void main(String[] args) {
        new MenuKeyListener().setVisible(true);
    }
    
}
