package game;

import java.awt.Image;

//��󥹥��`������
public class Monster extends Enemy{
	int xspeed = 3;
	//����Ŀɷ��־���
	int see = 100;
	Boolean flag = false;
	Boolean hit = false;
	
	public Monster(int x, int y, int width, int height, Image img) {
		super(x, y, width, height, img);
		// TODO �Զ����ɵĹ��캯�����}
	}
    public void Ai(Hero hero)throws MyException{
    	//x���㷨���
    	if(this.x>hero.x){
    		if(hero.x + see < this.x){
    			flag = true;
    		}else if(hero.x + see >= this.x ){
    		x -= xspeed;
    		}else{    
    		throw new MyException("ai�㷨�����������");
    		}
    	}else if(this.x < hero.x){

        	if(hero.x + see > this.x){
        		flag = true;
        	}else if(hero.x + see <= this.x ){
        		x += xspeed;
        	}else{
        		throw new MyException("ai�㷨�����������");
        	}	
    	}else if(hero.x == this.x){
    		hit = true;
    	}else{
    		throw new MyException("ai�㷨�����������");
    	}
    	
    	//y���㷨���(�ݶ����ﲻ����) 	
    	//������ﲻ�ܷ���hero,������������ƶ�
    	if(flag){
    		
    	}
	}
}