import java.util.Random;

/**
 * 生成消息
 */
public class MessageGenerator extends Thread {
    
    private CellularPhone phone;

    public MessageGenerator(String name, CellularPhone aPhone) {
        super(name);
        phone = aPhone;
    }

    public void run() {
        int counter = 0;
        Random randomGenerator = new Random();
        while ( counter++ < 20 ) {
            try {
                phone.addMessage(getName() + " " + counter);
                int length = randomGenerator.nextInt( 3 );
                sleep( length * 1000 );
            } catch( InterruptedException ie) {
                System.err.println("消息生成器中断");
            }
        }
    }

 
}