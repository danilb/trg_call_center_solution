package com.trg.task;

import com.trg.task.domain.CallerIssueRequest;
import com.trg.task.utils.IssueSolver;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class IssueSolverTest {

    @Inject
    IssueSolver solver;

    @Test
    public void testIssueSolver() {

        CallerIssueRequest issue = new CallerIssueRequest(System.currentTimeMillis(), "expectedResult:100");

        List<String> solutions = solver.solve(3 ,issue.getIssue()).getSolutions();
        Assertions.assertEquals(solutions.size(), 3);

        Assertions.assertEquals(solutions.get(0), "x=0, y=50;");
        Assertions.assertEquals(solutions.get(1), "x=2, y=49;");
        Assertions.assertEquals(solutions.get(2), "x=4, y=48;");



    }

}