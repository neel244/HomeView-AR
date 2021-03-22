package com.example.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;




import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ChairActivity extends AppCompatActivity implements View.OnClickListener  {
    private ArFragment arFragment;
    private ModelRenderable
            modelRenderable,
            catRenderable,
            stoolRenderable,
            tableRenderable,
            horseRenderable,
            wolvesRenderable;


    int selected=2;
    @Override
    public void onClick(View v) {

        if(v.getId() ==R.id.stool)
            selected =2;
        if(v.getId() == R.id.table)
            selected =4;
    }
    ImageView bear,cat,horse,table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chair);

        Button OpenBottomSheet = findViewById(R.id.open_bottom_sheet);

        OpenBottomSheet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                        bottomSheet.show(getSupportFragmentManager(),
                                "ModalBottomSheet");
                    }
                });




        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        cat = (ImageView)findViewById(R.id.stool);
        table = (ImageView)findViewById(R.id.table);

        cat.setOnClickListener(this);
        table.setOnClickListener(this);

        setUpModel();
        setUpPlane();
    }


    private void setUpModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.stool)
                .build()
                .thenAccept(renderable -> stoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(ChairActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.table)
                .build()
                .thenAccept(renderable -> tableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(ChairActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });


    }

    private void setUpPlane(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode,selected);
            }
        });
    }

    private void createModel(AnchorNode anchorNode, int selected){
        if(selected==1) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(modelRenderable);
            node.select();
        }

        if(selected==2) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(stoolRenderable);
            node.select();
        }



        if(selected==4) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(tableRenderable);
            node.select();
        }
    }

}
