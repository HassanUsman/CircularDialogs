package com.example.circulardialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.circulardialog.extras.CDConstants;

import static com.example.circulardialog.extras.CDConstants.LARGE;
import static com.example.circulardialog.extras.CDConstants.MEDIUM;
import static com.example.circulardialog.extras.CDConstants.POSITION_BOTTOM;
import static com.example.circulardialog.extras.CDConstants.POSITION_TOP;
import static com.example.circulardialog.extras.CDConstants.SUCCESS;
import static com.example.circulardialog.extras.CDConstants.WARNING;


/**
 * Created by multimeet on 18/11/17.
 */

public class CDialog {

    Dialog dialog;
    Context context;
    TextView messageTextView;
    ImageView imageView;
    RelativeLayout relativeLayout;
    int size=0;
    int duration=0;
    public CDialog(Context context){
        this.context=context;
        dialog=new Dialog(context);

    }


    public CDialog createAlert(String message,int alertType,int givenSize){
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.round_back);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.simple_text);
        dialog.getWindow().getAttributes().windowAnimations=R.style.slide_from_left_to_right;
        switch(givenSize){

            case MEDIUM:
                size=context.getResources().getInteger(R.integer.medium_dialog);
                break;

            case LARGE:
                size=context.getResources().getInteger(R.integer.large_dialog);
                break;
        }

        dialog.getWindow().setLayout(size,size);
        messageTextView=dialog.findViewById(R.id.msg);
        messageTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
        messageTextView.setText(message);
        imageView=dialog.findViewById(R.id.icn);
        imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.rotate));
        relativeLayout=dialog.findViewById(R.id.rl);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        switch(alertType){
            case SUCCESS:
                // success icon
                imageView.setImageResource(R.drawable.checked_1);
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorSuccess));
                break;

            case WARNING:
                // warning icon

                imageView.setImageResource(R.drawable.warning);
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorWarning));
                break;

            case CDConstants.ERROR:
                // error icon
                imageView.setImageResource(R.drawable.cancel1);
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorError));
                break;
        }

        return this;
    }

    public CDialog createAlert(String message,Bitmap icon,int alertType,int givenSize){

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.round_back);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.simple_text);
        dialog.getWindow().getAttributes().windowAnimations=R.style.slide_from_left_to_right;
        switch(givenSize){

            case MEDIUM:
                size=context.getResources().getInteger(R.integer.medium_dialog);
                break;

            case LARGE:
                size=context.getResources().getInteger(R.integer.large_dialog);
                break;
        }
        imageView.setImageBitmap(icon);
        dialog.getWindow().setLayout(size,size);
        messageTextView=dialog.findViewById(R.id.msg);
        messageTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
        messageTextView.setText(message);
        imageView=dialog.findViewById(R.id.icn);
        relativeLayout=dialog.findViewById(R.id.rl);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        switch(alertType){
            case SUCCESS:
                // success icon
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorSuccess));
                break;

            case WARNING:
                // warning icon

                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorWarning));
                break;

            case CDConstants.ERROR:
                // error icon
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorError));
                break;
        }

        return this;
    }

    public CDialog createAlert(String message,Drawable icon,int alertType,int givenSize){

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.round_back);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.simple_text);
        dialog.getWindow().getAttributes().windowAnimations=R.style.slide_from_left_to_right;
        switch(givenSize){

            case MEDIUM:
                size=context.getResources().getInteger(R.integer.medium_dialog);
                break;

            case LARGE:
                size=context.getResources().getInteger(R.integer.large_dialog);
                break;
        }
        imageView.setImageDrawable(icon);
        dialog.getWindow().setLayout(size,size);
        messageTextView=dialog.findViewById(R.id.msg);
        messageTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
        messageTextView.setText(message);
        imageView=dialog.findViewById(R.id.icn);
        relativeLayout=dialog.findViewById(R.id.rl);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        switch(alertType){
            case SUCCESS:
                // success icon
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorSuccess));
                break;

            case WARNING:
                // warning icon

                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorWarning));
                break;

            case CDConstants.ERROR:
                // error icon
                relativeLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorError));
                break;
        }

        return this;
    }

    public CDialog setDuration(int duration){
        this.duration=duration;
        return this;
    }

    public CDialog setBackgroundColor(int color){
        relativeLayout=dialog.findViewById(R.id.rl);
        relativeLayout.setBackgroundColor(color);
        return this;
    }

    public CDialog setTextSize(int textSize){
        messageTextView=dialog.findViewById(R.id.msg);
        switch (textSize){
            case CDConstants.LARGE_TEXT_SIZE:
                messageTextView.setTextSize((float)context.getResources()
                        .getInteger(R.integer.large_text));
                break;

            case CDConstants.NORMAL_TEXT_SIZE:
                messageTextView.setTextSize((float)context.getResources()
                        .getInteger(R.integer.normal_text));
                break;

            case CDConstants.EXTRA_LARGE_TEXT_SIZE:
                messageTextView.setTextSize((float)context.getResources()
                        .getInteger(R.integer.extra_large_text));
        }
        return this;
    }

    public CDialog setPosition(int position){
        switch (position){
            case POSITION_BOTTOM:
                dialog.getWindow().getAttributes().gravity= Gravity.BOTTOM;
                break;
            case POSITION_TOP:
                dialog.getWindow().getAttributes().gravity= Gravity.BOTTOM;
                break;
        }

        return this;
    }

    public CDialog setBackDimness(float dimness){
        dialog.getWindow().setDimAmount(dimness);
        return this;
    }

    public CDialog setAnimation(int animation){
        int selectedAnimation=0;
        switch(animation){

            // Scale

            case CDConstants.SCALE_FROM_BOTTOM_TO_BOTTOM:
                selectedAnimation=R.style.scale_from_bottom_to_bottom;
                break;

            case CDConstants.SCALE_FROM_BOTTOM_TO_TOP:
                selectedAnimation=R.style.scale_from_bottom_to_top;
                break;

            case CDConstants.SCALE_FROM_TOP_TO_BOTTOM:
                selectedAnimation=R.style.scale_from_top_to_bottom;
                break;

            case CDConstants.SCALE_FROM_TOP_TO_TOP:
                selectedAnimation=R.style.scale_from_top_to_top;
                break;

            case CDConstants.SCALE_TO_BOTTOM_FROM_BOTTOM:
                selectedAnimation=R.style.scale_to_bottom_from_bottom;
                break;

            case CDConstants.SCALE_TO_TOP_FROM_BOTTOM:
                selectedAnimation=R.style.scale_to_top_from_bottom;
                break;

            case CDConstants.SCALE_TO_TOP_FROM_TOP:
                selectedAnimation=R.style.scale_to_top_from_top;
                break;




            case CDConstants.SCALE_FROM_LEFT_TO_LEFT:
                selectedAnimation=R.style.scale_from_left_to_left;
                break;
            case CDConstants.SCALE_FROM_LEFT_TO_RIGHT:
                selectedAnimation=R.style.scale_from_left_to_right;
                break;

            case CDConstants.SCALE_FROM_RIGHT_TO_LEFT:
                selectedAnimation=R.style.scale_from_right_to_left;
                break;

            case CDConstants.SCALE_FROM_RIGHT_TO_RIGHT:
                selectedAnimation=R.style.scale_from_right_to_right;
                break;

            case CDConstants.SCALE_TO_LEFT_FROM_LEFT:
                selectedAnimation=R.style.scale_to_left_from_left;
                break;

            case CDConstants.SCALE_TO_RIGHT_FROM_LEFT:
                selectedAnimation=R.style.scale_to_right_from_left;
                break;

            case CDConstants.SCALE_TO_RIGHT_FROM_RIGHT:
                selectedAnimation=R.style.scale_to_right_from_right;
                break;



                // Slide



            case CDConstants.SLIDE_FROM_BOTTOM_TO_BOTTOM:
                selectedAnimation=R.style.slide_from_bottom_to_bottom;
                break;
            case CDConstants.SLIDE_FROM_BOTTOM_TO_TOP:
                selectedAnimation=R.style.slide_from_bottom_to_top;
                break;

            case CDConstants.SLIDE_FROM_TOP_TO_BOTTOM:
                selectedAnimation=R.style.slide_from_top_to_bottom;
                break;

            case CDConstants.SLIDE_FROM_TOP_TO_TOP:
                selectedAnimation=R.style.slide_from_top_to_top;
                break;

            case CDConstants.SLIDE_TO_BOTTOM_FROM_BOTTOM:
                selectedAnimation=R.style.slide_to_bottom_from_bottom;
                break;

            case CDConstants.SLIDE_TO_TOP_FROM_BOTTOM:
                selectedAnimation=R.style.slide_to_top_from_bottom;
                break;

            case CDConstants.SLIDE_TO_TOP_FROM_TOP:
                selectedAnimation=R.style.slide_to_top_from_top;
                break;




            case CDConstants.SLIDE_FROM_LEFT_TO_LEFT:
                selectedAnimation=R.style.slide_from_left_to_left;
                break;
            case CDConstants.SLIDE_FROM_LEFT_TO_RIGHT:
                selectedAnimation=R.style.slide_from_left_to_right;
                break;

            case CDConstants.SLIDE_FROM_RIGHT_TO_LEFT:
                selectedAnimation=R.style.slide_from_right_to_left;
                break;

            case CDConstants.SLIDE_FROM_RIGHT_TO_RIGHT:
                selectedAnimation=R.style.slide_from_right_to_right;
                break;

            case CDConstants.SLIDE_TO_LEFT_FROM_LEFT:
                selectedAnimation=R.style.slide_to_left_from_left;
                break;

            case CDConstants.SLIDE_TO_RIGHT_FROM_LEFT:
                selectedAnimation=R.style.slide_to_right_from_left;
                break;

            case CDConstants.SLIDE_TO_RIGHT_FROM_RIGHT:
                selectedAnimation=R.style.slide_to_right_from_right;
                break;


        }
        dialog.getWindow().getAttributes().windowAnimations=selectedAnimation;

        return this;
    }

    public void show(){
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(duration);
                    dialog.dismiss();
                }catch (InterruptedException e){
                    Log.e("show intrupt",""+e.getMessage());
                }
            }
        }).start();
    }
}
