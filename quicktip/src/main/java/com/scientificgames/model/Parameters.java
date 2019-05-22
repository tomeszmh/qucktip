package com.scientificgames.model;

public class Parameters {
    private int maxNumber;
    private int lotteryNumbersCount;
    private int panelCount;

    public Parameters() {

    }

    public Parameters(int maxNumber, int lotteryNumbersCount, int panelCount) {
        this.maxNumber = maxNumber;
        this.lotteryNumbersCount = lotteryNumbersCount;
        this.panelCount = panelCount;
    }

    public int getPanelCount() {
        return panelCount;
    }

    public Parameters setPanelCount(int panelCount) {
        this.panelCount = panelCount;
        return this;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public Parameters setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        return this;
    }

    public int getLotteryNumbersCount() {
        return lotteryNumbersCount;
    }

    public Parameters setLotteryNumbersCount(int lotteryNumbersCount) {
        this.lotteryNumbersCount = lotteryNumbersCount;
        return this;
    }
}
