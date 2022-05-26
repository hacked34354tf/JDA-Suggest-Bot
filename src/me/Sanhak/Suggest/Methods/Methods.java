package me.Sanhak.Suggest.Methods;

import javax.security.auth.login.LoginException;

import me.Sanhak.Suggest.Commands.SuggestCMD;
import net.dv8tion.jda.api.JDABuilder;

public class Methods 
{//Start

	
	public static String Token = "Bot-Token";
	

	public static void Start_Bot() throws LoginException {
		JDABuilder b = JDABuilder.createDefault(Token);		
		b.addEventListeners(new SuggestCMD());
		b.build();
			
	}
	
	
}//End
