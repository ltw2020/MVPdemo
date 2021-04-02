package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;

import Model.MyDatabaseHelper;
import Presenter.IMainPresenter;
import Presenter.IRegisterPresenter;
import Presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private Button button;
    private TextView register;
    private EditText username;
    private EditText userpsw;
    private IMainPresenter mainPresenter;
    public  static String phonenum;
    public static String password;
    public static int p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        RegisterActivity.dpHelper=new MyDatabaseHelper(this,"Customer.db",null,1);

        mainPresenter=new MainPresenter(MainActivity.this);
        button=findViewById(R.id.btn);
        register=findViewById(R.id.register);
        username=findViewById(R.id.username);
        userpsw=findViewById(R.id.userpsw);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                phonenum=username.getText().toString();
                password=userpsw.getText().toString();
                p=Integer.parseInt(password);
                mainPresenter.Search();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void phonefalse() {
        Toast.makeText(MainActivity.this,"用户不存在",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pswfalse() {
        Toast.makeText(MainActivity.this,"密码输入错误",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void finalsuccess() {
        Toast.makeText(MainActivity.this,"登陆成功！！！",Toast.LENGTH_LONG).show();
    }
}