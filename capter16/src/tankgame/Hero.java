package tankgame;

import java.util.Vector;

/**
 * @author 王俊彪
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank{
    public Hero(int x, int y) {
        super(x, y);
    }
    //定义一个shot对象，表示 一个射击(线程)
    Shot shot = null;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();

    public void shotEnemyTank(){
        if(shots.size()==5){
            return;
        }
        //创建 Shot 对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirect()){//得到Hero对象方向
            case 0://向上
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1://向右
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2://向下
                shot = new Shot(getX()+20,getY()+60,2);
;                break;
            case 3://向左
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        //把新创建的shot 放入shots中
        shots.add(shot);
        //启动我们的shot线程
        new Thread(shot).start();
    }

}
