package org.javacentric;

import ljpf.PluginClassLoaderFactory;
import ljpf.PluginManager;
import ljpf.examples.common.ExampleConfig;
import ljpf.DefaultPluginManager;
import ljpf.loader.ParentLastClassLoaderFactory;
import ljpf.repository.ClasspathPluginRepository;
import ljpf.repository.DirPluginRepository;
import ljpf.repository.MultiPluginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by souzen on 29.03.2017.
 * Modified to suit my fork of the framework by Arild G. Gjerd
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class.getSimpleName());

    private PluginManager pluginManager;

    // Relative to user home directory
    String pluginRepository1 =  System.getProperty("user.home") +
                                File.separator + "spades" +
                                File.separator + "plugins";

    // Relative to project-directory
    String pluginRepository2 =  "plugins";

    public void init() {

        new File(pluginRepository2).mkdirs();

        MultiPluginRepository pluginRepository = new MultiPluginRepository(
                new ClasspathPluginRepository(),
                new DirPluginRepository(pluginRepository1),
                new DirPluginRepository(pluginRepository2)
        );

        PluginClassLoaderFactory classLoaderFactory = new ParentLastClassLoaderFactory();
        pluginManager = new DefaultPluginManager(pluginRepository, classLoaderFactory);

        ExampleConfig config = new ExampleConfig();
        config.setValue("World");

        pluginManager.load("FirstPlugin", config);
        //pluginManager.load("SecondPlugin", config);
        //pluginManager.load("ThirdPlugin", config);
    }

    public void shutdown() {
        LOG.info("Shutting down...");
        pluginManager.unloadAll();
    }

    public static void main(String[] args) {
        App app = new App();
        app.init();
        app.shutdown();
    }

}
