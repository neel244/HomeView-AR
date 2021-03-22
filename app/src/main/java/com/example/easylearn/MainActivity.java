package com.example.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;




import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private ArFragment arFragment;
    private ModelRenderable
            modelRenderable,

            catRenderable,
            stooltwoRenderable,
            stoolRenderable,
            tableRenderable,
            horseRenderable,

            coffeetableRenderable,
            diningtableRenderable,
            greytableRenderable,
            gtableRenderable,
            woodtableRenderable,

            stooldiningRenderable,
            quiltedstoolRednerable,
            pinksidedstoolRenderable,
            sidestooolRenderable,
            woodenstoolRenderable,
            whiteblackstoolRenderable,
            redbrownstoolRenderable,
            cubestoolRenderable,

            redarmchairRenderable,
            armchairRenderable,
            bluebrownRenderable,
            cyanchairRendearable,
            glossybrownRenderable,
            officechairRenderable,




            bed1Renderable,
            wolvesRenderable;


    int selected=1;
    @Override
    public void onClick(View v) {


        if(v.getId() ==R.id.stool)
            selected =2;
       /* if(v.getId() == R.id.)
            selected =3;*/
        if(v.getId() == R.id.table)
            selected =4;
        if(v.getId() ==R.id.stool2)
            selected =5;
        if(v.getId() ==R.id.coffeetable)
            selected =6;
        if(v.getId() ==R.id.diningtable)
            selected =7;
        if(v.getId() ==R.id.greytable)
            selected =8;
        if(v.getId() ==R.id.gtable)
            selected =9;
        if(v.getId() ==R.id.woodtable)
            selected =10;
        if(v.getId() ==R.id.pinksidedstool)
            selected =11;
        if(v.getId() ==R.id.sidestool)
            selected =12;
        if(v.getId() ==R.id.woodenstool)
            selected =13;
        if(v.getId() ==R.id.whiteblackstool)
            selected =14;
        if(v.getId() ==R.id.redbrownstool)
            selected =15;
        if(v.getId() ==R.id.cubestool)
            selected =16;

        if(v.getId() ==R.id.redarmchair)
            selected =17;
        if(v.getId() ==R.id.bluebrownchair)
            selected =18;
        if(v.getId() ==R.id.cyanchair)
            selected =19;
        if(v.getId() ==R.id.armchair)
            selected =20;

        if(v.getId() ==R.id.glossybrown)
            selected =21;
        if(v.getId() ==R.id.officechair)
            selected =22;

    }
    ImageView bear,cat,horse,table,stool2,cubestool,woodtable,cofeetable,diningtable,greytable,gtable,quiltedstool,sidestool,armchair,bluebrownchair,cyanchair,officechair,redbrownstool,pinksidedstool,redbrowmchair,woodenstool,redarmchair,glossybrown,whiteblackstool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button OpenBottomSheet = findViewById(R.id.open_bottom_sheet);
        OpenBottomSheet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        BottomSheetDialog bottomSheet = new BottomSheetDialog();

                        bottomSheet.show(getSupportFragmentManager(),
                                "ModalBottomSheet");/*


                     /*   FragmentManager fm = getSupportFragmentManager();
                        fm.beginTransaction().add(R.id.mainlayout,bottomSheet).commit(); */


                    }

                });






        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        cat = (ImageView)findViewById(R.id.stool);
        stool2 = (ImageView)findViewById(R.id.stool2);


        table = (ImageView)findViewById(R.id.table);
        cofeetable=(ImageView)findViewById(R.id.coffeetable);
        diningtable= (ImageView)findViewById(R.id.diningtable);
        greytable=(ImageView)findViewById(R.id.greytable);
        gtable=(ImageView)findViewById(R.id.gtable);
        woodtable=(ImageView)findViewById(R.id.woodtable);


        armchair=(ImageView)findViewById(R.id.armchair);
        redarmchair=(ImageView)findViewById(R.id.redarmchair);
        officechair=(ImageView)findViewById(R.id.officechair);
        bluebrownchair=(ImageView)findViewById(R.id.bluebrownchair);
        glossybrown=(ImageView)findViewById(R.id.glossybrown);
        cyanchair=(ImageView)findViewById(R.id.cyanchair);


        pinksidedstool=(ImageView)findViewById(R.id.pinksidedstool);
        woodenstool=(ImageView)findViewById(R.id.woodenstool);
        redbrownstool=(ImageView)findViewById(R.id.redbrownstool);
        cubestool=(ImageView)findViewById(R.id.cubestool);
        whiteblackstool=(ImageView)findViewById(R.id.whiteblackstool);
        sidestool=(ImageView)findViewById(R.id.sidestool);




        cat.setOnClickListener(this);
        table.setOnClickListener(this);
        stool2.setOnClickListener(this);
        cofeetable.setOnClickListener(this);
        diningtable.setOnClickListener(this);
        greytable.setOnClickListener(this);
        gtable.setOnClickListener(this);
        woodtable.setOnClickListener(this);
        sidestool.setOnClickListener(this);
        armchair.setOnClickListener(this);
        redarmchair.setOnClickListener(this);
        officechair.setOnClickListener(this);
        bluebrownchair.setOnClickListener(this);
        glossybrown.setOnClickListener(this);
        cyanchair.setOnClickListener(this);
        pinksidedstool.setOnClickListener(this);
        woodenstool.setOnClickListener(this);
        redbrownstool.setOnClickListener(this);
        cubestool.setOnClickListener(this);
        whiteblackstool.setOnClickListener(this);



        setUpModel();
        setUpPlane();

    }


    private void setUpModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.stool)
                .build()
                .thenAccept(renderable -> stoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.table)
                .build()
                .thenAccept(renderable -> tableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.stooltwo)
                .build()
                .thenAccept(renderable -> stooltwoRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, R.raw.cofeetable)
                .build()
                .thenAccept(renderable -> coffeetableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.diningtable)
                .build()
                .thenAccept(renderable -> diningtableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.greytable)
                .build()
                .thenAccept(renderable -> greytableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.gtable)
                .build()
                .thenAccept(renderable -> gtableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });




        ModelRenderable.builder()
                .setSource(this, R.raw.woodtable)
                .build()
                .thenAccept(renderable -> woodtableRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.stoolside)
                .build()
                .thenAccept(renderable -> sidestooolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.redbrownstool)
                .build()
                .thenAccept(renderable -> redbrownstoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });


        ModelRenderable.builder()
                .setSource(this, R.raw.whiteblackstool)
                .build()
                .thenAccept(renderable -> whiteblackstoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.pinksidestool)
                .build()
                .thenAccept(renderable -> pinksidedstoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.woodenstool)
                .build()
                .thenAccept(renderable -> woodenstoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });


        ModelRenderable.builder()
                .setSource(this, R.raw.cube)
                .build()
                .thenAccept(renderable -> cubestoolRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.armchair1)
                .build()
                .thenAccept(renderable -> armchairRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.redarmchair)
                .build()
                .thenAccept(renderable -> redarmchairRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.blue_brown)
                .build()
                .thenAccept(renderable -> bluebrownRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });



        ModelRenderable.builder()
                .setSource(this, R.raw.glossybrown)
                .build()
                .thenAccept(renderable -> glossybrownRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.cyanchair)
                .build()
                .thenAccept(renderable -> cyanchairRendearable= renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, R.raw.officechair)
                .build()
                .thenAccept(renderable -> officechairRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });


    }

    public void chairactivity(){


        cat.setImageResource(R.drawable.redarmchair);
        cat.setId(R.id.redarmchair);
        table.setImageResource(R.drawable.armchair);
        table.setId(R.id.armchair);
        stool2.setImageResource(R.drawable.bluebrownchair);
        stool2.setId(R.id.bluebrownchair);

        cofeetable.setImageResource(R.drawable.glossybrown);
        cofeetable.setId((R.id.glossybrown));
        diningtable.setImageResource(R.drawable.cyanchair);
        diningtable.setId(R.id.cyanchair);
        greytable.setImageResource(R.drawable.officechair);
        greytable.setId(R.id.officechair);





        gtable.setImageDrawable(null);
        woodtable.setImageDrawable(null);
        sidestool.setImageDrawable(null);

        gtable.setImageDrawable(null);
        woodtable.setImageDrawable(null);
        woodenstool.setImageDrawable(null);
        redbrownstool.setImageDrawable(null);
        cubestool.setImageDrawable(null);
        redarmchair.setImageDrawable(null);
        bluebrownchair.setImageDrawable(null);
        cyanchair.setImageDrawable(null);
        armchair.setImageDrawable(null);
        glossybrown.setImageDrawable(null);
        officechair.setImageDrawable(null);
        pinksidedstool.setImageDrawable(null);
        whiteblackstool.setImageDrawable(null);






    }



    public void stoolactivity(){

        cat.setImageResource(R.drawable.woodenstool);
        cat.setId(R.id.woodenstool);
        table.setImageResource(R.drawable.sidestool);
        table.setId(R.id.sidestool);
        stool2.setImageResource(R.drawable.pinksidedstool);
        stool2.setId(R.id.pinksidedstool);

        cofeetable.setImageResource(R.drawable.cubestool);
        cofeetable.setId((R.id.cubestool));
        diningtable.setImageResource(R.drawable.whiteblackstool);
        diningtable.setId(R.id.whiteblackstool);
        greytable.setImageResource(R.drawable.redbrownstool);
        greytable.setId(R.id.redbrownstool);



        gtable.setImageDrawable(null);
        woodtable.setImageDrawable(null);
        sidestool.setImageDrawable(null);

        gtable.setImageDrawable(null);
        woodtable.setImageDrawable(null);
        woodenstool.setImageDrawable(null);
        redbrownstool.setImageDrawable(null);
        cubestool.setImageDrawable(null);
        redarmchair.setImageDrawable(null);
        bluebrownchair.setImageDrawable(null);
        cyanchair.setImageDrawable(null);
        armchair.setImageDrawable(null);
        glossybrown.setImageDrawable(null);
        officechair.setImageDrawable(null);
        pinksidedstool.setImageDrawable(null);
        whiteblackstool.setImageDrawable(null);
    }

    public void tableactivity(){

        cat.setImageResource(R.drawable.coffee_table);
        cat.setId(R.id.coffeetable);
        table.setImageResource(R.drawable.table);
        table.setId(R.id.table);
        stool2.setImageResource(R.drawable.gtable);
        stool2.setId(R.id.gtable);
        cofeetable.setImageResource(R.drawable.greytable);
        cofeetable.setId(R.id.greytable);
        diningtable.setImageResource(R.drawable.dining);
        diningtable.setId(R.id.diningtable);
        greytable.setImageResource(R.drawable.woodtable);
        greytable.setId(R.id.woodtable);


        gtable.setImageDrawable(null);
        woodtable.setImageDrawable(null);
        pinksidedstool.setImageDrawable(null);
        whiteblackstool.setImageDrawable(null);
        woodenstool.setImageDrawable(null);
        redbrownstool.setImageDrawable(null);
        cubestool.setImageDrawable(null);
        redarmchair.setImageDrawable(null);
        bluebrownchair.setImageDrawable(null);
        cyanchair.setImageDrawable(null);
        armchair.setImageDrawable(null);
        glossybrown.setImageDrawable(null);
        officechair.setImageDrawable(null);

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
        if(selected==5) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(stooltwoRenderable);
            node.select();
        }

        if(selected==6) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(coffeetableRenderable);
            node.select();
        }

        if(selected==7) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(diningtableRenderable);
            node.select();
        }

        if(selected==8) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(greytableRenderable);
            node.select();
        }
        if(selected==9) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(gtableRenderable);
            node.select();
        }


        if(selected==10) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(woodtableRenderable);
            node.select();
        }


        if(selected==11) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(pinksidedstoolRenderable);
            node.select();
        }

        if(selected==12) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(sidestooolRenderable);
            node.select();
        }

        if(selected==13) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(woodenstoolRenderable);
            node.select();
        }

        if(selected==14) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(whiteblackstoolRenderable);
            node.select();
        }


        if(selected==15) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(redbrownstoolRenderable);
            node.select();
        }


        if(selected==16) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(cubestoolRenderable);
            node.select();
        }


        if(selected==17) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(redarmchairRenderable);
            node.select();
        }



        if(selected==18) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(bluebrownRenderable);
            node.select();
        }

        if(selected==19) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(cyanchairRendearable);
            node.select();
        }


        if(selected==20) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(armchairRenderable);
            node.select();
        }


        if(selected==21) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(glossybrownRenderable);
            node.select();
        }

        if(selected==22) {
            TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
            node.setParent(anchorNode);
            node.setRenderable(officechairRenderable);
            node.select();
        }




    }

}
