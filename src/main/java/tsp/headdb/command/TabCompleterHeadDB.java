package tsp.headdb.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleterHeadDB implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> comp = new ArrayList<>();
        if (args.length == 1) {
            String sub = args[0];
            comp.add("info");
            if (sender.hasPermission("headdb.reload"))
                comp.add("reload");
            if (sender.hasPermission("headdb.search"))
                comp.add("search");
            if (sender.hasPermission("headdb.tagsearch"))
                comp.add("tagsearch");
            if (sender.hasPermission("headdb.give"))
                comp.add("give");
            if (sender.hasPermission("headdb.update"))
                comp.add("update");
            return StringUtil.copyPartialMatches(sub, comp, new ArrayList<>());
        }
        if (args[0].equalsIgnoreCase("give") && args.length == 2) {
            for (Player p : Bukkit.getOnlinePlayers())
                comp.add(p.getName());
            return StringUtil.copyPartialMatches(args[1], comp, new ArrayList<>());
        }
        return Collections.emptyList();
    }
}
