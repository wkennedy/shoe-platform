package com.github.wkennedy.shoeservice.models;

public enum TrueToSize {
    ONE(1, "Really Small"),
    TWO(2, "Small"),
    THREE(3, "True to Size"),
    FOUR(4, "Big"),
    FIVE(5, "Really Big");

    public static final String REALLY_SMALL = "These shoes run really small";
    public static final String SMALL = "These shoes run a bit small on the small size";
    public static final String TRUE_TO_SIZE = "These shoes run true to size";
    public static final String BIG = "These shoes run a bit on the large size";
    public static final String REALLY_BIG = "These shoes run really large";

    private int value;
    private String description;

    TrueToSize(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static TrueToSize getFromValue(int trueToSizeValue) {
        for (TrueToSize trueToSize : TrueToSize.values()) {
            if(trueToSize.value == trueToSizeValue) {
                return trueToSize;
            }
        };
        return null;
    }

    public static String getDescriptionForRange(double trueToSize) {
        if(trueToSize >= 1 && trueToSize < 1.5) {
            return REALLY_SMALL;
        }
        if(trueToSize >= 1.5 && trueToSize < 2.5) {
            return SMALL;
        }
        if(trueToSize >= 2.5 && trueToSize < 3.5) {
            return TRUE_TO_SIZE;
        }
        if(trueToSize >= 3.5 && trueToSize < 4.5) {
            return BIG;
        }
        if(trueToSize >= 4.5 && trueToSize <= 5) {
            return REALLY_BIG;
        }

        return "True to size value is not within the acceptable range";
    }


}
