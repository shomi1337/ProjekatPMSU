package com.project.milos.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Miloš on 1/2/2017.
 */

public class ListAdapter extends ArrayAdapter<Todo> {
    private final Context context;
    private final List<Todo> todoList;

    public ListAdapter(Context context, List<Todo> todoList) {
        super(context, R.layout.todo, todoList);
        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public View getView(int position, View contertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.todo, parent, false);

        TextView todoText = (TextView) rowView.findViewById(R.id.todoText);
        todoText.setText(todoList.get(position).getText());

        return  rowView;
    }
}
