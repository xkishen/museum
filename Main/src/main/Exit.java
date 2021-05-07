
package main;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Exit implements Runnable{
    String ticketNo;
    int duration;
    Museum museum;
    Time time;
    DecimalFormat df;
    String exitName;
    ArrayList<String> exit;
    
    
    public Exit(String ticketNo, int duration, Museum museum, Time time, String exitName){
        this.ticketNo = ticketNo;
        this.duration = duration*100;
        this.museum = museum;
        this.time = time;
        this.df = new DecimalFormat("0000");
        this.exit = new ArrayList<String>();
        this.exitName = exitName;
    }
    

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(df.format(time.time)+" Ticket "+ticketNo+" exited through "+ exitName);
            museum.exitVisitor(ticketNo);
            
        } catch (InterruptedException ex) {
        }
    }
    
    
}
