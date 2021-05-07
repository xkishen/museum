
package main;

import java.util.ArrayList;

public class WaitingLine {
    ArrayList<String> waitline;
    
    public WaitingLine(){
        this.waitline = new ArrayList<String>();
    }
    
    public void add(String ticketNo){
        waitline.add(ticketNo);
    }
    
    public String get(){
        String temp = waitline.get(0);
        waitline.remove(0);
        return temp;
    }
}
