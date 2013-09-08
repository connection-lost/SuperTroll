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
    		sender.sendMessage(ChatColor.RED+"SuperTrollָ��ʹ�÷���:");
    		sender.sendMessage(ChatColor.RED+"/troll <��ʽ> <���>");
    		sender.sendMessage(ChatColor.RED+"����/troll ? �鿴���з�ʽ����");
    		sender.sendMessage(ChatColor.RED+"��:���� "+ChatColor.RESET+"/troll 1 xxs"+ChatColor.RED+" ����ʹ���xxs�Ŀͻ��˱���");
    		sender.sendMessage(ChatColor.GREEN+"SuperTroll��������ߣ�connection_lost");
    		sender.sendMessage(ChatColor.GREEN+"�ҵ���վ�� www.crafter.me");
    		sender.sendMessage(ChatColor.GREEN+"�����κν��飬�뷢MCBBS˽�š��û�����920329");
    		return true;
    	}
    	if (args[0].equals("?")){
    		sender.sendMessage(ChatColor.RED+"SuperTrollָ�ʽ�б�");
    		sender.sendMessage(ChatColor.RED+"1.�ͻ��˱���        2.ѣ��Ч��");
    		sender.sendMessage(ChatColor.RED+"3.��äЧ��          4.������ɵ��˺�����");
    		sender.sendMessage(ChatColor.RED+"5.�ڷŷ���������ը 6.�����ܵ����˺�");
    		sender.sendMessage(ChatColor.RED+"7.��������          8.��ΧˢҩˮЧ��");
    		sender.sendMessage(ChatColor.RED+"9.���ſֲ�����");
    		sender.sendMessage(ChatColor.GREEN+"SuperTroll��������ߣ�connection_lost");
    		sender.sendMessage(ChatColor.GREEN+"�ҵ���վ�� www.crafter.me");
    		sender.sendMessage(ChatColor.GREEN+"�����κν��飬�뷢MCBBS˽�š��û�����920329");
    		return true;
    	}
    	if (args.length == 1 || Bukkit.getServer().getPlayer(args[1]) == null){
    		sender.sendMessage(ChatColor.RED+"��Ҳ����߻򲻴���");
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
	        sender.sendMessage(ChatColor.GRAY+p.getName()+" �Ŀͻ��˱�����");
	        return true;
    	}
    	/*Nausea p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 2));*/
    	if (args[0].equals("2") ){
    		if (troll2.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" ��ѣ��Ч�����Ƴ���");
    			p.removePotionEffect(PotionEffectType.CONFUSION);
    			troll2.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" ���ѣ��Ч����");
    		troll2.add(p);
    		return true;
    	}
    	if (args[0].equals("3") ){
    		if (troll3.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" ����äЧ�����Ƴ���");
    			p.removePotionEffect(PotionEffectType.BLINDNESS);
    			troll3.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" �����äЧ����");
    		troll3.add(p);
    		return true;
    	}
    	if (args[0].equals("4") ){
    		if (troll4.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" �˺�����Ч�����Ƴ�");
    			troll4.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" ����˺�����Ч����");
    		troll4.add(p);
    		return true;
    	}
    	if (args[0].equals("5") ){
    		if (troll5.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" �ڷŷ��鱬ըЧ�����Ƴ���");
    			troll5.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" ��Ӱڷŷ���������ըЧ����");
    		troll5.add(p);
    		return true;
    	}
    	if (args[0].equals("6") ){
    		if (troll6.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" ֹͣ�ܵ����˺���");
    			troll6.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" �����ܵ����˺�.");
    		troll6.add(p);
    		return true;
    	}
    	if (args[0].equals("7") ){
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" �������죡");
    		p.setVelocity(new Vector(0,4,0));
    		return true;
    	}
    	if (args[0].equals("8") ){
    		if (troll8.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" ���ֹͣˢҩˮЧ����");
    			troll8.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" ��ΧˢҩˮЧ����");
    		troll8.add(p);
    		return true;
    	}
    	if (args[0].equals("9") ){
    		if (troll9.contains(p)){
    			sender.sendMessage(ChatColor.GRAY+p.getName()+" ֹͣ���ſֲ�������");
    			troll9.remove(p);
    			return true;
    		}
    		sender.sendMessage(ChatColor.GRAY+p.getName()+" ��ʼ���ſֲ�������");
    		troll9.add(p);
    		return true;
    	}
    	sender.sendMessage(ChatColor.RED+"��ʽ����򲻴���");
		return true;
   }
}

