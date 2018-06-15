package me.RafaelAulerDeMeloAraujo.Updater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class SpigotUpdater
  extends Thread
{
  private final Plugin plugin;
  private final int id;
  private final boolean log;
  private boolean enabled;
  private URL url;
  /**
  *
  * @author zEnderX5_
  *
  */
  public String color(String msg, boolean prefix)
  {
    return ChatColor.translateAlternateColorCodes('&', "[KP-PVP]" + msg);
  }
  
  public SpigotUpdater(Plugin plugin, int resourceID)
    throws IOException
  {
    this(plugin, resourceID, true);
  }
  
  public SpigotUpdater(Plugin plugin, int resourceID, boolean log)
    throws IOException
  {
    if (plugin == null) {
      throw new IllegalArgumentException("Plugin cannot be null");
    }
    if (resourceID == 0) {
      throw new IllegalArgumentException("Resource ID cannot be null (0)");
    }
    this.plugin = plugin;
    this.id = resourceID;
    this.log = log;
    this.url = new URL("https://api.inventivetalent.org/spigot/resource-simple/" + resourceID);
    super.start();
  }
  
  public synchronized void start() {}
  
  public void run()
  {
    if (this.plugin.isEnabled())
    {
      if (this.log) {
        this.plugin.getServer().getConsoleSender().sendMessage(color("&aSearching for updates...", true));
      }
      HttpURLConnection connection = null;
      try
      {
        connection = (HttpURLConnection)this.url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        connection.setRequestMethod("GET");
        BufferedReader e = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String e11 = "";
        for (String line = null; (line = e.readLine()) != null; e11 = e11 + line) {}
        e.close();
        JSONObject json = null;
        try
        {
          json = (JSONObject)new JSONParser().parse(e11);
        }
        catch (ParseException localParseException) {}
        String currentVersion = null;
        if ((json != null) && (json.containsKey("version")))
        {
          String version = (String)json.get("version");
          if ((version != null) && (!version.isEmpty())) {
            currentVersion = version;
          }
        }
        if (currentVersion == null)
        {
          if (this.log)
          {
            this.plugin.getServer().getConsoleSender().sendMessage(color("&cInvalid response received.", true));
            this.plugin.getServer().getConsoleSender().sendMessage(color("&cEither the author of this plugin has configured the updater wrong, or the API is experiencing some issues.", true));
          }
          return;
        }
        if (!currentVersion.equals(this.plugin.getDescription().getVersion()))
        {
          this.plugin.getServer().getConsoleSender().sendMessage(color("&aNew update found: v" + currentVersion + "! (Current version " + this.plugin.getDescription().getVersion() + ")", true));
          this.plugin.getServer().getConsoleSender().sendMessage(color("&aDownload it from: http://www.spigotmc.org/resources/" + this.id, true));
        }
        else if (this.log)
        {
          this.plugin.getServer().getConsoleSender().sendMessage(color("&c&oNo updates found for KP-PVP", true));
        }
      }
      catch (IOException var10)
      {
        if (this.log)
        {
          if (connection != null) {
            try
            {
              int e1 = connection.getResponseCode();
              this.plugin.getServer().getConsoleSender().sendMessage(color("&cAPI connection returned response code " + e1, true));
            }
            catch (IOException localIOException1) {}
          }
          var10.printStackTrace();
        }
      }
    }
  }
}
