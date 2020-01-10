package net.kathir.myapplication.roomencrypted;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context mCtx;
    private List<Student> studentList;

    public StudentAdapter(Context mCtx, List<Student> employeeList) {
        this.mCtx = mCtx;
        this.studentList = employeeList;
    }

    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_items, parent, false);
        return new StudentAdapter.StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.StudentViewHolder holder, int position) {


        Student student = studentList.get(position);
        holder.textViewEmpName.setText(student.getStu_name());
        holder.textViewEmpCity.setText(student.getStu_city());
        holder.textViewEmpAge.setText(student.getStu_age());
        holder.textViewEmpPh.setText(student.getStu_ph());




    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }








    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewEmpName, textViewEmpCity, textViewEmpAge, textViewEmpPh;

        public StudentViewHolder(View itemView) {
            super(itemView);

            textViewEmpName = itemView.findViewById(R.id.txt_name);
            textViewEmpCity = itemView.findViewById(R.id.txt_city);
            textViewEmpAge = itemView.findViewById(R.id.txt_age);
            textViewEmpPh = itemView.findViewById(R.id.txt_phone);


        }

    }
}
