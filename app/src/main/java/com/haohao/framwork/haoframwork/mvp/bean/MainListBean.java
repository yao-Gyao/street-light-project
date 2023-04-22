package com.haohao.framwork.haoframwork.mvp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date
 * @description
 */

public class MainListBean extends BaseBean {


    /**
     * msg : 200:
     * data : [{"data_id":94,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:36"},{"data_id":93,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:35"},{"data_id":92,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:35"},{"data_id":91,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:25"},{"data_id":90,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:25"},{"data_id":89,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:24"},{"data_id":88,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:24"},{"data_id":87,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:25:24"},{"data_id":86,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:24:06"},{"data_id":85,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:24:05"},{"data_id":84,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:24:05"},{"data_id":83,"dev_ip":"/113.138.204.20","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-21 18:23:58"},{"data_id":82,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:29:33"},{"data_id":81,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:29:26"},{"data_id":80,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:29:07"},{"data_id":79,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:28:36"},{"data_id":78,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:28:36"},{"data_id":77,"dev_ip":"/36.45.225.80","location":"109.194145,34.366802","temp":"21","rh":"51","lx":"240","vol":"11.92","cur":"12.2","time":"2023-04-17 20:28:34"}]
     * state : 1
     */

    private String msg;
    private int state;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * data_id : 94
         * dev_ip : /113.138.204.20
         * location : 109.194145,34.366802
         * temp : 21
         * rh : 51
         * lx : 240
         * vol : 11.92
         * cur : 12.2
         * time : 2023-04-21 18:25:36
         */

        private int data_id;
        private String dev_ip;
        private String location;
        private String temp;
        private String rh;
        private String lx;
        private String vol;
        private String cur;
        private String time;

        public int getData_id() {
            return data_id;
        }

        public void setData_id(int data_id) {
            this.data_id = data_id;
        }

        public String getDev_ip() {
            return dev_ip;
        }

        public void setDev_ip(String dev_ip) {
            this.dev_ip = dev_ip;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getRh() {
            return rh;
        }

        public void setRh(String rh) {
            this.rh = rh;
        }

        public String getLx() {
            return lx;
        }

        public void setLx(String lx) {
            this.lx = lx;
        }

        public String getVol() {
            return vol;
        }

        public void setVol(String vol) {
            this.vol = vol;
        }

        public String getCur() {
            return cur;
        }

        public void setCur(String cur) {
            this.cur = cur;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}

