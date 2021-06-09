package com.superb.core.thread.callback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ParallelTaskExecutor {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(8, 20,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(2000)
    );

    public static synchronized Map<String,Object> execute(List<ParallelTask> taskList){
        Map<String,Object> resultMap = new HashMap<>();
        CompletionService<ParallelTaskResult> completionService = new ExecutorCompletionService<>(threadPool);

        for (ParallelTask task : taskList){
            completionService.submit(() -> {
                Object o = task.execute();
                return new ParallelTaskResult(task.getTaskKey(),o);
            });
        }

        for(int i = 0; i < taskList.size();i++){
            try {
                ParallelTaskResult parallelTaskResult = completionService.take().get();
                resultMap.put(parallelTaskResult.getTaskKey(),parallelTaskResult.getTaskResult());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}
