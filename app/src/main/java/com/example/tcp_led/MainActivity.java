package com.example.tcp_led;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    String a;
    int b;
    connectthread lianjie;
    TextView receive;
    Socket socket=null;
    Button connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ip=findViewById(R.id.mEtIP);
        EditText port=findViewById(R.id.mEtPort);
        EditText out=findViewById(R.id.mEtOut);
        receive=findViewById(R.id.receive);
        connect=findViewById(R.id.mBt1);
        Button send=findViewById(R.id.mBt7);
        Button LED1=findViewById(R.id.mBt3);
        Button LED2=findViewById(R.id.mBt4);
        Button LED3=findViewById(R.id.mBt5);
        Button LED4=findViewById(R.id.mBt6);
        Button Clear=findViewById(R.id.mBt8);

        // 连接 按键底层代码
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=ip.getText().toString();
                String c=port.getText().toString();
                if("".equals(a)||"".equals(c)){
                    Toast.makeText(MainActivity.this,"请输入ip和端口号",Toast.LENGTH_SHORT).show();
                    receive.append("请输入ip和端口号" + "\r\n");
                }
                else{b=Integer.parseInt(c);
                    lianjie=new connectthread();
                    lianjie.start();}
            }
        });

        // 发送数据 按键底层代码
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中进行网络操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(socket!=null){
                            try {
                                String text=out.getText().toString();
                                lianjie.outputStream.write(text.getBytes());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }else{
                            runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                            {
                                public void run()
                                {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(MainActivity.this,"请先建立连接",Toast.LENGTH_SHORT).show();
                                    receive.append("请先建立连接" + "\r\n");
                                }
                            });
                        }
                    }
                }).start();

            }
        });
        // LED1 按键底层代码 其实就是发送数据按键代码基础上修改的，后面三个按键都是
        LED1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中进行网络操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(socket!=null){
                            try {
                                String text="1";
                                lianjie.outputStream.write(text.getBytes());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }else{
                            runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                            {
                                public void run()
                                {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(MainActivity.this,"请先建立连接",Toast.LENGTH_SHORT).show();
                                    receive.append("请先建立连接" + "\r\n");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        // LED2 按键底层代码
        LED2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中进行网络操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(socket!=null){
                            try {
                                String text="2";
                                lianjie.outputStream.write(text.getBytes());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }else{
                            runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                            {
                                public void run()
                                {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(MainActivity.this,"请先建立连接",Toast.LENGTH_SHORT).show();
                                    receive.append("请先建立连接" + "\r\n");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        // LED3 按键底层代码
        LED3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中进行网络操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(socket!=null){
                            try {
                                String text="3";
                                lianjie.outputStream.write(text.getBytes());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }else{
                            runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                            {
                                public void run()
                                {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(MainActivity.this,"请先建立连接",Toast.LENGTH_SHORT).show();
                                    receive.append("请先建立连接" + "\r\n");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        // LED4 按键底层代码
        LED4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中进行网络操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(socket!=null){
                            try {
                                String text="4";
                                lianjie.outputStream.write(text.getBytes());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }else{
                            runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                            {
                                public void run()
                                {
                                    // TODO Auto-generated method stub
                                    Toast.makeText(MainActivity.this,"请先建立连接",Toast.LENGTH_SHORT).show();
                                    receive.append("请先建立连接" + "\r\n");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receive.setText("");
            }
        });

       // onCreate
    }
    //子线程中进行网络相关操作
    // 联网子线程
    class connectthread extends Thread {

        OutputStream outputStream=null;
        InputStream inputStream=null;
        @SuppressWarnings("InfiniteLoopStatement")
        @Override
        public void run() {

            //连接
            try {
                socket=new Socket(a, b);
                runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                {
                    public void run()
                    {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this,"连接成功",Toast.LENGTH_SHORT).show();
                        receive.append("连接成功" + "\r\n");

                    }
                });
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                {
                    public void run()
                    {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this,"连接失败",Toast.LENGTH_SHORT).show();
                        receive.append("连接失败" + "\r\n");
                    }
                });
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                {
                    public void run()
                    {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this,"连接失败",Toast.LENGTH_SHORT).show();
                        receive.append("连接失败" + "\r\n");
                    }
                });
            }
            if(socket!=null){
                //获取输出流对象
                try {
                    outputStream=socket.getOutputStream();
                    outputStream.write(123);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    do {
                        final byte[] buffer = new byte[1024];//创建接收缓冲区
                        inputStream = socket.getInputStream();
                        final int len = inputStream.read(buffer);//数据读出来，并且返回数据的长度
                        runOnUiThread(new Runnable()//不允许其他线程直接操作组件，用提供的此方法可以
                        {
                            public void run() {
                                // TODO Auto-generated method stub
                                receive.append(new String(buffer, 0, len) + "\r\n");
                            }
                        });
                    } while (true);
                }
                catch (IOException ignored) {

                }
            }
        }
    }
    // MainActivity
}