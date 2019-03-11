package com.cezarydanilowski;

public class BinarySearchingNumber {
    private int looked;
    private int shot;
    private int rangeMax;
    private int p;
    private int q;
    private static int howManyShots = 1;

    public BinarySearchingNumber(int max, int looked, int shot) {
        this.rangeMax = max;
        this.looked = looked;
        this.shot = shot;
    }

    public void automaticSolving() {
        if (shot > this.looked) {
            p = 0;
            q = shot;
        } else {
            p = shot;
            q = rangeMax;
        }

        while (!this.isCorrect()) {
            if (shot > this.looked) {
                q = shot;
                shot = p + (q - p) / 2;
            } else {
                p = shot;
                shot = p + (q - p) / 2;
            }

            BinarySearchingNumber binary = new BinarySearchingNumber(rangeMax, looked, shot);
            this.check();
            System.out.print(shot + "\n");
        }
    }

    public void check() {
        if (shot >= 0 && shot <= rangeMax && shot < looked) {
            System.out.print("It's too small! (" + howManyShots + " attempt) ");
            howManyShots += 1;
        } else if (shot >= 0 && shot <= rangeMax && shot > looked) {
            System.out.print("It's too high! (" + howManyShots + " attempt) ");
            howManyShots += 1;
        } else if (shot == looked) {
            System.out.print("You hitted perfectly in " + howManyShots + " attempt! Looked was ");
            howManyShots = 1;
        } else {
            System.out.print("Out of range! ");
        }
    }

    public boolean isCorrect() {
        if (shot == looked) {
            return true;
        } else {
            return false;
        }
    }
}