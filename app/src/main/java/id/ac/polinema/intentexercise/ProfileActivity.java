package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    Button button_homepage;
    TextView FullName, Email, HomePage, About;
    //ArrayList<RegisterActivity> daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String full_name = getIntent().getExtras().getString("fullName");
        String email = getIntent().getExtras().getString("email");
        String homePage = getIntent().getExtras().getString("homePage");
        String about = getIntent().getExtras().getString("about");

        FullName = findViewById(R.id.label_fullname);
        Email = findViewById(R.id.label_email);
        HomePage = findViewById(R.id.label_homepage);
        About = findViewById(R.id.label_about);

        FullName.setText(full_name);
        Email.setText(email);
        HomePage.setText(homePage);
        About.setText(about);


        button_homepage = (Button) findViewById(R.id.button_homepage);
        button_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                ProfileActivity.this.startActivity(intent);
            }
        });


    }
}
