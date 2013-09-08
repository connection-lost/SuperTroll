package me.crafter.mc.supertroll;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.server.v1_6_R2.Packet206SetScoreboardObjective;
import net.minecraft.server.v1_6_R2.Packet207SetScoreboardScore;
import net.minecraft.server.v1_6_R2.Packet208SetScoreboardDisplayObjective;
import net.minecraft.server.v1_6_R2.Scoreboard;
import net.minecraft.server.v1_6_R2.ScoreboardBaseCriteria;
import net.minecraft.server.v1_6_R2.ScoreboardScore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SuperTroll extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Mincraft");
	public final TrollListener pl = new TrollListener(this);

    public void onEnable(){
    	this.logger.info("Plugin made by connection_lost. www.crafter.me");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.pl, this);
        TrollClass tc = new TrollClass(this);
        Bukkit.getServer().getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("SuperTroll") , tc, 60L, 60L);
    }

    public void onDisable() {

    }
    /*----------------------------------------------------------*/
    private List<Player> troll2 = new ArrayList<Player>();
    private List<Player> troll3 = new ArrayList<Player>();
    private List<Player> troll4 = new ArrayList<Player>();
    private List<Player> troll5 = new ArrayList<Player>();
    private List<Player> troll6 = new ArrayList<Player>();
    private List<Player> troll8 = new ArrayList<Player>();
    private List<Player> troll9 = new ArrayList<Player>();
    
    public List<Player> get2(){
		return troll2;    	
    }
    public List<Player> get3(){
		return troll3;    	
    }
    public List<Player> get4(){
		return troll4;    	
    }
    public List<Player> get5(){
		return troll5;    	
    }
    public List<Player> get6(){
		return troll6;    	
    }
    public List<Player> get8(){
		return troll8;    	
    }
    public List<Player> get9(){
		return troll9;    	
    }
    /*----------------------------------------------------------*/
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if ((args.length == 0 || args.length>2)){
    		sender.sendMessage(ChatColor.RED+"SuperTroll指令使用方法:");
    		sender.sendMessage(ChatColor.RED+"/troll <方式> <玩家>");
    		sender.sendMessage(ChatColor.RED+"输入/troll ? 查看所有方式代码");
    		sender.sendMessage(ChatColor.RED+"例:输入 "+ChatColor.RESET+"/troll 1 xxs"+ChatColor.RED+" 可以使玩家xxs的客户端崩溃");
    		sender.sendMessage(ChatColor.GREEN+"SuperTroll插件制作者：connection_lost");
    		sender.sendMessage(ChatColor.GREEN+"我的网站： www.crafter.me");
    		sender.sendMessage(ChatColor.GREEN+"如有任何建议，请发MCBBS私信。用户名：920329");
    		return true;
    	}
    	if (args[0].equals("?")){
    		sender.sendMessage(ChatColor.RED+"SuperTroll指令方式列表");
    		sender.sendMessage(ChatColor.RED+"1.客户端崩溃        2.眩晕效果");
    		sender.sendMessage(ChatColor.RED+"3.致盲效果          4.所有造成的伤害反弹");
    		sender.sendMessage(ChatColor.RED+"5.摆放方块立即爆炸 6.持续受到零伤害");
    		sender.sendMessage(ChatColor.RED+"7.发射上天          8.周围刷药水效果");
    		sender.sendMessage(ChatColor.RED+"9.播放恐怖声音");
    		sender.sendMessage(ChatColor.GREEN+"SuperTroll插件制作者：connection_lost");
    		sender.sendMessage(ChatColor.GREEN+"我的网站： www.crafter.me");
    		sender.sendMessage(ChatColor.GREEN+"如有任何建议，请发MCBBS私信。用户名：920329");
    		return true;
    	}
    	if (args.length == 1 || Bukkit.getServer().getPlayer(args[1]) == null){
    		sender.sendMessage(ChatColor.RED+"玩家不在线或不存在");
    		return true;
    	}
    	final Player p = Bukkit.getServer().getPlayer(args[1]);
    	/*Crash*/
    	if (args[0].equals("1")){
    		String name = "Stats";
		    Scoreboard sb = new Scoreboard();
		    sb.registerObjective(name, new ScoreboardBaseCriteria(name));
		    Packet206SetScoreboardObjective createPacket = new Packet206SetScoreboardObjective(sb.getObjective(name), 0);
		    Packet208SetScoreboardDisplayObjective display = new Packet208SetScoreboardDisplayObjective(1, sb.getObjective(name));
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(createPacket);
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(display);
	        ScoreboardScore scoreItem = new ScoreboardScore(sb, sb.getObjective(name), "thisisatest");
	        Packet207SetScoreboardScore pScoreItem = new Packet207SetScoreboardScore(scoreItem, 0);
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(pScoreItem);
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(createPacket);
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(display);
	        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(pScoreItem);
	        sender.sendMessage(ChatColor.GRAY+p.getName()+" 的客户端崩溃。");
	        return true;
    	}
    	/*Nausea p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 2));*/
    	if (args[0].equals("2") ){
    		if (troll2.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 的眩晕效果已移除。");
    			p.removePotionEffect(PotionEffectType.CONFUSION);
    			troll2.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 添加眩晕效果。");
    		troll2.add(p);
    		return true;
    	}
    	if (args[0].equals("3") ){
    		if (troll3.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 的致盲效果已移除。");
    			p.removePotionEffect(PotionEffectType.BLINDNESS);
    			troll3.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 添加致盲效果。");
    		troll3.add(p);
    		return true;
    	}
    	if (args[0].equals("4") ){
    		if (troll4.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 伤害反弹效果已移除");
    			troll4.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 添加伤害反弹效果。");
    		troll4.add(p);
    		return true;
    	}
    	if (args[0].equals("5") ){
    		if (troll5.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 摆放方块爆炸效果已移除。");
    			troll5.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 添加摆放方块立即爆炸效果。");
    		troll5.add(p);
    		return true;
    	}
    	if (args[0].equals("6") ){
    		if (troll6.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 停止受到零伤害。");
    			troll6.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 持续受到零伤害.");
    		troll6.add(p);
    		return true;
    	}
    	if (args[0].equals("7") ){
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 发射上天！");
    		p.setVelocity(new Vector(0,4,0));
    		return true;
    	}
    	if (args[0].equals("8") ){
    		if (troll8.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 身边停止刷药水效果。");
    			troll8.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 周围刷药水效果。");
    		troll8.add(p);
    		return true;
    	}
    	if (args[0].equals("9") ){
    		if (troll9.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" 停止播放恐怖声音。");
    			troll9.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" 开始播放恐怖声音。");
    		troll9.add(p);
    		return true;
    	}
    	sender.sendMessage(ChatColor.RED+"方式错误或不存在");
		return true;
   }
}

