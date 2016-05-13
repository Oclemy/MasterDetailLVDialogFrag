package com.tutorials.hp.masterdetaillvdialogfrag.mListView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.masterdetaillvdialogfrag.R;
import com.tutorials.hp.masterdetaillvdialogfrag.mData.SpaceCraft;
import com.tutorials.hp.masterdetaillvdialogfrag.mFragment.SpaceCraftFragment;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/12/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<SpaceCraft> spaceCrafts;
    FragmentManager fm;

    LayoutInflater inflater;


    public CustomAdapter(Context c, ArrayList<SpaceCraft> spaceCrafts, FragmentManager fm) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;
        this.fm = fm;

        //INITIALIZE INFALETR
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spaceCrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spaceCrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.spacecraftImage);

        final String name=spaceCrafts.get(position).getName();
        final int image=spaceCrafts.get(position).getImage();

        //BIND
        nameTxt.setText(name);
        img.setImageResource(image);

        //ITEMCLCK LISTENER
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDialogFragment(name,image);
            }
        });

        return convertView;
    }

    private void openDialogFragment(String name,int image)
    {
        //BUNDLE DATA
        Bundle b=new Bundle();
        b.putString("NAME_KEY", name);
        b.putInt("IMAGE_KEY", image);

        SpaceCraftFragment spaceCraftFragment=new SpaceCraftFragment();
        spaceCraftFragment.setArguments(b);

        //SHOW Dialog FRAG
        spaceCraftFragment.show(fm,"my_tag");
    }
}








