package com.example.a;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.ar.core.Anchor;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;


public class MainActivity extends AppCompatActivity
{


    private String modelLink = " ";  //https://github.com/yudiz-solutions/runtime_ar_android/raw/master/model/model.gltf
    EditText edittext;
    Button button, back;
    ImageView image;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.edittext);
        text2 = (TextView) findViewById(R.id.textView);
        image = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        // back = (Button) findViewById(R.id.back);

        image.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        edittext.setVisibility(View.INVISIBLE);

        image.animate().alpha(0).setDuration(5300);
        new CountDownTimer(5000, 1000)
        {
            @Override
            public void onTick(long l)
            {

            }

            @Override
            public void onFinish()
            {
                button.setVisibility(View.VISIBLE);
                edittext.setVisibility(View.VISIBLE);
                image.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
            }
        }.start();
       /* back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Back();
            }
        });*/
    }


    public void ButtonPress(View view)
    {
        modelLink = edittext.getText().toString();
        DataHolder.modelLink = modelLink;
        Intent in = new Intent(this, ARActivity.class);
        startActivity(in);
//        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
//            placeModel(hitResult.createAnchor());
//        });
    }


//    private void placeModel(Anchor anchor){
//
//        ModelRenderable
//                .builder()
//                .setSource(this,
//                        RenderableSource
//                                .builder()
//                                .setSource(this,Uri.parse(modelLink),RenderableSource.SourceType.GLTF2)
//                                .setScale(0.5f)
//                                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
//                                .build()
//                )
//                .setRegistryId(modelLink)
//                .build()
//                .thenAccept(modelRenderable ->  addNodeToScene(modelRenderable,anchor))
//                .exceptionally( throwable -> {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                    builder.setMessage(throwable.getMessage()).show();
//                    return null;
//                });
//    }


//    TransformableNode andy;
//    AnchorNode anchorNode;
//
//    private void addNodeToScene(ModelRenderable modelRenderable, Anchor anchor) {
//       anchorNode = new AnchorNode(anchor);
//        //anchorNode.setRenderable(modelRenderable);
//        //arFragment.getArSceneView().getScene().addChild(anchorNode);
//
//        anchorNode.setParent(arFragment.getArSceneView().getScene());
//
//        // Create the transformable andy and add it to the anchor.
//       andy = new TransformableNode(arFragment.getTransformationSystem());
//        andy.setParent(anchorNode);
//        andy.setRenderable(modelRenderable);
//        andy.select();
//        andy.getScaleController().setMinScale(0.0f);
//        andy.getScaleController().setMaxScale(25.0f);
//
//    }


    public void Back()
    {
        image.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        edittext.setVisibility(View.VISIBLE);
    }

}
