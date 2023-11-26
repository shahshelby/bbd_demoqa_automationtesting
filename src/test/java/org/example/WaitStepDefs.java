package org.example;
import io.cucumber.java.en.And;

public class WaitStepDefs extends AbstractStepDefs{

    // For Website transition delay or Launching new tabs
    @And("Wait for {string} seconds")
    public void iWaitForDurationSeconds(String duration) {
        try {
            long durationInSeconds = Long.parseLong(duration);
            Thread.sleep(durationInSeconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (NumberFormatException ex) {
            // Handle if the duration string cannot be parsed to a number
            System.err.println("Invalid duration provided: " + duration);
        }
    }
}
