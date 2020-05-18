package com.trg.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trg.task.domain.CallCenterResponse;
import com.trg.task.domain.CallerIssueRequest;
import com.trg.task.utils.IssueSolver;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;
import java.util.concurrent.*;


@ApplicationScoped
public class CallCenterService {

    @Inject
    IssueSolver solver;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Incoming("calls")
    public CompletionStage<Void> findSolution(Message<String> issueMessage)
            throws JsonProcessingException {

        String payload = issueMessage.getPayload();
        CallerIssueRequest issue = new ObjectMapper().readValue(payload, CallerIssueRequest.class);

        CompletableFuture<Void> future =
                new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                Random rnd = new Random();

                CallCenterResponse resp = solver.solve(rnd.nextInt(4) + 1, issue.getIssue());
                future.complete(null);

                double solutionTime = (resp.getResponseTime() - issue.getRegisteredTime()) * 0.001;

                System.out.println(Thread.currentThread().getName());
                System.out.println("SolutionTime: " + solutionTime);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, executorService);

        return issueMessage.ack();
    }

}
