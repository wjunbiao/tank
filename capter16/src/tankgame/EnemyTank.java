package tankgame;

import java.util.Vector;

/**
 * @author 王俊彪
 * @version 1.0
 * 敌人的坦克
 */
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    //增加成员 在EnemyTank 中可以得到敌人坦克的 Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //这里提供一个方法，可以将MyPanel 的成员Vector<EnemyTank> enemyTaks = new Vector<>();
    //设置到 EnemyTank 的成员 enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前的这个敌人坦克，是否和 enemyTanks 中的其他坦克发生的重叠或者碰撞
    public boolean isTouchEnemyTank() {
        //判断当前敌人坦克（this）方向
        switch (this.getDirect()) {
            case 0://上
                //当前敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector 中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        //如果敌人坦克是上/下
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+40]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克 左上角的坐标[this.getX(),this.getY()]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克 右上角的坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克 左上角的坐标[this.getX(),this.getY()]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克 右上角的坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                //当前敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector 中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        //如果敌人坦克是上/下
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+40]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克 右上角的坐标[this.getX()+60,this.getY()]
                            if (this.getX()+60 > enemyTank.getX()
                                    && this.getX()+60 < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克 右下角的坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 > enemyTank.getX()
                                    && this.getX() + 60 < enemyTank.getX() + 40
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克 右上角的坐标[this.getX()+60,this.getY()]
                            if (this.getX()+60 > enemyTank.getX()
                                    && this.getX()+60 < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克 右下角的坐标[this.getX()+60,this.getY()+40]
                            if (this.getX()+60 > enemyTank.getX()
                                    && this.getX()+60 < enemyTank.getX() + 60
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                //当前敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector 中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        //如果敌人坦克是上/下
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+40]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克 左下角的坐标[this.getX(),this.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY()+60 > enemyTank.getY()
                                    && this.getY()+60 < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克 右下角的坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 40
                                    && this.getY()+60> enemyTank.getY()
                                    && this.getY()+60 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克 左下角的坐标[this.getX(),this.getY()+60]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY()+60 > enemyTank.getY()
                                    && this.getY()+60 < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克 右下角的坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 > enemyTank.getX()
                                    && this.getX() + 40 < enemyTank.getX() + 60
                                    && this.getY()+60 > enemyTank.getY()
                                    && this.getY()+60 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                //当前敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector 中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (this != enemyTank) {
                        //如果敌人坦克是上/下
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+40]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //当前坦克 左上角的坐标[this.getX(),this.getY()]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 60) {
                                return true;
                            }
                            //当前坦克 左下角的坐标[this.getX(),this.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 40
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40 < enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人坦克是右/左
                        //敌人坦克上/下 x 的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //            y 的范围 [enemyTank.getY(),enemyTank.getY()+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //当前坦克 左上角的坐标[this.getX(),this.getY()]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY() > enemyTank.getY()
                                    && this.getY() < enemyTank.getY() + 40) {
                                return true;
                            }
                            //当前坦克 左下角的坐标[this.getX(),this.getY()+40]
                            if (this.getX() > enemyTank.getX()
                                    && this.getX() < enemyTank.getX() + 60
                                    && this.getY()+40 > enemyTank.getY()
                                    && this.getY()+40 < enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {
            //这里我们判断如果shots size()=0,创建一颗子弹，放入到
            //shots集合，并启动
            if (isLive && shots.size() < 2) {/*isLive&&shots.size()==0 敌人坦克打一颗子弹*/
                Shot s = null;
                //判断坦克的方向，创建对应的子弹
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://向上
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 1000 && !isTouchEnemyTank()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750  && !isTouchEnemyTank()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && !isTouchEnemyTank()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //然后随机的改变坦克方向0-3
            setDirect((int) (Math.random() * 4));
            //重要注意：写并发程序，一定要考虑清楚，该线程什么时候结束
            if (!isLive) {
                break;//退出线程
            }
        }
    }
}
