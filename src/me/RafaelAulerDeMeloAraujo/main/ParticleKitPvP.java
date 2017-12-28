/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import net.minecraft.server.v1_10_R1.EntityPlayer;
/*    */ import net.minecraft.server.v1_10_R1.EnumParticle;
/*    */ import net.minecraft.server.v1_10_R1.PacketPlayOutWorldParticles;
/*    */ import net.minecraft.server.v1_10_R1.PlayerConnection;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class ParticleKitPvP
/*    */ {
/*    */   public static void sendParticle(EnumParticle type, Location loc, float xOffset, float yOffset, float zOffset, float speed, int count)
/*    */   {
/* 15 */     float x = (float)loc.getX();
/* 16 */     float y = (float)loc.getY();
/* 17 */     float z = (float)loc.getZ();
/* 18 */     PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, x, y, z, xOffset, yOffset, zOffset, speed, count, null);
/* 19 */     for (Player p : org.bukkit.Bukkit.getOnlinePlayers()) {
/* 20 */       ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void sendParticle(EnumParticle type, double x, double y, double z, float xOffset, float yOffset, float zOffset, float speed, int count)
/*    */   {
/* 26 */     float xf = (float)x;
/* 27 */     float yf = (float)y;
/* 28 */     float zf = (float)y;
/* 29 */     PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, xf, yf, zf, xOffset, yOffset, zOffset, speed, count, null);
/* 30 */     for (Player p : org.bukkit.Bukkit.getOnlinePlayers()) {
/* 31 */       ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void sendParticleTo(EnumParticle type, Player p, Location loc, float xOffset, float yOffset, float zOffset, float speed, int count)
/*    */   {
/* 37 */     float x = (float)loc.getX();
/* 38 */     float y = (float)loc.getY();
/* 39 */     float z = (float)loc.getZ();
/* 40 */     PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, x, y, z, xOffset, yOffset, zOffset, speed, count, null);
/* 41 */     ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
/*    */   }
/*    */   
/*    */   public static void sendParticleTo(EnumParticle type, Player p, double x, double y, double z, float xOffset, float yOffset, float zOffset, float speed, int count)
/*    */   {
/* 46 */     float xf = (float)x;
/* 47 */     float yf = (float)y;
/* 48 */     float zf = (float)y;
/* 49 */     PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(type, true, xf, yf, zf, xOffset, yOffset, zOffset, speed, count, null);
/* 50 */     ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
/*    */   }
/*    */ }

