import java.math.BigInteger;

public class MasseyOmura {
    public static Point encrypt (Point m, int ma, int mb ){
        Point m1 = Point.tich(m,ma);
        Point m2= Point.tich(m1,mb);
        return m2;
    }
    public static  Point decrypt(Point m, int ma, int mb){
        int n= Base.finddiem(Point.prime).size()+2;
        Point m3 = Point.tich(m,BigInteger.valueOf(ma).modInverse(BigInteger.valueOf(n)).intValue());
        Point m4= Point.tich(m3,BigInteger.valueOf(mb).modInverse(BigInteger.valueOf(n)).intValue());
        return m4;
    }
    public static void main(String [] args){
        Point m= new Point(BigInteger.valueOf(0),BigInteger.valueOf(14085));
        Point en =encrypt(m,25,41);
        System.out.println("encrypt: "+Point.point(en));
        Point de= decrypt(en,25,41);
        System.out.println("decrypt: "+Point.point(de));
    }
}

