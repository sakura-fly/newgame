package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

	public class KeyLessson extends KeyAdapter{  
	      
	    public MyPanel_1 gf;  
	    public boolean jumpFlag=true;  
	      
	    public KeyLessson(MyPanel_1 gf) {  
	        this.gf=gf;  
	    }  
	      
	    //���̼���  
	    public void keyPressed(KeyEvent e) {  
	        int code = e.getKeyCode();  
	        switch(code){  
	        //������  
	        case 39:  
	            gf.hero.right=true;  
	            break;  
	            //������  
	        case 37:  
	            gf.hero.left=true;  
	        break;  
	
	          
	        //������  
	        case 74:  
	            gf.hero.up=true;  
	            break;  
	    }  
	    }  
	      
	  
	    //�����ͷż���  
	    public void keyReleased(KeyEvent e) {  
	          
	        int code=e.getKeyCode();  
	        if(code==39){  
	              
	            gf.hero.right=false;  
	              
	            gf.hero.img=new ImageIcon("src/image/timg.gif").getImage();  
	        }  
	        if(code==37){  
	            gf.hero.left=false;  
	              
	            gf.hero.img=new ImageIcon("src/image/timg.gif").getImage();  
	        }  
	          
	        if(code==74){  
	            gf.hero.up=false;  
	            gf.hero.img=new ImageIcon("src/image/timg.png").getImage();  
	        }  
	    }  
	  
	}  
