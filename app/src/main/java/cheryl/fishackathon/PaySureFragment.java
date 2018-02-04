package cheryl.fishackathon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cheryl.fishackathon.Dialog.MyDialog;
import cheryl.fishackathon.Dialog.MyDialogListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaySureFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pay_sure);

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


    public void sureOnClick(View view){
        startActivity(new Intent(PaySureFragment.this, MainActivity.class));
    }
}
