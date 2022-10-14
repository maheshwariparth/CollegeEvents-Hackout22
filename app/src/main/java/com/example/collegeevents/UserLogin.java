package com.example.collegeevents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.w3c.dom.Text;


public class UserLogin extends AppCompatActivity  {


    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        TextView tv=findViewById(R.id.login_sign);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/lobster.ttf");
        tv.setTypeface(customfont);
        googleBtn=findViewById(R.id.sign_in_button);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc=GoogleSignIn.getClient(this,gso);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
//        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this, gso);
////        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
////        updateUI(account);
//        SignInButton signInButton=findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
//        signInButton.setColorScheme(SignInButton.COLOR_LIGHT);
//        findViewById(R.id.sign_in_button).setOnClickListener(this);

    }







    void signIn(){
        Intent signInIntent=gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent=new Intent(UserLogin.this,UserLogin.class);
        startActivity(intent);
    }


    //    @Override
//    protected void onStart() {
//
//        super.onStart();
//        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);
//    }
//
//    public void updateUI(GoogleSignInAccount account)
//    {
//        if(account != null){
//            Toast.makeText(this,"You Signed In successfully",Toast.LENGTH_LONG).show();
//            //startActivity(new Intent(this,AnotherActivity.class));
//
//        }else {
//            Toast.makeText(this,"You Didnt signed in",Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.sign_in_button:
//                signIn();
//                break;
//        }
//    }
//    private void signIn(){
//        Intent signInIntent= mGoogleSignInClient.getSignInIntent();
//        someActivityResultLauncher.launch(signInIntent);
//    }
//    ActivityResultLauncher<Intent> someActivityResultLauncher=registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if(result.getResultCode()== Activity.RESULT_OK){
//                        Intent data=result.getData();
//                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                        handleSignInResult(task);
//                    }
//                }
//            }
//    );
//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//            updateUI(account);
//        } catch (ApiException e) {
//            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
//        }
//    }
}