package dev.doeshing.koukeNekoAnnoundement.commands;

import dev.doeshing.koukeNekoAnnoundement.KoukeNekoAnnoundement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final KoukeNekoAnnoundement plugin;

    public ReloadCommand(KoukeNekoAnnoundement plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 重新載入配置文件
        plugin.reloadConfig();
        // 重新排程公告任務，讓新的設定生效
        plugin.scheduleAnnouncements();
        sender.sendMessage("§a設定文件已重新載入並更新公告任務！");
        return true;
    }
}
