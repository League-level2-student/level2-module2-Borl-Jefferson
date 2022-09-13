package _08_LeagueSnake;

import processing.core.PApplet;

/*
 * This class will be used to represent each part of the moving snake.
 * 
 * 1. Add x and y member variables.
 *    They will hold the corner location of each segment of the snake.
 * 
 * 2. Add a constructor with parameters to initialize each variable.
 */
public class Segment {
    int x=0;
    int y=0;
    PApplet processing;
    public Segment(int x, int y, PApplet processing){
    	this.x=x;
    	this.y=y;
this.processing = processing;
    }
    public void draw() {
    		processing.square(x, y, 10);
    	}
}
