package com.example.lukasresutik.sportstats;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas.resutik on 21.8.2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://uchiharaizens.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String email, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name", username);
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
