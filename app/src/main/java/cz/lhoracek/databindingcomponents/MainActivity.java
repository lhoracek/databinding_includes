package cz.lhoracek.databindingcomponents;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import org.apache.commons.codec.binary.StringUtils;

import cz.lhoracek.databindingcomponents.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Item first = new Item("First title");
    Item second = new Item("Second title");
    Item third = new Item("Third title");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setActivity(this);
    }

    @Override
    public void onClick(View v) {
        ((Button) v).getBackground().setColorFilter(getResources().getColor((TextUtils.isEmpty(first.content) || TextUtils.isEmpty(second.content) || TextUtils.isEmpty(third.content)) ? R.color.colorAccent : R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
    }

    public Item getFirst() {
        return first;
    }

    public Item getSecond() {
        return second;
    }

    public Item getThird() {
        return third;
    }

    public static class Item {
        private final String title;
        private String content;

        public Item(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public TextWatcher getOnChangedListener() {

            return new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    content = s.toString();
                }
            };
        }

    }


}
