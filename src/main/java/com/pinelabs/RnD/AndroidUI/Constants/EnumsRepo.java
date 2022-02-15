package com.pinelabs.RnD.AndroidUI.Constants;

public class EnumsRepo {

    public enum methodName {
        POST,
        GET,
        PUT,
        DELETE,
        PATCH
    }

    public enum Unit {
        HORIZONTAL("HORIZONTAL"),
        VERTICAL("VERTICAL");
        private String unit;

        Unit(String unit) {
            this.unit = unit;
        }
        String getValues(){
            return unit;
        }



    }
}
