package dev.doeshing.koukeNekoAnnoundement;

import dev.doeshing.koukeNekoAnnoundement.commands.ReloadCommand;
import dev.doeshing.koukeNekoAnnoundement.core.CommandSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class KoukeNekoAnnoundement extends JavaPlugin {

    private CommandSystem commandSystem;
    private int announcementTaskId = -1; // 用來記錄公告任務的 ID

    @Override
    public void onEnable() {
        // 若 config.yml 尚未存在則複製預設配置
        saveDefaultConfig();

        // 使用 CommandSystem 註冊 reload 指令
        commandSystem = new CommandSystem(this);
        commandSystem.registerCommand("koukenekoannouncementreload", new ReloadCommand(this), null, "重新載入設定文件", "/koukenekoannouncementreload", "knar");

        // 啟動公告任務
        scheduleAnnouncements();
    }

    @Override
    public void onDisable() {
        // 插件關閉時取消公告任務（若有的話）
        if (announcementTaskId != -1) {
            Bukkit.getScheduler().cancelTask(announcementTaskId);
        }
    }

    /**
     * 根據 config.yml 中 Global_Messages 設定來定時廣播公告訊息
     */
    public void scheduleAnnouncements() {
        // 如果已經有公告任務，先取消它
        if (announcementTaskId != -1) {
            Bukkit.getScheduler().cancelTask(announcementTaskId);
        }

        int intervalSeconds = getConfig().getInt("Global_Messages.Interval", 30);
        long intervalTicks = intervalSeconds * 20L; // 將秒轉換成 Minecraft 的 tick
        List<String> messages = getConfig().getStringList("Global_Messages.Messages");
        String prefix = getConfig().getString("Global_Messages.Prefix", "");
        boolean headerAndFooter = getConfig().getBoolean("Global_Messages.Header_And_Footer", true);
        String header = getConfig().getString("Global_Messages.Header", "");
        String footer = getConfig().getString("Global_Messages.Footer", "");

        if (messages.isEmpty()) {
            getLogger().warning("設定文件中未找到任何公告訊息！");
            return;
        }

        announcementTaskId = Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            int index = 0;

            @Override
            public void run() {
                String msg = messages.get(index);
                // 替換 {Prefix} 佔位符
                msg = msg.replace("{Prefix}", prefix);
                // 轉換色彩代碼
                msg = ChatColor.translateAlternateColorCodes('&', msg);

                if (headerAndFooter) {
                    String coloredHeader = ChatColor.translateAlternateColorCodes('&', header);
                    Bukkit.broadcastMessage(coloredHeader);
                }
                Bukkit.broadcastMessage(msg);
                if (headerAndFooter) {
                    String coloredFooter = ChatColor.translateAlternateColorCodes('&', footer);
                    Bukkit.broadcastMessage(coloredFooter);
                }
                index = (index + 1) % messages.size();
            }
        }, 0L, intervalTicks).getTaskId();
    }
}
