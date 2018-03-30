package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;

public class Scoreboard {
private Main main;
	 public Scoreboard(Main main) {
		 /* 21 */     this.main = main;
		 /*    */   }
		 /*    */   
public static void createScoreBoard(Player player) {
ScoreBoardHelper helper = ScoreBoardHelper.createScore(player);
int streak = ((Integer)me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak.killstreak.get(player.getName())).intValue();
/* 45 */       
helper.setTitle(Main.getInstace().getConfig().getString("ScorePrefix").replace("&", "§"));
helper.setSlot(7, "");
helper.setSlot(6, Main.getInstace().getConfig().getString("ScoreKills").replace("&", "§") + "" +  AntiDeathDrop.GetKills(player));
helper.setSlot(5, Main.getInstace().getConfig().getString("ScoreDeaths").replace("&", "§") +  "" + AntiDeathDrop.GetDeaths(player));
helper.setSlot(4, Main.getInstace().getConfig().getString("ScoreStreak").replace("&", "§") +  "" + streak);
helper.setSlot(3, Main.getInstace().getConfig().getString("ScoreCoins").replace("&", "§") +  "" + Coins.getCoins(player.getName()));
helper.setSlot(2, Main.getInstace().getConfig().getString("ScoreKit").replace("&", "§") +  "" + Habilidade.getAbility(player));
helper.setSlot(1, "");
}
}

