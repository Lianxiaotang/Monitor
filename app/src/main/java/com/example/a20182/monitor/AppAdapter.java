package com.example.a20182.monitor;

/**
 * Created by 20182 on 2018/3/30.
 */
import java.util.List;
import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class AppAdapter extends BaseAdapter {
    private List<Application> apps;
    private LayoutInflater inflater;

    public AppAdapter (Context context, List<Application> infos) {
        this.apps = infos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount () {
        return apps.size();
    }

    @Override
    public Object getItem (int position) {
        return position;
    }

    @Override
    public long getItemId (int position) {
        return position;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.monitor_item, null);
            holder.icon = (ImageView) convertView.findViewById(R.id.app_image);
            holder.name = (TextView) convertView.findViewById(R.id.app_name);
            holder.runtime = (TextView) convertView.findViewById(R.id.app_time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageDrawable(apps.get(position).getIcon());
        holder.name.setText(apps.get(position).getName());
        holder.runtime.setText(String.valueOf(apps.get(position).getRuntime()));
        //holder.runtime.setBase(SystemClock.elapsedRealtime()-apps.get(position).getRuntime()*1000);

        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
        TextView runtime;
    }
}