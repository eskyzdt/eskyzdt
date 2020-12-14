package cn.eskyzdt.modules.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueTest {

    public static void main(String[] args) {
      ConcurrentLinkedQueue<String> followQueue = new ConcurrentLinkedQueue<>();
      followQueue.add("21");
      followQueue.add("22");
      followQueue.add("23");
      followQueue.add("22");
      followQueue.add("25");
      followQueue.forEach(System.out::println);
        System.out.println("打印结束");
      followQueue.clear();
      if (followQueue.isEmpty()) {
          System.out.println("followQueue为空");
      }

    }
}
