
package main;

import java.awt.FontFormatException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, FontFormatException, IOException {
        
        Frame frame = new Frame();
        WaitingLine waitline = new WaitingLine();
        Museum museum = new Museum();
        Time time = new Time(museum, frame);
        TicketCounter ticketCounter = new TicketCounter(time, waitline);
        Enter enter1 = new Enter(museum, time, waitline, frame);
        Visitor v1 = new Visitor(ticketCounter, museum, time, waitline, enter1);

        Thread t1 = new Thread(v1);
        Thread timer = new Thread(time);
        t1.start();
        timer.start();
    }
    
}
