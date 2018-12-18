package com.test.androiddemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/12/18
 *     desc   :
 *     modify :
 * </pre>
 */
public class ExpandBean {
    private String name;
    private boolean checked;
    private boolean isClick;
    private List<ExpandChildBean> childs;
    private OnGroupCheckedChangeListener mListener;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked, boolean isClick){
        this.isClick = isClick;
        setChecked(checked);
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        if(mListener != null) {
            mListener.onGroupCheckedChanged(checked, isClick);
        }
    }

    public List<ExpandChildBean> getChilds() {
        return childs;
    }

    public void setChilds(List<ExpandChildBean> childs) {
        this.childs = childs;
    }

    public static class ExpandChildBean {
        private String name;
        private boolean checked;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
    }

    public static List<ExpandBean> getData() {
        List<ExpandBean> parentList = new ArrayList<>();
        ExpandBean parentBean;
        for(int i = 0; i < 20; i++) {
            parentBean = new ExpandBean();
            parentBean.setName("一级列表"+(i+1));
            List<ExpandChildBean> childBeanList = getChildBeanList(parentBean.getName());
            parentBean.setChilds(childBeanList);
            parentList.add(parentBean);
        }
        return parentList;
    }

    private static List<ExpandChildBean> getChildBeanList(String name) {
        List<ExpandChildBean> list = new ArrayList<>();
        ExpandChildBean bean;
        for(int i = 0; i < 10; i++) {
            bean = new ExpandChildBean();
            bean.setName(name + "\u0020二级列表"+(i+1));
            list.add(bean);
        }
        return list;
    }

    public void setOnGroupCheckedChangeListener(OnGroupCheckedChangeListener listener){
        this.mListener = listener;
    }

    public interface OnGroupCheckedChangeListener{
        void onGroupCheckedChanged(boolean isChecked, boolean isClick);
    }

}
