package com.nure.model.comparator;

import com.nure.model.MobilePhone;

import java.util.Comparator;

public class BatteryCapacityComparator implements Comparator<MobilePhone> {


    @Override
    public int compare(MobilePhone mobilePhone1, MobilePhone mobilePhone2) {
        if (mobilePhone1.getBatteryCapacity() == mobilePhone2.getBatteryCapacity())
            return 0;
        return (mobilePhone1.getBatteryCapacity() > mobilePhone2.getBatteryCapacity()) ? 1 : -1;
    }
}
