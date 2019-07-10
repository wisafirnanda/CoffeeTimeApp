package com.coffeetimeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private Button btnbiji, btnbubuk, btnkopijadi;
    private FloatingActionButton fab;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mUserRef;
    private FirebaseUser mUser;

    //ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init firebase
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btnbiji = (Button) findViewById(R.id.btnbiji);
        btnbubuk = (Button) findViewById(R.id.btnbubuk);
        btnkopijadi = (Button) findViewById(R.id.btnkopijadi);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnbiji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListWarkopActivity.class);
                startActivity(intent);
            }
        });

        btnbubuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnkopijadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        int images[] = {R.drawable.promo1, R.drawable.promo2, R.drawable.promo3};
        //v_flipper = findViewById(R.id.v_flipper);

        for (int i =0; i<images.length; i++){
            fliverImages(images[i]);
        }
        for (int image: images)
            fliverImages(image);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       /* if (mUser != null) {
            // User is signed in
            String userlogin = mUser.getEmail();
            Toast.makeText(MainActivity.this,"user login is : "+userlogin,Toast.LENGTH_SHORT).show();

            //delete soon
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Already Login")
                    .setMessage("test Logout ??")
                    .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            logOut();
                        }
                    })
                    .create();
            dialog.show();


        } else {
            // No user is signed in
            sendToLogin();
        }*/

    }

    //send to login
    private void sendToLogin() {
        //Check i user is Sign-out
        Intent startIntent = new Intent(MainActivity.this, LoginActivity.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(startIntent);

        finish();

    }

    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

       /* v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);*/

    }

    public void logOut(){
        Toast.makeText(MainActivity.this,"log out",Toast.LENGTH_SHORT).show();
        mAuth.signOut();
        sendToLogin();
    }

    public void terbaru(View view) {
        Intent startIntent = new Intent(MainActivity.this, TambahWarkopActivity.class);
        startActivity(startIntent);
    }
}
