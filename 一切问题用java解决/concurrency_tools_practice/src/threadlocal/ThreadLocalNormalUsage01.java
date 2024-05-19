package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalNormalUsage01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String data = new ThreadLocalNormalUsage01().data(j);
                    System.out.println(data);
                }
            }).start();
            Thread.sleep(100);
        }
    }

    public String data(int seconds) {
        // 参数是毫秒，从1970-1-1 00:00:00开始计算，经过了多少毫秒，然后转换成现在的日期
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
