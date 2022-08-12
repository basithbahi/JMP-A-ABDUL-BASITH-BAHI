package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText fullName, email, password, confirmPass, homePage, about;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = (EditText) findViewById(R.id.text_fullname);
        email = (EditText) findViewById(R.id.text_email);
        password = (EditText) findViewById(R.id.text_password);
        confirmPass = (EditText) findViewById(R.id.text_confirm_password);
        homePage = (EditText) findViewById(R.id.text_homepage);
        about = (EditText) findViewById(R.id.text_about);
        buttonRegister = findViewById(R.id.button_ok);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputfullName = fullName.getText().toString();
                String inputEmail = email.getText().toString();
                String inputPassword = password.getText().toString();
                String inputConfirmPass = confirmPass.getText().toString();
                String inputHomepage = homePage.getText().toString();
                String inputAbout = about.getText().toString();

                if (!inputfullName.isEmpty() && !inputEmail.isEmpty() && !inputPassword.isEmpty() && !inputConfirmPass.isEmpty()
                        && !inputHomepage.isEmpty() && !inputAbout.isEmpty()) {
                    if (inputPassword.equals(inputConfirmPass)) {
                        Intent move = new Intent(RegisterActivity.this, ProfileActivity.class);
                        move.putExtra("fullName", inputfullName);
                        move.putExtra("email", inputEmail);
                        move.putExtra("homePage", inputHomepage);
                        move.putExtra("about", inputAbout);
                        Toast.makeText(RegisterActivity.this, "REGISTRASI BERHASIL!", Toast.LENGTH_SHORT).show();
                        startActivity(move);
                    } else {
                        AlertDialog.Builder build = new AlertDialog.Builder(RegisterActivity.this);
                        build.setMessage("PASSWORD ANDA TIDAK COCOK!").setNegativeButton("COBA LAGI!", null)
                                .create().show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "MOHON ISI DATA DIRI ANDA!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}