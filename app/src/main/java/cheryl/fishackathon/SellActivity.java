package cheryl.fishackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        textJudgement();
    }

    private void textJudgement() {
        /*
        switch(name){
            case "吳郭魚":
            case "Tilapias":
            case "Cichlids":
            case "福壽魚":
            case "南洋鯽":
            case "尼羅魚":
            case "臺灣鯛":
            case "尼羅紅魚":
                binomialName = "Cichlidae";
                break;
            case "鯁魚":
            case "Mud carp":
            case "鯪魚":
            case "鯪仔魚":
            case "花鯪仔":
            case "青鱗魚":
            case "土鯪":
            case "鯪公":
                binomialName = "Cirrhinus molitorella";
                break;}
                */
    }


    public void finishOnClick(View view){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}
