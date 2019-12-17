package ru.hubsmc.ru.hubschesterton.internal.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.hubsmc.ru.hubschesterton.internal.ClickHandler;

public class ChestertonItem {

    private Material material;
    private ItemStack cachedItem;
    private ClickHandler clickHandler;

    private boolean needToRefresh;

    public ChestertonItem(Material material) {
        this.material = material;
        this.needToRefresh = false;
    }

    public Material getMaterial() {
        return material;
    }

    public void setClickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    public ClickHandler getClickHandler() {
        return clickHandler;
    }

    public void setNeedToRefresh(boolean needToRefresh) {
        this.needToRefresh = needToRefresh;
    }

    public boolean isNeedToRefresh() {
        return needToRefresh;
    }

    public ItemStack createItemStack(Player player) {
        if (!needToRefresh && cachedItem != null) {
            return cachedItem;
        }

        ItemStack itemStack = setItemData( (material != null) ? new ItemStack(material) : new ItemStack(Material.BEDROCK) , player);

        if (!needToRefresh) {
            cachedItem = itemStack;
        }

        return itemStack;
    }

    protected ItemStack setItemData(ItemStack itemStack, Player player) {
        return itemStack;
    }

    public boolean onClick(Player whoClicked) {
        if (clickHandler != null) {
            return clickHandler.onClick(whoClicked);
        }
        return false;
    }

}
