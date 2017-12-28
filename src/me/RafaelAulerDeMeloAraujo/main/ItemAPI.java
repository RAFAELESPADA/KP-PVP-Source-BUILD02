package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.NBTTagList;

public class ItemAPI {
	
	public static ItemStack Criar(Material material, int quantia, int id, String nome, boolean inquebravel) {
		ItemStack item = new ItemStack(material, quantia, (short)id);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(nome);
		meta.spigot().setUnbreakable(inquebravel);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack Criar(Material material, int quantia, int id, String nome, boolean inquebravel, String... desc) {
		ItemStack item = new ItemStack(material, quantia, (short)id);
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(inquebravel);
		List<String> Lore = new ArrayList<>();
	    for (String loreString : desc) {
	    	Lore.add(loreString);
	    }
		meta.setLore(Lore);
		meta.setDisplayName(nome);
		
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack Criar(Material material, int quantia, int id, String nome, boolean inquebravel, List<String> desc) {
		ItemStack item = new ItemStack(material, quantia, (short)id);
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(inquebravel);
		List<String> Lore = new ArrayList<>();
	    for (String loreString : desc) {
	    	Lore.add(loreString.replace("&", "§"));
	    }
		meta.setLore(Lore);
		meta.setDisplayName(nome);
		
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack Criar(Material material, int quantia, int id, String nome, boolean inquebravel, Enchantment encanto, int level, String... desc) {
		ItemStack item = new ItemStack(material, quantia, (short)id);
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(inquebravel);
		item.addUnsafeEnchantment(encanto, level);
		List<String> Lore = new ArrayList<>();
	    for (String loreString : desc) {
	    	Lore.add(loreString);
	    }
		meta.setLore(Lore);
		meta.setDisplayName(nome);
		
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack Criar(Material material, int quantia, int id, String nome, boolean inquebravel, Enchantment encanto, int level) {
		ItemStack item = new ItemStack(material, quantia, (short)id);
		item.addUnsafeEnchantment(encanto, level);
		ItemMeta meta = item.getItemMeta();
		meta.spigot().setUnbreakable(inquebravel);
		meta.setDisplayName(nome);
		
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack Head(String nome , String dono) {
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(dono);
		meta.setDisplayName(nome);
		item.setItemMeta(meta);
		return item;
	}
    public static ItemStack Skull(String skullOwner, String displayName, int quantity) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, quantity, (byte) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        skullMeta.setOwner(skullOwner);
        if (displayName != null) {
            skullMeta.setDisplayName("§r" + displayName);
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }
    
    
    public static ItemStack removeAttributes(ItemStack i){
         if(i == null || i.getType() == Material.BOOK_AND_QUILL)
              return i;
     
         ItemStack item = i.clone();
     
         net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
         NBTTagCompound tag;
         if (!nmsStack.hasTag()){
              tag = new NBTTagCompound();
              nmsStack.setTag(tag);
         }else
              tag = nmsStack.getTag();
     
         NBTTagList am = new NBTTagList();
     
         tag.set("AttributeModifiers", am);
         nmsStack.setTag(tag);
     
         return CraftItemStack.asBukkitCopy(nmsStack);
    }
     

}
