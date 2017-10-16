package com.jason.dailyproject.daysign;

/**
 * 创建日期: 2017/10/16 on 下午6:09
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class DaySignImgBean {

    /**
     * imgUrl : http://oss.chuangworld.com/img/rq/1505810090577.jpg
     * showDate : 2017-09-20
     * detailsUrl : https://czs.chuangworld.com/rq/details_url?daysignDetailsId=6c70fd7f6b5949d98a3cf0ec62c5c564
     */

    private String imgUrl;
    private String showDate;
    private String detailsUrl;

    public DaySignImgBean(String imgUrl, String showDate, String detailsUrl) {
        this.imgUrl = imgUrl;
        this.showDate = showDate;
        this.detailsUrl = detailsUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

}
