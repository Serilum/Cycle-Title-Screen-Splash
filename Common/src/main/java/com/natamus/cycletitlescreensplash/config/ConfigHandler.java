package com.natamus.cycletitlescreensplash.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.cycletitlescreensplash.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 1, max = 72000) public static int ticksBetweenSplashCycle = 100;

	public static void initConfig() {
		configMetaData.put("ticksBetweenSplashCycle", Arrays.asList(
			"How many ticks in between splash changes when on the title screen. 1 second = 20 ticks"
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}