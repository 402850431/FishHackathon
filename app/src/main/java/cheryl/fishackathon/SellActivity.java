package cheryl.fishackathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;

public class SellActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name, price, quantity, binomialName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        findViewByIds();
        getBundles();
        textJudgement();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.show();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        //up button pressed. pop back stack.
        onBackPressed();
        return true;
    }

    private void getBundles() {
        Bundle bundle = getIntent().getExtras();
//        Bitmap bmp = bundle.getParcelable("imagebitmap");
//        imageView.setImageBitmap(bmp);
//        Glide.with(SellActivity.this)
//                .load(bmp)
//                .into(imageView);
        if(bundle!=null) {
            name.setText(bundle.getString("name", ""));
            price.setText(bundle.getString("price", "0"));
            quantity.setText(bundle.getString("quantity", "0"));
        }
    }

    private void findViewByIds() {
        imageView = (ImageView) findViewById(R.id.sellImg);
        name = (TextView) findViewById(R.id.sellName);
        binomialName = (TextView) findViewById(R.id.sellBinomialName);
        price = (TextView) findViewById(R.id.sellPrice);
        quantity = (TextView) findViewById(R.id.sellQuantity);

    }

    private void textJudgement() {
        switch(name.getText().toString()){
            case "吳郭魚":
            case "Tilapias":
            case "Cichlids":
            case "福壽魚":
            case "南洋鯽":
            case "尼羅魚":
            case "臺灣鯛":
            case "尼羅紅魚":
                binomialName.setText("Cichlidae");
                break;
            case "鯁魚":
            case "Mud carp":
            case "鯪魚":
            case "鯪仔魚":
            case "花鯪仔":
            case "青鱗魚":
            case "土鯪":
            case "鯪公":
                binomialName.setText("Cirrhinus molitorella");
                break;}
    }


    public void finishOnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("show",true);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }


}
