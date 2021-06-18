
package main;

import java.awt.Color;
import java.text.DecimalFormat;

public class Time implements Runnable{
    
    Museum museum;
    int min;
    int time;
    Frame frame;
    
    public Time(Museum museum, Frame frame){
        this.museum = museum;
        this.min=480;
        this.time=0;
        this.frame = frame;
    }

    @Override
    public void run() {
        DecimalFormat df = new DecimalFormat("0000");
        for (int j = min; j < 1080; j++) {
            min++;
            time= ((min/60)*100)+(min%60);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            if (min>=540) {
                museum.open();
                frame.setStatus("Open", new Color(231, 230, 247));
            }
            frame.setClock(df.format(time));
        }
        frame.setStatus("Close", new Color(132, 0, 50));
    }
}
