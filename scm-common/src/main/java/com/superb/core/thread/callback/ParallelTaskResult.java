package com.superb.core.thread.callback;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParallelTaskResult {

    private String taskKey;

    private Object taskResult;
}
