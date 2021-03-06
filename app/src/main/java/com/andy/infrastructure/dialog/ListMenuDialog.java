package com.andy.infrastructure.dialog;

import android.support.v7.widget.LinearLayoutManager;

import com.andy.baselibrary.dialog.DataBindBaseDialog;
import com.andy.baselibrary.utils.CommonUtils;
import com.andy.infrastructure.R;
import com.andy.infrastructure.adapter.ListDialogAdapter;
import com.andy.infrastructure.bean.ListDialogItemDataBean;
import com.andy.infrastructure.databinding.DlgMaterialMenuBinding;

import java.util.List;

/**
 * Created by Andy on 2017/3/8.
 */

public class ListMenuDialog<T> extends DataBindBaseDialog {

    private ListDialogAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.dlg_material_menu;
    }

    @Override
    protected int getStyle() {
        return R.style.BaseDialog;
    }

    private List<ListDialogItemDataBean<T>> itemDataSet;

    @Override
    public void onStart() {
        super.onStart();
        adapter = new ListDialogAdapter(mContext);

        DlgMaterialMenuBinding mDataBind = (DlgMaterialMenuBinding) dataBinding;
        mDataBind.rclMaterialMenu.setLayoutManager(new LinearLayoutManager(mContext));
        mDataBind.rclMaterialMenu.setAdapter(adapter);

        adapter.initData(itemDataSet);
    }

    /**
     * 初始化数据
     */
    public void setDataSet(List<ListDialogItemDataBean<T>> dataSet) {
        if (CommonUtils.isListEmpty(dataSet)) {
            return;
        }

        this.itemDataSet = dataSet;

        if (adapter!=null) {
            adapter.notifyDataSetChanged();
        }
    }

}
