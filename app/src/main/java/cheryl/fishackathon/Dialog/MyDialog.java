package cheryl.fishackathon.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cheryl.fishackathon.R;

/**
 * Created by Innooz on 2017/12/19.
 */

public class MyDialog implements DialogInterface.OnCancelListener, View.OnClickListener{

    private Context context;
    private Dialog mDialog;
    private SharedPreferences sharedPreferences;
    private Toast toast;
    private MyDialogListener listener;

    public MyDialog(Context context){
        this.context = context;
    }

    public MyDialog simpleDialog(){ //int title, String content

        mDialog = new Dialog(context);
        mDialog.setContentView(R.layout.custom_dialog_one_button);
        mDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mDialog.setCanceledOnTouchOutside(false);

        TextView yesTv = (TextView)mDialog.findViewById(R.id.yesTv);
        TextView titleTv = (TextView)mDialog.findViewById(R.id.titleTv);
        TextView contentTv = (TextView)mDialog.findViewById(R.id.contentTv);

//        titleTv.setText(title);
//        contentTv.setText(content);

        yesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.isUserAgreed();
            }
        });

        return this;
    }

    public MyDialogListener getListener() {
        return listener;
    }

    public void setListener(MyDialogListener listener) {
        this.listener = listener;
    }

    public void show(){
        mDialog.show();
    }

    public void dismiss(){
        mDialog.dismiss();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mDialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        mDialog.dismiss();
    }

}
