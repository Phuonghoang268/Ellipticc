
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Point {
    public static BigInteger prime=BigInteger.valueOf(35677);
    public static BigInteger ax=BigInteger.valueOf(22705);
    public static BigInteger b0=BigInteger.valueOf(58782);
//    public static BigInteger prime=BigInteger.probablePrime(16,new Random());
//    public static BigInteger ax=new BigInteger(16,new Random());
//    public static BigInteger b0=new BigInteger(16,new Random());
    public BigInteger x;
    public BigInteger y;
    Point(BigInteger x, BigInteger y){
        this.x=x;
        this.y=y;
    }
    public boolean compare(Point b){
        if(this.x==b.x&& this.y==b.y) return true;
        else return false;
    }
    public static BigInteger lamda(Point a, Point b)throws ArithmeticException{
        BigInteger lam = null;
        if(a.compare(b)){
            BigInteger tuso=(BigInteger.valueOf(3).multiply(a.x.pow(2)).add(ax));
            BigInteger mauso=(a.y.multiply(BigInteger.valueOf(2)));
            lam=tuso.multiply(mauso.modInverse(prime)).mod(prime);
        }
        else {
            BigInteger tuso=(b.y.subtract(a.y)).mod(prime);
            BigInteger mauso=(b.x.subtract(a.x)).mod(prime);
            lam=tuso.multiply(mauso.modInverse(prime)).mod(prime);
        }
        return lam;
    }
    public static Point sum(Point a, Point b){
        Point kq=new Point(BigInteger.valueOf(5),BigInteger.valueOf(1));
        BigInteger lam=lamda(a,b);
        kq.x=(lam.pow(2).subtract(a.x).subtract(b.x)).mod(prime);
        kq.y=(lam.multiply(a.x.subtract(kq.x))).subtract(a.y).mod(prime);
        return kq;
    }
    public static Point tich(Point a, int k){
        if(k==1) return a;
        if(k==2) return sum(a,a);
        else if (k%2==0) return tich(tich(a,k/2),2);
        else return sum(a,tich(tich(a,k/2),2));
    }

    public static  String point(Point a){
        return "("+a.x+", "+a.y+")";
    }
    public static void main(String [] args){

//        Base.finddiem(prime);
        System.out.println(prime);
        System.out.println(ax);
        System.out.println(b0);
        ArrayList<Point> points=Base.finddiem(prime);
        int diem=points.size()+1;
        System.out.println("so diem:" +diem);
//        for (Point a:points  ) {
//            System.out.println(point(a));
//        }
        Point m= new Point(BigInteger.valueOf(0),BigInteger.valueOf(14085));
        for(int i=1;i<35393;i++){
            System.out.println(point(tich(m,i)));
        }
    }
}
