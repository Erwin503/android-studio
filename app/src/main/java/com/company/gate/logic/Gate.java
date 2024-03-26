package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
// статические публичные переменные состояний ворот
    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;
// закртыая переменная текущего состояния
    private int mSwing;
// геттер текущего состояния
    public int getSwingDirection() {
        return mSwing;
    }
// функция для установки ворот в нужное положение
    public boolean setSwing(int mSwing) {
        if (-1 <= mSwing && mSwing <= 1) {
            this.mSwing = mSwing;
            return true;
        } else {
            return false;
        }
    }
// функция открытия ворот
    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }
// функция закрытия ворот
    public void close() {
        setSwing(CLOSED);
    }
// подсчёт прошедших улиток
    public int thru(int count) {
        return (getSwingDirection() == OUT) ? -count : (getSwingDirection() == IN) ? count : 0;
    }
// переопределение метода ToString для корректного вывода 
    @Override
    public String toString() {
        if (getSwingDirection() == OUT){
            return "This gate is open and swings to exit the pen only";
        }else {
            if (getSwingDirection()== IN){
                return "This gate is open and swings to enter the pen only";
            }else {
                if (getSwingDirection() == CLOSED){
                    return "This gate is closed";
                }
                else {
                    return "This gate has an invalid swing direction";
                }
            }
        }
    }
}
