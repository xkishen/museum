package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Museum {
    ArrayList<String> visitors;
    final int maxCount = 100;
    boolean isOpen;
    ReentrantLock lock;
    Condition cond;
    
    public Museum() throws InterruptedException{
        this.visitors = new ArrayList<String>();
        this.lock = new ReentrantLock();
        this.cond = lock.newCondition();
        this.isOpen = false;
    }
    
    public void enterVisitor(String ticketNo, int duration) throws InterruptedException{
        try{
            lock.lock();
            while (isOpen==false) {
                cond.await();
            }
            while (visitors.size()==maxCount) {
                    cond.await();
                }
                this.visitors.add(ticketNo);
        }finally{
            lock.unlock();
        }
        
    }
    
    public void exitVisitor(String ticketNo) throws InterruptedException{
        try{
            lock.lock();
            visitors.remove(ticketNo);
            cond.signalAll();
        }finally{
            lock.unlock();
        }
        
    }
    
    public void open(){
        try{
            lock.lock();
            isOpen=true;
            cond.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
