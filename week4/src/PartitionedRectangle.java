/*
Cut a (w x h) rectangle in half, and find the number of 1x1 squares that are not cut - Summber/Winter Coding(2019)
*/

// answer is correct, but execution time is long for large inputs (w, h)

public class PartitionedRectangle {
    public static void main(String[] args){
        int w = 8, h = 12;
        System.out.println(solution(w, h));
    }

    static long solution(int w, int h) {
        long broken = 0; // number of broken squares in (w/gcd)x(h/gcd) rectangle
        long gcd = gcd(w, h);

        // let the rectangle lie on x, y axis - the most left, lowest point is (0, 0)
        for(int i = 0; i < w / gcd; i++){
            for(int j = 0; j < h / gcd; j++){
                if(squareCrossed(i, j, (double)h / w)) broken++;
            }
        }

        return (long)w * (long)h - broken * gcd;
    }

    // does the line y = ax cross the 1x1 square that has its most left, lowest point on (i, j)?
    static boolean squareCrossed(int i, int j, double a){
        if((a * i < j + 1) && (a * (i + 1) > j)) return true;
        else return false;
    }

    static int gcd(int x, int y){
        int currentGCD = 1, divisor = 2;
        while(divisor <= Math.min(x, y)){
            if(x % divisor == 0 && y % divisor == 0){
                x /= divisor;
                y /= divisor;
                currentGCD *= divisor;
            } else {
                divisor++;
            }
        }

        return currentGCD;
    }
}
