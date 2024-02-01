package net.galaxy.tothemoon;

import net.fabricmc.api.ClientModInitializer;

public class ToTheMoonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Hello Fabric world! (Client side)");
    }
}
