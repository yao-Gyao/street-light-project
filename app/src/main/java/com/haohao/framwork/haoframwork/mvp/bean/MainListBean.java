package com.haohao.framwork.haoframwork.mvp.bean;

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
     * code : null
     * msg : null
     * data : null
     * map : {"count":3,"list":[{"dev_id":30,"dev_num":"LED_001","dev_ip":"36.45.242.135","location":"34.234234234,45.23423424","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":0,"light_switch":true,"set_state":2,"light_time":"0","beep_state":false,"light_pwm":900,"create_time":"2023-05-04 15:57:08","update_time":"2023-05-04 16:25:13"},{"dev_id":28,"dev_num":"LED_2","dev_ip":"-36.45.242.135","location":"2222,2222","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":3,"light_switch":false,"set_state":1,"light_time":"0","beep_state":false,"light_pwm":655,"create_time":"2023-05-04 00:01:46","update_time":"2023-05-04 15:28:56"},{"dev_id":27,"dev_num":"LED_1","dev_ip":"-36.45.242.135","location":"11111111,11111111","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":3,"light_switch":false,"set_state":1,"light_time":"0","beep_state":false,"light_pwm":655,"create_time":"2023-05-03 23:55:08","update_time":"2023-05-04 15:57:50"}]}
     */

    private Object code;
    private Object msg;
    private Object data;
    private MapBean map;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public static class MapBean {
        /**
         * count : 3
         * list : [{"dev_id":30,"dev_num":"LED_001","dev_ip":"36.45.242.135","location":"34.234234234,45.23423424","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":0,"light_switch":true,"set_state":2,"light_time":"0","beep_state":false,"light_pwm":900,"create_time":"2023-05-04 15:57:08","update_time":"2023-05-04 16:25:13"},{"dev_id":28,"dev_num":"LED_2","dev_ip":"-36.45.242.135","location":"2222,2222","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":3,"light_switch":false,"set_state":1,"light_time":"0","beep_state":false,"light_pwm":655,"create_time":"2023-05-04 00:01:46","update_time":"2023-05-04 15:28:56"},{"dev_id":27,"dev_num":"LED_1","dev_ip":"-36.45.242.135","location":"11111111,11111111","reg_id":18,"admin_id":35,"serve_id":35,"net_state":true,"run_state":3,"light_switch":false,"set_state":1,"light_time":"0","beep_state":false,"light_pwm":655,"create_time":"2023-05-03 23:55:08","update_time":"2023-05-04 15:57:50"}]
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * dev_id : 30
             * dev_num : LED_001
             * dev_ip : 36.45.242.135
             * location : 34.234234234,45.23423424
             * reg_id : 18
             * admin_id : 35
             * serve_id : 35
             * net_state : true
             * run_state : 0
             * light_switch : true
             * set_state : 2
             * light_time : 0
             * beep_state : false
             * light_pwm : 900
             * create_time : 2023-05-04 15:57:08
             * update_time : 2023-05-04 16:25:13
             */

            private int dev_id;
            private String dev_num;
            private String dev_ip;
            private String location;
            private int reg_id;
            private int admin_id;
            private int serve_id;
            private boolean net_state;
            private int run_state;
            private boolean light_switch;
            private int set_state;
            private String light_time;
            private boolean beep_state;
            private int light_pwm;
            private String create_time;
            private String update_time;

            public int getDev_id() {
                return dev_id;
            }

            public void setDev_id(int dev_id) {
                this.dev_id = dev_id;
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

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getReg_id() {
                return reg_id;
            }

            public void setReg_id(int reg_id) {
                this.reg_id = reg_id;
            }

            public int getAdmin_id() {
                return admin_id;
            }

            public void setAdmin_id(int admin_id) {
                this.admin_id = admin_id;
            }

            public int getServe_id() {
                return serve_id;
            }

            public void setServe_id(int serve_id) {
                this.serve_id = serve_id;
            }

            public boolean isNet_state() {
                return net_state;
            }

            public void setNet_state(boolean net_state) {
                this.net_state = net_state;
            }

            public int getRun_state() {
                return run_state;
            }

            public void setRun_state(int run_state) {
                this.run_state = run_state;
            }

            public boolean isLight_switch() {
                return light_switch;
            }

            public void setLight_switch(boolean light_switch) {
                this.light_switch = light_switch;
            }

            public int getSet_state() {
                return set_state;
            }

            public void setSet_state(int set_state) {
                this.set_state = set_state;
            }

            public String getLight_time() {
                return light_time;
            }

            public void setLight_time(String light_time) {
                this.light_time = light_time;
            }

            public boolean isBeep_state() {
                return beep_state;
            }

            public void setBeep_state(boolean beep_state) {
                this.beep_state = beep_state;
            }

            public int getLight_pwm() {
                return light_pwm;
            }

            public void setLight_pwm(int light_pwm) {
                this.light_pwm = light_pwm;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }
        }
    }
}

