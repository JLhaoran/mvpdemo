package com.rrcc.mvp.mvpdemo.view;

import com.rrcc.mvp.mvpdemo.model.OrderListBean;

import java.util.List;

/**
 * Created by mac on 2019/3/22.
 */

public interface ISearchView {
    void showResult(List<OrderListBean.DataBean> data);
    void cancelShow(List<OrderListBean.DataBean> data);
}
