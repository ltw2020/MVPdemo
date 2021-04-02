package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpdemo.R;

import Model.MyDatabaseHelper;
import Presenter.IRegisterPresenter;
import Presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IRegisterActivity{

    private Button btn_register;

    private IRegisterPresenter registerPresenter;
    private EditText name;
    private EditText phone;
    private EditText psw1;
    private EditText psw2;
    public  static String username;
    public static String password1;
    public static String password2;
    public static String phonenumber;
    public static MyDatabaseHelper dpHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerPresenter=new RegisterPresenter(RegisterActivity.this);

        name=findViewById(R.id.name);
        psw1=findViewById(R.id.psw1);
        psw2=findViewById(R.id.psw2);
        phone=findViewById(R.id.phone);


        dpHelper=new MyDatabaseHelper(this,"Customer.db",null,1);
        btn_register=findViewById(R.id.register_final);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=name.getText().toString();
                password1=psw1.getText().toString();
                password2=psw2.getText().toString();
                phonenumber=phone.getText().toString();

                if (phone.getText().length()!=0&&password1.equals(password2)){
                    registerPresenter.Create();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if (phone.getText().length()==0){
                    Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }
                else if (psw1.getText().length()==0||psw2.getText().length()==0){
                    Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();

                }
                else if (name.getText().length()==0){
                    Toast.makeText(RegisterActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(RegisterActivity.this,"请确认输入的密码一致",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}