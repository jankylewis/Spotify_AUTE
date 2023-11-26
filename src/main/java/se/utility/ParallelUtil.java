package se.utility;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelUtil {

    private static <T> T executeFunction(@NotNull Callable<T> func) throws Exception {
        return func.call();
    }

    public static <T> void parallelizeFunctions(@NotNull List<Callable<T>> listOfFuncs) throws InterruptedException {

        List<Callable<T>> listOfTasks = new ArrayList<>();

        for (Callable<T> func : listOfFuncs) {
            Callable<T> _func = () -> executeFunction(func);

            //Adding all tasks to a list
            listOfTasks.add(_func);
        }

        ExecutorService executor = Executors.newFixedThreadPool(listOfFuncs.size());

        //Starting threads accordingly to the number of threads that has been defined
        List<Future<T>> listOfFutures = executor.invokeAll(listOfTasks);

        //Throwing exceptions if any
        listOfFutures.stream().filter(x -> {
            try {
                return x.get().equals(false) || x.state() != Future.State.SUCCESS;
            } catch (InterruptedException | ExecutionException ieEx) {
                throw new RuntimeException(ieEx);
            }
        }).toList();
    }

    //region Running tasks in parallel as runnable objects

    public static void parallelizeTasks(@NotNull List<Runnable> listOfTasks) {

        AtomicBoolean processing = new AtomicBoolean(true);

        Executor.ParallelBuilder parallelBuilder = new Executor.ParallelBuilder();

        //Adding tasks to parallel builder
        for (Runnable task : listOfTasks) {
            parallelBuilder.add(task);
        }

        parallelBuilder.callback(() -> {
            System.out.println("PROGRAM COMPLETED");
            processing.set(false);                  //Program completed
        });

        parallelBuilder.build().execute();

        while (processing.get()){}                  //Program runs continuously
    }

    public static class Executor extends Thread {
        private ConcurrentLinkedQueue<Worker> workers;
        private Callback callback;
        private CountDownLatch latch;

        private Executor(@NotNull List<Runnable> tasks, Callback callback) {
            super();
            this.callback = callback;
            workers = new ConcurrentLinkedQueue<>();
            latch = new CountDownLatch(tasks.size());

            for (Runnable task : tasks) {
                workers.add(new Worker(task, latch));
            }
        }

        public void execute() {
            start();
        }

        @Override
        public void run() {
            while (true) {
                Worker worker = workers.poll();
                if (worker == null) {
                    break;
                }

                worker.start();
            }

            try {
                latch.await();
            } catch (InterruptedException iE) {
                iE.getStackTrace();
            }

            if (callback != null) {
                callback.onComplete();
            }
        }

        public static class ParallelBuilder {
            private List<Runnable> tasks = new ArrayList<>();
            private Callback callback;

            public ParallelBuilder add(Runnable task) {
                tasks.add(task);
                return this;
            }

            public ParallelBuilder callback(Callback callback) {
                this.callback = callback;
                return this;
            }

            public Executor build() {
                return new Executor(tasks, callback);
            }
        }

        public interface Callback {
            void onComplete();
        }
    }

    public static class Worker implements Runnable {

        private AtomicBoolean started;
        private Runnable task;
        private Thread thread;
        private CountDownLatch latch;

        public Worker(Runnable task, CountDownLatch latch) {
            this.latch = latch;
            this.task = task;
            started = new AtomicBoolean(false);
            thread = new Thread(this);
        }

        public void start() {
            if (!started.getAndSet(true)) {
                thread.start();
            }
        }

        @Override
        public void run() {
            task.run();
            latch.countDown();
        }
    }

    //endregion
}

