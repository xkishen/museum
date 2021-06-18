
package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JLabel;


public class Exit implements Runnable{
    String ticketNo;
    int duration;
    Museum museum;
    Time time;
    DecimalFormat df;
    String exitName;
    ArrayList<String> exit;
    JLabel ticket;
    Frame frame;
    
    public Exit(String ticketNo, int duration, Museum museum, Time time, String exitName, JLabel ticket, Frame frame){
        this.ticketNo = ticketNo;
        this.duration = duration*100;
        this.museum = museum;
        this.time = time;
        this.df = new DecimalFormat("0000");
        this.exit = new ArrayList<String>();
        this.exitName = exitName;
        this.ticket = ticket;
        this.frame = frame;
    }
    

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(df.format(time.time)+" Ticket "+ticketNo+" exited through "+ exitName);
            museum.exitVisitor(ticketNo);
            frame.removeTicket(ticket);
            
        } catch (InterruptedException ex) {
        }
    }
    
    
}
