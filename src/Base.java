import java.math.BigInteger;
import java.util.ArrayList;

public class Base {
    public static ArrayList<Point> finddiem(BigInteger prime) {
        int p = prime.intValue();
        ArrayList<Point> diemm = new ArrayList<Point>();
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if ((j * j) % p == (Math.pow(i, 3) + Point.ax.intValue() * i + Point.b0.intValue()) % p) {
                    Point d = new Point(BigInteger.valueOf(i), BigInteger.valueOf(j));
                    diemm.add(d);
                    Point d2 = new Point(BigInteger.valueOf(i), BigInteger.valueOf(p - j));
                    diemm.add(d2);
                    break;
                }
            }
        }

        return diemm;

    }
}

