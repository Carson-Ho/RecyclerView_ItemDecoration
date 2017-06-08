package scut.carson_ho.recyclerviewitemdecoration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MyItemClickListener {
    private RecyclerView Rv;
    private ArrayList<HashMap<String,Object>> listItem;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    public void initData(){
        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", "第" + i + "行");
            map.put("ItemText", "这是第" + i + "行");
            map.put("ItemImage",R.mipmap.ic_launcher);
            listItem.add(map);
        }
    }
    public void initView(){
        Rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        //使用线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        Rv.setLayoutManager(layoutManager);
        Rv.setHasFixedSize(true);

        //用自定义分割线类设置分割线
        Rv.addItemDecoration(new DividerItemDecoration());

        //为ListView绑定适配器
        myAdapter = new MyAdapter(this,listItem);
        Rv.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(View view, int postion) {//点击事件的回调函数
        System.out.println("点击了第" + postion + "行");
        Toast.makeText(this, (String) listItem.get(postion).get("ItemText"), Toast.LENGTH_SHORT).show();
    }

}
