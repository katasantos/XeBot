package main.java;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class BotDiscord {

    public static void main(String[] args){

        try {
            JDA jda = new JDABuilder(AccountType.BOT).setToken("MzYzNTg0MDc1MjgzMzAwMzY0.DLDVlQ.eyrQMhtxF-NFhJ8IIE7h3IlWNSg").buildAsync();
            jda.addEventListener(new BotListener());
            System.out.print("Bot connected");
        } catch (LoginException | IllegalArgumentException | RateLimitedException e) {
            e.printStackTrace();
        }
    }
}
