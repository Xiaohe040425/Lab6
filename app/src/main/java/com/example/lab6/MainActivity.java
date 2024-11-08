package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }
    public class MyAdapter extends BaseAdapter {
        private MainActivity.Data[] data; // 儲存在 myAdapter 中的資料來源
        private int view; // myAdapter 之中使用的畫面

        public MyAdapter(MainActivity.Data[] data, int view) {
            this.data = data; // 透過建構子儲存資料來源
            this.view = view; // 儲存畫面
        }

        @Override
        public int getCount() {
            return data.length; // 回傳資料來源筆數
        }

        @Override
        public Object getItem(int position) {
            return data[position]; // 回傳資料來源項目內容
        }

        @Override
        public long getItemId(int position) {
            return 0; // 回傳資料項目 id
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(view, parent, false); // 取得 Xml 畫面
            TextView name = convertView.findViewById(R.id.name); // 連接 TextView 元件
            name.setText(data[position].name); // 根據 position 把字串顯示到 TextView
            ImageView imageView = convertView.findViewById(R.id.imageView); // 連接 ImageView 元件
            imageView.setImageResource(data[position].photo); // 根據 position 把圖片顯示到 ImageView
            return convertView;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step1: 建立資料來源
        String[] transNameArray = new String[]{"腳踏車", "機車", "汽車", "巴士", "飛機", "輪船"};
        int[] transPhotoIdArray = new int[]{
                R.drawable.trans1, R.drawable.trans2, R.drawable.trans3,
                R.drawable.trans4, R.drawable.trans5, R.drawable.trans6
        };

        Data[] transData = new Data[transNameArray.length];
        for (int i = 0; i < transData.length; i++) {
            transData[i] = new Data();
            transData[i].name = transNameArray[i];
            transData[i].photo = transPhotoIdArray[i];
        }

        // Step2: 建立 myAdapter 物件，並放入 transData 與 trans_list.xml
        MyAdapter transAdapter = new MyAdapter(transData, R.layout.trans_list);

        // Step3: 連接 Spinner 元件，並連結 myAdapter
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);

        // Step1: 建立資料來源
        String[] cubeeNameArray = new String[]{"哭哭", "發抖", "再見", "生氣", "驚訝", "大笑"};
        int[] cubeePhotoIdArray = new int[]{
                R.drawable.cubee1, R.drawable.cubee2, R.drawable.cubee3,
                R.drawable.cubee4, R.drawable.cubee5, R.drawable.cubee6,
                R.drawable.cubee7, R.drawable.cubee8, R.drawable.cubee9
        };

        Data[] cubeeData = new Data[cubeeNameArray.length];
        for (int i = 0; i < cubeeData.length; i++) {
            cubeeData[i] = new Data();
            cubeeData[i].name = cubeeNameArray[i];
            cubeeData[i].photo = cubeePhotoIdArray[i];
        }

        // Step2: 建立 myAdapter 物件，並放入 cubeeData 與 cubee_list.xml
        MyAdapter cubeeAdapter = new MyAdapter(cubeeData, R.layout.cubee_list);

        // Step3: 連接 GridView 元件，並連結 myAdapter
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(cubeeAdapter);
        gridView.setNumColumns(3);

        String[] messageArray = new String[]{"訊息1", "訊息2", "訊息3", "訊息4", "訊息5", "訊息6"};
        ArrayAdapter<String> messageAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messageArray);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(messageAdapter);
    }
}

