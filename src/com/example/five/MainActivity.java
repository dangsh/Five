package com.example.five;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageButton imageButton_wuxian;
    private ImageButton imageButton_sijian;
    private ImageButton imageButton_sixian;
    private ImageButton imageButton_sanjian;
    private ImageButton imageButton_sanxian;
    private ImageButton imageButton_erjian;
    private ImageButton imageButton_erxian;
    private ImageButton imageButton_yijian;
    private ImageButton imageButton_yixian;
    private ImageButton imageButton_xiayijian;
    private ImageButton imageButton_xiayixian;
    private MediaPlayer mediaPlayer01;
    private Button btn1;
    private Button btn2;
    
    List<String> arr = new ArrayList<String>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mediaPlayer01 = new MediaPlayer();

        imageButton_wuxian = (ImageButton) findViewById(R.id.wuxian);
        imageButton_sijian = (ImageButton) findViewById(R.id.sijian);
        imageButton_sixian = (ImageButton) findViewById(R.id.sixian);
        imageButton_sanjian = (ImageButton) findViewById(R.id.sanjian);
        imageButton_sanxian = (ImageButton) findViewById(R.id.sanxian);
        imageButton_erjian = (ImageButton) findViewById(R.id.erjian);
        imageButton_erxian = (ImageButton) findViewById(R.id.erxian);
        imageButton_yijian = (ImageButton) findViewById(R.id.yijian);
        imageButton_yixian = (ImageButton) findViewById(R.id.yixian);
        imageButton_xiayijian = (ImageButton) findViewById(R.id.xiayijian);
        imageButton_xiayixian = (ImageButton) findViewById(R.id.xiayixian);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

         
         
        
        imageButton_xiayixian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white1);
                    arr.add("white1");
                    
                }
         
                return false;
            }
        });

        imageButton_xiayijian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    play(R.raw.white2);
                    arr.add("white2");
                }
                
                return false;
            }
        });

        imageButton_yixian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white3);
                    arr.add("white3");
                }
                
                return false;
            }
        });

        imageButton_yijian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white4);
                    arr.add("white4");
                }
                
                return false;
            }
        });

        imageButton_erxian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white5);
                    arr.add("white5");
                }
              
                return false;
            }
        });

        imageButton_erjian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white6);
                    arr.add("white6");
                }
               
                return false;
            }
        });

        imageButton_sanxian.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.white7);
                    arr.add("white7");
                }
               
                return false;
            }
        });
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				arr.clear();
				Toast.makeText(MainActivity.this, "开始录制", Toast.LENGTH_SHORT).show();
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Toast.makeText(MainActivity.this, "开始播放", Toast.LENGTH_SHORT).show();
				for (String i : arr) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					if(i.equals("white1")){
						play(R.raw.white1);
					}else if(i.equals("white2")){
						play(R.raw.white2);
					}else if(i.equals("white3")){
						play(R.raw.white3);
					}else if(i.equals("white4")){
						play(R.raw.white4);
					}else if(i.equals("white5")){
						play(R.raw.white5);
					}else if(i.equals("white6")){
						play(R.raw.white6);
					}else if(i.equals("white7")){
						play(R.raw.white7);
					}

				}
			}
		});
        
//		监听事件，网络流媒体播放结束监听 
        mediaPlayer01.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer arg0) {
                mediaPlayer01.release();  //释放 MediaPlayer 对象
                mediaPlayer01 = null;
                Toast.makeText(MainActivity.this, "资源释放了!", Toast.LENGTH_SHORT).show();
            }
        });
//      设置错误信息监听 
        mediaPlayer01.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer arg0, int i, int i1) {
                try {
                    mediaPlayer01.release();   //释放 MediaPlayer 对象
                    Toast.makeText(MainActivity.this, "发生错误了!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
	}

	private void play(int resource) {
        try {

            mediaPlayer01.release();
            mediaPlayer01 = MediaPlayer.create(MainActivity.this, resource);//创建一个多媒体播放器
            mediaPlayer01.start();//开始播放
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "发生错误了:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer01 != null) {
            mediaPlayer01.release();//释放 MediaPlayer 对象
            mediaPlayer01 = null;
        }

    }

}
