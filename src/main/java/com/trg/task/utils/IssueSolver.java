package com.trg.task.utils;

import com.trg.task.domain.CallCenterResponse;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class IssueSolver {

    public CallCenterResponse solve(int solutionLimit, String issue) {

        int expectedResult = extractProblem(issue);
        int solutionCounter = 0;

        List<String> solutions = new ArrayList<>();

        for (long i = 0; i < expectedResult; i++) {
            for (long j = 0; j < expectedResult; j++) {
                if (i + j * 2 == expectedResult) {
                    solutions.add("x=" + i + ", y=" + j + ";");
                    solutionCounter++;
                    break;
                }
            }
            if (solutionCounter == solutionLimit) break;
        }

        return new CallCenterResponse(
                System.currentTimeMillis(),
                expectedResult, solutions);
    }

    private int extractProblem(String problem) {
        String strValue =
                problem.substring(problem.indexOf(':') + 1);

        return Integer.parseInt(strValue);
    }
}
