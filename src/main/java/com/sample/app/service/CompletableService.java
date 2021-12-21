package com.sample.app.service;

import com.sample.app.representation.SampleRequest;
import com.sample.app.representation.SampleResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CompletableService {

    public void process(List<SampleRequest> requests) {
        long start = System.currentTimeMillis();
        List<CompletableFuture<SampleResponse>> futures = new ArrayList<>();
        for (SampleRequest request : requests) {
            futures.add(createCompletableFuture(request));
        }
        System.out.println("Fired all request within: " + (System.currentTimeMillis() - start));

        futures.forEach(CompletableFuture::join);

        System.out.println("Processed all requests in " + (System.currentTimeMillis() - start));
    }

    @Async("batchTaskExecutor")
    public CompletableFuture<SampleResponse> createCompletableFuture(SampleRequest request) {
        System.out.println("Running " + request.getId() + " on thread " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return SampleResponse.builder().id(request.getId()).status("success").build();
        });
    }
}
