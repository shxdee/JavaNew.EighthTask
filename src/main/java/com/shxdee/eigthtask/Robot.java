package com.shxdee.eigthtask;

import java.util.Objects;

public class Robot implements Executable {
    private int modelNumber;

    public Robot(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void execute() {
        System.out.println("No one expects the Spanish execution!");
    }
}
