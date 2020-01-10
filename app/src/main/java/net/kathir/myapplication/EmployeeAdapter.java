package net.kathir.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {



    private Context mCtx;
    private List<Employee> employeeList;

    public EmployeeAdapter(Context mCtx, List<Employee> employeeList) {
        this.mCtx = mCtx;
        this.employeeList = employeeList;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_items, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {


        Employee employee = employeeList.get(position);
        holder.textViewEmpName.setText(employee.getEmp_name());
        holder.textViewEmpCity.setText(employee.getEmp_city());
        holder.textViewEmpAge.setText(employee.getEmp_age());
        holder.textViewEmpPh.setText(employee.getEmp_ph());




    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }








    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewEmpName, textViewEmpCity, textViewEmpAge, textViewEmpPh;

        public EmployeeViewHolder(View itemView) {
            super(itemView);

            textViewEmpName = itemView.findViewById(R.id.txt_name);
            textViewEmpCity = itemView.findViewById(R.id.txt_city);
            textViewEmpAge = itemView.findViewById(R.id.txt_age);
            textViewEmpPh = itemView.findViewById(R.id.txt_phone);


        }

    }
}
