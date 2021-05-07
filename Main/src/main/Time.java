package main;

public class Time implements Runnable{
    
    Museum museum;
    int min;
    int time;
    
    public Time(Museum museum){
        this.museum = museum;
        this.min=480;
        this.time=0;
    }

    @Override
    public void run() {
        for (int j = min; j < 1080; j++) {
            min++;
            time= ((min/60)*100)+(min%60);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            if (min>=540) {
                museum.open();
            }
        }
    }
}
