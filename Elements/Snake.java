package Elements;

import Features.Values;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

import Graphics.Shape;

public class Snake {
    private int boardW, boardH;
    private ArrayList<Point> snakeList;
    private ArrayList<Point> lastSnakeList;
    private Shape[][] boardDrawing;
    private Point apple;
    private Shape appleShape = new Shape(0,0, Values.blockSize, Values.blockSize, 0, 0, 0, "rect normal", Values.timerSpeed);
    private Random r = new Random();
    public Values.Directions currDirection;
    public int speed;
    public int speedCounter = 0;
    public int applesEaten = 0;
    public final int speedDecrement = 25;

    public Snake(int displayW, int displayH) {
        this.boardW = displayW;//(displayW - Values.blockGap) / (Values.blockSize + Values.blockGap);
        this.boardH = displayH;//(displayH - Values.blockGap) / (Values.blockSize + Values.blockGap);
        snakeList = new ArrayList<Point>();
        boardDrawing = new Shape[boardH][boardW];
        this.currDirection = Values.Directions.NONE;
        // System.out.println(boardDrawing.length+", "+boardDrawing[0].length);
        for(int y = 0; y < boardDrawing.length; ++y) {
            for(int x = 0; x < boardDrawing[y].length; ++x) {
                boardDrawing[y][x] = new Shape(Values.blockGap + (Values.blockGap + Values.blockSize) * x, Values.blockGap + (Values.blockGap + Values.blockSize) * y, Values.blockSize, Values.blockSize, 0, 0, 0, "rect normal", Values.timerSpeed);
            }
        }

        this.speed = 100;
        
        Point startPoint = new Point(r.nextInt(this.boardW), r.nextInt(this.boardH));
        snakeList.add(startPoint);
        this.replaceApple();
    }

    public boolean isInSnake(Point check){
        for(Point p:snakeList){
            if(p.x == check.x && p.y==check.y) return true;
        }
        return false;
    }

    public void replaceApple(){
        while(isInSnake(this.apple=new Point(r.nextInt(this.boardW), r.nextInt(this.boardH))));
        this.appleShape.setX(Values.blockGap + (Values.blockGap + Values.blockSize) * this.apple.x);
        this.appleShape.setY(Values.blockGap + (Values.blockGap + Values.blockSize) * this.apple.y);
        //new Shape(Values.blockGap + (Values.blockGap + Values.blockSize) * this.apple.x, Values.blockGap + (Values.blockGap + Values.blockSize) * this.apple.y, Values.blockSize, Values.blockSize, 0, 0, 0, "rect normal", Values.timerSpeed);
    }

    public void update() {
        this.lastSnakeList = this.getSnakeListClone();
        if(this.currDirection != Values.Directions.NONE) {
            for(int i = snakeList.size() - 1; i > 0; --i) {
                snakeList.get(i).x = snakeList.get(i - 1).x;
                snakeList.get(i).y = snakeList.get(i - 1).y;
            }
        }

        switch(this.currDirection) {
            case RIGHT:
                snakeList.get(0).x += 1;
                break;

            case LEFT:
                snakeList.get(0).x -= 1;
                break;

            case UP:
                snakeList.get(0).y -= 1;
                break;

            case DOWN:
                snakeList.get(0).y += 1;
                break;

            default:
                break;
        }

    }

    public ArrayList<Point> getSnakeListClone(){
        ArrayList<Point> clone = new ArrayList<Point>();
        for(Point p:this.snakeList)
            clone.add(new Point(p.x,p.y));
        return clone;
    }


    public void drawSnake(Graphics g) {
        for(int y = 0; y < boardDrawing.length; ++y) {
            for(int x = 0; x < boardDrawing[y].length; ++x) {
                boolean isIn = false;

                for(Point p : this.snakeList) {
                    if(p.x == x && p.y == y) isIn = true;
                }

                boardDrawing[y][x].draw(g, isIn ? Color.WHITE : Values.backgroundColor, true);
            }
        }
    }
    public void drawApple(Graphics g){
        this.appleShape.draw(g, Color.RED, true);
    }

    public Point getApplePoint(){
        return this.apple;
    }

    /*
     * Return:
     *  2 if apple eaten
     *  1 if nothing happened
     *  0 if failed
     */
    public int run(Graphics g){

        this.update();
        this.drawSnake(g);
        this.drawApple(g);

        if(this.isInSnake(this.getApplePoint())){
            this.replaceApple();
            this.grow();
            this.speedCounter++;
            this.applesEaten++;
            return 2;
        }
        if(this.getFail()){
            this.speedCounter = 0;
            return 0;
        }
        else {
            if(this.speedCounter%5==0 && this.speedCounter!=0 && this.speed-speedDecrement>0){
                this.speedCounter = 0;
                this.speed-=speedDecrement;
            }
            return 1;
        }
    }

    public void grow(){
        this.snakeList.add(this.lastSnakeList.get(this.lastSnakeList.size()-1));
    }

    public boolean getFail(){
        Point head = (Point)this.snakeList.get(0).clone();
        for(int i = 1;i<this.snakeList.size();++i){
            if(this.snakeList.get(0).equals(this.snakeList.get(i))) return true;
        }
        return head.x<0 || head.y<0 || head.y>=this.boardH || head.x>=this.boardW;
    }
}
