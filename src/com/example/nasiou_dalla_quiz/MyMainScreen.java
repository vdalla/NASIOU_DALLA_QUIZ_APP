package com.example.nasiou_dalla_quiz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.view.MenuItem;
import java.util.Random;


public class MyMainScreen extends ActionBarActivity{
	 private Button button1;
	 private Button button2;
	 private Button button3;
	 private Button button4;
	 private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        
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
        	Toast.makeText(MyMainScreen.this, "���� ��� ������ ��� �������������� ���������!!", Toast.LENGTH_LONG).show();  	
            return true;
        }
    	if (id == R.id.about_settings) {
    Toast.makeText(MyMainScreen.this, "� �������� ��� ��������������� ����� ������ ��������� " +
    		"��������. �� ���������� ����� : ������ ���� & �������� �����", Toast.LENGTH_LONG).show();
        	
            return true;
        }
        return super.onOptionsItemSelected(item);
    
}
    
    public void addListenerOnButton()   {
    	        //Select a specific button to bundle it with the action you want
    	        button1 = (Button) findViewById(R.id.button1);
    	        button2 = (Button) findViewById(R.id.button2);
    	        button3 = (Button) findViewById(R.id.button3);
    	        button4 = (Button) findViewById(R.id.button4);
    	        button5 = (Button) findViewById(R.id.button5);
    	        
    	   findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
    		   @Override
    		   public void onClick(View view) {
    			   Intent intent = new Intent(MyMainScreen.this, Activity_Mathematics.class);
					Bundle b = new Bundle();
					b.putInt("category", 1); //Your choice
					intent.putExtras(b); //Put your choice to your next Intent
					startActivity(intent);
    		  }
    		});
    	   
    	   findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
    		   @Override
    		   public void onClick(View view) {
    			   Intent intent = new Intent(MyMainScreen.this, Activity_History.class);
					Bundle b = new Bundle();
					b.putInt("category", 2); //Your choice
					intent.putExtras(b); //Put your choice to your next Intent
					startActivity(intent);
    		  
    		  }
    		});
    	   
    	   findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
    		   @Override
    		   public void onClick(View view) {
    			   Intent intent = new Intent(MyMainScreen.this, Activity_Geo.class);
					Bundle b = new Bundle();
					b.putInt("category", 3); //Your choice
					intent.putExtras(b); //Put your choice to your next Intent
					startActivity(intent);
    		  
    		  }
    		});
    	   
    	   findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
    		   @Override
    		   public void onClick(View view) {
    			   Intent intent = new Intent(MyMainScreen.this, Activity_Problems.class);
					Bundle b = new Bundle();
					b.putInt("category", 4); //Your choice
					intent.putExtras(b); //Put your choice to your next Intent
					startActivity(intent);
    		  
    		  }
    		});
    	   
    	   findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
    		   @Override
    		   public void onClick(View view) {
    			   Intent intent ;
    			   Bundle b ;
    			   Random rn = new Random();
    			   int random =  rn.nextInt(4) + 1;
    			   switch (random){
    			   case 1:   intent = new Intent(MyMainScreen.this, Activity_Mathematics.class); 
    			     b = new Bundle();
					 b.putInt("category", 1); //Your choice
    			     break;
    			   case 2:   intent = new Intent(MyMainScreen.this, Activity_Problems.class);    
    			   	 b = new Bundle();
					 b.putInt("category", 4); //Your choice
					 break;
    			   case 3:   intent = new Intent(MyMainScreen.this, Activity_Geo.class);        
    			     b = new Bundle();
					 b.putInt("category", 3); //Your choice
					 break;
    			   default:  intent = new Intent(MyMainScreen.this, Activity_History.class); 
    			     b = new Bundle();
					 b.putInt("category", 2); //Your choice
    			   }
					
					intent.putExtras(b); //Put your choice to your next Intent
					startActivity(intent);
    		  }
    		});
    	       
    }
}
