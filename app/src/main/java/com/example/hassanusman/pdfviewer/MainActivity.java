package com.example.hassanusman.pdfviewer;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.circulardialog.CDialog;
import com.example.circulardialog.extras.CDConstants;
import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    ProgressBar progressBar;
    Toolbar toolbar;
    FloatingActionButton fab;
    private static final int CHOOSE_CODE=11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PDF Viewer");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        progressBar=new ProgressBar(this);
        progressBar.setMax(100);
        progressBar.setProgress(1);
        pdfView=findViewById(R.id.pdfView);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog();
            }
        });
    }

    public void createDialog(){
        new CDialog(this).createAlert("Created successfully",
                CDConstants.ERROR, CDConstants.LARGE)
                .setAnimation(CDConstants.SCALE_FROM_BOTTOM_TO_TOP)
                .setDuration(2000)
                .setTextSize(CDConstants.LARGE_TEXT_SIZE)
                .show();
        /*Dialog d=new Dialog(this);
        d.getWindow().setBackgroundDrawableResource(R.drawable.round_back);
        d.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.dialog_layout);
        d.getWindow().setLayout(300,300);
        d.setCancelable(true);
        d.show();*/
    }
    public void selectFile(){
        Intent i=new Intent();
        i.setType("application/pdf");
        i.setAction(Intent.ACTION_GET_CONTENT);
        if(i.resolveActivity(getPackageManager())!=null)
            startActivityForResult(Intent.createChooser(i,"Complete using"),CHOOSE_CODE);
        else
            Toast.makeText(getApplicationContext(),"No application to complete the action !!!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            switch(requestCode){
                case CHOOSE_CODE:
                    Uri uri=data.getData();

                    pdfView.fromUri(uri).enableSwipe(true).swipeVertical(false)
                        .defaultPage(1).enableDoubletap(true).load();

                    progressBar.setProgress(100);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_SHORT).show();
                    break;
            }



    }
}
