package game;

import java.awt.Image;

//モンスターの作成
public class Monster extends Enemy{
	int xspeed = 3;
	//怪物的可发现距离
	int see = 100;
	Boolean flag = false;
	Boolean hit = false;
	
	public Monster(int x, int y, int width, int height, Image img) {
		super(x, y, width, height, img);
		// TODO 自动生成的构造函数存根}
	}
    public void Ai(Hero hero)throws MyException{
    	//x轴算法设计
    	if(this.x>hero.x){
    		if(hero.x + see < this.x){
    			flag = true;
    		}else if(hero.x + see >= this.x ){
    		x -= xspeed;
    		}else{    
    		throw new MyException("ai算法错误，重新设计");
    		}
    	}else if(this.x < hero.x){

        	if(hero.x + see > this.x){
        		flag = true;
        	}else if(hero.x + see <= this.x ){
        		x += xspeed;
        	}else{
        		throw new MyException("ai算法错误，重新设计");
        	}	
    	}else if(hero.x == this.x){
    		hit = true;
    	}else{
    		throw new MyException("ai算法错误，重新设计");
    	}
    	
    	//y轴算法设计(暂定怪物不会跳) 	
    	//如果怪物不能发现hero,进行慢速随机移动
    	if(flag){
    		
    	}
	}
}