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

    public void setPanelCount(int panelCount) {
        this.panelCount = panelCount;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getLotteryNumbersCount() {
        return lotteryNumbersCount;
    }

    public void setLotteryNumbersCount(int lotteryNumbersCount) {
        this.lotteryNumbersCount = lotteryNumbersCount;
    }
}
