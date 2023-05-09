package com.haohao.framwork.haoframwork.mvp.presenter;

import com.haohao.framwork.haoframwork.mvp.bean.LoginBean;
import com.haohao.framwork.haoframwork.mvp.manager.DataManager;
import com.haohao.framwork.haoframwork.mvp.view.LoginView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

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

public class LoginPresenter extends BasePresenter {

    private LoginView expressView;
    private DataManager dataManager;

    public LoginPresenter(LoginView expressView, LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        this.expressView = expressView;
        dataManager = DataManager.getInstance();
    }


    public void getLogin(Map<String,Object> map) {
        expressView.showProgressDialog();

        Observable<LoginBean> expressInfo = dataManager.getLogin(map);
        expressInfo.subscribeOn(Schedulers.io()) // 在子线程中进行Http访问
                .observeOn(AndroidSchedulers.mainThread()) // UI线程处理返回接口
                .compose(getProvider().<LoginBean>bindUntilEvent(ActivityEvent.DESTROY)) // onDestroy取消订阅
                .subscribe(new DefaultObserver<LoginBean>() {  // 订阅
                    @Override
                    public void onNext(@NonNull LoginBean mainListBean) {
                        expressView.updateView(mainListBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        expressView.showError(e.getMessage());
                        expressView.hideProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        expressView.hideProgressDialog();
                    }
                });
    }
}
