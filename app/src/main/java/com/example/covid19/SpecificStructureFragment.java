package com.example.covid19;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.model.Review;
import com.example.covid19.model.ReviewListAdapter;
import com.example.covid19.model.Structure;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;


public class SpecificStructureFragment extends Fragment {

    private RecyclerView reviewsRecyclerView;
    private Structure structure;
    private Review[] reviews;
    private ImageView image;
    private TextView nameStructureSpecificStructure;
    private TextView phone;
    private TextView email;
    private TextView site;
    private TextView openClose;
    private RatingBar ratingBar;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        image=view.findViewById(R.id.structureImage);
        image.setTag(structure.getImageLink());
        class DownloadImagesTask extends AsyncTask<ImageView, Void, Bitmap> {
            ImageView imageView = null;
            @Override
            protected Bitmap doInBackground(ImageView... imageViews) {
                this.imageView = imageViews[0];
                try {
                    return download_Image((String) imageView.getTag());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                imageView.setImageBitmap(result);
            }

            private Bitmap download_Image(String url) throws IOException {
                return  BitmapFactory.decodeStream(new URL(url).openConnection().getInputStream());
            }
        }
        new DownloadImagesTask().execute(image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);

        nameStructureSpecificStructure=view.findViewById(R.id.nameStructureSpecificStructure);
        nameStructureSpecificStructure.setText(structure.getName());
        phone=view.findViewById(R.id.phoneSpecificStructure);
        phone.setText(structure.getPhone());
        email=view.findViewById(R.id.emailtexViewSpecificStructure);
        email.setText(structure.getEmail());
        site=view.findViewById(R.id.siteWebTextViewSpecificStructure);
        site.setText(structure.getSite());
        openClose=view.findViewById(R.id.OpenClosetextViewSpecificStructure);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        openClose.setText(sdf.format(structure.getOpeningHours()) + " - " + sdf.format(structure.getClosingHours()));
        Double avg;
        Double sum=0D;
        for(Review r : reviews){
            sum=sum+r.getRating();
        }
        avg=sum/reviews.length;
        ratingBar=view.findViewById(R.id.ratingBarSpecificStructure);
        ratingBar.setRating(avg.floatValue());

        reviewsRecyclerView =view.findViewById(R.id.reviewListRecycleView);
        ReviewListAdapter reviewListAdapter = new ReviewListAdapter(requireContext(), reviews);
        reviewsRecyclerView.setAdapter(reviewListAdapter);
        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_specific_structure, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            SpecificStructureFragmentArgs args = SpecificStructureFragmentArgs.fromBundle(getArguments());
            structure=args.getStructure();
            reviews=args.getReviews();

        }
    }
}
