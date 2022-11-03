import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public abstract class BuyButton extends Actor
{
    protected GreenfootImage actionIcon;
    protected int cost, highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    protected boolean active;  // if neither player can afford the upgrade, grey-out the button
}
