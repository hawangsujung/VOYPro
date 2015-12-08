package com.example.t.voypro;

public class AimDetailedListData {
    private String mText1;
    private String mText2;
    private String mText3;
    private String successDate;
    public AimDetailedListData(String mText1, String mText2, String mText3, String successDate) {
        this.mText1 = mText1;
        this.mText2 = mText2;
        this.mText3 = mText3;
        this.successDate = successDate;
    }

    public String getStartDate()    {return mText1;}
    public String getContent()      {return mText2;}
    public String getSuccess()      {return mText3;}
    public String getSuccessDate () {return successDate;}
}