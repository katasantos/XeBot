package main.java;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import java.util.Random;

public class BotListener implements EventListener{
    Random rand = new Random();
    @Override
    public void onEvent(Event event){
        System.out.println(event.getClass().getSimpleName());
        if(event instanceof MessageReceivedEvent) onMessage((MessageReceivedEvent) event);
        if(event instanceof MessageReceivedEvent) onMessageRandomImage((MessageReceivedEvent) event);
    }


    public void onMessage(MessageReceivedEvent event){
        String message = event.getMessage().getContent();

        if(event.getAuthor().equals(event.getJDA().getSelfUser())){
            return;
        }

        if(event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE) && message.startsWith("fuck")) {
            event.getTextChannel().sendMessage("Dont say that, bitch.").complete();
        }
    }

    public void onMessageRandomImage(MessageReceivedEvent event){
        String message = event.getMessage().getContent();

        if (event.getAuthor().equals(event.getJDA().getSelfUser())) {

            return;
        }

        if(event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE) && message.startsWith("wubbalubbadubdub")){
            int  n = rand.nextInt(3) + 1;
            event.getTextChannel().sendMessage("http://google.com").complete();
        }
    }


}
