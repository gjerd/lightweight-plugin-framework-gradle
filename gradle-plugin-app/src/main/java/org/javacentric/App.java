package org.javacentric;

import ljpf.DefaultPluginManager;
import ljpf.PluginManager;
import ljpf.PluginRepository;
import ljpf.repository.DirPluginRepository;

public class App {
    public void init() {
        PluginRepository pluginRepository = new DirPluginRepository("/home/hectic/spades/plugins");
        PluginManager pluginManager = new DefaultPluginManager(pluginRepository);

        pluginManager.load("yay-plugin");
    }

    public static void main(String[] args) {
        new App().init();
    }
}
