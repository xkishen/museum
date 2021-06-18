
package main;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class Enter implements Runnable{
    
    Museum museum;
    String ticketNo;
    Time time;
    WaitingLine waitline;
    ArrayList<String> entranceName;
    ArrayList<Color> color;
    ArrayList<String> exitName;
    Frame frame;
    
    public Enter(Museum museum, Time time, WaitingLine waitline, Frame frame){
        this.museum = museum;
        this.time = time;
        this.waitline = waitline;
        
        this.entranceName = new ArrayList<String>();
        this.frame = frame;
        entranceName.add("SET1");
        entranceName.add("SET2");
        entranceName.add("SET3");
        entranceName.add("SET4");
        entranceName.add("NET1");
        entranceName.add("NET2");
        entranceName.add("NET3");
        entranceName.add("NET4");
        
        this.color = new ArrayList<Color>();
        color.add(new Color(255, 27, 28));
        color.add(new Color(13, 92, 99));
        color.add(new Color(146, 55, 77));
        color.add(new Color(255, 127, 17));
        color.add(new Color(32, 42, 37));
        color.add(new Color(95, 75, 182));
        color.add(new Color(134, 165, 217));
        color.add(new Color(38, 240, 241));
        
        this.exitName = new ArrayList<String>();
        exitName.add("EET1");
        exitName.add("EET2");
        exitName.add("EET3");
        exitName.add("EET4");
        exitName.add("WET1");
        exitName.add("WET2");
        exitName.add("WET3");
        exitName.add("WET4");
    }

    @Override
    public synchronized void run() {
            try {
                Random r = new Random();
                DecimalFormat df = new DecimalFormat("0000");
                int entrance = r.nextInt(8);
                ticketNo = waitline.get();
                
                int duration = r.nextInt(100)+50;
                int temp = duration+time.min;
                temp = ((temp/60)*100)+(temp%60);
                if(temp>1800){
                   duration = 1080-time.min;
                }
                
                
                JLabel ticket = frame.createTicket(ticketNo,color.get(entrance));
                Exit exit = new Exit(ticketNo,duration, museum, time, exitName.get(r.nextInt(8)), ticket, frame);
                Thread t = new Thread(exit);
                museum.enterVisitor(ticketNo,duration);
                frame.addTicket(ticket);
                System.out.println(df.format(time.time)+" Ticket "+ticketNo+" entered through Turnstile "+entranceName.get(entrance)+". Staying for "+duration+" minutes");
                
                t.start();
                
            } catch (InterruptedException ex) {
                
            }
    }
    
}
