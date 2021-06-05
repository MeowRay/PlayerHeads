package org.shininet.bukkit.playerheads.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author MeowRay
 * @version 1.0
 * @date 2021/6/5 22:54
 */
public class HeadRollPreEvent   extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    public boolean isPlayer() {
        return player;
    }

    private final Entity target;
    private final boolean player;
    private  double droprateOriginal;
    private  double lootingModifier;
    private  double chargedcreeperModifier;

    public double getSlimeModifier() {
        return slimeModifier;
    }

    public void setSlimeModifier(double slimeModifier) {
        this.slimeModifier = slimeModifier;
    }

    private double slimeModifier;

    public HeadRollPreEvent(Entity killer ,  Entity target ,boolean player, double droprateOriginal , double lootingModifier , double chargedcreeperModifier , double slimeModifier){
        this.killer = killer;
        this.target = target;
        this.player = player;
        this.droprateOriginal = droprateOriginal;
        this.lootingModifier = lootingModifier;
        this.chargedcreeperModifier = chargedcreeperModifier;
        this.slimeModifier = slimeModifier;
    }

    private final Entity killer;

    public void setDroprateOriginal(double droprateOriginal) {
        this.droprateOriginal = droprateOriginal;
    }

    public void setLootingModifier(double lootingModifier) {
        this.lootingModifier = lootingModifier;
    }

    public void setChargedcreeperModifier(double chargedcreeperModifier) {
        this.chargedcreeperModifier = chargedcreeperModifier;
    }

    public Entity getKiller() {
        return killer;
    }

    public double getDroprateOriginal() {
        return droprateOriginal;
    }

    public double getLootingModifier() {
        return lootingModifier;
    }

    public double getChargedcreeperModifier() {
        return chargedcreeperModifier;
    }

    /**
     * Get a list of handlers for the event.
     *
     * @return a list of handlers for the event
     */
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Get a list of handlers for the event.
     *
     * @return a list of handlers for the event
     */
    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Entity getTarget() {
        return target;
    }
}
