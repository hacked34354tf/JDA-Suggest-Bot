package me.Sanhak.Suggest.Commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SuggestCMD extends ListenerAdapter
{//Start

	private String suggest;	
	@SuppressWarnings("deprecation")
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {	     
	     String[] message = e.getMessage().getContentRaw().split("\\s+");
	     EmbedBuilder eb = new EmbedBuilder();
	     if (e.getChannel().getId().equalsIgnoreCase("CMD-Channel-ID")) {
	     if (message[0].equalsIgnoreCase("!sug")) {	        
	      if (message.length < 2) {
	    		 e.getChannel().sendMessage("This usage is wrong, please write it like this `!sug <suggest>`").queue();
	    		 return;
	    	 }
	         StringBuffer sb = new StringBuffer();
	         for (int i  = 1; i < message.length; i++) {
	            sb.append(message[i]);
	            sb.append(" ");
	         }	            	         	         
	         
	         this.suggest = sb.toString();
	         
	         TextChannel textChannel = e.getGuild().getTextChannelById("Suggestments-Channel-ID");
	         
	         eb.setColor(Color.DARK_GRAY);
	         eb.setTitle("Suggestments");
	         eb.setDescription("Suggest : " + suggest);
	         eb.setFooter(e.getMember().getUser().getAsTag(), e.getMember().getUser().getAvatarUrl());
	         textChannel.sendMessage(eb.build()).queue(tt -> {
	        	  tt.addReaction("✔").queue();
	        	  tt.addReaction("X").queue();
	        	});
	    }
	     
	}
}
	
	
}//End
