package com.example.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnModelToJson, btnJsonToModel, btnArraylistToAndFromList;
    TextView txtResult;
    private String json;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnModelToJson = findViewById(R.id.btnModelToJson);
        btnJsonToModel = findViewById(R.id.btnJsonToModel);
        btnArraylistToAndFromList = findViewById(R.id.btnArraylistToAndFromList);
        txtResult = findViewById(R.id.txtResult);

        gson = new Gson();

        btnModelToJson.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                UserModel userModel = new UserModel("IT wala");
                json = gson.toJson(userModel);

                txtResult.setText(json);
            }
        });

        btnJsonToModel.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (!TextUtils.isEmpty(json)) {
                    try {
                        UserModel model = gson.fromJson(json, UserModel.class);
                        txtResult.setText(model.toString());
                    } catch (Exception exception) {
                        Toast.makeText(MainActivity.this, "Click model to json first.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Click model to json first.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnArraylistToAndFromList.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String result;

                Type listType = new TypeToken<List<UserModel>>() {
                }.getType();

                ArrayList<UserModel> list = new ArrayList<>();
                list.add(new UserModel("A"));
                list.add(new UserModel("B"));
                list.add(new UserModel("C"));

                json = gson.toJson(list, listType);

                ArrayList<UserModel> list1 = gson.fromJson(json, listType);

                result = "Json: " + json + "\n" +
                        "List: " + list1.toString();

                txtResult.setText(result);
            }
        });
    }
}