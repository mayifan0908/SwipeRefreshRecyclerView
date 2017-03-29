package com.yf.fengmai.swiperefreshrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yf.fengmai.swiperefreshrecyclerview.beans.BaseBean;
import com.yf.fengmai.swiperefreshrecyclerview.beans.ContentBean;
import com.yf.fengmai.swiperefreshrecyclerview.beans.NoDataBean;
import com.yf.fengmai.swiperefreshrecyclerview.cards.BaseCard;
import com.yf.fengmai.swiperefreshrecyclerview.cards.ContentCard;
import com.yf.fengmai.swiperefreshrecyclerview.cards.NoDataCard;
import com.yf.fengmai.swiperefreshrecyclerview.recyclerview.BaseViewHolder;

import java.util.ArrayList;

public class ContentListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context mContext;
    private ArrayList<BaseBean> mContentList = null;

    public ContentListAdapter(Context context, ArrayList<BaseBean> contentList) {
        mContext     = context;
        mContentList = contentList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        BaseViewHolder baseViewHolder = null;

        if (ContentCard.class.getCanonicalName().hashCode() == viewType) {
            view = new ContentCard(mContext);
        }
        else if (NoDataCard.class.getCanonicalName().hashCode() == viewType) {
            view = new NoDataCard(mContext);
        }

        if (null != view) {
            baseViewHolder = new BaseViewHolder(view);
        }

        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if ((null != holder.itemView)
         && (null != mContentList)
         && (mContentList.size() > position)) {
            mContentList.get(position).setItemNum(position);

            ((BaseCard)holder.itemView).bindData(mContentList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = -1;

        if ((0 <= position)
         && (null != mContentList)
         && (mContentList.size() > position)
         && (null != mContentList.get(position))) {
            if (mContentList.get(position) instanceof ContentBean) {
                viewType = ContentCard.class.getCanonicalName().hashCode();
            }
            else if (mContentList.get(position) instanceof NoDataBean) {
                viewType = NoDataCard.class.getCanonicalName().hashCode();
            }
        }

        return viewType;
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }
}
