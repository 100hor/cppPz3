package com.nure.model.comparator;

import com.nure.model.MobilePhone;

import java.util.Comparator;

public class ScreenDiagonalComparator implements Comparator<MobilePhone> {


    @Override
    public int compare(MobilePhone mobilePhone1, MobilePhone mobilePhone2) {
        if (mobilePhone1.getScreenDiagonal() == mobilePhone2.getScreenDiagonal())
            return 0;
        return (mobilePhone1.getScreenDiagonal() > mobilePhone2.getScreenDiagonal()) ? 1 : -1;
    }
}
