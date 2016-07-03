package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

/**
 * 通用的指示器标题，子元素内容由外部提供，事件回传给外部
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/7/3.
 */
public class CommonPagerTitleView extends FrameLayout implements IPagerTitleView {
    private OnPagerTitleChangeListener mOnPagerTitleChangeListener;

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    public OnPagerTitleChangeListener getOnPagerTitleChangeListener() {
        return mOnPagerTitleChangeListener;
    }

    public void setOnPagerTitleChangeListener(OnPagerTitleChangeListener onPagerTitleChangeListener) {
        mOnPagerTitleChangeListener = onPagerTitleChangeListener;
    }

    @Override
    public void onSelected(int index) {
        if (mOnPagerTitleChangeListener != null) {
            mOnPagerTitleChangeListener.onSelected(index);
        }
    }

    @Override
    public void onDeselected(int index) {
        if (mOnPagerTitleChangeListener != null) {
            mOnPagerTitleChangeListener.onDeselected(index);
        }
    }

    @Override
    public void onLeave(int index, float leavePercent, boolean leftToRight) {
        if (mOnPagerTitleChangeListener != null) {
            mOnPagerTitleChangeListener.onLeave(index, leavePercent, leftToRight);
        }
    }

    @Override
    public void onEnter(int index, float enterPercent, boolean leftToRight) {
        if (mOnPagerTitleChangeListener != null) {
            mOnPagerTitleChangeListener.onEnter(index, enterPercent, leftToRight);
        }
    }

    /**
     * 外部直接将布局设置进来
     *
     * @param contentView
     */
    public void setContentView(View contentView) {
        setContentView(contentView, null);
    }

    public void setContentView(View contentView, FrameLayout.LayoutParams lp) {
        removeAllViews();
        if (contentView != null) {
            if (lp == null) {
                lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
            addView(contentView, lp);
        }
    }

    public void setContentView(int layoutId) {
        View child = LayoutInflater.from(getContext()).inflate(layoutId, null);
        setContentView(child, null);
    }

    public interface OnPagerTitleChangeListener {
        void onSelected(int index);

        void onDeselected(int index);

        void onLeave(int index, float leavePercent, boolean leftToRight);

        void onEnter(int index, float enterPercent, boolean leftToRight);
    }
}