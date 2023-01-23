package com.arpu.shofha.msisdnvalidation.StaticData;

import com.arpu.shofha.msisdnvalidation.dto.CountryResponse;
import com.arpu.shofha.msisdnvalidation.dto.HasPrefix;
import com.arpu.shofha.msisdnvalidation.dto.OperatorResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class  CountriesData {
/*    private Map countries()
    {
        Map<String,String[][] >countries=new HashMap<>();
        countries.put("EG", new String[][]{{"Egypt", "20"},{"60201","60202","60203","60204"}});
        countries.put("KW",new String[][]{{"Kuwait","965"},{"41903","41904","41902"}});
        countries.put("TN",new String[][]{{"Tunisia","216"},{"60501","60503","60502"}});
        countries.put("SA",new String[][]{{"Saudi Arabia","966"},{"42003","42004","42001"}});
        countries.put("IQ",new String[][]{{"Iraq","964"},{"41830","41805","41840"}});
        countries.put("AE",new String[][]{{"United Arab Emirates","971"},{"42402","42403"}});
        countries.put("DZ",new String[][]{{"Algeria","213"},{"60303"}});
        countries.put("SD",new String[][]{{"Sudan","249"},{"63401","63407"}});
        countries.put("QA",new String[][]{{"Qatar","974"},{"42702","42701"}});
        countries.put("OM",new String[][]{{"Oman","968"},{"42202","42203"}});
        countries.put("MA",new String[][]{{"Morocco","212"},{"63907"}});
        countries.put("LY",new String[][]{{"Libya","218"},{"60600"}});
        countries.put("BH",new String[][]{{"Bahrain","973"},{"42604","42602","42601"}});
        countries.put("SI",new String[][]{{"Syria","963"},{}});
        countries.put("JO",new String[][]{{"Jordan","962"},{"41603","41677","41601"}});
        countries.put("LB",new String[][]{{"Lebanon","961"},{}});
        return countries;
    }

    public CountryResponse getCountry(String countryCode){
        Map map=countries();
        CountryResponse countryResponse=new CountryResponse();
        String country[][]= (String[][]) map.get(countryCode);
        //System.out.println("country "+country[0]+" "+country[1]);
        countryResponse.setCountry(country[0][0]);
       // System.out.println("test ");
        countryResponse.setCountryCode(country[0][1]);
        countryResponse.setOperatorCode(Arrays.asList(country[1]));
        return countryResponse;
    }*/
    private static Map OperatorsData()
    {
        //Egypt start

        Map<String,String[] >operatorData=new HashMap<>();
        operatorData.put("2012", new String[]{"Egypt", "20","60201","Orange","012xxxxxxxx"});
        operatorData.put("2010", new String[]{"Egypt", "20","60202","Vodafone","010xxxxxxxx"});
        operatorData.put("2011", new String[]{"Egypt", "20","60203","Etisalat","011xxxxxxxx"});
        operatorData.put("2015", new String[]{"Egypt", "20","60204","WE","015xxxxxxxx"});

        operatorData.put("20012", new String[]{"Egypt", "20","60201","Orange","012xxxxxxxx"});
        operatorData.put("20010", new String[]{"Egypt", "20","60202","Vodafone","010xxxxxxxx"});
        operatorData.put("20011", new String[]{"Egypt", "20","60203","Etisalat","011xxxxxxxx"});
        operatorData.put("20015", new String[]{"Egypt", "20","60204","WE","015xxxxxxxx"});
        //Egypt end

        //Tunisia start

        operatorData.put("2165",new String[]{"Tunisia","216","60501","Orange","216xxxxxxxx"});
        operatorData.put("2162",new String[]{"Tunisia","216","60503","Ooredoo","216xxxxxxxx"});
        operatorData.put("2169",new String[]{"Tunisia","216","60502","Tunisia Telecom","216xxxxxxxx"});

        //Tunisia end

        //Iraq start

        operatorData.put("96479",new String[]{"Iraq","964","41830","Zain","964xxxxxxxxxx"});
        operatorData.put("96478",new String[]{"Iraq","964","41830","Zain","964xxxxxxxxxx"});

        operatorData.put("96477",new String[]{"Iraq","964","41805","Asiacell","964xxxxxxxxxx"});
        operatorData.put("96475",new String[]{"Iraq","964","41840","Korek","964xxxxxxxxxx"});

        //Iraq end

        //Kuwait start

        operatorData.put("9656",new String[]{"Kuwait","965","41903","Ooredoo","965xxxxxxxx"});
        operatorData.put("9655",new String[]{"Kuwait","965","41904","STC","965xxxxxxxx"});
        operatorData.put("9659",new String[]{"Kuwait","965","41902","Zain","965xxxxxxxx"});

        //Kuwait end

        //Saudi Arabia START

        operatorData.put("96654",new String[]{"Saudi Arabia","966","42003","Mobily","966xxxxxxxxx"});
        operatorData.put("96656",new String[]{"Saudi Arabia","966","42003","Mobily","966xxxxxxxxx"});

        operatorData.put("96658",new String[]{"Saudi Arabia","966","42004","Zain","966xxxxxxxxx"});
        operatorData.put("96659",new String[]{"Saudi Arabia","966","42004","Zain","966xxxxxxxxx"});

        operatorData.put("96650",new String[]{"Saudi Arabia","966","42001","STC","966xxxxxxxxx"});
        operatorData.put("96653",new String[]{"Saudi Arabia","966","42001","STC","966xxxxxxxxx"});
        operatorData.put("96655",new String[]{"Saudi Arabia","966","42001","STC","966xxxxxxxxx"});

        operatorData.put("96657",new String[]{"Saudi Arabia","966","42005","Virgin Mobile","966xxxxxxxxx"});

        //Saudi Arabia end

        //Qatar start

        operatorData.put("97470",new String[]{"Qatar","974","42702","Vodafone","974xxxxxxxx"});
        operatorData.put("97430",new String[]{"Qatar","974","42702","Vodafone","974xxxxxxxx"});
        operatorData.put("97477",new String[]{"Qatar","974","42702","Vodafone","974xxxxxxxx"});
        operatorData.put("97431",new String[]{"Qatar","974","42702","Vodafone","974xxxxxxxx"});

        operatorData.put("97450",new String[]{"Qatar","974","42701","Ooredoo","974xxxxxxxx"});
        operatorData.put("97455",new String[]{"Qatar","974","42701","Ooredoo","974xxxxxxxx"});
        operatorData.put("97433",new String[]{"Qatar","974","42701","Ooredoo","974xxxxxxxx"});
        operatorData.put("97466",new String[]{"Qatar","974","42701","Ooredoo","974xxxxxxxx"});

        //Qatar end

        //Sudan start

        operatorData.put("24991",new String[]{"Sudan","249","63401","Zain","249xxxxxxxxx"});
        operatorData.put("24990",new String[]{"Sudan","249","63401","Zain","249xxxxxxxxx"});
        operatorData.put("24996",new String[]{"Sudan","249","63401","Zain","249xxxxxxxxx"});

        operatorData.put("24910",new String[]{"Sudan","249","63407","Sudani","249xxxxxxxxx"});
        operatorData.put("24911",new String[]{"Sudan","249","63407","Sudani","249xxxxxxxxx"});
        operatorData.put("24912",new String[]{"Sudan","249","63407","Sudani","249xxxxxxxxx"});

        //Sudan end

        //United Arab Emirates start

        operatorData.put("97150",new String[]{"United Arab Emirates","971","42402","Etisalat","971xxxxxxxxx"});
        operatorData.put("97154",new String[]{"United Arab Emirates","971","42402","Etisalat","971xxxxxxxxx"});
        operatorData.put("97156",new String[]{"United Arab Emirates","971","42402","Etisalat","971xxxxxxxxx"});

        operatorData.put("97152",new String[]{"United Arab Emirates","971","42403","Etisalat","971xxxxxxxxx"});
        operatorData.put("97155",new String[]{"United Arab Emirates","971","42403","Etisalat","971xxxxxxxxx"});
        operatorData.put("97158",new String[]{"United Arab Emirates","971","42403","Etisalat","971xxxxxxxxx"});

        //United Arab Emirates end

        //Oman start

        operatorData.put("96891",new String[]{"Oman","968","42202","Omantel","968xxxxxxxx"});
        operatorData.put("96892",new String[]{"Oman","968","42202","Omantel","968xxxxxxxx"});
        operatorData.put("96895",new String[]{"Oman","968","42202","Omantel","968xxxxxxxx"});
        operatorData.put("96899",new String[]{"Oman","968","42202","Omantel","968xxxxxxxx"});

        operatorData.put("96894",new String[]{"Oman","968","42203","Ooredoo","968xxxxxxxx"});
        operatorData.put("96895",new String[]{"Oman","968","42203","Ooredoo","968xxxxxxxx"});
        operatorData.put("96896",new String[]{"Oman","968","42203","Ooredoo","968xxxxxxxx"});
        operatorData.put("96897",new String[]{"Oman","968","42203","Ooredoo","968xxxxxxxx"});

        //Oman end

        //Algeria start
        operatorData.put("21354",new String[]{"Algeria","213","60303","Ooredoo","213xxxxxxxxx"});
        operatorData.put("21355",new String[]{"Algeria","213","60303","Ooredoo","213xxxxxxxxx"});
        operatorData.put("21356",new String[]{"Algeria","213","60303","Ooredoo","213xxxxxxxxx"});

        //Algeria end

        //Morocco start
        operatorData.put("254",new String[]{"Morocco","212","63907","Telkom","212xxxxxxxxx"});
        //Morocco end

        //Libya start

        operatorData.put("218",new String[]{"Libya","218","60600","Libyana","218xxxxxxxxx"});

        //Libya end

        //Bahrain start
        operatorData.put("9733",new String[]{"Bahrain","973","42601","Batelco","973xxxxxxxx"});
        operatorData.put("973",new String[]{"Bahrain","973","42602","Zain","973xxxxxxxx"});
        // countries.put("973",new String[]{"Bahrain","973","42602","Batelco"});
        //Bahrain end

        //Jordan start

        operatorData.put("96277",new String[]{"Jordan","962","41677","Orange","962xxxxxxxxx"});
        operatorData.put("96278",new String[]{"Jordan","962","41603","Umniah","962xxxxxxxxx"});
        operatorData.put("96279",new String[]{"Jordan","962","41601","Zain","962xxxxxxxxx"});

        //Jordan end
        return operatorData;
    }
    public  String convertToEnglishDigits(String value) {
        String newValue = value;
        try {
            newValue = value.replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5")
                    .replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9").replace("٠", "0")
                    .replace("۱", "1").replace("۲", "2").replace("۳", "3").replace("۴", "4").replace("۵", "5")
                    .replace("۶", "6").replace("۷", "7").replace("۸", "8").replace("۹", "9").replace("۰", "0");
        } catch (Exception e) {

        }
        return newValue;
    }
    public OperatorResponse operatorData(List<String> prefix){
        Map map=OperatorsData();
        OperatorResponse operatorResponse=new OperatorResponse();
        String[] opData = null;
        for(String s:prefix){
            opData= (String[]) map.get(s);
            if(opData!=null)break;
        }
        if(opData!=null){
            operatorResponse.setCountry(opData[0]);
            operatorResponse.setCountryCode(opData[1]);
            operatorResponse.setOperatorCode(opData[2]);
            operatorResponse.setOperatorName(opData[3]);
            operatorResponse.setMsisdnPattern(opData[4]);
        }
        return operatorResponse;
    }
    //has prefix
    public HasPrefix hasPrefixForCountry(String countryName,String msisdn){
        Map data=countryId();
        String[]countryData= (String[]) data.get(countryName);
        HasPrefix hasPrefix=new HasPrefix();
        if(!msisdn.startsWith(countryData[1])&&msisdn.startsWith("01")){
            msisdn=countryData[1]+msisdn;
        }
        if(!msisdn.startsWith(countryData[1])&&msisdn.length()!=countryData[2].length()-countryData[1].length()){
            hasPrefix.setHasPrefix(false);
            hasPrefix.setMsisdnPattern(countryData[3]);
            hasPrefix.setCountryCode(countryData[1]);
            hasPrefix.setCountryId(countryData[0]);
            hasPrefix.setMsisdnLen(Integer.parseInt(String.valueOf(countryData[2])));
            hasPrefix.setMsisdn(msisdn);
        }
        if(!msisdn.startsWith(countryData[1])&&msisdn.length()==countryData[2].length()-countryData[1].length()){
            msisdn=countryData[1]+msisdn;
            hasPrefix.setHasPrefix(true);
            hasPrefix.setMsisdnPattern(countryData[3]);
            hasPrefix.setCountryCode(countryData[1]);
            hasPrefix.setCountryId(countryData[0]);
            hasPrefix.setMsisdnLen(Integer.parseInt(String.valueOf(countryData[2])));
            hasPrefix.setMsisdn(msisdn);
        }else{
           // msisdn=countryData[1]+msisdn;
            hasPrefix.setHasPrefix(true);
            hasPrefix.setMsisdnPattern(countryData[3]);
            hasPrefix.setCountryCode(countryData[1]);
            hasPrefix.setCountryId(countryData[0]);
            hasPrefix.setMsisdnLen(Integer.parseInt(String.valueOf(countryData[2])));
            hasPrefix.setMsisdn(msisdn);
        }
        return hasPrefix;
    }
    private static Map countryId(){
        Map<String,String[]>countries=new HashMap<>();
        countries.put("Egypt",new String[]{"EG","20","12","01xxxxxxxxx"});
        countries.put("Kuwait",new String[]{"KW","965","11","965xxxxxxxx"});
        countries.put("Tunisia",new String[]{"TN","216","11","216xxxxxxxx"});
        countries.put("Saudi Arabia",new String[]{"SA","966","12","966xxxxxxxxx"});
        countries.put("Iraq",new String[]{"IQ","964","13","964xxxxxxxxxx"});
        countries.put("United Arab Emirates",new String[]{"AE","971","12","971xxxxxxxxx"});
        countries.put("Algeria",new String[]{"DZ","213","12","213xxxxxxxxx"});
        countries.put("Sudan",new String[]{"SD","249","12","249xxxxxxxxx"});
        countries.put("Qatar",new String[]{"QA","974","11","974xxxxxxxx"});
        countries.put("Oman",new String[]{"OM","968","11","968xxxxxxxx"});
        countries.put("Morocco",new String[]{"MA","212","12","212xxxxxxxxx"});
        countries.put("Libya",new String[]{"LY","218","",""});
        countries.put("Bahrain",new String[]{"BH","973","11","973xxxxxxxx"});
        countries.put("Syria",new String[]{"SI","963","",""});
        countries.put("Jordan",new String[]{"JO","962","12","962xxxxxxxxx"});
        countries.put("Lebanon",new String[]{"LB","961","",""});
        return countries;
    }
  /*  public Map countryIdByCountryName(){
        Map<String,String>countries=new HashMap<>();
        countries.put("Egypt","EG");
        countries.put("Kuwait","KW");
        countries.put("Tunisia","TN");
        countries.put("Saudi Arabia","SA");
        countries.put("IQ","Iraq");
        countries.put("United Arab Emirates","AE");
        countries.put("Algeria","DZ");
        countries.put("Sudan","SD");
        countries.put("Qatar","QA");
        countries.put("Oman","OM");
        countries.put("Morocco","MA");
        countries.put("Libya","LY");
        countries.put("Bahrain","BH");
        countries.put("Syria","SI");
        countries.put("Jordan","JO");
        countries.put("Lebanon","LB");
        return countries;
    }*/
}
