package com.example.covid19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.covid19.R;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final List<String> list1;


    public CustomListAdapter(Activity context, List<String>nameArrayParam) {
        super(context, R.layout.list_view, nameArrayParam);


        this.context = context;
        this.list1 = nameArrayParam;


    }

    //TODO METODO UTILIZZATO PER POPOLARE I DATI DI OGNI RIGA!
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_view, null, true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.list1);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(list1.get(position));


        return rowView;

    }

}