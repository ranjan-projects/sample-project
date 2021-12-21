package com.sample.app.controller;

import com.sample.app.representation.SampleRequest;
import com.sample.app.representation.SampleResponse;
import com.sample.app.service.CompletableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private CompletableService completableService;

    @PostMapping("/send")
    public List<SampleResponse> processRequest(@RequestBody List<SampleRequest> request) {
        System.out.println("Request payload is: " + request);

        completableService.process(request);

        System.out.println("Sending response");
        return new ArrayList<>();
    }

    //    @Async("taskExecutor")
    //    private void process(List<SampleRequest> requestBody) {
    //        requestBody.forEach(sampleRequest -> {
    //                            try {
    //                                System.out.println("Running the process on thread " + Thread.currentThread());
    //                                System.out.println(sampleRequest);
    //                                Thread.sleep(10000L);
    //                            } catch (InterruptedException e) {
    //                                e.printStackTrace();
    //                            }
    //                        }
    //        );
    //
    //    }
}
