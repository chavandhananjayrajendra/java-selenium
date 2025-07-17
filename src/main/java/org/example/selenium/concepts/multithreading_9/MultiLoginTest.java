package org.example.selenium.concepts.multithreading_9;

public class MultiLoginTest {
    public static void main(String[] args) {
        new LoginTask("standard_user").start();
        new LoginTask("problem_user").start();
    }
}
