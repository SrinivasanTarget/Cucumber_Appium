package com.cucumber;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by saikrisv on 04/03/16.
 */
public class CucumberRunner {

    CommandPrompt cmd = new CommandPrompt();
    HtmlReporter htmlReporter = new HtmlReporter();

    @Test
    public void testApp() throws IOException, InterruptedException {
        runCommand();
        htmlReporter.generateReports();
    }

    public void runCommand() throws IOException, InterruptedException {
        cmd.runCommand("java -cp "+ System.getProperty("user.dir")+"/libs/cucumber-core-1.2.4.jar:"+
                System.getProperty("user.dir")+"/libs/gherkin-2.12.2.jar:"+
                        System.getProperty("user.dir")+"/libs/cucumber-html-0.2.3.jar:"+
                System.getProperty("user.dir")+"/libs/cucumber-java-1.2.4.jar:"+
                System.getProperty("user.dir")+"/libs/cucumber-jvm-deps-1.0.5.jar" + " cucumber.api.cli.Main " +
                System.getProperty("user.dir")+"/src/main/java/com/cucumber/feature/sample.feature "
                + " --plugin json:"+System.getProperty("user.dir")+"/target/sample.feature.json"
                );
    }
}
