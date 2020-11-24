package Domain.Singletons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadController {

    private static ThreadController singleton;

    private ArrayList<Thread> threadArrayList=new ArrayList<>();

    private boolean isPaused=false;

    private ThreadController(){}

    public synchronized static ThreadController getInstance() {
        if(singleton==null){
            singleton=new ThreadController();
        }
        return singleton;
    }

    public synchronized void cleanPool(){
        threadArrayList.clear();
    }

    public int getSize(){
        return threadArrayList.size();
    }

    public synchronized void addThreadIntoPool(Runnable runnable,String name){
        Thread thread=new Thread(runnable);
        thread.setName(name);
        threadArrayList.add(thread);
    }

    public synchronized void addThreadIntoPool(Thread thread,String name){
        thread.setName(name);
        threadArrayList.add(thread);
    }

    public synchronized boolean removeThreadFromPool(String name){
        for (Thread thread:threadArrayList) {
            if(thread.getName().equals(name)){
                if(thread.isAlive()){
                    return false;
                }else {
                    threadArrayList.remove(thread);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean startSpecificThread(String name){
        List<Thread> threads=threadArrayList.stream().filter(s->s.getName().equals(name)).collect(Collectors.toList());
        if(threads.isEmpty()) return false;
        if(threads.get(0).isAlive()) return false;
        threads.get(0).start();
        return true;
    }

    public void startAllThreads(){
        for (Thread thread:threadArrayList) {
            thread.start();
        }
    }

    public void pauseAllThreads(){
        if(!isPaused){
            for (Thread thread:threadArrayList) {
                if(!thread.getName().equals("KeyListener"))
                    thread.interrupt();
            }
            isPaused=true;
        }
    }

    public void restartAllThreads(){
        if(isPaused){
            for (Thread thread:threadArrayList) {
                if(!thread.getName().equals("KeyListener"))
                    thread.interrupt();
            }
            isPaused=false;
        }
    }

    public boolean getStatue(){
        return isPaused;
    }
}
