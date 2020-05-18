package com.trg.task.utils;

import com.trg.task.domain.CallerIssueRequest;
import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class CallGenerator {

    private Random random = new Random();

    @Outgoing("generated-call")
    public Flowable<Message<CallerIssueRequest>> generate1() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(problem -> {
                    int expectedResult = random.nextInt(99999) + 1;

                    CallerIssueRequest issue =
                            new CallerIssueRequest(System.currentTimeMillis(), "expectedResult:" + expectedResult);


                    Message<CallerIssueRequest> msg =Message.of(issue);

                    return msg;
                });
    }

    @Outgoing("generated-call")
    public Flowable<Message<CallerIssueRequest>> generate2() {
        return Flowable.interval(3, TimeUnit.SECONDS)
                .map(problem -> {
                    int expectedResult = random.nextInt(99999) + 1;

                    CallerIssueRequest issue =
                            new CallerIssueRequest(System.currentTimeMillis(), "expectedResult:" + expectedResult);

                    Message<CallerIssueRequest> msg =Message.of(issue);

                    return msg;
                });
    }
}
