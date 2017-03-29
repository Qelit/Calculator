package qelit.calculator;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Qelit on 29.03.2017.
 */

public class Dialog extends DialogFragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("О программе");
        View v = inflater.inflate(R.layout.dialog, null);
        v.findViewById(R.id.btnOk).setOnClickListener(this);
        return v;
    }

    public void onClick(View v){
        dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
