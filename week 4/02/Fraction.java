/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Fraction {

    public int topN;
    public int btmN;

    public String toFraction() {
        return topN + "/" + btmN;
    }

    public String toFloat() {
        float result = (float) this.topN / this.btmN;
        return Float.toString(result);
    }

    public void addFraction(Fraction f) {
        if (this.btmN == f.btmN) {
            this.topN = this.topN + f.topN;
        } else {
            this.topN = (this.topN * f.btmN) + (f.topN * this.btmN);
            this.btmN = this.btmN * f.btmN;
        }
    }

    public boolean myEquals(Fraction x) {
        float result1 = (float) this.topN / this.btmN;
        float result2 = (float) x.topN / x.btmN;
        return result1 == result2;
    }

    public void LowestTermFrac() {
        int gcd = 1;
        for (int i = 1; i <= topN && i <= btmN; i++) {
            if (topN % i == 0 && btmN % i == 0) {
                gcd = i;
            }
        }

        topN /= gcd;
        btmN /= gcd;
    }
}
