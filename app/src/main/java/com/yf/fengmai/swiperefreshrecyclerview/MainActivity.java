package com.yf.fengmai.swiperefreshrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yf.fengmai.swiperefreshrecyclerview.beans.CategoryBean;
import com.yf.fengmai.swiperefreshrecyclerview.fragments.ContentListFragment;
import com.yf.fengmai.swiperefreshrecyclerview.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {
    private ContentListFragment mContentListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        CategoryBean categoryBean = new CategoryBean();

        categoryBean.setCategoryId(1);
        categoryBean.setCategoryName("分类");
        categoryBean.setSubclassCount(5);

        mContentListFragment = ContentListFragment.newInstance(categoryBean);
        FragmentUtils.addFragmentToActivity(getSupportFragmentManager(),
                                            mContentListFragment,
                                            R.id.fl_fragment_container);

    }
}
