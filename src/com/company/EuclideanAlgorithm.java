package com.company;

public class EuclideanAlgorithm {
    int a, b, c, xa, ya, xb, yb, x, y;
    int astart, bstart;

    public EuclideanAlgorithm(int a, int b) {
        this.astart = a;
        this.bstart = b;
        this.a = a;
        this.b = b;
        this.c = 0;
        this.xa = 1;
        this.ya = 0;
        this.xb = 0;
        this.yb = 1;
    }

    public int licz() {
        while (!(a * b == 0)) {
            if (a >= b) {
                c = a / b;
                a = a % b;
                xa = xa - xb * c;
                ya = ya - yb * c;
            } else {
                c = b / a;
                b = b%a;
                xb = xb - xa * c;
                yb = yb - ya * c;
            }
        }
        if(a > 0) {
            x = xa;
            y = ya;
        }else if (b > 0) {
            x = xb;
            y = yb;
        }

        if(x > 0) {
            return x;
        } else {
            return bstart + x;
        }
    }
}
