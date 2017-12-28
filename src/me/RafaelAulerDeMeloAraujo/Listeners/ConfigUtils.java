package me.RafaelAulerDeMeloAraujo.Listeners;

import java.io.File;
import java.util.List;

import me.RafaelAulerDeMeloAraujo.main.Main;

public class ConfigUtils {

	private Main pl;
public boolean loadConfig()
{
  File pluginFolder = new File("plugins" + System.getProperty("file.separator") + Main.pluginName);
  if (!pluginFolder.exists()) {
    pluginFolder.mkdir();
  }
  File configFile = new File("plugins" + System.getProperty("file.separator") + Main.pluginName + System.getProperty("file.separator") + "config.yml");
  if (!configFile.exists())
  {
   Main.log.info("No config file found! Creating new one...");
    this.pl.saveDefaultConfig();
  }
  try
  {
    Main.log.info("Loading the config file...");
    this.pl.getConfig().load(configFile);
    Main.log.info("Config file loaded!");
    return true;
  }
  catch (Exception e)
  {
    Main.log.info("Could not load config file! You need to regenerate the config! Error: " + e.getMessage());
    e.printStackTrace();
  }
  return false;
}
public List<String> getStringList(String key)
{
  if (!this.pl.getConfig().contains(key))
  {
    this.pl.getLogger().severe("Could not locate '" + key + "' in the config.yml inside of the " + Main.pluginName + " folder! (Try generating a new one by deleting the current)");
    return null;
  }
  return this.pl.getConfig().getStringList(key);
}

public String getString(String key)
{
  if (!this.pl.getConfig().contains(key))
  {
    this.pl.getLogger().severe("Could not locate " + key + " in the config.yml inside of the " + Main.pluginName + " folder! (Try generating a new one by deleting the current)");
    return "errorCouldNotLocateInConfigYml:" + key;
  }
  return this.pl.getConfig().getString(key);
}

public String getStringWithColor(String key)
{
  if (!this.pl.getConfig().contains(key))
  {
    this.pl.getLogger().severe("Could not locate " + key + " in the config.yml inside of the " + Main.pluginName + " folder! (Try generating a new one by deleting the current)");
    return "errorCouldNotLocateInConfigYml:" + key;
  }
  return this.pl.getConfig().getString(key).replaceAll("&", "§");
}
}