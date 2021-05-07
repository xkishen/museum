
package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class TicketCounter {
    final int max = 900;
    int num;
    Time time;
    WaitingLine waitline;
    Random rand;
    DecimalFormat df;
    ArrayList<String> ticketNo;
    
    public TicketCounter(Time time, WaitingLine waitline){
        this.time = time;
        this.num = 0;
        this.waitline = waitline;
        this.rand = new Random();
        this.df = new DecimalFormat("0000");
        this.ticketNo = new ArrayList<String>();
    }
    
    public synchronized int buyTicket(){
        if(num<max && time.time<1700){
            int numOfTickets = rand.nextInt(4)+1;
            for (int i = 0; i < numOfTickets; i++) {
                num++;
                ticketNo.add("T"+df.format(num));
            }

            int j=0;
            System.out.print(df.format(time.time)+" Tickets "); 
            while(!ticketNo.isEmpty()){
                System.out.print(ticketNo.get(0)+", ");
                waitline.add(ticketNo.get(0));
                ticketNo.remove(0);
                j++;
            }
            System.out.println(" sold");
            return numOfTickets;
        }
        return 0;
    }
}
