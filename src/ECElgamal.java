import javafx.scene.layout.BorderPane;
import javafx.util.Pair;

import java.math.BigInteger;
import java.security.PrivateKey;

public class ECElgamal {
    private int k=14;
    private int s = 10;
    public Point P=new Point(BigInteger.valueOf(0),BigInteger.valueOf(14085));
    public Point B= Point.tich(P,s);

    public Pair<Point,Point> encrypt (Point m, int k){
        Point m1 = Point.tich(m,k);
        Point m2 = Point.sum(m1, Point.tich(B,k));
        Pair <Point, Point> en = new Pair<>(m1,m2);
        return en;
    }
    public Point decrypt(Pair<Point, Point> en){
        int t= Point.prime.subtract(BigInteger.valueOf(s).mod(Point.prime)).intValue();
        Point m= Point.sum(en.getValue(),Point.tich(en.getKey(),t));
        return m;
    }
    public static void main(String [] args){
        ECElgamal c= new ECElgamal();
        Point m= new Point(BigInteger.valueOf(0),BigInteger.valueOf(14085));
        Pair<Point,Point> en=c.encrypt(m,c.k);
        Point de = c.decrypt(en);
        System.out.println("encrypt:"+Point.point(en.getValue())+","+Point.point(en.getKey()));
        System.out.println("decrypt:"+Point.point(de));

    }
}
