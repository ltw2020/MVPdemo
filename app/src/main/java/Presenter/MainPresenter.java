package Presenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import Model.Data;
import Model.LoadDataCallback;
import View.IMainActivity;
import View.IRegisterActivity;
import View.MainActivity;
import View.RegisterActivity;

public class MainPresenter implements IMainPresenter, LoadDataCallback {

    private final IMainActivity iMainActivity;
    private final Data data;


    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        data=new Data();

    }

    @Override
    public void Search() {
        data.getData(MainPresenter.this);
    }

    @Override
    public void success() {
        Log.i("ltw","登陆成功");
        iMainActivity.finalsuccess();
    }

    @Override
    public void phonefailure() {
        iMainActivity.phonefalse();
    }

    @Override
    public void pswfailure() {
        iMainActivity.pswfalse();
    }

}
