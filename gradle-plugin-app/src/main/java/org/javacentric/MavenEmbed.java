package org.javacentric;

import org.apache.maven.cli.MavenCli;

// https://www.javatips.net/api/org.apache.maven.embedder.mavenembedder

public class MavenEmbed {

    public void wrapper() {

        // So I am trying to embed maven in my code rather than use a
        // shell wrapper however I am having issues getting it to actually work.

        String src = "/maven-project";
        System.setProperty(MavenCli.MULTIMODULE_PROJECT_DIRECTORY, src);
        MavenCli cli = new MavenCli();
        final String[] mavenBuildCommands = {"clean", "compile", "package", "-DskipTests -Dmaven.test.skip=true"};
        int result = cli.doMain(mavenBuildCommands, src, System.out, System.out);
        System.out.println("result: " + result);
    }

    public void some() {
        System.out.println("Before calling embedded maven");
        MavenCli cli = new MavenCli();
        cli.doMain(
                new String[]{"package", "exec:java"}, // maven command line
                System.getProperty("user.home") + "/anotherProject", // working dir
                System.out, // output stream
                System.err  // error stream
        );
        System.out.println("After calling embedded maven");
    }


    public void init() {
        MavenCli cli = new MavenCli();
        int result = cli.doMain(new String[]{"compile"},
                "/home/aioffe/workspace/MiscMaven",
                System.out, System.out);
        System.out.println("result: " + result);
    }

    public static void main(String[] args) {
        new MavenEmbed().init();
    }
}
