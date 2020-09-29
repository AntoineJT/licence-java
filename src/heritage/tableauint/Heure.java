package heritage.tableauint;

import java.util.Random;

@SuppressWarnings("unused")
public class Heure implements Comparable<Heure>
{
    private int heures, minutes;

    public Heure(int heures, int minutes)
    {
        this.heures = intAbs(heures) % 24;
        this.minutes = intAbs(minutes) % 60;
    }

    public Heure(Random r)
    {
        this(r.nextInt(), r.nextInt());
    }

    private int intAbs(int x)
    {
        return (x > 0) ? x : -x;
    }

    public int getHeures()
    {
        return heures;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public void setHeures(int heures)
    {
        this.heures = heures;
    }

    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }

    @Override
    public String toString()
    {
        return heures + ":" + minutes;
    }

    public int enMinutes()
    {
        return 60 * heures + minutes;
    }

    // old java method, don't use it, it's bad
    /*
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Heure)) {
            throw new IllegalArgumentException("Not comparable");
        }
        Heure other = (Heure) o;
        int h = heures - other.heures;
        int m = minutes - other.minutes;
        return (h != 0) ? h : m;
    }
    */

    @Override
    public int compareTo(Heure other) {
        int h = heures - other.heures;
        int m = minutes - other.minutes;
        return (h != 0) ? h : m;
    }
}
