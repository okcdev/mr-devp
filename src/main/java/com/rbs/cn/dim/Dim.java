package com.rbs.cn.dim;

/**
 * Created by fengtao.xue on 2018/1/13.
 */
public class Dim {
    //130	1300000	山东	济南	联通	250000	0531	370100	中国联通 GSM
    private Boolean is_validate = true;
    private String pre_3_num; //前三位
    private String pre_7_num; //前七位
    private String province; //归属省
    private String city; //归属城市
    private String isp; //运营商
    private String post_code; //邮政编码
    private String city_code; //城市区号
    private String area_code; //地区编号
    private String card_types; //运营商类型

    /**
     *
     * @param line
     * @return
     */
    public static Dim parsePhoneRecord(String line){
        String[] dimStr = line.split("\t");
        Dim dim = new Dim();
        if(dimStr.length >= 9){
            dim.setIs_validate(true);
            dim.setPre_3_num(dimStr[0]);
            dim.setPre_7_num(dimStr[1]);
            dim.setProvince(dimStr[2]);
            dim.setCity(dimStr[3]);
            dim.setIsp(dimStr[4]);
            dim.setPost_code(dimStr[5]);
            dim.setCity_code(dimStr[6]);
            dim.setArea_code(dimStr[7]);
            dim.setCard_types(dimStr[8]);
        }
        return dim;
    }

    @Override
    public String toString() {
        return "Dim{" +
                "is_validate=" + is_validate +
                ", pre_3_num='" + pre_3_num + '\'' +
                ", pre_7_num='" + pre_7_num + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", isp='" + isp + '\'' +
                ", post_code='" + post_code + '\'' +
                ", city_code='" + city_code + '\'' +
                ", area_code='" + area_code + '\'' +
                ", card_types='" + card_types + '\'' +
                '}';
    }

    public static void main(String[] args){
        String line = "130\t1300000\t山东\t济南\t联通\t250000\t0531\t370100\t中国联通 GSM";
        Dim dim = Dim.parsePhoneRecord(line);
        System.out.println(dim.toString());
    }

    public Boolean getIs_validate() {
        return is_validate;
    }

    public void setIs_validate(Boolean is_validate) {
        this.is_validate = is_validate;
    }

    public String getPre_3_num() {
        return pre_3_num;
    }

    public void setPre_3_num(String pre_3_num) {
        this.pre_3_num = pre_3_num;
    }

    public String getPre_7_num() {
        return pre_7_num;
    }

    public void setPre_7_num(String pre_7_num) {
        this.pre_7_num = pre_7_num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getCard_types() {
        return card_types;
    }

    public void setCard_types(String card_types) {
        this.card_types = card_types;
    }
}
