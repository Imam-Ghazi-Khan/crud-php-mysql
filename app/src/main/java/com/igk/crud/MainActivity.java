package com.igk.crud;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText idET,nameET;
    TextView createTV,readTV,updateTV,deleteTV;
    Button createBtn,readBtn,updateBtn,deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTV = findViewById(R.id.createTV);
        readTV = findViewById(R.id.readTV);
        updateTV = findViewById(R.id.updateTV);
        deleteTV = findViewById(R.id.deleteTV);

        createBtn = findViewById(R.id.createBtn);
        readBtn = findViewById(R.id.readBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        idET = findViewById(R.id.idET);
        nameET = findViewById(R.id.nameET);

        RequestQueue queue = Volley.newRequestQueue(this);

            //-----------------create------------------
        String create_url = "http://192.168.29.98/crud/create.php";

        createBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringRequest createRequest = new StringRequest(Request.Method.POST, create_url,
                            response -> createTV.setText(response),
                            error -> createTV.setText("Something's wrong"+error.toString())){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> m = new HashMap<>();
                            m.put("name", nameET.getText().toString());
                            m.put("id",idET.getText().toString());
                            return m;
                        }
                    };
                    queue.add(createRequest);
                }
            });
            //-----------------create------------------

        //-----------------read------------------
        String read_url = "http://192.168.29.98/crud/read.php";

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest readRequest = new StringRequest(Request.Method.POST, read_url,
                        response -> readTV.setText(response),
                        error -> readTV.setText("Something's wrong"+error.toString()));
                queue.add(readRequest);
            }
        });
        //-----------------read------------------


        //-----------------update------------------
        String update_url = "http://192.168.29.98/crud/update.php";

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest createRequest = new StringRequest(Request.Method.POST, update_url,
                        response -> updateTV.setText(response),
                        error -> updateTV.setText("Something's wrong"+error.toString())){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> m = new HashMap<>();
                        m.put("name", nameET.getText().toString()+"");
                        m.put("id",idET.getText().toString()+"");
                        return m;
                    }
                };
                queue.add(createRequest);
            }
        });
        //-----------------update------------------

        //-----------------delete-----------------

        String delete_url = "http://192.168.29.98/crud/delete.php";

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest createRequest = new StringRequest(Request.Method.POST, delete_url,
                        response -> deleteTV.setText(response),
                        error -> deleteTV.setText("Something's wrong"+error.toString())){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> m = new HashMap<>();
                        m.put("id",idET.getText().toString());
                        return m;
                    }
                };
                queue.add(createRequest);
            }
        });
        //-----------------delete------------------

    }
}