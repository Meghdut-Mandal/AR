package com.popit;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ARActivity extends AppCompatActivity
{

    private ArFragment arFragment;
    private String modelLink;
    private AnchorNode anchorNode;
    private TransformableNode andy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        modelLink = DataHolder.modelLink;
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            placeModel(hitResult.createAnchor());
        });

    }


    private void placeModel(Anchor anchor)
    {

        ModelRenderable
                .builder()
                .setSource(this,
                           RenderableSource
                                   .builder()
                                   .setSource(this, Uri.parse(modelLink), RenderableSource.SourceType.GLTF2)
                                   .setScale(0.5f)
                                   .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                                   .build()
                )
                .setRegistryId(modelLink)
                .build()
                .thenAccept(modelRenderable -> addNodeToScene(modelRenderable, anchor))
                .exceptionally(throwable -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(throwable.getMessage()).show();
                    return null;
                });
    }

    private void addNodeToScene(ModelRenderable modelRenderable, Anchor anchor)
    {
        anchorNode = new AnchorNode(anchor);
        //anchorNode.setRenderable(modelRenderable);
        //arFragment.getArSceneView().getScene().addChild(anchorNode);

        anchorNode.setParent(arFragment.getArSceneView().getScene());

        // Create the transformable andy and add it to the anchor.
        andy = new TransformableNode(arFragment.getTransformationSystem());
        andy.setParent(anchorNode);
        andy.setRenderable(modelRenderable);
        andy.select();
        andy.getScaleController().setMinScale(0.1f);
        andy.getScaleController().setMaxScale(10.0f);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();

    }
}