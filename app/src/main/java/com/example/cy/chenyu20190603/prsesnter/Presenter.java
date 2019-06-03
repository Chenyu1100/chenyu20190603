package com.example.cy.chenyu20190603.prsesnter;

import android.content.Context;

import com.example.cy.chenyu20190603.Qiyue;
import com.example.cy.chenyu20190603.model.Model;

public class Presenter implements Qiyue.IPresenter {
    private Qiyue.IModel iModel;
    private Qiyue.IView iView;
    public Presenter(){
        iModel=new Model();
    }
    @Override
    public void lianjie(Qiyue.IView iView) {
        this.iView=iView;
    }

    @Override
    public void xielou() {
          if (iModel!=null){
              iModel=null;
          }
    }

    @Override
    public void setshow(String url, Context context) {
            iModel.getshow(url, context, new Qiyue.IModel.Callback() {
                @Override
                public void chenggong(String data) {
                    iView.getshow(data);
                }
            });
    }
}
