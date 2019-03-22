package com.rrcc.mvp.mvpdemo.model;

import java.util.List;

/**
 * Created by mac on 2019/3/20.
 */

public interface OrderListListenter {
    public void onSuccess(List<OrderListBean.DataBean> datas);
    public void onError();
}
