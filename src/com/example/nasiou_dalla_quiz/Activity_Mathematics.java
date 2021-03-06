package com.example.nasiou_dalla_quiz;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Mathematics extends Activity {
	
	List<Question> quesList;
	int score=0;
	int category=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion;
	EditText txtChoice ;
	RadioButton rda, rdb, rdc, rbd;
	Button butNext;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        Bundle b = getIntent().getExtras();
		category= b.getInt("category");
	    Toast.makeText(Activity_Mathematics.this, "��������� �� ����������.. ��� ��������� "+category+"!!. N� ����� ����������� �� ��� ���������� ���!!", Toast.LENGTH_LONG).show();
		DbHelper_Maths db=new DbHelper_Maths(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView2);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		rbd=(RadioButton)findViewById(R.id.radio3);
		txtChoice=(EditText)findViewById(R.id.textView3);
		butNext=(Button)findViewById(R.id.button1);
		setQuestionView();
		
		
		rbd.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) { 
				
				Toast.makeText(Activity_Mathematics.this, "��������� ���� ��������!!", Toast.LENGTH_SHORT).show();
				String answer = txtChoice.getText().toString().trim();
				
				if(currentQ.getANSWER().equals(answer))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
			}
		});  
		butNext.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
			
				if(currentQ.getANSWER().equals(answer.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(Activity_Mathematics.this, ResultActivity.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		});   
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
	}
     
   }
