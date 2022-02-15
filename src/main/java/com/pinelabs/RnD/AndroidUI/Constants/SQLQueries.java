package com.pinelabs.RnD.AndroidUI.Constants;

public class SQLQueries {

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

    public static final String sqlQuery1= "select Top 1 with ties * from" +Unit.VERTICAL+ "TRM_TRANSACTION_DATA_TBL where CLIENT_NUMBER = 294264 order by ROW_INSERTION_DATE_TIME desc";

}
