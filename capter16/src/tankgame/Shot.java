package tankgame;

/**
 * @author 王俊彪
 * @version 1.0
 * 射击子弹
 */
public class Shot implements Runnable {
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct = 0;//子弹方向
    int speed = 2;//子弹的速度
    boolean isLive = true;//子弹是否还存活

    //构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            //休眠50毫秒
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向来修改x，y坐标
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            //测试：这里输出x,y的坐标看一下
            //System.out.println(Thread.currentThread().getName()+"子弹 x=" + x + " y=" + y);
            //int threadCount = Thread.activeCount();
            //System.out.println("当前线程数量:"+threadCount);
            //当子弹移动到面板边界时，就应该销毁（把启动子弹的线程销毁）
            //当子弹碰到敌人坦克时，也应该销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                    isLive=false;
//                System.out.println(Thread.currentThread().getName()+"子弹线程退出 ");
               // System.out.println("当前线程数量:"+threadCount);
                    break;
            }
        }
    }
}
