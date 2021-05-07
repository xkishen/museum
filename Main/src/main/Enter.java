
package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Enter implements Runnable{
    
    Museum museum;
    String ticketNo;
    Time time;
    WaitingLine waitline;
    ArrayList<String> entranceName;
    ArrayList<String> exitName;
    
    public Enter(Museum museum, Time time, WaitingLine waitline){
        this.museum = museum;
        this.time = time;
        this.waitline = waitline;
        this.entranceName = new ArrayList<String>();
        entranceName.add("SET1");
        entranceName.add("SET2");
        entranceName.add("SET3");
        entranceName.add("SET4");
        entranceName.add("NET1");
        entranceName.add("NET2");
        entranceName.add("NET3");
        entranceName.add("NET4");
        
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
                
                Exit exit = new Exit(ticketNo,duration, museum, time, exitName.get(r.nextInt(8)));
                Thread t = new Thread(exit);
                museum.enterVisitor(ticketNo,duration);
                System.out.println(df.format(time.time)+" Ticket "+ticketNo+" entered through Turnstile "+entranceName.get(entrance)+". Staying for "+duration+" minutes");
                
                t.start();
                
            } catch (InterruptedException ex) {
                
            }
    }
    
}
package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Enter implements Runnable{
    
    Museum museum;
    String ticketNo;
    Time time;
    WaitingLine waitline;
    ArrayList<String> entranceName;
    ArrayList<String> exitName;
    
    public Enter(Museum museum, Time time, WaitingLine waitline){
        this.museum = museum;
        this.time = time;
        this.waitline = waitline;
        this.entranceName = new ArrayList<String>();
        entranceName.add("SET1");
        entranceName.add("SET2");
        entranceName.add("SET3");
        entranceName.add("SET4");
        entranceName.add("NET1");
        entranceName.add("NET2");
        entranceName.add("NET3");
        entranceName.add("NET4");
        
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
                
                Exit exit = new Exit(ticketNo,duration, museum, time, exitName.get(r.nextInt(8)));
                Thread t = new Thread(exit);
                museum.enterVisitor(ticketNo,duration);
                System.out.println(df.format(time.time)+" Ticket "+ticketNo+" entered through Turnstile "+entranceName.get(entrance)+". Staying for "+duration+" minutes");
                
                t.start();
                
            } catch (InterruptedException ex) {
                
            }
    }
    
}
