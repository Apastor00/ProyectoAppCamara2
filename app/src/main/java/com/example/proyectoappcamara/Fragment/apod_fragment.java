package com.example.proyectoappcamara.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoappcamara.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link apod_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class apod_fragment extends Fragment {
    ImageView imgViewApodActual;
    TextView textViewApod;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "url";
    private static final String ARG_PARAM2 = "explicacion";

    // TODO: Rename and change types of parameters
    private String url;
    private String explicacion;

    public apod_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Apod_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static apod_fragment newInstance(String nombre, String explicacion) {
        apod_fragment fragment = new apod_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre);
        args.putString(ARG_PARAM2, explicacion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_PARAM1);
            explicacion = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_apod_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewApod = view.findViewById(R.id.textViewApod);
        imgViewApodActual = view.findViewById(R.id.imvApodActual);

        Picasso.get().load(url).into(imgViewApodActual);

        textViewApod.setGravity(View.TEXT_ALIGNMENT_INHERIT);
        textViewApod.setGravity(View.TEXT_ALIGNMENT_TEXT_END);

        textViewApod.setText(explicacion);

    }
}