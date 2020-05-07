package club.banyuan;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
  // TODO
  // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
  // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
  // 3. 用户猜拳界面，输入0，返回到上一级，重新开始选择参与人数
  // 4. 用户进入到猜拳界面，提示当前的人数的信息，例如"当前游戏3人猜拳"，每次猜拳下一轮开始时，显示本轮剩余玩家数量，
  public static void main(String[] args) {
    int playerCount = 0;
    while (true) {
      System.out.println("用户输入多少人参与猜拳（2~5人）,输入0退出程序");
      Player.willBackToMenu = false;
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      scanner.nextLine();
      switch (n) {
        case 0:
          System.out.println("猜拳结束");
          System.exit(0);
        case 2:
        case 3:
        case 4:
        case 5: {
          playerCount = n;
          Player[] players = Player.initPlayers(playerCount);

          while (true) {
            if (Player.willBackToMenu){
              break;
            }
            System.out.println("当前游戏"+playerCount+"位玩家猜拳");
            Rules.showFingers(players);
            String rlt = Rules.competeResult(players);

            if (Rules.isDraw(rlt)) {
//              System.out.println("平局！");
              continue;
            } else {
              Rules.outPlayer(players, rlt);
            }
            if (Rules.isFinalWinner(players)) {
              break;
            }
          }
          if (Player.willBackToMenu){
            continue;                //如果输入0则返回上一级
          }
          else {
            Rules.printWinner(players);
            System.exit(0);
          }
        }
        default:
          System.out.println("请输入2～5之间的整数！");

      }
    }
  }

}
