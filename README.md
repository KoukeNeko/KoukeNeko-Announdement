# KoukeNeko Announcement Plugin

## 🌟 Introduction

KoukeNeko Announcement is a lightweight and easy-to-use Minecraft announcement plugin that supports randomized message order and customizable sound effects.

## 🔧 Features

- ✅ Scheduled broadcast messages with easy configuration
- ✅ Customizable prefixes, headers, and footers
- ✅ Randomized message order for varied announcements
- ✅ Optional sound playback with announcements
- ✅ Simple command to reload configuration without restarting

## 📂 Installation

1. Place the compiled `.jar` file into your server's `plugins` folder.
2. Restart your server or use the `/reload` command to activate the plugin.

## 🚀 Commands

| Command                                 | Description              | Permission                        |
|-----------------------------------------|--------------------------|-----------------------------------|
| `/koukenekoannouncementreload` (`/knareload`) | Reload plugin configuration | `koukeneko.announcement.admin` |

## 🔑 Permissions

| Permission                        | Description                      |
|-----------------------------------|----------------------------------|
| `koukeneko.announcement.admin`    | Allows use of the reload command |

## ⚙️ Configuration

Example configuration (`config.yml`):

```yaml
Global_Messages:
    Enable: true
    Header_And_Footer: true
    Interval: 30
    Prefix: "&7[&6!&7]"
    Header: "&7*&7&m--------------------------------&7*"
    Footer: "&7*&7&m--------------------------------&7*"
    Sound: 'ENTITY_PLAYER_LEVELUP' # Minecraft official sound ID
    Random: true # Randomize message order
    Messages:
      - "{Prefix} &6Welcome to the server! Please read the rules and enjoy your stay."
      - "{Prefix} &7Ask an admin or join our Discord if you have questions."
```

You can use any valid Minecraft sound ID listed in the [official Minecraft sound documentation](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html).

## ⚠️ Important Note

- If an invalid sound name is provided in the configuration, the plugin will log a warning in the server console.

## 🤝 Contribution

Feel free to submit Issues or Pull Requests if you encounter any problems or have suggestions for additional features.

## 📜 License

This plugin is released under the MIT License.

---

## 🌟 簡介

KoukeNeko Announcement 是一個輕量級且簡單易用的 Minecraft 公告插件，支援訊息亂序播放及自訂聲音效果。

## 🔧 功能特色

- ✅ 定時公告並提供簡易的配置
- ✅ 可自訂前綴、標題與頁尾
- ✅ 支援亂序播放訊息，提升變化性
- ✅ 可選擇公告時播放自訂聲音
- ✅ 提供重新載入配置指令，無需重啟伺服器

## 📂 安裝方式

1. 將編譯完成的 `.jar` 檔案放入伺服器的 `plugins` 目錄。
2. 重啟伺服器或輸入 `/reload` 指令載入插件。

## 🚀 指令

| 指令                                    | 功能                | 權限                           |
|----------------------------------------|--------------------|--------------------------------|
| `/koukenekoannouncementreload` (`/knareload`) | 重新載入插件配置   | `koukeneko.announcement.admin` |

## 🔑 權限

| 權限                             | 說明                    |
|----------------------------------|-------------------------|
| `koukeneko.announcement.admin`   | 允許使用重新載入配置指令 |

## ⚙️ 設定範例

設定檔範例 (`config.yml`):

```yaml
Global_Messages:
    Enable: true
    Header_And_Footer: true
    Interval: 30
    Prefix: "&7[&6!&7]"
    Header: "&7*&7&m--------------------------------&7*"
    Footer: "&7*&7&m--------------------------------&7*"
    Sound: 'ENTITY_PLAYER_LEVELUP' # Minecraft 官方聲音名稱
    Random: true # 是否亂序播放訊息
    Messages:
      - "{Prefix} &6歡迎來到伺服器! 請閱讀規則並享受遊戲。"
      - "{Prefix} &7有問題請詢問管理員或加入 Discord 尋求幫助。"
```

聲音名稱必須為有效的 Minecraft 聲音 ID，可參考 [官方聲音列表](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html)。

## ⚠️ 注意事項

- 如設定錯誤的聲音名稱，插件將在伺服器控制台顯示警告。

## 🤝 貢獻

若發現任何問題或希望提供功能建議，歡迎提交 Issue 或 Pull Request。

---

🚀 Enjoy your game! 祝你遊戲愉快！
