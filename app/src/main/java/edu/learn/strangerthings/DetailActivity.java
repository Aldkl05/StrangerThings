package edu.learn.strangerthings;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import edu.learn.strangerthings.datas.User;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgCharacterDetail;
    private TextView tvName, tvPortrayedBy, tvStatus, tvGender, tvEyeColor, tvHairColor, tvBorn;
    private TextView tvAliases, tvOtherRelations, tvAffiliation, tvOccupation, tvResidence, tvAppearsInEpisodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        imgCharacterDetail = findViewById(R.id.imgCharacterDetail);
        tvName = findViewById(R.id.tvName);
        tvPortrayedBy = findViewById(R.id.tvPortrayedBy);
        tvStatus = findViewById(R.id.tvStatus);
        tvGender = findViewById(R.id.tvGender);
        tvEyeColor = findViewById(R.id.tvEyeColor);
        tvHairColor = findViewById(R.id.tvHairColor);
        tvBorn = findViewById(R.id.tvBorn);
        tvAliases = findViewById(R.id.tvAliases);
        tvOtherRelations = findViewById(R.id.tvOtherRelations);
        tvAffiliation = findViewById(R.id.tvAffiliation);
        tvOccupation = findViewById(R.id.tvOccupation);
        tvResidence = findViewById(R.id.tvResidence);
        tvAppearsInEpisodes = findViewById(R.id.tvAppearsInEpisodes);

        User user = (User) getIntent().getSerializableExtra("user");

        if (user != null) {
            tvName.setText(user.getName());
            tvPortrayedBy.setText("Portrayed by: " + user.getPortrayedBy());
            tvStatus.setText("Status: " + user.getStatus());
            tvGender.setText("Gender: " + user.getGender());
            tvEyeColor.setText("Eye Color: " + user.getEyeColor());
            tvHairColor.setText("Hair Color: " + user.getHairColor());
            tvBorn.setText("Born: " + user.getBorn());

            tvAliases.setText("Aliases: " + String.join(", ", user.getAliases()));
            tvOtherRelations.setText("Other Relations: " + String.join(", ", user.getOtherRelations()));
            tvAffiliation.setText("Affiliation: " + String.join(", ", user.getAffiliation()));
            tvOccupation.setText("Occupation: " + String.join(", ", user.getOccupation()));
            tvResidence.setText("Residence: " + String.join(", ", user.getResidence()));
            tvAppearsInEpisodes.setText("Appears In Episodes: " + String.join(", ", user.getAppearsInEpisodes()));

            if (user.getPhoto().equalsIgnoreCase("unknown")) {
                imgCharacterDetail.setImageResource(R.drawable.runaway);
            } else {
                Glide.with(this).load(user.getPhoto()).into(imgCharacterDetail);
            }
        }

    }
}