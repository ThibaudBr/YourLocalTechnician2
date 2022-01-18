package org.architecturelogiciel;

import com.sun.tools.javac.Main;
import org.architecturelogiciel.cli.CLILauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        CLILauncher cliLauncher = new CLILauncher();
        cliLauncher.start();
    }
}
