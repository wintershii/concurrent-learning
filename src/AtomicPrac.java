import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicPrac {

    static volatile Integer num = 0;
    static AtomicStampedReference money = new AtomicStampedReference(num,1);

    public static void main(String[] args) {
        int oldStamp = money.getStamp();
        money.compareAndSet(0,1,oldStamp,oldStamp+1);
        System.out.println(money.getReference());
        money.compareAndSet(1,0,oldStamp+1,oldStamp+2);
        System.out.println(money.getReference());
        money.compareAndSet(0,2,oldStamp+2,oldStamp+3);
        System.out.println(money.getReference());
    }
}
