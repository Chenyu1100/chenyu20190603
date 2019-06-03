package com.example.cy.chenyu20190603;

import android.content.Context;

public interface Qiyue {
    interface IModel{
        void getshow(String url, Context context,Callback callback);
        interface Callback{
            void chenggong(String data);
        }
    }
    interface IPresenter{
        void lianjie(IView iView);
        void xielou();
        void setshow(String url,Context context);
    }
    interface IView{
        void getshow(String data);
    }
}
