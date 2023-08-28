package com.example.prm_project;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {
    /* **********************************************************************
     * Variable
     ********************************************************************** */
    private List<Tab> tabs = null;

    {
        tabs = Arrays.asList(
                new Tab(
                        Type.HOME,
                        R.string.home,
                        R.drawable.ic_home,
                        null
                ),
                new Tab(
                        Type.PRODUCT,
                        R.string.product,
                        R.drawable.ic_product,
                        null
                ),
                new Tab(
                        Type.FAVORITE,
                        R.string.favorite,
                        R.drawable.ic_favorite,
                        null
                ),
                new Tab(
                        Type.SETTING,
                        R.string.setting,
                        R.drawable.ic_setting,
                        null
                )
        );
    }

    /* **********************************************************************
     * Function
     ********************************************************************** */
    public List<Tab> getTabs() {
        return tabs;
    }

    /* **********************************************************************
     * Class
     ********************************************************************** */
    public enum Type {HOME, PRODUCT, FAVORITE, SETTING}

    public static class Tab {
        public final Type type;
        public final int title;
        public final int icon;
        public Fragment fragment;

        public Tab(Type type, int title, int icon, Fragment fragment) {
            this.type = type;
            this.title = title;
            this.icon = icon;
            this.fragment = fragment;
        }
    }
}
