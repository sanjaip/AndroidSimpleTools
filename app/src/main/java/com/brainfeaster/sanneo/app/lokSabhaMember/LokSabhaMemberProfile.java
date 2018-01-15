package com.brainfeaster.sanneo.app.lokSabhaMember;

/**
 * Created by sanja on 8/29/2017.
 */

public final class LokSabhaMemberProfile {
    public String MemberId;
    public String Name;
    public String Party;
    public String Constituencies;
    public String State;
    public String Paddress;
    public String Permanentphone;
    public String Localaddress;
    public String Localphone;
    public String EmailID;

    public LokSabhaMemberProfile()
    {

    }
    public LokSabhaMemberProfile(String MemberId, String Name, String Party,
                                 String Constituencies, String State, String Paddress,
                                 String Permanentphone, String Localaddress,
                                 String Localphone, String EmailID)
    {
        this.MemberId = MemberId;this.Name = Name;this.Party =Party;
        this.Constituencies=Constituencies;this.State=State; this.Paddress=Paddress;
        this.Permanentphone=Permanentphone; this.Localaddress=Localaddress;
        this.Localphone=Localphone; this.EmailID=EmailID;
    }
    
    public void RSMProperty(String key, String value)
    {
        switch (key)
        {
            case "MemberId": this.MemberId = value; break;
            case "Name": this.Name = value;  break;
            case "Party": this.Party =value; break;
            case "Constituencies": this.Constituencies=value; break;
            case "State": this.State=value; break;
            case "Paddress": this.Paddress=value; break;
            case "Permanentphone": this.Permanentphone=value; break;
            case "Localaddress": this.Localaddress=value; break;
            case "Localphone": this.Localphone=value;  break;
            case "EmailID":this.EmailID=value;break;
        }
    }
}
