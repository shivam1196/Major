package com.example.fblogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String profile;
    TextView textView;
    LoginButton login_Button;
    CallbackManager callbackManager;
    private ProfilePictureView profilePictureView;
    private LinearLayout infoLayout;
    private TextView email;
    private TextView gender;
    private TextView facebookName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initalizeControls();
        LoginFB();

    }

    private void initalizeControls()
    {
        callbackManager = CallbackManager.Factory.create();
        textView=(TextView)findViewById(R.id.textView);
        login_Button=(com.facebook.login.widget.LoginButton)findViewById(R.id.login_button);
        login_Button.setReadPermissions("email","public_profile");
    }

    private void LoginFB()
    {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               // textView.setText("Login Successful: "+loginResult.getAccessToken());
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                       setProfileView(object);

                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
                parameters.putString("id",profile);
                Intent intent = new Intent(getApplicationContext(),Score.class);
                intent.putExtras(parameters);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                textView.setText("Login cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                textView.setText("Error occured "+error.getMessage());
            }
        });

    }

    private void setProfileView(JSONObject jsonObject) {
//        try {
//
////            email.setText(jsonObject.getString("email"));
////            facebookName.setText(jsonObject.getString("name"));
////            profilePictureView.setPresetSize(ProfilePictureView.NORMAL);
////           profile= jsonObject.getString("id");
//            infoLayout.setVisibility(View.VISIBLE);
//        }
//        catch (JSONException e) {
//                e.printStackTrace();
//        }
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
