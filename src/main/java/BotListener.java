package main.java;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.EventListener;

import java.util.Random;

public class BotListener implements EventListener{

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

        if(event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE) && message.startsWith("!spawn")){
            Random rand = new Random();
            int  n = rand.nextInt(5) + 1;
            //Max: 5 Min: 1

            switch(n){
                case 1:
                    event.getTextChannel().sendMessage("**" + event.getAuthor().getName()  + "** spawned **GELICO**! " +
                            "https://raw.githubusercontent.com/katasantos/XeBot/master/src/resources/gelico.png").complete();
                    break;
                case 2:
                    event.getTextChannel().sendMessage("**" + event.getAuthor().getName()  + "** spawned **MIKEE**! " +
                            "https://raw.githubusercontent.com/katasantos/XeBot/master/src/resources/mikee.png").complete();
                    break;
                case 3:
                    event.getTextChannel().sendMessage("**" + event.getAuthor().getName()  + "** spawned **CHARLES**! " +
                            "https://raw.githubusercontent.com/katasantos/XeBot/master/src/resources/charles.png").complete();
                    break;
                case 4:
                    event.getTextChannel().sendMessage("**" + event.getAuthor().getName()  + "** spawned **JASPER**! " +
                            "https://raw.githubusercontent.com/katasantos/XeBot/master/src/resources/jasper.png").complete();
                    break;
                case 5:
                    event.getTextChannel().sendMessage("**" + event.getAuthor().getName()  + "** spawned **YO**! " +
                            "https://raw.githubusercontent.com/katasantos/XeBot/master/src/resources/yo.png").complete();
                    break;
            }

        }
    }


}
