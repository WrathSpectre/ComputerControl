package com.wrathspectre.computercontrol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.ServerViewHolder> {

    private Context context;
    private List<ServerDetails> servers;

    public ServerAdapter(Context context, List<ServerDetails> servers) {
        this.context = context;
        this.servers = servers;
    }

    @Override
    public ServerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.server_card_view, null);
        return new ServerViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(ServerViewHolder holder, int position) {
        ServerDetails serverDetails = servers.get(position);

       // context.getResources().getDrawable(serverDetails.getLogo(), null)
        //holder.logo.setImageDrawable(context.getDrawable(R.drawable.windows_logo2));
        //holder.logo.setImageResource(context.getResources().getDrawable(R.drawable.windows_logo2));
       // holder.name.setText(serverDetails.getName());
       // holder.ip.setText(serverDetails.getIP());
       // holder.port.setText(serverDetails.getPort());
       // holder.available.setText(serverDetails.getAvailable());
    }

    @Override
    public int getItemCount() {
        return servers.size();
    }

    class ServerViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        TextView name, ip, port, available;

        public ServerViewHolder(View itemView) {
            super(itemView);

           // logo = itemView.findViewById(R.id.system_logo);
            name = itemView.findViewById(R.id.name_data);
            ip = itemView.findViewById(R.id.ip_data);
            //port = itemView.findViewById(R.id.port_data);
            available = itemView.findViewById(R.id.available_data);
        }
    }
}
