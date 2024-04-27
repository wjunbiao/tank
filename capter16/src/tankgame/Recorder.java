package tankgame;

import java.io.*;
import java.util.Vector;

/**
 * @author 王俊彪
 * @version 1.0
 * 该类用于记录相关信息的，和文件交互
 */
public class Recorder {
    //记录变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum=0;

    //定义IO对象，准备写数据到文件中

    private static BufferedWriter bw = null;
    private static BufferedReader br= null;
    private static String recordFile="src\\myRecord.txt";
    //定义Vector ,指向 Mypanel 对象的 敌人坦克Vector
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node 的Vector ,用于保存敌人的信息node
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    //返回记录文件的目录
    public static String getRecordFile() {
        return recordFile;
    }

    //增加一个方法，用于读取recordFile,恢复相关信息
    //该方法在调用上局游戏的时候启动即可
    public static Vector<Node>getNodesAndEnemyTankRec(){
        try {
            br= new BufferedReader(new FileReader(recordFile));
            String count =br.readLine();
            if(count !=null) {
                allEnemyTankNum = Integer.parseInt(count);
            }
            String line="";
            while((line=br.readLine())!=null){
                String [] syd = line.split(" ");
                Node node = new Node(Integer.parseInt(syd[0]),
                        Integer.parseInt(syd[1]),
                        Integer.parseInt(syd[2]));
                nodes.add(node);//放入node Vector
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }
    //增加一个方法，当游戏退出时，我们将allEnemyTankNum 保存到 recordFile
    public static void keepRecord(){
        try {
            bw=new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum+"\r\n");
            //遍历敌人坦克的Vector ，然后根据情况保存即可。
            //OOP，定义一个属性，然后通过setXxx得到 敌人坦克的Vector
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){
                    //保存该enemyTank信息
                    String record = enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                    //写入到文件
                    bw.write(record+"\r\n");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;
    }
}
