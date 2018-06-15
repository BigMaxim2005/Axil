/**
 * Axill , Java Application Template

 */

/**
 * @author MAXIM
 *
 */
//����������� ����������� ��������� 
import java.applet.*;
import java.io.*;
import java.awt.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import java.net.*;
import java.net.URL;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.imageio.*;

//���������� ��������� ������ � ����������� ���������� 
public class Axill extends JFrame implements KeyListener, MouseMotionListener, ActionListener, Runnable
{
//������� ����
	int windowSizeX=1200;
	int windowSizeY=800;
//�������� � ���� ��������
	int delay=30;
//��������� ���������� ������
	Graphics offscreen;
	Image offscreenImg;
	Image[] fruits = new Image[2];
//	ImageObserver observer;
//��������� ������ 
	public AudioClip BoomAudio;
	public AudioClip appAudio;
	public AudioClip oxxxAudio;

	private static final long serialVersionUID = 1L;
//���������� ��������� ������    
	public Axill() 
    {
//����������� ���������� ����	
		JFrame f = this;
//��������� ������� ��������� 
		f.setLayout( new FlowLayout() );
//��������� ������ ��� �������� ����		
    	f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//������ ��������� �������     
    	init();    	
//��������� �������� ����    	
    	f.setSize(windowSizeX , windowSizeY);   	
//���������� ����������� ����������    	
    	f.addKeyListener(this);
//��������� ������        
    	f.setFocusable(true);    
//������� ���� �������        
    	f.setVisible( true );   	
//���������� ������� �������        
    	Thread t = new Thread( this );
//������ �������    
    	t.start();
    }
 
//���������� ��������� �������	
    public void init() {
//�������� ������ ������    	
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        windowSizeX = gd.getDisplayMode().getWidth();
    	windowSizeY = gd.getDisplayMode().getHeight();
    	fruits[0] = null;
    	fruits[1] = null;
    	//��������� ���� � ��������� ����� �����
    	URL myUrl = ClassLoader.getSystemResource("boom.wav");
    	try {
    	    fruits[0] = ImageIO.read(new File("src/apples.png"));
    	} catch (IOException e) {
    	}
    	try {
    	    fruits[1] = ImageIO.read(new File("src/banans.png"));
    	} catch (IOException e) {
    	}
//������ ��������� �����        
    	BoomAudio=Applet.newAudioClip(myUrl);
//������������ ��������� �����    	
//    	BoomAudio.play();
//��������� ���� � ��������� ����� �����
    	URL appUrl = ClassLoader.getSystemResource("4.wav");
//������ ��������� �����        
    	appAudio=Applet.newAudioClip(appUrl);
//������������ ��������� �����    	
//      appAudio.play();
//��������� ���� � ��������� ����� �����
    	URL oxxxUrl = ClassLoader.getSystemResource("oxxx.wav");
//������ ��������� �����        
    	oxxxAudio=Applet.newAudioClip(oxxxUrl);
//������������ ��������� �����    	
//    	oxxxAudio.play();
    }
      
  //��������� ������� ������  
        @Override
        public void keyPressed(KeyEvent evt) {
  //��������� ������� ������� �� � ����	
            switch (evt.getKeyCode()) {
  //������� �� ������� ������� "����" 
                case KeyEvent.VK_DOWN:
  //������ �������, ��� �������
                	
                    break;  
  //������� �� ������� ������� "�����"        
                case KeyEvent.VK_UP:
  //������ �������, ��� �������
                	
                	break;
  //������� �� ������� ������� "�����"            	
                case KeyEvent.VK_LEFT:
  //������ �������, ��� �������              	
                	
                    break;
  //������� �� ������� ������� "������"                  
                case KeyEvent.VK_RIGHT:
  //������ �������, ��� �������              	
                	
                    break;
            }
  //������� �� ������� ������� �� �����          
            switch (evt.getKeyChar()) {
  //��� ������� �� ������� s ������ ����� ����                 
                case 's':
  //              	startGame();
                	break;
  //��� ������� �� ������� r ���������� ����              	
                case 'r': 
  //              	runGame();
                	break;
  //��� ������� �� ������� p-����� � ����              	
                case 'p': 
  //              	pauseGame();
                    break;
           }
        }
 //����������������� �������, ������� ������       
        public void keyTyped(KeyEvent ev){
        }
 //����������������� �������, ������� ��������       
        public void keyReleased(KeyEvent ev){
        }  
    
    	
    
    @Override
    public void paint(Graphics screen) {
 //�������� ������ ������ ��������
    	offscreenImg = createImage(windowSizeX, windowSizeY);
 //�������� ������� ������������ ����������   	
    	offscreen=offscreenImg.getGraphics();
 //�������� ����������
    	offscreen.clearRect(0,0,windowSizeX,windowSizeY);
 //����������� ������������ �����
 //���� ������� ���� (�����)   	
        Color backColor = new Color(255, 255, 255);
 //������� ���� ������� ����
    	offscreen.setColor(backColor);
 //��������� �� �� ����   	
        offscreen.fillRect(0, 0, windowSizeX, windowSizeY);
 //	---------------------------------------------------------------
        offscreen.drawImage(fruits[1], 500, 500,this);
 //������� ����� �����       
        Font fontC = new Font ("Times New Roman", 1, 14); 
 //���������� ���� ������
    	offscreen.setColor(Color.black); 
 //��������� ������������ �����
    	offscreen.setFont (fontC); 
 //���������� copyright    
    	offscreen.drawString ("Axill, ver. 1.01, Copyright (C) 2018 Maxim Mironov", 100, windowSizeY-50);
 //������� ���������� ������ �� �����
    	screen.drawImage(offscreenImg,0,0,this);
    }
 //������� ���������� ������   
    public void update(Graphics screen){
    	 paint(screen);
    	} 
    
    
    //��������� ���� -- �� ������������ � ����
    public void mouseDragged(MouseEvent e) {
   // messageX = e.getX();
   // messageY = e.getY();
   // repaint();
    }
    public void mouseMoved(MouseEvent e) { }
    public void actionPerformed( ActionEvent e) {
   // repaint();
    }
 //������� �������� ����   
    public void run() {
 //��������� �������������� ��������   
       try {   	
          while(true) {
 //������ ���� �� ���������       	  
 //          playGame(); 
 //�������� ���������� ������	
             repaint(); 
 //������� �������� �� delay ����������
             Thread.sleep(delay);
          }
       }
 //���������� �������������� ��������      
       catch (InterruptedException ie) { }
    }
 //���������� �������� �������   
    public static void main(String[] args)
    {
 //������ ������ Tennis
       new Axill();
    }
}