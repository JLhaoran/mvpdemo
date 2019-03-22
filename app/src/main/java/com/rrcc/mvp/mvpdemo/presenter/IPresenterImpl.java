package com.rrcc.mvp.mvpdemo.presenter;

import com.rrcc.mvp.mvpdemo.model.OrderListBean;
import com.rrcc.mvp.mvpdemo.model.OrdersModelImpl;
import com.rrcc.mvp.mvpdemo.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2019/3/22.
 */

public class IPresenterImpl implements IPresenter {
    private OrdersModelImpl mOrdersModelImpl = null;
    private ISearchView mSearchView = null;
    private List<OrderListBean.DataBean> mList = null;

    public IPresenterImpl(final OrdersModelImpl ordersModelImpl,final ISearchView searchView) {
        this.mOrdersModelImpl = ordersModelImpl;
        this.mSearchView = searchView;
        mList = new ArrayList<OrderListBean.DataBean>();
    }

    @Override
    public void doSearch() {
        mList = mOrdersModelImpl.getOrderList();
        mSearchView.showResult(mList);
    }

    @Override
    public void cancelSearch() {
        if(mList!=null)
            mList.clear();
        mSearchView.cancelShow(mList);
    }
}
