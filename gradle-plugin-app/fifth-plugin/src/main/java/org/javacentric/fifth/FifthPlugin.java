package org.javacentric.fifth;

import ljpf.Plugin;

public class FifthPlugin implements Plugin {
    @Override
    public void load() {
        System.out.println("Yay it actually loads!");
    }

    @Override
    public void unload() {
        System.out.println("Unloaded Yay plugin!");
    }
}
