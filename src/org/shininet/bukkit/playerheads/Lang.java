package org.shininet.bukkit.playerheads;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import org.bukkit.plugin.Plugin;

public class Lang {
	private static final String BUNDLE_NAME = "lang";
	private static Plugin plugin;
	private static ResourceBundle RESOURCE_BUNDLE;
	private static ResourceBundle RESOURCE_BUNDLE0;
	
	public static String BEHEAD_GENERIC;
	public static String BEHEAD_OTHER;
	public static String BEHEAD_SELF;
	public static String BRACKET_LEFT;
	public static String BRACKET_RIGHT;
	public static String CLICKINFO;
	public static String CMD_CONFIG;
	public static String CMD_GET;
	public static String CMD_RELOAD;
	public static String CMD_RENAME;
	public static String CMD_SET;
	public static String CMD_SPAWN;
	public static String CMD_UNKNOWN;
	public static String CMD_UPDATE;
	public static String COLON;
	public static String COLON_SPACE;
	public static String COMMA_SPACE;
	public static String CONFIG_RELOADED;
	public static String CONFIG_VARIABLES;
	public static String ERROR_CONFIGTYPE;
	public static String ERROR_CONSOLE_SPAWN;
	public static String ERROR_INV_FULL;
	public static String ERROR_INVALID_SUBCOMMAND;
	public static String ERROR_METRICS;
	public static String ERROR_NOT_A_HEAD;
	public static String ERROR_NOT_ONLINE;
	public static String ERROR_NUMBERCONVERT;
	public static String ERROR_PERMISSION;
	public static String ERROR_UPDATE_DISABLED;
	public static String ERROR_UPDATE_NOT_AVAILABLE;
	public static String ERROR_UPDATER;
	public static String OPT_HEADNAME_OPTIONAL;
	public static String OPT_HEADNAME_REQUIRED;
	public static String OPT_RECIEVER_OPTIONAL;
	public static String OPT_RECIEVER_REQUIRED;
	public static String OPT_VALUE_OPTIONAL;
	public static String OPT_VARIABLE_REQUIRED;
	public static String RENAMED_HEAD;
	public static String SPACE;
	public static String SPAWNED_HEAD;
	public static String SUBCOMMANDS;
	public static String SYNTAX;
	public static String UPDATE_STARTED;
	public static String UPDATE1;
	public static String UPDATE2;
	
	private Lang() {}

	private static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (Exception e) {
			try {
				return RESOURCE_BUNDLE0.getString(key);
			} catch (Exception f) {
				return '!' + key + '!';
			}
		}
	}
	
	public static void init(Plugin instance) {
		plugin = instance;
		reload();
	}

	public static void reload() {
		RESOURCE_BUNDLE0 = ResourceBundle.getBundle(BUNDLE_NAME);
		String locale = RESOURCE_BUNDLE0.getLocale().toString();
		if (!(locale.equals(""))) {
			locale = "_".concat(locale);
		}
		try {
			URL[] urls = {(plugin.getDataFolder().toURI().toURL())};
			RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault(), new URLClassLoader(urls));
		} catch (Exception e) {
			plugin.saveResource(BUNDLE_NAME.concat(locale).replace('.', '/').concat(".properties"), false);
		}
		for (Field field : Lang.class.getFields()) {
			if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
				try {
					field.set(null, getString(field.getName()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}