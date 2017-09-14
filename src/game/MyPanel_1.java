package game;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;  
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
  
import javax.swing.*;

public class MyPanel_1 extends JFrame{  
    
    public Hero hero;  
    public Enemy obstruct_1,cion,obstruct_2,monster_1;  
    //����ͼƬ  
    public BackGround bg ;  
    //�ϰ���  
    public ArrayList<Enemy> eneryList = new ArrayList<Enemy>();
    //����  
    public ArrayList<Monster> monsterList = new ArrayList<Monster>();
    //��������
    public int monster[]= new int[1000];
    //�ϰ������飬�ڵ�ͼ����������ϰ���
    public int obstruct[][] = new int[1000][1000];
    //���캯����ʼ������ͼƬ��hero����  
    public MyPanel_1(){  
          
    	hero = new Hero(this);  
    	hero.start();  
        bg = new BackGround();  
        //�����ػ�  
        re_paint();
        //�ϰ�������
        obsturct_set();
        //�ϰ������
        obsturct_add();
        
        monster_set();
        obsturct_add();
  }  
    
    
  //�����ػ�
    public void re_paint(){
    	 //�����ػ��߳�  
        new Thread(){  
            public void run(){  
                while(true){  
                    //�ػ洰��  
                    repaint();  
                   try {  
                        Thread.sleep(10);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }.start(); 
    }
   //��������
    public void monster_set(){
	   	 int max = 210;
	     int min = 10;
      	 for (int i = 5; i < 1000; i++) {  
    			//����min-max�����
    		   	Random random = new Random();
    	    	 int a = random.nextInt(max)%(max-min+1) + min;
    	    	 if(a>=10 && a<100)
        	         monster[i]=0;
    	    	 if(a>=100 && a<207)
    	    		 monster[i]=1;
    	
    }
    }
  //�ϰ�������
    public void obsturct_set(){
    	 int max = 210;
         int min = 10;
        //����i,j����5��ֹ���￨���ڳ�����
    	for (int i = 5; i < 1000; i++) {  
    		for (int j = 5; j < 1000; j++) {
    			//����min-max�����
    		   	Random random = new Random();
    	    	 int a = random.nextInt(max)%(max-min+1) + min;
    	    	 if(a>=10 && a<205)
        	         obstruct[i][j]=0;
    	    	 if(a>=205 && a<207)
    	    		 obstruct[i][j]=1;
    	    	 if(a>=207 && a<208)
    	    		 obstruct[i][j]=0;
    	    	 if(a>=208 && a<=209)
    	    		 obstruct[i][j]=2;
            }
    	}
    	
    }
    
    //�������
      public void  monster_add(){
      	//�������
          for (int i = 0; i < monster.length; i++) {  
                //��ȡ������1�����ϰ���1  
                  if(obstruct[0][i]==1){  
                	  monster_1 = new Pipe(hero.x,i*30,30,30,new ImageIcon("src/image/timg.jpg").getImage());  
                      eneryList.add(monster_1);  
                  }  
                     
          }  
      }
    
    
  //�ϰ������
    public void  obsturct_add(){
    	//�ϰ������
        for (int i = 0; i < obstruct.length; i++) {  
            for (int j = 0; j < obstruct[0].length; j++) {  
                //��ȡ������1�����ϰ���1  
                if(obstruct[i][j]==1){  
                	obstruct_1 = new Pipe(j*30,i*30,30,30,new ImageIcon("src/image/timg.jpg").getImage());  
                    eneryList.add(obstruct_1);  
                }  
                //����2�����  
                if(obstruct[i][j]==2){  
                    cion = new Pipe(j*30,i*30,30,30,new ImageIcon("src/image/timg1.jpg").getImage());  
                    eneryList.add(cion);  
                }  
                //����3���ϰ���2
                if(obstruct[i][j]==3){  
                	obstruct_2 = new Pipe(j*30,i*30,60,60,new ImageIcon("src/image/timg3.jpg").getImage());  
                    eneryList.add(obstruct_2);  
                }  
                  
            }  
        }  
    }
    
    
    public void window(){  
        //���ô����������  
        this.setSize(800,450);  
        this.setTitle("game");  
        this.setResizable(false);  
        //���ڷ��м�
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(3);  
        this.setVisible(true);  
          
        //�ô�����Ӽ��̼���  
        KeyLessson kl = new KeyLessson(this);  
        this.addKeyListener(kl);  
    }  
      
    public void paint(Graphics g) {  
        //��������ͼƬ��hero
        BufferedImage bu =(BufferedImage)this.createImage(this.getSize().width,this.getSize().height);  
        Graphics hero_g =bu.getGraphics();  
        //������ͼƬ
        //hero_g.drawImage(bg.img, bg.x, bg.y, null);  
          
        for (int i = 0; i <eneryList.size(); i++) {  
            Enemy e =eneryList.get(i);  
            hero_g.drawImage(e.img, e.x, e.y, e.width, e.height,null);  
        }  
 
          
        //������  
        hero_g.drawImage(hero.img, (int)hero.x, (int)hero.y, hero.width, hero.height,null);  
        g.drawImage(bu,0,0,null);  
          
    }  
}  
  


class Hero extends Thread{
	    public MyPanel_1 gf;  
	      
	    public boolean jumpFlag=true;  
	      
	    //hero������  
	    public int x=0,y=358;  
	    //hero���ٶ�  
	    public int xspeed=5,yspeed=1;  
	    //hero�Ŀ��  

	    public int width=38,height=75;
	    //hero��ͼƬ����3.8 7.5  
	    public Image img = new ImageIcon("src/image/timg.png").getImage();  
	      
	    public boolean left=false,right=false,down=false,up=false;  
	      
	    public String Dir_Up="Up",Dir_Left="Left",Dir_Right="Right",Dir_Down="Down";  
	      
	    //���캯��
	    public Hero (MyPanel_1 gf) {  
	        this.gf=gf;  
	        this.floorFlag();  
	    }  
	    
	      
	    public void run(){  
	        while(true){  
	            //������  
	            if(left){  
	                //��ײ����  
	                if(hit(Dir_Left)){  
	                    this.xspeed=0;  
	                }  
	                  
	                if(this.x>=0){  
	                    this.x-=this.xspeed;  
	                    this.img=new ImageIcon("src/image/timg.gif").getImage();  
	                }  
	                  
	                this.xspeed=5;  
	            }  
	              
	            //������  
	            if(right){  
	                  
	                if(hit(Dir_Right)){  
	                    this.xspeed=0;  
	                }  
	                //�����������ƶ�  
	                if(this.x<400){  
	                    this.x+=this.xspeed;  
	                    this.img=new ImageIcon("src/image/timg.gif").getImage();  
	                }  
	                  
	                if(this.x>=400){  
	                    //���������ƶ�  
	                    gf.bg.x-=this.xspeed;  
	                    //�ϰ��������ƶ�  
	                    for (int i = 0; i <gf.eneryList.size(); i++) {  
	                        Enemy enery = gf.eneryList.get(i);  
	                        enery.x-=this.xspeed;  
	                    }  
	                    this.img=new ImageIcon("src/image/timg.gif").getImage();  
	                }  
	                this.xspeed=5;  
	            }  
	              
	            //������  
	            if(up){  
	  
	                if(jumpFlag && !isGravity){  
	                    jumpFlag=false;  
	                    new Thread(){  
	                        public void run(){  
	                            jump();  
	                            jumpFlag=true;  
	                        }  
	                    }.start();  
	                }  
	            }  
	              
	            try {  
	                this.sleep(20);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	      
	      
	    //�������ĺ���  
	    public void jump(){  
	        int jumpHeigh=0;  
	        for (int i = 0; i < 150; i++) {  
	            gf.hero.y-=this.yspeed;  
	            jumpHeigh++;  
	            if(hit(Dir_Up)){  
	                break;  
	            }  
	            try {  
	                Thread.sleep(5);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        for (int i = 0; i <jumpHeigh; i++) {  
	            gf.hero.y+=this.yspeed;  
	            if(hit(Dir_Down)){  
	                this.yspeed=0;  
	            }  
	            try {  
	                Thread.sleep(5);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	              
	              
	        }  
	        this.yspeed=1;//��ԭ�ٶ�  
	    }  
	      
	    //�����ײ  
	    public boolean hit(String dir){  
	    	//�Ƚ��Լ����﷽��͵������﷽���Ƿ񽻲�
	        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);  
	        Rectangle rect =null;  
	          
	        for (int i = 0; i < gf.eneryList.size(); i++) {  
	            Enemy enery = gf.eneryList.get(i);  
	              
	            if(dir.equals("Left")){  
	                rect = new Rectangle(enery.x+4,enery.y,enery.width,enery.height);  
	            }  
	            else if(dir.equals("Right")){  
	                rect = new Rectangle(enery.x-4,enery.y,enery.width,enery.height);  
	            }  
	              
	            else if(dir.equals("Up")){  
	                rect = new Rectangle(enery.x,enery.y+2,enery.width,enery.height);  
	            }else if(dir.equals("Down")){  
	                rect = new Rectangle(enery.x,enery.y-4,enery.width,enery.height);  
	            }  
	            //intersects���α߿�ͱ߿��Ƿ񽻲�
	            if(myrect.intersects(rect)){  
	                return true;  
	            }  
	        }  
	          
	        return false;  
	    }  
	      
	    //����Ƿ��ڵ���(��ֹ������) 
	    public boolean isGravity=false;  
	      
	    public void floorFlag(){  
	            new Thread(){  
	                public void run(){  
	                      
	                    while(true){  
	                        try {  
	                            sleep(10);  
	                        } catch (InterruptedException e) {  
	                            e.printStackTrace();  
	                        }  
	                          
	                        if(!jumpFlag){  
	                              
	                        }  
	                          
	                        while(true){  
	                            if(!jumpFlag){  
	                                break;  
	                            }  
	                              
	                            if(hit(Dir_Down)){  
	                                break;  
	                            }  
	                              
	                            if(y>=358){  
	                                isGravity=false;  
	                            }  
	                            else{  
	                                isGravity=true;  
	                                y+=yspeed;  
	                            }  
	                              
	                            try {  
	                                sleep(10);  
	                            } catch (InterruptedException e) {  
	                                e.printStackTrace();  
	                            }  
	                    }  
	                }  
	                }  
	            }.start();  
	      
	    }  
	    }  
