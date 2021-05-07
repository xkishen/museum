package main;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WaitingLine waitline = new WaitingLine();
        Museum museum = new Museum();
        Time time = new Time(museum);
        TicketCounter ticketCounter = new TicketCounter(time, waitline);
        Enter enter1 = new Enter(museum, time, waitline);
        Visitor v1 = new Visitor(ticketCounter, museum, time, waitline, enter1);
        
        Thread t1 = new Thread(v1);
        Thread timer = new Thread(time);
        t1.start();
        timer.start();
        
    }
    
}
