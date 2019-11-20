package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    Data data = new Data();

    //เTimer
    CountDownTimer Timer = null;


    int mplayerHP = data.getPlayerHP();

    int moperator = 1;//ทดลองด้วย1 = บวกเลข
    int mquestion = 0;
    String minputanswer = "";
    int manswer = 0;
    String menemyName = "Enemy";
    int menemyMaxHP = 1000;
    int menemyHP = menemyMaxHP;

    int mmustdef = 3;
    int mcountdef = 0;

    int mcombo = 0;
    int mscore = 0;

    int mbg ;


    private void setPlayerHP() {
        ImageView imageviewplayerhp1 = findViewById(R.id.imageViewPlayerHP1);
        ImageView imageviewplayerhp2 = findViewById(R.id.imageViewPlayerHP2);
        ImageView imageviewplayerhp3 = findViewById(R.id.imageViewPlayerHP3);
        int playerHP = mplayerHP;
        if (playerHP == 3) {
            imageviewplayerhp1.setVisibility(View.VISIBLE);
            imageviewplayerhp2.setVisibility(View.VISIBLE);
            imageviewplayerhp3.setVisibility(View.VISIBLE);
        } else if (playerHP == 2) {
            imageviewplayerhp1.setVisibility(View.VISIBLE);
            imageviewplayerhp2.setVisibility(View.VISIBLE);
            imageviewplayerhp3.setVisibility(View.INVISIBLE);
        } else if (playerHP == 1) {
            imageviewplayerhp1.setVisibility(View.VISIBLE);
            imageviewplayerhp2.setVisibility(View.INVISIBLE);
            imageviewplayerhp3.setVisibility(View.INVISIBLE);
        } else if (playerHP == 0) {
            imageviewplayerhp1.setVisibility(View.INVISIBLE);
            imageviewplayerhp2.setVisibility(View.INVISIBLE);
            imageviewplayerhp3.setVisibility(View.INVISIBLE);

        }
    }

    private void setScreen() {
        ConstraintLayout layoutaction = findViewById(R.id.layoutAction);
        ConstraintLayout layoutattack = findViewById(R.id.layoutAttackAction);


        //ไม่แสดง
        ConstraintLayout layoutdefend = findViewById(R.id.layoutDefendAction);
        layoutdefend.setVisibility(View.INVISIBLE);

        TextView textviewtimer = findViewById(R.id.textViewTimer);
        textviewtimer.setVisibility(View.INVISIBLE);
        TextView textviewdefend = findViewById(R.id.textViewDefend);
        textviewdefend.setVisibility(View.INVISIBLE);

        //แสดง
        TextView textviewquestion = findViewById(R.id.textViewQuestion);
        textviewquestion.setText("");
        textviewquestion.setVisibility(View.VISIBLE);

        TextView textviewanswer = findViewById(R.id.textViewAnswer);
        textviewanswer.setText("");
        textviewanswer.setVisibility(View.VISIBLE);

        TextView textviewenemyhp = findViewById(R.id.textViewEnemyHP);
        textviewenemyhp.setText(menemyName + " : " + menemyHP + " / " + menemyMaxHP);





        //เริ่มทำงาน

        Handler setscreen = new Handler();
        setscreen.postDelayed(new Runnable() {
            @Override
            public void run() {

                setPlayerHP();
                attackTurn();
            }
        }, 1000);

    }

    private void attackTurn() {
        final ImageView imageviewattackturn = findViewById(R.id.imageViewAttackTurn);
        imageviewattackturn.setVisibility(View.VISIBLE);

        final Handler hattackturn = new Handler();
        hattackturn.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageviewattackturn.setVisibility(View.INVISIBLE);

                setAttackScreen();

                createQuestion();

                final TextView textviewtimer = findViewById(R.id.textViewTimer);
                textviewtimer.setVisibility(View.VISIBLE);
                Timer = new CountDownTimer(15000, 1000) {
                    TextView textviewquestion = findViewById(R.id.textViewQuestion);

                    public void onTick(long millisUntilFinised) {
                        //mtimeleft = millisUntilFinised / 1000;
                        textviewtimer.setText("Time Left : " + millisUntilFinised / 1000);
                    }

                    public void onFinish() {
                        final ImageView imageviewtimeout = findViewById(R.id.imageViewTimeOut);
                        imageviewtimeout.setVisibility(View.VISIBLE);

                        hattackturn.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageviewtimeout.setVisibility(View.INVISIBLE);
                                textviewtimer.setVisibility(View.INVISIBLE);
                                defendTurn();


                            }
                        }, 1000);

                    }


                };
                Timer.start();
                Button btatk1 = findViewById(R.id.buttonAttack1);
                Button btatk2 = findViewById(R.id.buttonAttack2);
                Button btatk3 = findViewById(R.id.buttonAttack3);
                Button btatk4 = findViewById(R.id.buttonAttack4);
                Button btatk5 = findViewById(R.id.buttonAttack5);
                Button btatk6 = findViewById(R.id.buttonAttack6);
                Button btatk7 = findViewById(R.id.buttonAttack7);
                Button btatk8 = findViewById(R.id.buttonAttack8);
                Button btatk9 = findViewById(R.id.buttonAttack9);
                Button btatk0 = findViewById(R.id.buttonAttack0);
                Button btatkclear = findViewById(R.id.buttonAttackClear);
                Button btatkenter = findViewById(R.id.buttonAttackEnter);

                final TextView textviewanswer = findViewById(R.id.textViewAnswer);

                btatk1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("1");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("2");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("3");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("4");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("5");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("6");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("7");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("8");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("9");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatk0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = minputanswer.concat("0");
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatkclear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        minputanswer = "";
                        textviewanswer.setText(minputanswer);
                    }
                });

                btatkenter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        manswer = Integer.parseInt(minputanswer);
                        minputanswer = "";
                        textviewtimer.setVisibility(View.INVISIBLE);
                        checkResult();
                    }
                });


            }
        }, 1000);
    }

    private void defendTurn() {
        final ImageView imageviewdefendturn = findViewById(R.id.imageViewDefendTurn);
        imageviewdefendturn.setVisibility(View.VISIBLE);

        final Handler hdefendturn = new Handler();
        hdefendturn.postDelayed(new Runnable() {
            @Override
            public void run() {
                setDefendScreen();
                imageviewdefendturn.setVisibility(View.INVISIBLE);

                final TextView textviewdefend = findViewById(R.id.textViewDefend);
                textviewdefend.setText("Prepare For Defend !!!");
                textviewdefend.setVisibility(View.VISIBLE);
                mcountdef = 0;
                final Handler hpredef = new Handler();
                hpredef.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textviewdefend.setText("3");
                        hpredef.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textviewdefend.setText("2");
                                hpredef.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        textviewdefend.setText("1");
                                        hpredef.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                textviewdefend.setText("start");
                                                hpredef.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        defend();

                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);
                            }
                        }, 1000);
                    }
                }, 1000);

            }
        }, 1000);


    }

    private void defend() {
        final ConstraintLayout layoutdefendaction = findViewById(R.id.layoutDefendAction);
        final TextView textviewdefend = findViewById(R.id.textViewDefend);
        textviewdefend.setVisibility(View.INVISIBLE);

        final Button btdef1 = findViewById(R.id.buttonDefend1);
        final Button btdef2 = findViewById(R.id.buttonDefend2);
        final Button btdef3 = findViewById(R.id.buttonDefend3);
        final Button btdef4 = findViewById(R.id.buttonDefend4);
        final Button btdef5 = findViewById(R.id.buttonDefend5);
        final Button btdef6 = findViewById(R.id.buttonDefend6);
        final Button btdef7 = findViewById(R.id.buttonDefend7);
        final Button btdef8 = findViewById(R.id.buttonDefend8);
        final Button btdef9 = findViewById(R.id.buttonDefend9);
        final Button btdef0 = findViewById(R.id.buttonDefend0);

        Random ran = new Random();
        final int randef = ran.nextInt(10);

        Handler hdefend = new Handler();
        hdefend.postDelayed(new Runnable() {
            @Override
            public void run() {
                textviewdefend.setText("Press " + randef + " !!!");
                textviewdefend.setVisibility(View.VISIBLE);
                layoutdefendaction.setVisibility(View.VISIBLE);

                Timer = new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinised) {

                    }

                    public void onFinish() {
                        //หมดเวลา
                        final ImageView imageviewtimeout = findViewById(R.id.imageViewTimeOut);
                        imageviewtimeout.setVisibility(View.VISIBLE);
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        Handler htimeout = new Handler();
                        htimeout.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                TextView textviewdefend = findViewById(R.id.textViewDefend);
                                textviewdefend.setVisibility(View.INVISIBLE);

                                imageviewtimeout.setVisibility(View.INVISIBLE);
                                mplayerHP -= 1;
                                isPlayerDefeated();
                            }
                        }, 1000);
                        ///animation
                        herohurt();
                        m1slashing();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                heroldle();
                                m1ldle();
                            }
                        }, 700);
                        ///
                    }
                };
                Timer.start();

                btdef1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 1;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///

                        }
                    }
                });

                btdef2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 2;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 3;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 4;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 5;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 6;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 7;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 8;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 9;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

                btdef0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Timer.cancel();
                        layoutdefendaction.setVisibility(View.INVISIBLE);
                        int pressdef = 0;

                        if (pressdef == randef) {
                            mcountdef += 1;
                            //textviewpredef.setVisibility(View.INVISIBLE);
                            textviewdefend.setText("Good !!!");
                            if (mcountdef != mmustdef) {
                                defend();
                            } else if (mcountdef == mmustdef) {
                                setScreen();

                            }
                        } else if (pressdef != randef) {
                            textviewdefend.setText("Bad !!!");
                            Handler hdefendfail = new Handler();
                            hdefendfail.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mplayerHP -= 1;
                                    isPlayerDefeated();
                                }
                            }, 1000);
                            ///animation
                            herohurt();
                            m1slashing();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    heroldle();
                                    m1ldle();
                                }
                            }, 700);
                            ///
                        }
                    }
                });

            }
        }, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        setBG();

        ImageView herorun = (ImageView) findViewById(R.id.hero);
        herorun.setImageResource(R.drawable.hero_ldle);
        AnimationDrawable heroldle = (AnimationDrawable) herorun.getDrawable();
        heroldle.start();

        ImageView monterrun = (ImageView) findViewById(R.id.moster);
        monterrun.setImageResource(R.drawable.golem1_idle);
        AnimationDrawable monterldle = (AnimationDrawable) monterrun.getDrawable();
        monterldle.start();

        setScreen();
    }

    private void setBG(){
        Random r = new Random();
        int randombg = r.nextInt(8)+1;


        ImageView imageviewbg = findViewById(R.id.imageviewBG);

        TextView textviewtimer = findViewById(R.id.textViewTimer);
        TextView textviewquestion = findViewById(R.id.textViewQuestion);
        TextView textviewanswer = findViewById(R.id.textViewAnswer);
        TextView textviewdefend = findViewById(R.id.textViewDefend);
        TextView textviewenemyhp = findViewById(R.id.textViewEnemyHP);
        TextView nametextview = findViewById(R.id.name_TextView);
        EditText nameedittext = findViewById(R.id.name_editText);

        System.out.println(randombg);
        if(randombg==1){
            imageviewbg.setImageResource(R.drawable.bg_1);
        }else if(randombg==2){
            imageviewbg.setImageResource(R.drawable.bg_2);
        }else if(randombg==3){
            imageviewbg.setImageResource(R.drawable.bg_3);
        }else if(randombg==4){
            imageviewbg.setImageResource(R.drawable.bg_4);
        }else if(randombg==5){
            imageviewbg.setImageResource(R.drawable.bg_5);
        }else if(randombg==6){
            imageviewbg.setImageResource(R.drawable.bg_6);
        }else if(randombg==7){
            imageviewbg.setImageResource(R.drawable.bg_7);
        }else if(randombg==8){
            imageviewbg.setImageResource(R.drawable.bg_8);
        }
        if(randombg==2||randombg==5){
            textviewtimer.setTextColor(Color.WHITE);
            textviewanswer.setTextColor(Color.WHITE);
            textviewquestion.setTextColor(Color.WHITE);
            textviewdefend.setTextColor(Color.WHITE);
            textviewenemyhp.setTextColor(Color.WHITE);
            nameedittext.setTextColor(Color.WHITE);
            nametextview.setTextColor(Color.WHITE);

        }else{
            textviewtimer.setTextColor(Color.BLACK);
            textviewanswer.setTextColor(Color.BLACK);
            textviewquestion.setTextColor(Color.BLACK);
            textviewdefend.setTextColor(Color.BLACK);
            textviewenemyhp.setTextColor(Color.BLACK);
            nameedittext.setTextColor(Color.BLACK);
            nametextview.setTextColor(Color.BLACK);
        }
    }

    private void setAttackScreen() {//
        //ไม่แสดง
        ConstraintLayout layoutdefend = findViewById(R.id.layoutDefendAction);
        layoutdefend.setVisibility(View.INVISIBLE);


        //แสดง
        ConstraintLayout layoutattack = findViewById(R.id.layoutAttackAction);
        layoutattack.setVisibility(View.VISIBLE);
    }

    private void setDefendScreen() {
        //ไม่แสดง
        ConstraintLayout layoutattack = findViewById(R.id.layoutAttackAction);
        layoutattack.setVisibility(View.INVISIBLE);

        TextView textviewquestion = findViewById(R.id.textViewQuestion);
        textviewquestion.setVisibility(View.INVISIBLE);
        TextView textviewanswer = findViewById(R.id.textViewAnswer);
        textviewanswer.setVisibility(View.INVISIBLE);

        //แสดง
        TextView textviewdefend = findViewById(R.id.textViewDefend);
        textviewdefend.setVisibility(View.INVISIBLE);

    }

    private void createQuestion() {
        Random r = new Random();
        int numq1 = numq1 = r.nextInt(10);
        int numq2 = numq2 = r.nextInt(10);
        mquestion = 0;

        TextView textviewquestion = findViewById(R.id.textViewQuestion);
        if (moperator == 1) {//บวกเลข
            mquestion = numq1 + numq2;
            String Q = numq1 + " + " + numq2 + " = ";
            textviewquestion.setText(Q);

        } else if (moperator == 2) {//ลบเลข
            mquestion = numq1 - numq2;
            String Q = numq1 + " - " + numq2 + " = ";
            textviewquestion.setText(Q);
        } else if (moperator == 3) {//คูณเลข
            mquestion = numq1 * numq2;
            String Q = numq1 + " * " + numq2 + " = ";
            textviewquestion.setText(Q);

        } else if (moperator == 4) {
            //ตั้งภายหลัง
        }
    }


    private void checkResult() {
        Timer.cancel();
        if (manswer == mquestion) {
            //ตอบถูก
            final ImageView imagecorrect = findViewById(R.id.imageViewCorrect);
            imagecorrect.setVisibility(View.VISIBLE);


            mcombo += 1;
            mscore = mscore + (mcombo * 5);
            menemyHP -= 20;
            ///animation
            heroslashing();
            m1hurt();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    heroldle();
                    m1ldle();
                }
            }, 500);
            ///
            Handler handlercorrect = new Handler();
            handlercorrect.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imagecorrect.setVisibility(View.INVISIBLE);
                    isEnemyDefeated();
                }
            },3000);

        } else if (manswer != mquestion) {
            //ตอบผิด
            final ImageView imagewrong = findViewById(R.id.imageViewWrong);
            imagewrong.setVisibility(View.VISIBLE);
            Handler handlerwrong = new Handler();
            handlerwrong.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     imagewrong.setVisibility(View.INVISIBLE);
                     mcombo = 0;
                     isEnemyDefeated();
                 }
            },3000);
        }
        TextView textviewenemyhp = findViewById(R.id.textViewEnemyHP);
        textviewenemyhp.setText(menemyName + " : " + menemyHP + " / " + menemyMaxHP);
    }

    private void isEnemyDefeated() {
        if (menemyHP <= 0) {


            //Data data = new Data();
            //int calscore = data.getMyScore();
            //calscore += mscore;
            //data.setMyScore(calscore);
            //data.setStage(1);
            //ศัตรูตาย
            ImageView imagevictory = findViewById(R.id.imageViewVictory);
            imagevictory.setVisibility(View.VISIBLE);

            ///animation
            m1dead();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView monsterrun = (ImageView) findViewById(R.id.moster);
                    monsterrun.setImageResource(R.drawable.golem_dying_014);
                }
            }, 500);
            ///
            Handler hvictory = new Handler();
            hvictory.postDelayed(new Runnable() {
                @Override
                public void run() {

                    ConstraintLayout layoutdefend = findViewById(R.id.layoutDefendAction);
                    layoutdefend.setVisibility(View.INVISIBLE);

                    ConstraintLayout layoutentername = findViewById(R.id.layoutEnterName);
                    layoutentername.setVisibility(View.VISIBLE);

                    final EditText nameedittext = findViewById(R.id.name_editText);
                    Button enterbutton = findViewById(R.id.enter_button);
                    enterbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            data = new Data();
                            Score score = new Score();
                            String endscore = nameedittext.getText() + "   Score : " + mscore;
                            score.setScore(endscore);

                            ScoreDAO scoreDAO = new ScoreDAO(getApplicationContext());
                            scoreDAO.open();
                            scoreDAO.add(endscore);
                            scoreDAO.close();
                            System.out.println(endscore);

                            Intent endgame = new Intent(PlayActivity.this, HighScoreActivity.class);
                            startActivity(endgame);
                            finish();
                        }
                    });
                }
            }, 1500);
        } else if (menemyHP > 0) {

            defendTurn();
            //ศัตรไมู่ตาย

        }
    }

    private void isPlayerDefeated() {
        setPlayerHP();
        if (mplayerHP == 0) {
            final ImageView imageviewdefeat = findViewById(R.id.imageViewDefeat);
            imageviewdefeat.setVisibility(View.VISIBLE);





            ///animation
            herodead();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ImageView herorun = (ImageView) findViewById(R.id.hero);
                    herorun.setImageResource(R.drawable.hero_dying_014);
                }
            }, 500);
            ///


            Handler hdefeat = new Handler();
            hdefeat.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imageviewdefeat.setVisibility(View.INVISIBLE);
                    ConstraintLayout layoutdefend = findViewById(R.id.layoutDefendAction);
                    layoutdefend.setVisibility(View.INVISIBLE);

                    ConstraintLayout layoutentername = findViewById(R.id.layoutEnterName);
                    layoutentername.setVisibility(View.VISIBLE);

                    final EditText nameedittext = findViewById(R.id.name_editText);
                    Button enterbutton = findViewById(R.id.enter_button);
                    enterbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            data = new Data();
                            Score score = new Score();
                            String endscore = nameedittext.getText() + "   Score : " + mscore;
                            score.setScore(endscore);

                            ScoreDAO scoreDAO = new ScoreDAO(getApplicationContext());
                            scoreDAO.open();
                            scoreDAO.add(endscore);
                            scoreDAO.close();
                            System.out.println(endscore);

                            Intent endgame = new Intent(PlayActivity.this, HighScoreActivity.class);
                            startActivity(endgame);
                            finish();
                        }
                    });


                }
            }, 1500);
        } else if (mplayerHP != 0) {
            setScreen();
        }
    }



    ///animation hero
    private void heroslashing() {
        ImageView herorun = (ImageView) findViewById(R.id.hero);
        herorun.setImageResource(R.drawable.hero_slashing);
        AnimationDrawable heroslashing = (AnimationDrawable) herorun.getDrawable();
        heroslashing.start();
    }

    private void heroldle() {
        ImageView herorun = (ImageView) findViewById(R.id.hero);
        herorun.setImageResource(R.drawable.hero_ldle);
        AnimationDrawable heroldle = (AnimationDrawable) herorun.getDrawable();
        heroldle.start();
    }

    private void herohurt() {
        ImageView herorun = (ImageView) findViewById(R.id.hero);
        herorun.setImageResource(R.drawable.hero_hurt);
        AnimationDrawable herolhurt = (AnimationDrawable) herorun.getDrawable();
        herolhurt.start();
    }
    private void herodead() {
        ImageView herorun = (ImageView) findViewById(R.id.hero);
        herorun.setImageResource(R.drawable.hero_dead);
        AnimationDrawable herodead = (AnimationDrawable) herorun.getDrawable();
        herodead.start();
    }
    ///animation monster
    private void m1ldle() {
        ImageView monsterrun = (ImageView) findViewById(R.id.moster);
        monsterrun.setImageResource(R.drawable.golem1_idle);
        AnimationDrawable monsterldle = (AnimationDrawable) monsterrun.getDrawable();
        monsterldle.start();
    }
    private void m1hurt() {
        ImageView monsterrun = (ImageView) findViewById(R.id.moster);
        monsterrun.setImageResource(R.drawable.golem1_hurt);
        AnimationDrawable monsterlhurt = (AnimationDrawable) monsterrun.getDrawable();
        monsterlhurt.start();
    }
    private void m1slashing() {
        ImageView monsterrun = (ImageView) findViewById(R.id.moster);
        monsterrun.setImageResource(R.drawable.golem1_slashing);
        AnimationDrawable monsterslashing = (AnimationDrawable) monsterrun.getDrawable();
        monsterslashing.start();
    }
    private void m1dead() {
        ImageView monsterrun = (ImageView) findViewById(R.id.moster);
        monsterrun.setImageResource(R.drawable.golem1_dead);
        AnimationDrawable monsterdead = (AnimationDrawable) monsterrun.getDrawable();
        monsterdead.start();
    }



}
