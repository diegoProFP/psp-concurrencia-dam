package delayQueruExample;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedElement implements Delayed {
    public String data;
    private long expiryTime;

    public DelayedElement(String data, long delay) {
        this.data = data;
        this.expiryTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.expiryTime, ((DelayedElement) other).expiryTime);
    }
}

