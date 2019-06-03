package com.example.cy.chenyu20190603;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cy.chenyu20190603.bean.ShangBean;
import com.example.cy.chenyu20190603.prsesnter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Qiyue.IView{
        private RecyclerView recyclerView;
        private String path="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
        private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        presenter=new Presenter();
        presenter.lianjie(this);
        presenter.setshow(path,this);
        presenter.xielou();
    }

    @Override
    public void getshow(String data) {
        Gson gson=new Gson();
        ShangBean shangBean = gson.fromJson(data, ShangBean.class);
        List<ShangBean.ResultBean> list = shangBean.getResult();
        MyAdapter adapter=new MyAdapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
