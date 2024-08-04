package edu.learn.strangerthings;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import edu.learn.strangerthings.adapters.UserAdapter;
import edu.learn.strangerthings.datas.User;
import edu.learn.strangerthings.utils.EndPoint;

public class AllCharacters extends AppCompatActivity {
    RecyclerView recyclerView;
    private AlertDialog progressDialog;
    private UserAdapter userAdapter;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_all_characters);

        recyclerView = findViewById(R.id.CharactersRecycle);
        userList = new ArrayList<>();

      // set a recyclerView layout manger to grid with 3 columns here
      // with reverse data

        requestToserver();
    }


    private void showProgressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progress_dialog, null));
        builder.setCancelable(false);
        progressDialog = builder.create();
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    void requestToserver() {
        showProgressDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = EndPoint.getAllCharacters;
        Log.d("requestUrl", url);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONArray jsonArray = new JSONArray(s);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                String id = obj.getString("_id");

                                ArrayList<String> aliases = new ArrayList<>();
                                JSONArray aliasesArray = obj.getJSONArray("aliases");
                                for (int j = 0; j < aliasesArray.length(); j++) {
                                    aliases.add(aliasesArray.getString(j));
                                }

                                ArrayList<String> otherRelations = new ArrayList<>();
                                JSONArray otherRelationsArray = obj.getJSONArray("otherRelations");
                                for (int j = 0; j < otherRelationsArray.length(); j++) {
                                    otherRelations.add(otherRelationsArray.getString(j));
                                }

                                ArrayList<String> affiliation = new ArrayList<>();
                                JSONArray affiliationArray = obj.getJSONArray("affiliation");
                                for (int j = 0; j < affiliationArray.length(); j++) {
                                    affiliation.add(affiliationArray.getString(j));
                                }

                                ArrayList<String> occupation = new ArrayList<>();
                                JSONArray occupationArray = obj.getJSONArray("occupation");
                                for (int j = 0; j < occupationArray.length(); j++) {
                                    occupation.add(occupationArray.getString(j));
                                }

                                ArrayList<String> residence = new ArrayList<>();
                                JSONArray residenceArray = obj.getJSONArray("residence");
                                for (int j = 0; j < residenceArray.length(); j++) {
                                    residence.add(residenceArray.getString(j));
                                }

                                ArrayList<String> appearsInEpisodes = new ArrayList<>();
                                JSONArray appearsInEpisodesArray = obj.getJSONArray("appearsInEpisodes");
                                for (int j = 0; j < appearsInEpisodesArray.length(); j++) {
                                    appearsInEpisodes.add(appearsInEpisodesArray.getString(j));
                                }

                                String photo = obj.optString("photo", "unknown");
                                String name = obj.optString("name", "unknown");
                                String status = obj.optString("status", "unknown");
                                String born = obj.optString("born", "unknown");
                                String gender = obj.optString("gender", "unknown");
                                String eyeColor = obj.optString("eyeColor", "unknown");
                                String hairColor = obj.optString("hairColor", "unknown");
                                String portrayedBy = obj.optString("portrayedBy", "unknown");

                                User user = new User(
                                        id,
                                        name,
                                        portrayedBy,
                                        status,
                                        gender,
                                        eyeColor,
                                        hairColor,
                                        born,
                                        aliases,
                                        otherRelations,
                                        affiliation,
                                        occupation,
                                        residence,
                                        appearsInEpisodes,
                                        photo
                                );

                                userList.add(user);

                                Log.d("userListSize", userList.size() + " " + i);
                            }
                            dismissProgressDialog();
                            if (!userList.isEmpty()) {
                                Collections.reverse(userList);
                                userAdapter = new UserAdapter(AllCharacters.this, userList);
                                recyclerView.setAdapter(userAdapter);
                            }
                        } catch (JSONException e) {
                            dismissProgressDialog();
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        dismissProgressDialog();
                    }
                });

        requestQueue.add(stringRequest);

        Log.d("userListSize", userList.size() + "");

    }

}