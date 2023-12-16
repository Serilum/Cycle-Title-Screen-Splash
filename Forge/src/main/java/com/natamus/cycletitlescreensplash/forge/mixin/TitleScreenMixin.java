package com.natamus.cycletitlescreensplash.forge.mixin;

import com.natamus.cycletitlescreensplash.config.ConfigHandler;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(value = TitleScreen.class, priority = 1001)
public abstract class TitleScreenMixin extends Screen {
	@Unique int tickCount = 0;
	@Shadow @Nullable private SplashRenderer splash;

	protected TitleScreenMixin(Component component) {
		super(component);
	}

	@Inject(method = "tick()V", at = @At(value = "TAIL"))
	public void tick(CallbackInfo ci) {
		tickCount+=1;
		if (tickCount % ConfigHandler.ticksBetweenSplashCycle != 0) {
			return;
		}
		
		this.splash = this.minecraft.getSplashManager().getSplash();
		tickCount = 0;
	}
}
