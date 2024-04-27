package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 王俊彪
 * @version 1.0
 */
public class TankGame01 extends JFrame {
    //定义 MyPanel
    private MyPanel mp = null;
    public static void main(String[] args) {
       // MyPanel myPanel = new MyPanel();

        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入选择1、新游戏 2、继续上局");
        String key = scanner.next();
        mp=new MyPanel(key);
        //将mp 放入Thread 并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//面板（就是游戏的绘图区域）
        this.setSize(1300,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setVisible(true);
        //在JFrame 中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {//WindowAdapter 适配器
            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("监听到了");
                Recorder.keepRecord();
            }
        });
    }
}
