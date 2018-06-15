/**
 * Axill , Java Application Template

 */

/**
 * @author MAXIM
 *
 */
//подключение необходимых библиотек 
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

//декларация основного класса и подключение клавиатуры 
public class Axill extends JFrame implements KeyListener, MouseMotionListener, ActionListener, Runnable
{
//размеры окна
	int windowSizeX=1200;
	int windowSizeY=800;
//задержка в мили секундах
	int delay=30;
//временное содержимое экрана
	Graphics offscreen;
	Image offscreenImg;
	Image[] fruits = new Image[2];
//	ImageObserver observer;
//аудиоклип звуков 
	public AudioClip BoomAudio;
	public AudioClip appAudio;
	public AudioClip oxxxAudio;

	private static final long serialVersionUID = 1L;
//декларация основного метода    
	public Axill() 
    {
//декларируем переменную окна	
		JFrame f = this;
//установка способа раскладки 
		f.setLayout( new FlowLayout() );
//установка выхода при закрытии окна		
    	f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//запуск начальной функции     
    	init();    	
//установка размеров окна    	
    	f.setSize(windowSizeX , windowSizeY);   	
//добавление обработчика клавиатуры    	
    	f.addKeyListener(this);
//установка фокуса        
    	f.setFocusable(true);    
//сделать окно видимым        
    	f.setVisible( true );   	
//декларация цепочки событий        
    	Thread t = new Thread( this );
//запуск цепочки    
    	t.start();
    }
 
//декларация начальной функции	
    public void init() {
//получить размер экрана    	
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        windowSizeX = gd.getDisplayMode().getWidth();
    	windowSizeY = gd.getDisplayMode().getHeight();
    	fruits[0] = null;
    	fruits[1] = null;
    	//получение пути к звуковому файлу удара
    	URL myUrl = ClassLoader.getSystemResource("boom.wav");
    	try {
    	    fruits[0] = ImageIO.read(new File("src/apples.png"));
    	} catch (IOException e) {
    	}
    	try {
    	    fruits[1] = ImageIO.read(new File("src/banans.png"));
    	} catch (IOException e) {
    	}
//чтение звукового файла        
    	BoomAudio=Applet.newAudioClip(myUrl);
//проигрывание звукового файла    	
//    	BoomAudio.play();
//получение пути к звуковому файлу удара
    	URL appUrl = ClassLoader.getSystemResource("4.wav");
//чтение звукового файла        
    	appAudio=Applet.newAudioClip(appUrl);
//проигрывание звукового файла    	
//      appAudio.play();
//получение пути к звуковому файлу удара
    	URL oxxxUrl = ClassLoader.getSystemResource("oxxx.wav");
//чтение звукового файла        
    	oxxxAudio=Applet.newAudioClip(oxxxUrl);
//проигрывание звукового файла    	
//    	oxxxAudio.play();
    }
      
  //обработка нажатий клавиш  
        @Override
        public void keyPressed(KeyEvent evt) {
  //обработка нажатия клавиши по её коду	
            switch (evt.getKeyCode()) {
  //реакция на нажатие клавиши "вниз" 
                case KeyEvent.VK_DOWN:
  //задать функцию, что сделать
                	
                    break;  
  //реакция на нажатие клавиши "вверх"        
                case KeyEvent.VK_UP:
  //задать функцию, что сделать
                	
                	break;
  //реакция на нажатие клавиши "влево"            	
                case KeyEvent.VK_LEFT:
  //задать функцию, что сделать              	
                	
                    break;
  //реакция на нажатие клавиши "вправо"                  
                case KeyEvent.VK_RIGHT:
  //задать функцию, что сделать              	
                	
                    break;
            }
  //реакция на нажатие клавиши по букве          
            switch (evt.getKeyChar()) {
  //при нажатии на клавишу s начать новую игру                 
                case 's':
  //              	startGame();
                	break;
  //при нажатии на клавишу r продолжить игру              	
                case 'r': 
  //              	runGame();
                	break;
  //при нажатии на клавишу p-пауза в игре              	
                case 'p': 
  //              	pauseGame();
                    break;
           }
        }
 //зарезервированная функция, клавиша нажата       
        public void keyTyped(KeyEvent ev){
        }
 //зарезервированная функция, клавиша отпущена       
        public void keyReleased(KeyEvent ev){
        }  
    
    	
    
    @Override
    public void paint(Graphics screen) {
 //создания буфера против мерцания
    	offscreenImg = createImage(windowSizeX, windowSizeY);
 //получить контент графического устройства   	
    	offscreen=offscreenImg.getGraphics();
 //очистить содержимое
    	offscreen.clearRect(0,0,windowSizeX,windowSizeY);
 //декларируем используемые цвета
 //цвет заднего фона (белый)   	
        Color backColor = new Color(255, 255, 255);
 //выбрать цвет заднего фона
    	offscreen.setColor(backColor);
 //заполнить им всё окно   	
        offscreen.fillRect(0, 0, windowSizeX, windowSizeY);
 //	---------------------------------------------------------------
        offscreen.drawImage(fruits[1], 500, 500,this);
 //выбрать новый шрифт       
        Font fontC = new Font ("Times New Roman", 1, 14); 
 //установить цвет шрифта
    	offscreen.setColor(Color.black); 
 //установит используемый шрифт
    	offscreen.setFont (fontC); 
 //отобразить copyright    
    	offscreen.drawString ("Axill, ver. 1.01, Copyright (C) 2018 Maxim Mironov", 100, windowSizeY-50);
 //вывести содержимое буфера на экран
    	screen.drawImage(offscreenImg,0,0,this);
    }
 //функция обновления экрана   
    public void update(Graphics screen){
    	 paint(screen);
    	} 
    
    
    //обработка мыши -- не используется в игре
    public void mouseDragged(MouseEvent e) {
   // messageX = e.getX();
   // messageY = e.getY();
   // repaint();
    }
    public void mouseMoved(MouseEvent e) { }
    public void actionPerformed( ActionEvent e) {
   // repaint();
    }
 //функция движения игры   
    public void run() {
 //обработка исключительных ситуаций   
       try {   	
          while(true) {
 //играть пока всё нормально       	  
 //          playGame(); 
 //обновить содержимое экрана	
             repaint(); 
 //сделать задержку на delay милисекунд
             Thread.sleep(delay);
          }
       }
 //обработать исключительную ситуацию      
       catch (InterruptedException ie) { }
    }
 //декларация основной функции   
    public static void main(String[] args)
    {
 //запуск метода Tennis
       new Axill();
    }
}