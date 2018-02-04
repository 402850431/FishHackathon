package cheryl.fishackathon;


import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cheryl.fishackathon.Dialog.MyDialog;
import cheryl.fishackathon.Dialog.MyDialogListener;

public class PayFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pay);

        findViewById(R.id.payBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDialog myDialog = new MyDialog(PayFragment.this);
                myDialog.setListener(new MyDialogListener() {
                    @Override
                    public void isUserAgreed() {
                        startActivity(new Intent(PayFragment.this, MainActivity.class));
                    }

                    @Override
                    public void isUserCanceled() {

                    }
                });
                myDialog.simpleDialog().show();
            }
        });
    }

}
