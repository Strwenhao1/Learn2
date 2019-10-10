package com.bjsxt.forkJoin;

import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private int step = 500000;

    Task(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        if (end - start < step) {
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            Long mid = (start + end) / 2;

            Task leftTask = new Task(start, mid);
            Task rightTask = new Task(mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            Long leftSum = leftTask.join();
            Long rightSum = leftTask.join();

            sum = leftSum + rightSum;
        }
        return sum;
    }

}
