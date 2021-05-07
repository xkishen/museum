
package main;

import java.util.Random;

public class Visitor implements Runnable{
    
    TicketCounter ticketCounter;
    String ticketNo;
    Museum museum;
    Time time;
    WaitingLine waitline;
    Enter enter;
    
    public Visitor(TicketCounter ticket, Museum museum,Time time, WaitingLine waitline, Enter enter){
        this.ticketCounter = ticket;
        this.museum = museum;
        this.time = time;
        this.waitline = waitline;
        this.enter = enter;
    }

    @Override
    public void run() {
        
        Random r = new Random();
        int num = r.nextInt(900)+1;
        for (int i = 0; i < num; i++) {
            if(time.time>=1700){
                break;
            }
            int numOfTickets = ticketCounter.buyTicket();
            for (int j = 0; j < numOfTickets; j++) {
                Thread enter_thread = new Thread(enter);
                enter_thread.start();
            }
            try {
                Thread.sleep(r.nextInt(350)+100);
            } catch (InterruptedException ex) {
            }
        }
        
    }
    
}
