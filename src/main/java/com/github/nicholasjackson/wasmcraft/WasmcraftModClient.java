package com.github.nicholasjackson.wasmcraft;

import com.github.nicholasjackson.wasmcraft.events.WasmBlockClicked;
import com.github.nicholasjackson.wasmcraft.gui.WasmBlockGui;
import com.github.nicholasjackson.wasmcraft.gui.WasmBlockScreen;
import com.github.nicholasjackson.wasmcraft.wasm.WasmRuntime;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;

public class WasmcraftModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // Here we will put client-only registration code

    WasmBlockClicked.EVENT.register((block, callback) -> {
      WasmBlockGui gui = new WasmBlockGui();
      WasmBlockScreen screen = new WasmBlockScreen(gui);
      MinecraftClient.getInstance().setScreen(screen);

      // set the default state
      gui.setup(block, callback);

      return ActionResult.PASS;
    });

    WasmRuntime.getInstance().init();
  }
}