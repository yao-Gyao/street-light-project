package com.haohao.framwork.haoframwork.mvp.net;


import com.haohao.framwork.haoframwork.mvp.bean.EnvBean;
import com.haohao.framwork.haoframwork.mvp.bean.LoginBean;
import com.haohao.framwork.haoframwork.mvp.bean.MainListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

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
 * @date 2017/10/30
 * @description
 */

public interface RetrofitService {

    /**
     * 获取快递信息-键值对方式
     * Rx方式
     * @return Observable<MainListBean>
     */
    @GET(Constant.UrlOrigin.get_list)
    Observable<MainListBean> getList();

    @GET(Constant.UrlOrigin.get_env)
    Observable<EnvBean> getEnvList(@QueryMap Map<String,Object> map);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept:application/json"})
    @POST(Constant.UrlOrigin.get_login)
    Observable<LoginBean> getLogin(@FieldMap Map<String,Object> map);
}
