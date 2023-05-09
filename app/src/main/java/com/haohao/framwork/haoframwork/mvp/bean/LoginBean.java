package com.haohao.framwork.haoframwork.mvp.bean;

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
 * @date 2023/5/9
 * @description
 */

public class LoginBean {

    /**
     * code : null
     * msg : null
     * data : null
     * map : {"userInfo":{"uid":35,"login_number":"18292251814","login_password":"","user_power":true,"user_name":"管理员一号","sex":true,"age":33,"email":"2341231@qq.com","address":"西安科技大学","create_time":"2023-05-03 23:54:42","update_time":"2023-05-05 15:32:43"},"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjM1LCJzdWIiOiJsaWdodF9tYW5hZ2VyIiwiZXhwIjoxNjgzNjkzMjIzLCJ1c2VyTnVtYmVyIjoiMTgyOTIyNTE4MTQiLCJ1c2VyUG93ZXIiOiJ0cnVlIiwianRpIjoiMDZiMGM4MjQtYTQyZS00ODhlLTgyZTAtZmQyOWU4NzAwYTgwIn0.j3GfToGv90lmFktM6XPFmo0GpYiwPOm04owyBVrCtGI"}
     */

    private Object code;
    private String msg;
    private Object data;
    private MapBean map;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
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
         * userInfo : {"uid":35,"login_number":"18292251814","login_password":"","user_power":true,"user_name":"管理员一号","sex":true,"age":33,"email":"2341231@qq.com","address":"西安科技大学","create_time":"2023-05-03 23:54:42","update_time":"2023-05-05 15:32:43"}
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjM1LCJzdWIiOiJsaWdodF9tYW5hZ2VyIiwiZXhwIjoxNjgzNjkzMjIzLCJ1c2VyTnVtYmVyIjoiMTgyOTIyNTE4MTQiLCJ1c2VyUG93ZXIiOiJ0cnVlIiwianRpIjoiMDZiMGM4MjQtYTQyZS00ODhlLTgyZTAtZmQyOWU4NzAwYTgwIn0.j3GfToGv90lmFktM6XPFmo0GpYiwPOm04owyBVrCtGI
         */

        private UserInfoBean userInfo;
        private String token;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserInfoBean {
            /**
             * uid : 35
             * login_number : 18292251814
             * login_password :
             * user_power : true
             * user_name : 管理员一号
             * sex : true
             * age : 33
             * email : 2341231@qq.com
             * address : 西安科技大学
             * create_time : 2023-05-03 23:54:42
             * update_time : 2023-05-05 15:32:43
             */

            private int uid;
            private String login_number;
            private String login_password;
            private boolean user_power;
            private String user_name;
            private boolean sex;
            private int age;
            private String email;
            private String address;
            private String create_time;
            private String update_time;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getLogin_number() {
                return login_number;
            }

            public void setLogin_number(String login_number) {
                this.login_number = login_number;
            }

            public String getLogin_password() {
                return login_password;
            }

            public void setLogin_password(String login_password) {
                this.login_password = login_password;
            }

            public boolean isUser_power() {
                return user_power;
            }

            public void setUser_power(boolean user_power) {
                this.user_power = user_power;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public boolean isSex() {
                return sex;
            }

            public void setSex(boolean sex) {
                this.sex = sex;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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
