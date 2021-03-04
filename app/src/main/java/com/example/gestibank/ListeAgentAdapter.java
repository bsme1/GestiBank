package com.example.gestibank;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;

import java.util.List;

public class ListeAgentAdapter extends BaseAdapter {

    private List<Agent> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListeAgentAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.mailView = (TextView)
                    convertView.findViewById(R.id.textViewEinfo);
            holder.nameView = (TextView)
                    convertView.findViewById(R.id.textViewNinfo);
            holder.prenomView = (TextView)
                    convertView.findViewById(R.id.textViewPinfo);
            holder.matriculeView = (TextView)
                    convertView.findViewById(R.id.textViewMinfo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Agent Agent = this.listData.get(position);
        holder.nameView.setText(Agent.getName());
        holder.mailView.setText(Agent.getEmail());
        holder.prenomView.setText(Agent.getPrenom());
        holder.matriculeView.setText(Agent.getMatricule());
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        TextView mailView;
        TextView prenomView;
        TextView matriculeView;
    }
}



