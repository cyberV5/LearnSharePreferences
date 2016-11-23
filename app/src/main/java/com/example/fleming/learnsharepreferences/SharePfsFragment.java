package com.example.fleming.learnsharepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * SharePfsFragment
 * Created by Fleming on 2016/11/23.
 */

public class SharePfsFragment extends Fragment {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.bt_read)
    Button btRead;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private static final String KEY_NAME = "name";
    private static final String KEY_PWD = "password";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sharepfs_fragment, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({R.id.bt_save, R.id.bt_read})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_save:
                mPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                mEditor = mPreferences.edit();
                mEditor.putString(KEY_NAME, etName.getText().toString().trim());
                mEditor.putString(KEY_PWD, etPassword.getText().toString().trim());
                mEditor.putString(KEY_EMAIL, etEmail.getText().toString().trim());
                mEditor.putString(KEY_PHONE, etPhone.getText().toString().trim());
                mEditor.commit();
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_read:
                StringBuilder sb = new StringBuilder();
                sb.append("姓名：" + mPreferences.getString(KEY_NAME, "default name") + "\n")
                        .append("密码：" + mPreferences.getString(KEY_PWD, "default password") + "\n")
                        .append("邮箱：" + mPreferences.getString(KEY_EMAIL, "default email") + "\n")
                        .append("手机号：" + mPreferences.getString(KEY_PHONE, "default phone") + "\n");
                tvResult.setText(sb.toString());
                break;
        }
    }
}
