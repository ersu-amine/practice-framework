package com.practice.qa_practice;

import java.util.function.Supplier;

public class RetryBasic {
    /*
        Basic Retry with Fixed Attempts
        Write a method simulating a very simple retry mechanism for an action that may fail:

        boolean retryOperation(Supplier<Boolean> action, int maxAttempts)

        Requirements:
        Call action.get() up to maxAttempts times.
        If it returns true at any attempt, return true immediately.
        If it never returns true, return false at the end.
     */

    public static boolean retryOperation(Supplier<Boolean> action, int maxAttempts){
        for (int i = 0; i < maxAttempts; i++) {
            if(action.get()){
                return true;
            }
        }
        //maximum retry has been reached
        return false;
    }
}
