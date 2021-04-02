package Presenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import Model.Data;
import View.IRegisterActivity;
import View.RegisterActivity;

public class RegisterPresenter implements IRegisterPresenter {

    private final IRegisterActivity iRegisterActivity;
    private final Data data;




    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        data=new Data();

    }

    @Override
    public void Create() {
        data.putData();
    }
}
