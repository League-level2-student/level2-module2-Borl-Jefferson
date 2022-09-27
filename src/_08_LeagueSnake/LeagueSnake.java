package _08_LeagueSnake;

import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	Segment head;
	int fx;
	int fy;
	int hx = 250;
	int hy = 250;
	int dir = UP;
	int food = 0;
	boolean fail = false;
	int nowx = 250;
	int nowy = 250;
	ArrayList<Segment> segments = new ArrayList<Segment>();
	ArrayList<Integer> nx = new ArrayList<Integer>();
	ArrayList<Integer> ny = new ArrayList<Integer>();
	ArrayList<Integer> px = new ArrayList<Integer>();
	ArrayList<Integer> py = new ArrayList<Integer>();

	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {

		size(500, 500);

		// it's 500,500 for now, but make it so there are 3 different difficulties modes
		// that change the size

	}

	@Override
	public void setup() {
		head = new Segment(250, 250, this);
		frameRate(20);
		dropFood();

		px.add(5);
		py.add(5);
		ny.add(5);
		nx.add(5);
	}

	void dropFood() {
		// Set the food in a new random location
		fx = ((int) random(50) * 10);
		fy = ((int) random(50) * 10);
	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(150, 150, 255);
		drawFood();
		move();
		drawSnake();

		eat();
		manageTail();

		/*
		 * px.remove(px.get(px.size()-1)); py.remove(py.get(py.size()-1)); px.add(nowx);
		 * py.add(nowy); nowy= hy; nowx= hx; nx.remove(nx.get(px.size()-1));
		 * ny.remove(ny.get(px.size()-1)); nx.add(hx); ny.add(hy);
		 */

	}

	void drawFood() {
		// Draw the food
		stroke(198, 137, 88);
		fill(198, 137, 88);
		square(fx, fy, 10);
	}

	void drawSnake() {
		stroke(50, 255, 100);
		fill(50, 255, 100);
		square(hx, hy, 15);

		drawTail();

		// Draw the head of the snake followed by its tail
	}

	void drawTail() {
		// Draw each segment of the tail

		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
		System.out.println(segments.size());

	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.

//for (int i=food-1; i < 0; i--) {

//}
		segments.add(new Segment(hx, hy, this));
		segments.remove(segments.size() -1);
		System.out.println(hx + " " + hy);
		// segments.add(new Segment(250, 250, this));

	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment

	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if (keyCode == 37 || keyCode == 65) {
			if (dir != RIGHT) {
				dir = LEFT;

			}
		}
		if (keyCode == 38 || keyCode == 87) {
			if (dir != DOWN) {
				dir = UP;

			}
		}
		if (keyCode == 39 || keyCode == 68) {
			if (dir != LEFT) {
				dir = RIGHT;
			}
		}

		if (keyCode == 40 || keyCode == 83) {
			if (dir != UP) {
				dir = DOWN;
			}

		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		if (dir == UP) {
			hy -= 10;

		} else if (dir == DOWN) {
			hy += 10;

		} else if (dir == LEFT) {
			hx -= 10;
		} else if (dir == RIGHT) {
			hx += 10;
		}
		checkBoundaries();
	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side

		if (hx > 500) {
			hx = 0;
		}
		if (hy > 500) {
			hy = 0;
		}
		if (hy < 0) {
			hy = 500;
		}
		if (hx < 0) {
			hx = 500;
		}

	}

	void eat() {
		int hya = hy + 16;
		int hys = hy - 16;
		int hxa = hx + 16;
		int hxs = hx - 16;
		// When the snake eats the food, its tail should grow and more
		// food appear

		if (fx >= hxs && fx <= hxa) {
			if (fy >= hys && fy <= hya) {
				food += 1;
				dropFood();

				segments.add(new Segment(hx, hy, this));

			}

		}
	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
