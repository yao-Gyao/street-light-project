package com.haohao.framwork.haoframwork.mvp.bean;

import java.util.List;

public class EnvBean {

    /**
     * code : 1
     * msg : 操作成功！
     * data : [{"data_id":328,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:08:11"},{"data_id":329,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:08:11"},{"data_id":330,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:08:11"},{"data_id":331,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:09:44"},{"data_id":332,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:09:45"},{"data_id":336,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:15:41"},{"data_id":337,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:15:42"},{"data_id":340,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:17:31"},{"data_id":341,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:17:32"},{"data_id":342,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:17:33"},{"data_id":347,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:21:05"},{"data_id":348,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:21:06"},{"data_id":349,"dev_id":32,"reg_id":18,"dev_num":"LED_10","dev_ip":"36.45.242.135","temp":"24","humd":"60","light":"706","current":"11.95","voltage":"5.42","create_time":"2023-05-04 17:21:06"}]
     * map : {}
     */

    private int code;
    private String msg;
    private MapBean map;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MapBean {
    }

    public static class DataBean {
        /**
         * data_id : 328
         * dev_id : 32
         * reg_id : 18
         * dev_num : LED_10
         * dev_ip : 36.45.242.135
         * temp : 24
         * humd : 60
         * light : 706
         * current : 11.95
         * voltage : 5.42
         * create_time : 2023-05-04 17:08:11
         */

        private int data_id;
        private int dev_id;
        private int reg_id;
        private String dev_num;
        private String dev_ip;
        private String temp;
        private String humd;
        private String light;
        private String current;
        private String voltage;
        private String create_time;

        public int getData_id() {
            return data_id;
        }

        public void setData_id(int data_id) {
            this.data_id = data_id;
        }

        public int getDev_id() {
            return dev_id;
        }

        public void setDev_id(int dev_id) {
            this.dev_id = dev_id;
        }

        public int getReg_id() {
            return reg_id;
        }

        public void setReg_id(int reg_id) {
            this.reg_id = reg_id;
        }

        public String getDev_num() {
            return dev_num;
        }

        public void setDev_num(String dev_num) {
            this.dev_num = dev_num;
        }

        public String getDev_ip() {
            return dev_ip;
        }

        public void setDev_ip(String dev_ip) {
            this.dev_ip = dev_ip;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getHumd() {
            return humd;
        }

        public void setHumd(String humd) {
            this.humd = humd;
        }

        public String getLight() {
            return light;
        }

        public void setLight(String light) {
            this.light = light;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public String getVoltage() {
            return voltage;
        }

        public void setVoltage(String voltage) {
            this.voltage = voltage;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
