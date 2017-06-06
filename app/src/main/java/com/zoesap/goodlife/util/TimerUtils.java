package com.zoesap.goodlife.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by maoqi on 2017/5/31.
 */

public class TimerUtils {
    private static TimerUtils instance;

    public static TimerUtils getInstance() {
        if (instance == null) {
            synchronized (TimerUtils.class) {
                if (instance == null) {
                    instance = new TimerUtils();
                }
            }
        }
        return instance;
    }

    // 任务调度实现基础类

    private volatile Timer myTimer = new Timer();
    private final HashMap<Runnable, TimerTask> myTimerTasks = new HashMap<Runnable, TimerTask>();

    private class MyTimerTask extends TimerTask {
        private final Runnable myRunnable;

        MyTimerTask(Runnable runnable) {
            myRunnable = runnable;
        }

        @Override
        public void run() {
            myRunnable.run();
        }
    }

    private void addTimerTaskInternal(Runnable runnable,
                                      long delayMilliseconds, long periodMilliseconds) {
        final TimerTask task = new MyTimerTask(runnable);
        myTimer.schedule(task, delayMilliseconds, periodMilliseconds);
        myTimerTasks.put(runnable, task);
    }

    private void addTimerTaskInternal(Runnable runnable, long delayMilliseconds) {
        final TimerTask task = new MyTimerTask(runnable);
        myTimer.schedule(task, delayMilliseconds);
        myTimerTasks.put(runnable, task);
    }


    private final Object myTimerLock = new Object();

    public final void stopTimer() {
        synchronized (myTimerLock) {
            if (myTimer != null) {
                myTimer.cancel();
                myTimer = null;
                myTimerTasks.clear();
            }
            instance = null;
            System.gc();
        }
    }

    public final void addTimerTask(Runnable runnable, long delayMilliseconds,
                                   long periodMilliseconds) {
        synchronized (myTimerLock) {
            removeTimerTask(runnable);
            if (myTimer != null) {
                addTimerTaskInternal(runnable, delayMilliseconds, periodMilliseconds);
            }
        }
    }

    public final void addTimerTask(Runnable runnable, long delayMilliseconds) {
        synchronized (myTimerLock) {
            removeTimerTask(runnable);
            if (myTimer != null) {
                addTimerTaskInternal(runnable, delayMilliseconds);
            }
        }
    }

    public final boolean isTimerTaskRunning(Runnable runnable) {
        synchronized (myTimerLock) {
            TimerTask task = myTimerTasks.get(runnable);
            if (task != null) {
                return true;
            }
            return false;
        }
    }

    public final void removeTimerTask(Runnable runnable) {
        synchronized (myTimerLock) {
            TimerTask task = myTimerTasks.get(runnable);
            if (task != null) {
                task.cancel();
                myTimerTasks.remove(runnable);
            }
        }
    }

    public final void removeTimerAllTask() {
        synchronized (myTimerLock) {
            for (Map.Entry<Runnable, TimerTask> entry : myTimerTasks.entrySet()) {
                TimerTask task = entry.getValue();
                if (task != null) {
                    task.cancel();
                }
            }
            // 清除所有任务
            myTimerTasks.clear();
        }
    }
}
