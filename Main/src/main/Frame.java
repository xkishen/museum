
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Frame {
    JFrame frame;
    JPanel panel;
    JLabel NE1;
    JLabel NE2;
    JLabel NE3;
    JLabel NE4;
    JLabel SE1;
    JLabel SE2;
    JLabel SE3;
    JLabel SE4;
    JLabel EE1;
    JLabel EE2;
    JLabel EE3;
    JLabel EE4;
    JLabel WE1;
    JLabel WE2;
    JLabel WE3;
    JLabel WE4;
    JPanel inner;
    JLabel status;
    JLabel clock;
    
    public Frame() throws FontFormatException, IOException{
        this.frame = this.createFrame("Museum");
        this.panel = this.createPanel(40, 30, 800, 600);
        this.inner = this.createPanel(65, 80, 750, 500);
        inner.setBackground(new Color(239, 242, 192));
        inner.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 18));

        this.NE1 = this.createLabel("NET1", 250, 0, new Color(32, 42, 37));
        this.NE2 = this.createLabel("NET2", 350, 0, new Color(95, 75, 182));
        this.NE3 = this.createLabel("NET3", 450, 0, new Color(134, 165, 217));
        this.NE4 = this.createLabel("NET4", 550, 0, new Color(38, 240, 241));
        
        this.WE1 = this.createLabel("WET1", 5, 150, new Color(83, 134, 228));
        this.WE2 = this.createLabel("WET2", 5, 250, new Color(83, 134, 228));
        this.WE3 = this.createLabel("WET3", 5, 350, new Color(83, 134, 228));
        this.WE4 = this.createLabel("WET4", 5, 450, new Color(83, 134, 228));
        
        this.EE1 = this.createLabel("EET1", 815, 150, new Color(83, 134, 228));
        this.EE2 = this.createLabel("EET2", 815, 250, new Color(83, 134, 228));
        this.EE3 = this.createLabel("EET3", 815, 350, new Color(83, 134, 228));
        this.EE4 = this.createLabel("EET4", 815, 450, new Color(83, 134, 228));
        
        this.SE1 = this.createLabel("SET1", 250, 590, new Color(255, 27, 28));
        this.SE2 = this.createLabel("SET2", 350, 590, new Color(13, 92, 99));
        this.SE3 = this.createLabel("SET3", 450, 590, new Color(146, 55, 77));
        this.SE4 = this.createLabel("SET4", 550, 590, new Color(255, 127, 17));
        
        this.status = this.status("Yet to be Opened!", new Color(255, 127, 17));
        this.clock = this.clock();
        
        frame.add(NE1);
        frame.add(NE2);
        frame.add(NE3);
        frame.add(NE4);
        
        frame.add(SE1);
        frame.add(SE2);
        frame.add(SE3);
        frame.add(SE4);
        
        frame.add(EE1);
        frame.add(EE2);
        frame.add(EE3);
        frame.add(EE4);
        
        frame.add(WE1);
        frame.add(WE2);
        frame.add(WE3);
        frame.add(WE4);
        
        frame.add(clock);
        frame.add(status);
        frame.add(inner);
        frame.add(panel);
        
        
        frame.setVisible(true);
    }
    
    public JFrame createFrame(String str){
        JFrame frame = new JFrame(str);
        frame.setSize(900, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    
    public JPanel createPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();  
        panel.setBounds(x, y, width, height);    
        panel.setBackground(new Color(190, 165, 125));
        panel.setLayout(new FlowLayout());
        return panel;
    }
    
    public JLabel createLabel(String name, int x, int y, Color color){
        JLabel label = new JLabel(name);
        label.setFont (label.getFont ().deriveFont (20.0f));
        label.setPreferredSize(new Dimension(60, 70));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.WHITE);
        Dimension size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        return label;
    }
    
    public JLabel createTicket(String name, Color color){
        JLabel label = new JLabel(name);
        label.setFont (label.getFont ().deriveFont (20.0f));
        label.setPreferredSize(new Dimension(70, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.WHITE);
        Dimension size = label.getPreferredSize();
        return label;
    }
    
    public void addTicket(JLabel ticket){
        inner.add(ticket);
        inner.repaint();
        inner.revalidate();
    }
    
    public void removeTicket(JLabel ticket){
        inner.remove(ticket);
        inner.repaint();
        inner.revalidate();
    }
    
    public JLabel status(String str, Color color){
        JLabel status = new JLabel(str);
        status.setPreferredSize(new Dimension(200, 50));
        Dimension size = status.getPreferredSize();
        status.setBounds(0, 0, size.width, size.height);
        status.setFont (status.getFont ().deriveFont (20.0f));
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setOpaque(true);
        status.setBackground(new Color(0, 38, 66));
        status.setForeground(color);
        return status;
    }
    
    public void setStatus(String str, Color color){
        status.setText(str);
        status.setForeground(color);
        frame.repaint();
        frame.revalidate();
    }
    
    public JLabel clock() throws FontFormatException, IOException{
        JLabel clock = new JLabel("");
        clock.setPreferredSize(new Dimension(200, 70));
        Dimension size = clock.getPreferredSize();
        clock.setBounds(675, -10, size.width, size.height);
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("digital-7.ttf"));
        font = font.deriveFont(Font.PLAIN,40);
        clock.setFont(font);
        clock.setHorizontalAlignment(JLabel.CENTER);
        clock.setVerticalAlignment(SwingConstants.CENTER);
        clock.setVerticalTextPosition(JLabel.TOP);
        clock.setOpaque(true);
        clock.setBackground(new Color(30, 30, 36));
        clock.setForeground(new Color(33, 161, 121));
        return clock;
    }
    
    public void setClock(String str){
        clock.setText(str);
        frame.repaint();
        frame.revalidate();
    }
}

