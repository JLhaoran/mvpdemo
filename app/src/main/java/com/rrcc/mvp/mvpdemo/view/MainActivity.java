package com.rrcc.mvp.mvpdemo.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.rrcc.mvp.mvpdemo.R;
import com.rrcc.mvp.mvpdemo.adapter.DailyPagerAdapter;
import com.rrcc.mvp.mvpdemo.model.OrderListBean;
import com.rrcc.mvp.mvpdemo.model.OrdersModelImpl;
import com.rrcc.mvp.mvpdemo.presenter.IPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ISearchView, View.OnClickListener{
    private RecyclerView mRecyclerView;
    private DailyPagerAdapter mDailyPagerAdapter = null;
    private List<OrderListBean.DataBean> mList = new ArrayList<OrderListBean.DataBean>();
    private Button mSearchBtn = null;
    private Button mCancelBtn = null;
    private IPresenterImpl mIPresenterImpl = null;
    private OrdersModelImpl mOrdersModelImpl = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOrdersModelImpl = new OrdersModelImpl();
        mIPresenterImpl = new IPresenterImpl(mOrdersModelImpl,this);
        initView();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                mIPresenterImpl.doSearch();
                break;
            case R.id.btn_search_cancel:
                mIPresenterImpl.cancelSearch();
                break;
        }


    }

    @Override
    public void showResult(List<OrderListBean.DataBean> datas) {
       if(null!=datas)
           setView(datas);
    }

    @Override
    public void cancelShow(List<OrderListBean.DataBean> datas) {
        if(null!=datas)
            setView(datas);
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.pager_shopping_recycler);
        mSearchBtn = findViewById(R.id.btn_search);
        mCancelBtn = findViewById(R.id.btn_search_cancel);

        mSearchBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void setView(List<OrderListBean.DataBean> mList){
        mDailyPagerAdapter = new DailyPagerAdapter(this,mList);
        mRecyclerView.setAdapter(mDailyPagerAdapter);
        mDailyPagerAdapter.notifyDataSetChanged();
    }
}
