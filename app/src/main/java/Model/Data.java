package Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import View.MainActivity;
import View.RegisterActivity;

public class Data implements IData {
    @Override
    public void getData(final LoadDataCallback loadDataCallback) {
                    String phone = null;
                    int password;
                    Boolean phonenum=true;
        Boolean phonenum2=true;
                    Boolean psw=true;
                    RegisterActivity.dpHelper.getReadableDatabase();//创建数据库
                    SQLiteDatabase db = RegisterActivity.dpHelper.getWritableDatabase();
                    Cursor cursor = db.query("Customer", null, null, null, null, null, null);
                    if (cursor.moveToFirst()) {
                        do {
                            Log.i("ltw", "search3");
                            phone = cursor.getString(cursor.getColumnIndex("phone"));
                            if (MainActivity.phonenum.equals(phone)) {
                                Log.i("ltw", "这");
                                phonenum=false;
                                break;
                            }
                        } while (cursor.moveToNext());
                        if (phonenum){
                            Log.i("ltw", "cuo");

                            loadDataCallback.phonefailure();
                        }
                    }
                    cursor.close();
                    if (phonenum2) {
                        cursor = db.query("Customer", new String[]{"password1"}, "phone=?", new String[]{phone}, null, null, null);
                        if (cursor.moveToFirst()) {
                            do {
                                Log.i("ltw", "a");
                                password = cursor.getInt(cursor.getColumnIndex("password1"));
                                if (MainActivity.p == password) {
                                    Log.i("ltw", "c");
                                    loadDataCallback.success();
                                    psw=false;
                                    break;
                                }
                            } while (cursor.moveToNext());
                        }
                        if (psw){
                            loadDataCallback.pswfailure();
                        }
                        cursor.close();
                    }

    }

    @Override
    public void putData() {
        RegisterActivity.dpHelper.getWritableDatabase();//创建数据库
        SQLiteDatabase db=RegisterActivity.dpHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",RegisterActivity.username);
        values.put("password1",RegisterActivity.password1);
        values.put("password2",RegisterActivity.password2);
        values.put("phone",RegisterActivity.phonenumber);
        db.insert("Customer",null,values);
        values.clear();
    }
}
