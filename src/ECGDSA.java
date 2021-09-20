import javafx.util.Pair;

import java.math.BigInteger;

public class ECGDSA {
    BigInteger n = BigInteger.valueOf(Base.finddiem(Point.prime).size() + 1);
    Point M = new Point(BigInteger.valueOf(5), BigInteger.valueOf(8451));
    int d = 19;
    int kE = 5;
    Point Q = Point.tich(M, BigInteger.valueOf(d).modInverse(n).intValue());
    Point Kg = Point.tich(M, kE);

    public Pair<BigInteger, BigInteger> sig() {
        BigInteger r = Kg.x;
        BigInteger hash = M.x;
//        BigInteger s = (kE*r-hash)*dmodn;
        BigInteger s=(r.multiply(BigInteger.valueOf(kE)).subtract(hash)).
                multiply(BigInteger.valueOf(d)).mod(n);
        Pair<BigInteger, BigInteger> rs = new Pair<>(r, s);
        return rs;
    }
    public boolean ver(Pair<BigInteger, BigInteger> rs) {
        BigInteger s = rs.getValue();
        BigInteger r = rs.getKey();
        BigInteger w = r.modInverse(n);
        BigInteger hash = M.x;
        BigInteger u1 = hash.multiply(w).mod(n);
        BigInteger u2 = s.multiply(w).mod(n);
        Point kq = Point.sum(Point.tich(M, u1.intValue()), Point.tich(Q, u2.intValue()));
        if (kq.x.compareTo(Kg.x) == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        ECGDSA ph = new ECGDSA();
        Pair<BigInteger, BigInteger> signature = ph.sig();
        System.out.println("chu ki: " + signature.getKey() + ";" + signature.getValue());
        System.out.println(ph.ver(signature));
    }
}
