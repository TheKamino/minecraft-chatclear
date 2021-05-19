package de.kamikazozi.chatclear;

import de.kamikazozi.chatclear.comamnds.CommandChatClear;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */

public class ChatClear extends JavaPlugin {

    public void onEnable() {
        registerCommands();
    }

    public void registerCommands() {
        getCommand("chatclear").setExecutor(new CommandChatClear());
    }
}
